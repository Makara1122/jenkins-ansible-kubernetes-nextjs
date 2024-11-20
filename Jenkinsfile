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
import org.example.deployNextjsToK8s


pipeline {
    agent any

    stages {
        stage('Deploy Next.js') {
            steps {
                script {
                    def deployer = new org.example.DeployNextjsToK8s()
                    deployer.deploy(this)
                }
            }
        }

        stage('Clean Up (Optional)') {
            steps {
                script {
                    def deployer = new  org.example.DeployNextjsToK8s()
                    deployer.cleanUp(this)
                }
            }
        }
    }
}

// @Library('ansible-library') _
// import org.example.DeployNextjsToK8s

// pipeline {
//     agent any
//     stages {
//         stage('Library Test') {
//             steps {
//                 script {
//                     echo "Shared Library Loaded Successfully"
//                 }
//             }
//         }
//     }
// }

