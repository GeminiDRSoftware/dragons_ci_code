#!/usr/bin/env groovy

def start() {
    sendNotifications 'STARTED'
}

def successful() {
    sendNotifications 'SUCCESSFUL'
}

def failed() {
    sendNotifications 'Fail'
}
