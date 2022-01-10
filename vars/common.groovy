def sonarQube()
{
    sh 'sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://3.235.28.135 :9000 -Dsonar.login=admin -Dsonar.password=admin123'
}