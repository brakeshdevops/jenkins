def call()
{
  pipeline
  {
    agent
    {
      label "${BUILD_LABEL}"
    }
    parameters {
      choice(name: 'ENVIRONMENT', choices: ['', 'dev', 'prod'], description:'Pick Environment')
      choice(name: 'ACTION', choices: ['', 'apply', 'destroy'], description:'Pick Terraform Action')
    }

    stages
    {
        stage('Label Builds')
        {
          steps
          {
            script
            {
              addShortText background: 'white', borderColor: 'white', color: 'red', link: '', text: "${ENVIRONMENT}"
              addShortText background: 'white', borderColor: 'white', color: 'red', link: '', text: "${ACTION}"
            }
          }
        }
        stage('Apply Terraform Action')
        {
          steps
          {
            sh '''
                sudo yum install -y yum-utils
                sudo yum-config-manager --add-repo https://rpm.releases.hashicorp.com/RHEL/hashicorp.repo
                sudo yum -y install terraform
                terraform init
            '''
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