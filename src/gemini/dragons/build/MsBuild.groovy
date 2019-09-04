package gemini.dragons.build

import gemini.dragons.IStepExecutor
import gemini.dragons.ioc.ContextRegistry


class MsBuild implements Serializable {

    private String _solutionPath

    MsBuild(String solutionPath) {
        _solutionPath = solutionPath
    }

    void build() {
        IStepExecutor steps = ContextRegistry.getContext().getStepExecutor()

        int returnStatus = steps.sh("echo \"building ${this._solutionPath}...\"")
        if (returnStatus != 0) {
            steps.error("some error")
        }
    }
}
