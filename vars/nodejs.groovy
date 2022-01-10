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
                        }
                post
                {
                    always
                    {
                      cleanws()
                    }
                }
            }
}