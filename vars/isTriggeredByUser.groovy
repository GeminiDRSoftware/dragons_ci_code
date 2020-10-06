#!/usr/bin/env groovy

/**
 * Checks if the Job was triggered by a user
 */
def call() {
    def userCause = 'hudson.model.Cause$UserIdCause'
    return currentBuild.getBuildCauses(userCause) != null
}
