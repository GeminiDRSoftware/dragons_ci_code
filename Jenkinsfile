#!/usr/bin/env groovy
/*
 * Jenkinsfile for DRAGONS
 *     by Bruno C. Quint (bquint at gemini dot edu)
 *
 * Required Plugins
 * -
 *
 */

//noinspection GroovyUnusedAssignment
@Library('dragons_ci@master') _
import gemini.dragons.GmosArcTests

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
        CONDA_ENV_NAME = "py3"
        CONDA_ENV_FILE = "python3.yml"
    }

    stages {

        stage('First Stage') {
            parallel {
                stage('Agent #1') {
                    agent any
                    steps {
                        echo "Hello World"
                        condaCreateEnv "$CONDA_ENV_NAME", "$CONDA_ENV_FILE"
                        def gmosArcTests = GmosArcTests()
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
