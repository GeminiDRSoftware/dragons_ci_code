#!/usr/bin/env groovy
/*
 * Jenkinsfile for dragons_ci
 *
 *   Contains several examples of how to create Jobs using a Jenkinsfile
 *     by Bruno C. Quint (bruno.quint@noirlab.edu)
 *
 */

@Library('dragons_ci@feature/isTriggeredBySCMChange') _


pipeline {

    // Set agent inside stages
    agent none

    // Set how the Job will start
    triggers {
        // Polls Source Code Manager every 10 minutes
        pollSCM('H/5 * * * *')
        // Run job every 30 minutes
        cron('H/30 * * * *')
    }

    options {
        // Persist artifacts and console output for the specific number
        // of recent Pipeline runs
        buildDiscarder(logRotator(numToKeepStr: '10'))
        // Adds timestamps for each line of a multi-branch pipeline
        timestamps()
    }

    stages {

        stage('Simplest Stage') {
            agent any
            steps {
                echo "This is a step inside the 'Simplest Stage'"
            }
        }

        stage('Run when triggered by') {
            parallel {

                stage('User') {
                    agent any
                    when { expression { return isTriggeredByUser() } }
                    steps {
                        echo "This is a step inside a stage started by a user"
                        echo "${isTriggeredByUser()}"
                    }
                }

                stage('Cron') {
                    agent any
                    when { expression { return isTriggeredByCron() } }
                    steps {
                        echo "This is a step inside a stage started by cron job"
                        echo "${isTriggeredByCron()}"
                    }
                }

                stage('SCM Change') {
                    agent any
                    // when { expression { return isTriggeredByCron() } }
                    steps {
                        echo "This is a step inside a stage started by SCM Change"
                        echo "${currentBuild.getBuildCauses()}"
                    }
                }

            }
        }

    }

    post {
        always {
            echo "This will always run after all stages"
        }
    }

}
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
