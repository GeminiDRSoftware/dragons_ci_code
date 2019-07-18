#!/usr/bin/groovy
/*
 * Send a message to Slack saying that the jobs has started
 */

def call() {
    sendNotifications 'STARTED'
}
