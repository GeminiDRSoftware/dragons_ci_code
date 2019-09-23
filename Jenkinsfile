#!/usr/bin/env groovy
/*
 * Jenkinsfile for DRAGONS
 *     by Bruno C. Quint (bquint at gemini dot edu)
 *
 * Required Plugins
 * -
 *
 */

@Library('dragons_ci@master') _


pipeline {

    agent none

    // Polls Source Code Manager every hour
    triggers {
        pollSCM('H * * * *')
    }

    options {
        skipDefaultCheckout(true)
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timestamps()
    }

    environment {
        PATH = "$JENKINS_HOME/anaconda3/bin:$PATH"
    }

    stages {

        stage('First Stage') {
            parallel {
                stage('Agent #1') {
                    agent {
                        label "centos7"
                    }
                    steps {
                        echo "Hello World"
                        condaCreateEnv
                    }
                }
            }
        }

    }

    post {
        always {
            echo "This will run always"
        }
    }

}
