// adding options
// pipeline
// {
//     agent any
//     options
//     {
//         disableConcurrentBuilds()
//     }
//     stages
//     {
//         stage('one')
//         {
//             steps
//             {
//                 echo 'sh Welcome to shell scripting in jenkins'
//             }
//         }
//     }
// }
pipeline
{
    agent any
    environment
    {
        A= "Jenkins program"
        cred=credentials('centos')
    }
    stages
    {
        stage('one')
        {
            steps
            {
                sh 'echo ${A}'
                echo A
                echo cred
            }
        }
    }
}