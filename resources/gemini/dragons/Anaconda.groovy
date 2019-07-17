#!/usr/bin/env groovy
/*
 * Anaconda
 *
 */
package gemini.dragons

class Anaconda {

    def steps

    Anaconda(steps) {this.steps = steps}

    def install() {
        steps.sh 'echo "Trying this step"'
    }

}
