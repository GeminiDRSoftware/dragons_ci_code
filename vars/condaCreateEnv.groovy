#!/usr/bin/env groovy

/**
 * Send notifications based on build status string
 */

/*
def call(String env_name, String env_file) {

    echo "Create Conda Environment: ${env_name}"
    echo "Using file: ${env_file}"

}
*/

def call() {
    echo "I am running from inside a custom step! That's so cool! \\o/"
}
