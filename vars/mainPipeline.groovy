#!/usr/bin/env groovy

def call() {
    pipeline {
        agent none
        stages {
            stage('Main Pipeline') {
                steps {
                    echo 'Master Pipeline - First Step'
                    echo 'Master Pipeline - Second Step'
                    sh 'Test bash'
                }
            }
        }
    }
}
