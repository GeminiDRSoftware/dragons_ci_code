#!/usr/bin/env groovy
/*
 * Anaconda
 *
 */
package gemini.dragons

class Anaconda implements Seriable {

    def steps
    Anaconda(steps) {this.steps = steps}

    def install(args) {
        steps.sh 'echo "Trying this step"'
    }

}
