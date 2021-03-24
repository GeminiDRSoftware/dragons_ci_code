#!/usr/bin/env groovy

/**
 * Send notifications based on build status string
 */
def call(String buildStatus = 'STARTED') {

    // build status of null means successful
    buildStatus =  buildStatus ?: 'SUCCESSFUL'

    // Default values
    def color = 'RED'
    def colorCode = '#cc0000'
    def message = "${buildStatus}: Job '${env.JOB_NAME} [<${env.RUN_DISPLAY_URL}|${env.BUILD_NUMBER}>] (<${env.BUILD_URL}/consoleText|Raw text traceback>)'"

    def details = """<p>${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p><br>
        <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>"""

    // Override default values based on build status
    if (buildStatus == 'STARTED') {
        color = 'YELLOW'
        colorCode = '#ffcc00'
    } else if (buildStatus == 'SUCCESSFUL') {
        color = 'GREEN'
        colorCode = '#00cc00'
    }

    // Send notifications
    slackSend (color: colorCode, message: message)

}
