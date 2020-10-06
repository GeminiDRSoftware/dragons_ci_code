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


pipeline {

    agent none

    triggers {

        // Polls Source Code Manager every 10 minutes
        pollSCM('H/10 * * * *')

        // Run job every 10 minutes
        pollSCM('H/10 * * * *')

    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timestamps()
    }

    environment {
        PATH = "$JENKINS_HOME/anaconda3/bin:$PATH"
        CONDA_ENV_NAME = "py3"
        CONDA_ENV_FILE = "python3.yml"
    }

    stages {

//         stage('First Stage') {
//             parallel {
//                 stage('Agent #1') {
//                     agent any
//                     steps {
//                         echo "Started steps inside Agent #1"
//                         condaCreateEnv "$CONDA_ENV_NAME", "$CONDA_ENV_FILE"
//                         script {
//                             def gmosArcTests = new gemini.dragons.GmosArcTests(env, this)
//                             gmosArcTests.archivePlots()
//                         }
//                     }
//                 }
//             }
//         }

    }

    post {
        always {
            echo "This will run always"
        }
    }

}
