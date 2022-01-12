import org.jenkinsci.plugins.pipeline.modeldefinition.Utils
def sonarQube()
{
//    sh 'sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://172.31.12.21:9000 -Dsonar.login=admin -Dsonar.password=admin123'
//    sh 'sonar-quality-gate.sh admin admin123 172.31.12.21 ${COMPONENT}'
    sh 'echo sonarqube quality check'
}
def skipStage()
{
    if(env.GIT_BRANCH == "*tags*")
    {
        println "Ran on Tag"
    }
    else
    {
        Utils.markStageSkippedForConditional('publish artifacts')
    }

}