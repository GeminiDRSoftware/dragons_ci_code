#!/usr/bin/env groovy

/**
 * Checks if the Job was triggered by the cron table
 */
def call() {
    def cronCause = 'hudson.triggers.TimerTrigger$TimerTriggerCause'
    return currentBuild.getBuildCauses("${cronCause}") != null
}
