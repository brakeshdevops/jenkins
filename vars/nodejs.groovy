def call()
{
    pipeline
            {
                agent
                        {
                            label 'WORKSTATION'
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
                                                   sh 'echo compile the code'
                                                }
                                    }
                            stage('Check the code quality')
                                    {
                                        steps
                                                {
                                                    sh 'echo check the code quality'
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