package gemini.dragons.ioc

import gemini.dragons.IStepExecutor

interface IContext {
    IStepExecutor getStepExecutor()
}
