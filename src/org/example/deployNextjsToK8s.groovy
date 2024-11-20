package org.example

import hudson.model.*
import groovy.json.JsonSlurper

class DeployNextjsToK8s {

    def deploy(script) {
        script.echo "Starting deployment of Next.js application using Ansible and Kubernetes..."

        try {
            // Step 1: Run Ansible Playbook
            script.sh """
                ansible-playbook -i vars/ansibleResources/inventory.ini vars/ansibleResources/play-book.yml
            """
            script.echo "Ansible playbook executed successfully."

            // Step 2: Apply Kubernetes Deployment YAML (with authentication)
            script.withCredentials([file(credentialsId: 'kubeconfig-id', variable: 'KUBECONFIG')]) {
                script.sh """
                    kubectl apply -f resources/deploy-nextjs/nextjs-deployment.yml
                """
            }
            script.echo "Next.js deployment applied successfully in Kubernetes."

            // Step 3: Apply Kubernetes Service YAML (with authentication)
            script.withCredentials([file(credentialsId: 'kubeconfig-id', variable: 'KUBECONFIG')]) {
                script.sh """
                    kubectl apply -f resources/deploy-nextjs/nextjs-service.yml
                """
            }
            script.echo "Next.js service created successfully in Kubernetes."

        } catch (Exception e) {
            script.error "Deployment failed: ${e.message}"
        }
    }

    def cleanUp(script) {
        script.echo "Cleaning up Kubernetes resources for Next.js application..."

        try {
            // Step 1: Delete Kubernetes Deployment (with authentication)
            script.withCredentials([file(credentialsId: 'kubeconfig-id', variable: 'KUBECONFIG')]) {
                script.sh """
                    kubectl delete -f resources/deploy-nextjs/nextjs-deployment.yml || true
                """
            }
            script.echo "Deleted Kubernetes deployment."

            // Step 2: Delete Kubernetes Service (with authentication)
            script.withCredentials([file(credentialsId: 'kubeconfig-id', variable: 'KUBECONFIG')]) {
                script.sh """
                    kubectl delete -f resources/deploy-nextjs/nextjs-service.yml || true
                """
            }
            script.echo "Deleted Kubernetes service."

        } catch (Exception e) {
            script.error "Cleanup failed: ${e.message}"
        }
    }
}
