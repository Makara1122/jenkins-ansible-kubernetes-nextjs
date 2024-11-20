// @Library('ansible-library') _
// import org.example.MyUtils

// pipeline {
//     agent any
//     stages {
//         stage('Test') {
//             steps {
//                 script {
//                     MyUtils.printMessage(this, "Hello from Shared Library!")
//                 }
//             }
//         }
//         stage('List folders and files') {
//             steps {
//                 script {
//                     MyUtils.listFoldersAndFiles(this, "ls -lrt")
//                 }
//             }
//         }
//     }
// }
@Library('ansible-library') _

pipeline {
    agent any

    stages {
        stage('Deploy Next.js') {
            steps {
                script {
                    def deployer = new vars.ansibleResources.DeployNextjsToK8s()
                    deployer.deploy(this)
                }
            }
        }

        stage('Clean Up (Optional)') {
            steps {
                script {
                    def deployer = new vars.ansibleResources.DeployNextjsToK8s()
                    deployer.cleanUp(this)
                }
            }
        }
    }
}
