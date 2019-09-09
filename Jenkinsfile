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

@Library('dragons_ci@master') _


pipeline {

    agent any

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

        stage('First Stage') {
            steps {
                    echo 'Step 1'
                    echo 'Step 2'
                    echo 'Step 3'
            }
        }

        stage('master branch stuff') {
            agent any
            when {
                branch 'master'
            }
            steps {
                echo 'run this stage - ony if the branch = master branch'
                echo 'This branch will test '
            }
        }

        stage('feature branch stuff') {
            agent any
            when {
                branch "feature/*"
            }
            steps {
                echo 'run this stage - only if the branch name started with feature/'
            }
        }

        stage('hotfix branch stuff') {
            agent any
            when {
                branch "hotfix/*"
            }
            steps {
                echo 'run this stage - only if the branch name started with hotfix/'
            }
        }

        stage('stable branch stuff') {
            agent any
            when {
                branch "stable"
            }
            steps {
                echo 'run this stage - ony if the branch = stable branch'
            }
        }

        stage('release branch stuff') {

            when {
                branch "release/*"
            }
            failFast true
            parallel {
                stage('build') {
                    stages {
                        stage('CentOS 6') {
                            steps {
                                echo "conda build for CentOS 6"
                            }

                        }
                        stage('CentOS 7') {
                            steps {
                                echo "conda build for CentOS 7"
                            }
                        }
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
