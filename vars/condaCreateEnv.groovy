#!/usr/bin/env groovy
/**
 * Send notifications based on build status string
 */

def call(String env_name, String env_file) {
    echo "I am running from inside a custom step! That's so cool! \\o/"

    //noinspection GroovyUnusedAssignment
    String parsedString = "And now this step received an argument: $env_name".toString()

    echo parsedString
    echo "And this is a second argument: ${env_file}"
}
