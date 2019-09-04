package gemini.dragons

interface IStepExecutor {
    int sh(String command)
    void error(String message)
}