#!/usr/bin/env groovy

/**
 * Checks if the commit message contains the [ci full] string.
 */
def call() {
    result = sh (script: "git log -1 | grep '.*\\[ci full\\].*'", returnStatus: true)
    return (result != 0)
}