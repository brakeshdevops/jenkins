//pipelineJob('roboshop-ansible') {
//    configure { flowdefinition ->
//        flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
//            'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
//                'userRemoteConfigs' {
//                    'hudson.plugins.git.UserRemoteConfig' {
//                        'url'('https://github.com/brakeshdevops/ansible.git')
//                    }
//                }
//                'branches' {
//                    'hudson.plugins.git.BranchSpec' {
//                        'name'('*/main')
//                    }
//                }
//            }
//            'scriptPath'('Jenkinsfile')
//            'lightweight'(true)
//        }
//    }
//}
//seed file added
//folder('CI-Pipelines') {
//    displayName('CI-Pipelines')
//    description('CI-Pipelines')
//}
//def COMPONENTS = ["cart", "catalogue", "payment", "shipping", "user", "dispatch"]
//def size=COMPONENTS.size-1
//for(i in 0..size)
//{
//    def j=COMPONENTS[i]
//    pipelineJob("CI-Pipelines/${j}") {
//        configure { flowdefinition ->
//            flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
//                'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
//                    'userRemoteConfigs' {
//                        'hudson.plugins.git.UserRemoteConfig' {
//                            'url'("https://github.com/brakeshdevops/${j}.git")
//                        }
//                    }
//                    'branches' {
//                        'hudson.plugins.git.BranchSpec' {
//                            'name'('*/main')
//                        }
//                    }
//                }
//                'scriptPath'('Jenkinsfile')
//                'lightweight'(true)
//            }
//        }
//    }
//}
folder('Mutable') {
    displayName('Mutable')
    description('Mutable')
}
pipelineJob('Mutable') {
    configure { flowdefinition ->
        flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
            'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
                'userRemoteConfigs' {
                    'hudson.plugins.git.UserRemoteConfig' {
                        'url'('https://github.com/brakeshdevops/terraform-vpc.git')
                    }
                }
                'branches' {
                    'hudson.plugins.git.BranchSpec' {
                        'name'('*/main')
                    }
                }
            }
            'scriptPath'('Jenkinsfile')
            'lightweight'(true)
        }
    }
}