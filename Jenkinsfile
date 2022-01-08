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
// pipeline
// {
//     agent any
//     environment
//     {
//         A= "Jenkins program"
//         cred=credentials('centos')
//     }
//     stages
//     {
//         stage('one')
//         {
//             steps
//             {
//                 sh 'echo ${A}'
//                 echo A
//                 sh 'env'
//                 echo cred
//             }
//         }
//     }
// }
// pipeline
// {
//     agent any
//     parameters
//     {
//         string(name:'PERSON',defaultValue:'Raju',description:'Hello Raju. How are you')
//         text(name:'BIOGRAPHY', defaultValue: '',description:'Welcome')
//         booleanParam(name:'TOGGLE',defaultValue:true,description:'Welcome')
//         choice(name:'CHOICE',choices:['one','two','three'],description:'welcome')
//         password(name:'PASSWORD',defaultValue:'Secret',description:'Enter the password')
//     }
//     stages
//     {
//         stage('Example')
//         {
//             steps
//             {
//                 echo "Hello ${params.PERSON}"
//                 echo "Biography: ${params.BIOGRAPHY}"
//                 echo "toggle: ${params.TOGGLE}"
//                 echo "choice: ${params.CHOICE}"
//                 echo "Password: ${params.PASSWORD}"
//             }
//         }
//     }
// }
// pipeline
// {
// agent any
// tools
// {
//     maven 'mvn-3.5.0'
// }
//     stages
//     {
//         stage('one')
//         {
//             steps
//             {
//             sh 'mvn --version'
//             }
//         }
//     }
// }
pipeline {
    agent any
    stages {
        stage('Example') {
            input {
                message "Should we continue?"
                ok "Yes, we should."
                submitter "rakesh"
                parameters {
                    string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
                }
            }
            steps {
                echo "Hello, ${PERSON}, nice to meet you."
            }
        }
    }
}