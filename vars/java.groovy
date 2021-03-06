def call()
{
    pipeline
            {
                agent
                {
                  label "${BUILD_LABEL}"
                }
                environment
                {
                   NEXUS = credentials('NEXUS')
                   PROG_LANG_NAME = "java"
                   PROG_LANG_VERSION = "1.8"
                }
//                triggers
//                {
//                   pollSCM('H/2 * * * *')
//                }
                stages
                        {
                            stage('Label Builds')
                                    {
                                        steps
                                                {
                                                    script
                                                            {
                                                                env.gitTag = GIT_BRANCH.split('/').last()
                                                                addShortText background: 'white', borderColor: 'white', color: 'red', link: '', text: "${gitTag}"
                                                            }
                                                }
                                    }

                            stage('Compile the code')
                                    {
                                        steps
                                                {
                                                    sh 'mvn compile'
                                                }
                                    }
                            stage('Check the code quality')
                                    {
                                        steps
                                                {
                                                    script
                                                            {
                                                                common.sonarQube()
                                                            }
                                                }
                                    }
                            stage('Lint Checks')
                                    {
                                        steps
                                                {
                                                    sh 'echo Lint Checks'
                                                }
                                    }
                            stage('Test Cases')
                                    {
                                        steps
                                                {
                                                    sh 'echo test cases'
                                                }
                                    }
                            stage('publish artifacts')
                                    {
                                        when
                                                {
                                                    expression { sh([returnStdout: true, script: 'echo ${GIT_BRANCH} | grep tags || true']) }
                                                }
                                        steps
                                                {
                                                    script
                                                            {
                                                                common.prepareArtifacts()
                                                                common.publishArtifacts()
                                                            }
                                                }
                                    }
                        }
                post
                {
                   always
                   {
                      cleanWs()
                   }
                }
            }
    }