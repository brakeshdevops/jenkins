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
                            pollSCM('H/2 * * * *')
                        }
                stages
                        {

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
                sh 'echo lint checks'
              }
            }
            stage('Test Cases')
            {
               steps
               {
                   sh 'echo test cases'
                   sh 'env'
                }
            }
            stage('publish artifacts')
            {
            steps
            {
                script
                {
                    common.skipStage()
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
    //
}
