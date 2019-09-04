
import gemini.dragons.build.MsBuild
import gemini.dragons.ioc.ContextRegistry


def call(String solutionPath) {
    ContextRegistry.registerDefaultContext(this)

    def msbuild = new MsBuild(solutionPath)
    msbuild.build()
}