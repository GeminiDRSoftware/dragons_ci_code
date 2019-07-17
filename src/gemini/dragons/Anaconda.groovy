#!/usr/bin/env groovy
/*
 * Anaconda
 *
 */
package gemini.dragons

class Anaconda implements Serializable {

    def steps

    Anaconda(steps) {this.steps = steps}

    def install() {
        steps.sh 'echo "I am running the install step!!"'
    }

}
