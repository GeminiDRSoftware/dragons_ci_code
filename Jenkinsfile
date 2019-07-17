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
    agents any
    
    when {
        branch 'master'
    }
    steps {
        masterPipeline
    }
}
