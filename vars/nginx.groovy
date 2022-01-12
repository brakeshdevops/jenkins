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
                            PROG_LANG_NAME = "angular"
                            PROG_LANG_VERSION = ""
                        }
//                triggers
//                        {
//                            pollSCM('*/2 * * * *')
//                        }
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

                            stage('Check the code quality')
                                    {
                                        steps
                                                {
                                                    sh 'echo check the ${COMPONENT} code quality'
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