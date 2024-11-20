@Library('ansible-library') _
import org.example.MyUtils

pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                script {
                    MyUtils.printMessage(this, "Hello from Shared Library!")
                }
            }
        }
    }
}
