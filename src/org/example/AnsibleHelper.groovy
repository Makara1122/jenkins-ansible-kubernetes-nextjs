package org.example

class AnsibleHelper {
    def steps

    AnsibleHelper(steps) {
        this.steps = steps
    }

    def runPlaybook(String playbookPath, String inventoryPath, String ansibleArgs = '') {
        steps.sh """
        ansible-playbook -i ${inventoryPath} ${playbookPath} ${ansibleArgs}
        """
    }
}
