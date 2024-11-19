def runPlaybook(String playbookName, String inventoryName, String ansibleArgs = '') {
    def libraryPath = libraryResource("ansibleResources/${playbookName}")
    def inventoryPath = libraryResource("ansibleResources/${inventoryName}")
    sh """
    ansible-playbook -i ${inventoryPath} ${libraryPath} ${ansibleArgs}
    """
}
