#!/usr/bin/env groovy
/*
 * Class that holds methods related to GMOS Arc Tests
 */
package gemini.dragons


class GmosArcTests implements Serializable {

    def steps
    private String _path_to_plots

    GmosArcTests(steps) {
        this.steps = steps
        this._path_to_plots = "process_arcs/GMOS/tst_gmos_lsspec_arcs.tar.gz"
    }

    void archivePlots() {
        echo "Hello World"
    }

}