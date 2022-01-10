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
                                                   sh 'echo compile the ${COMPONENT} code'
                                                }
                                    }
                            stage('Check the code quality')
                                    {
                                        steps
                                                {
                                                    sh 'echo check the ${COMPONENT} code quality'
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
            }
}