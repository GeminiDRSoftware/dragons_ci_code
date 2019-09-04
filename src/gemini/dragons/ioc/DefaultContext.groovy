package gemini.dragons.ioc

import gemini.dragons.IStepExecutor
import gemini.dragons.StepExecutor


class DefaultContext implements IContext, Serializable {

    private _steps

    DefaultContext(steps) {
        this._steps = steps
    }

    @Override
    IStepExecutor getStepExecutor() {
        return new StepExecutor(this._steps)
    }

}
