#!/usr/bin/env groovy
/*
 * Class that holds methods related to GMOS Arc Tests
 */
package gemini.dragons


class GmosArcTests implements Serializable {

    def steps

    GmosArcTests(steps) { this.steps = steps }

    void archivePlots() {

        steps.echo "Running 'archivePlots' from inside GmosArcTests"
        steps.archiveArtifacts artifacts: "plots/*", allowEmptyArchive: true

    }

}