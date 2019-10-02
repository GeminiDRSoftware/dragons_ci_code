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

        steps.echo "Running 'archivePlots' from inside GmosArcTests"

        def sourceFile = new File(env.DRAGONS_TEST_OUTPUTS, this._path_to_plots)
        def targetFolder = new File("plots/")
        def targetFile = new File(targetFolder, sourceFile.getName())

        if (! targetFolder.exists()) {
            targetFolder.mkdir()
        }

        if (sourceFile.exists()) {
            steps.echo "Confirmed that file exists: ${sourceFile}"
            steps.echo "Will copy it to the target file: ${targetFile}"
            Files.copy(sourceFile, tarFile)
//             steps.archiveArtifacts tarFile.toString()
        } else {
            steps.echo "Could not find file: ${sourceFile}"
        }

    }

}