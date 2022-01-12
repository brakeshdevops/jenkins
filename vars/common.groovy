import org.jenkinsci.plugins.pipeline.modeldefinition.Utils
def sonarQube()
{
//    sh 'sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://172.31.12.21:9000 -Dsonar.login=admin -Dsonar.password=admin123'
//    sh 'sonar-quality-gate.sh admin admin123 172.31.12.21 ${COMPONENT}'
    sh 'echo sonarqube quality check'
}
def publishArtifacts()
{
//    if(env.GIT_BRANCH == "*tags*")
//    {
//        println "Ran on Tag"
//    }
//    else
//    {
//        Utils.markStageSkippedForConditional('publish artifacts')
//    }
    sh '''
    curl -f -v -u ${NEXUS_USR}:${NEXUS_PSW} --upload-file ${COMPONENT}-${gitTag}.zip http://172.31.3.68:8081/repository/${COMPONENT}/${COMPONENT}-${gitTag}.zip
    '''

}
def prepareArtifacts()
{
    if(env.PROG_LANG_NAME == "nodejs" && PROG_LANG_VERSION == "6")
    {
        sh '''
            npm install
            zip -r ${COMPONENT}-${gitTag}.zip node_modules server.js
            ls -ltr 
        '''
    }
    if(env.PROG_LANG_NAME == "java" && PROG_LANG_VERSION == "1.8")
    {
        sh '''
            mvn clean package
            mv target/${COMPONENT}-1.0.jar ${COMPONENT}.jar
            zip -r ${COMPONENT}-${gitTag}.zip ${COMPONENT}.jar
        '''
    }
}