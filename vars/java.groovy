def call()
{
    pipeline
            {
                agent
                        {
                            label "${BUILD_LABEL}"
                        }
                triggers
                        {
                            pollSCM('*/2 * * * *')
                        }
                stages
                        {
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