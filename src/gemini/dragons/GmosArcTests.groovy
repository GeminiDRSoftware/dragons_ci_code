#!/usr/bin/env groovy
/*
 * Class that holds methods related to GMOS Arc Tests
 */
package gemini.dragons


class GmosArcTests implements Serializable {

    def env
    def steps
    private String _path_to_plots

    GmosArcTests(env, steps) {
        this.env = env
        this.steps = steps
        this._path_to_plots = "process_arcs/GMOS/test_gmos_lsspec_arcs.tar.gz"
    }

    void archivePlots() {

        File tarFile = null
        String tarFileName = ""
        boolean fileExists = false

        steps.echo "Running 'archivePlots' from inside GmosArcTests"

        tarFile = new File(env.DRAGONS_TEST_OUTPUTS, this._path_to_plots)
        fileExists = tarFile.exists()

        if (fileExists) {
            steps.echo "Confirmed that file exists: ${tarFile}"
            tarFileName = tarFile.toString()
            steps.archiveArtifacts tarFileName
        } else {
            steps.echo "Could not find file: ${tarFile}"
        }

    }

}