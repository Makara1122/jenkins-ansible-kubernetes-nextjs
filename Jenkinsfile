@Library('my-shared-library') _
import com.example.MyUtils

pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                script {
                    MyUtils.printMessage("Hello from Shared Library!")
                }
            }
        }
    }
}
