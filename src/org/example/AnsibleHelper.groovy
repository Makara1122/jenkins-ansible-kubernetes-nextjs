def runPlaybook(steps, String playbookPath, String inventoryPath, String ansibleArgs = '') {
    steps.sh """
    ansible-playbook -i ${inventoryPath} ${playbookPath} ${ansibleArgs}
    """
}

node {
    stage('Deploy') {
        runPlaybook(this, '/path/to/playbook.yml', '/path/to/inventory.ini')
    }
}
