#!/usr/bin/env groovy
/*
 * Jenkinsfile for DRAGONS
 *     by Bruno C. Quint (bquint at gemini dot edu)
 *
 * Required Plugins
 * -
 *
 *
 */

@Library('dragons_ci_local@master') import gemini.dragons.*

def anaconda

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
        CONDA_ENV_FILE = ".jenkins/conda_py3env_stable.yml"
        CONDA_ENV_NAME = "py3_stable"
    }

    stages {

        stage('Stage 1') {
            steps {
                echo 'Running stage 1'
            }
        }

    }

}
