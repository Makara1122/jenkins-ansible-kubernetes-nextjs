def runPlaybook(steps, String playbookPath, String inventoryPath, String ansibleArgs = '') {
    steps.sh """
    ansible-playbook -i ${inventoryPath} ${playbookPath} ${ansibleArgs}
    """
}
