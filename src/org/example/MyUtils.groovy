package com.example

class MyUtils {
    static void printMessage(steps, String message) {
        steps.echo "Message: ${message}"
    }
    static void listFoldersAndFiles(steps, String command) {
        steps.sh "${command}"
    }
}
