#!/usr/bin/env groovy
/*
 * Class that holds methods related to GMOS Arc Tests
 */
package gemini.dragons


class GmosArcTests implements Serializable {

    private String _path_to_plots

    GmosArcTests() {
        _path_to_plots = "process_arcs/GMOS/tst_gmos_lsspec_arcs.tar.gz"
    }

    void archivePlots() {
        echo this._path_to_plots
    }

}