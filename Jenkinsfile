pipeline {
    agent any

    stages {
        stage('One') {
            steps {
                echo 'This is stage1'
            }
        }
        stage('two') {
            steps {
                echo 'Second stage'
            }
        }
        stage('Three') {
            steps {
                echo 'Third stage'
            }
        }
        stage('Four') {
            steps {
                echo 'Fourth stage'
            }
        }
        stage('Five') {
            steps {
                echo 'Fifth stage'
            }
        }
        stage('Six') {
             steps {
        mail bcc: '', body: 'Hello', cc: 'rakeshbandarupalli1@gmail.com', from: '', replyTo: '', subject: 'Hello Rakesh', to: 'bandarupallirakesh@gmail.com'             }
        }

    }
}
