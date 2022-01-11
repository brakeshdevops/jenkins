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
                }
            }
            stage('publish artifacts')
            {
            steps
            {
                sh 'echo publish artifacts'
                sh 'env'
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