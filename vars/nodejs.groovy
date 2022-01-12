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
            stage('Label Builds')
            {
                def gitTag=GIT_BRANCH.split('/').last()
                addShortText background: 'white', borderColor: 'white', color: 'red', link: '', text: "${gitTag}"
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
