#!/usr/bin/env groovy

def call() {
    pipeline {
        agent none
        stages {
            stage('Stage 1') {
                steps {
                    echo 'Master Pipeline - First Step'
                    echo 'Master Pipeline - Second Step'
                    sh 'Test bash'
                }
            }
            stage('Stage 2') {
                steps {
                    echo 'Master Pipeline - First Step'
                    echo 'Master Pipeline - Second Step'
                    sh 'Test bash'
                }
            }
        }
    }
}
