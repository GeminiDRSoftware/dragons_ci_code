#!/usr/bin/env groovy

/**
 * Checks if the Job was triggered by a user
 */
def call() {
    def causes = currentBuild.rawBuild.getCause(hudson.model.Cause$UserIdCause)
    return causes != null
}
