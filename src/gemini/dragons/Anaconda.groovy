#!/usr/bin/env groovy
/*
 * Anaconda
 *
 */
package gemini.dragons

class Anaconda {

    static def install(script) {
        script.sh 'echo "I am running the install step"'
    }

}
