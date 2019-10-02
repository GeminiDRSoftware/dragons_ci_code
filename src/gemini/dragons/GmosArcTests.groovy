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
        this._path_to_plots = "process_arcs/GMOS/tst_gmos_lsspec_arcs.tar.gz"
    }

    void archivePlots() {
        steps.echo "Running 'archivePlots' from inside GmosArcTests"

        def tarFile = new File(env.DRAGONS_TEST_OUTPUTS, this._path_to_plots)

        if (tarFile.exits()) {
            steps.echo "Confirmed that file exists: ${tarFile}"
        } else {
            steps.echo "Could not find file: ${tarFile}"
        }

    }

}