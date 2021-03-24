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

    def blocks = [
        [
            "type": "section",
            "text": [
			    "type": "mrkdwn",
			    "text": "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}] (${env.RUN_DISPLAY_URL})'"
		    ]
        ]
    ]

    // Override default values based on build status
    if (buildStatus == 'STARTED') {
        color = 'YELLOW'
        colorCode = '#ffcc00'
    } else if (buildStatus == 'SUCCESSFUL') {
        color = 'GREEN'
        colorCode = '#00cc00'
    }

    // Send notifications
    slackSend (color: colorCode, blocks: blocks)

}
