#!/usr/bin/env groovy
/*
 * Jenkinsfile for dragons_ci
 *
 *   Contains several examples of how to create Jobs using a Jenkinsfile
 *     by Bruno C. Quint (bruno.quint@noirlab.edu)
 *
 */

@Library('dragons_ci@master') _


pipeline {

    // Set agent inside stages
    agent none

    // Setting Pipeline Parameters
    parameters {
        string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')

        text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')

        booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')

        choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')

        password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
    }

    // Set how the Job will start
    triggers {
        // Polls Source Code Manager every 10 minutes
        pollSCM('H/10 * * * *')
        // Run job every day
        cron('H H * * *')
    }

    options {
        // Checkout repository to keep track of changes
        skipDefaultCheckout(false)
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
                sh "pwd"
                sh "mkdir -p foo"
                sh "touch foo/file_1"
                sh "touch foo/file_2"
                sh "touch foo/file_3"
                sh "ls foo/"
            }
            post {
                always {
                    echo 'Run always after stage'
                    archiveArtifacts artifacts: 'foo', allowEmptyArchive: true
                }
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
                    when { expression { return isTriggeredBySCMChange() } }
                    steps {
                        echo "This is a step inside a stage started by SCM Change"
                        echo "${isTriggeredBySCMChange()}"
                    }
                }

            }
        }

    }

    post {
        always {
            echo 'I always run'
        }
        success {
            echo 'I succeeded!'
        }
        failure {
            echo 'I failed! :('
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
