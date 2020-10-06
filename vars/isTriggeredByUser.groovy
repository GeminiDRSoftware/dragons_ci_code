#!/usr/bin/env groovy

/**
 * Checks if the Job was triggered by a user
 */
def call() {
    def userCause = 'hudson.model.Cause$UserIdCause'
    def causeList = currentBuild.getBuildCauses(userCause)
    return !(causeList.isEmpty())
}
