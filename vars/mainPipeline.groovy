#!/usr/bin/env groovy

def call(int build) {
    pipeline {
        agent none
        stages {
            stage('Master Pipeline: Stage 1') {
                steps {
                    echo 'Master Pipeline - First Step'
                    echo 'Master Pipeline - Second Step'
                }
            }
            stage('Master Pipeline: Stage 2') {
                steps {
                    echo 'Master Pipeline - Third Step'
                    echo 'Master Pipeline - Fourth Step'
                }
            }
        }
    }
}
