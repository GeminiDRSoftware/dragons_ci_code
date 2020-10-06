#!/usr/bin/env groovy

/**
 * Checks if the Job was triggered by a change in SCM
 */
def call() {
    def scmCause = 'hudson.triggers.SCMTrigger$SCMTriggerCause'
    def causeList = currentBuild.getBuildCauses(scmCause)
    return !(causeList.isEmpty())
}
