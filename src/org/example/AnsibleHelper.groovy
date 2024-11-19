package org.example

class AnsibleHelper {
    def runPlaybook(String playbookPath, String inventoryPath, String ansibleArgs = '') {
        sh """
        ansible-playbook -i ${inventoryPath} ${playbookPath} ${ansibleArgs}
        """
    }
}