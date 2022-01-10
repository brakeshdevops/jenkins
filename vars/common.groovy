def sonarQube()
{
    sh 'sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://44.200.162.195:9000 -Dsonar.login=admin -Dsonar.password=admin123'
}