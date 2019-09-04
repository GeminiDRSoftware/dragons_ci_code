package gemini.dragons.build

import gemini.dragons.IStepExecutor
import gemini.dragons.ioc.ContextRegistry
import gemini.dragons.ioc.IContext
import org.junit.Before
import org.junit.Test

import static org.mockito.Mockito.*


/**
 * Example test class
 */
class MsBuildTest {
    private IContext _context
    private IStepExecutor _steps

    @Before
    void setup() {
        _context = mock(IContext.class)
        _steps = mock(IStepExecutor.class)

        when(_context.getStepExecutor()).thenReturn(_steps)

        ContextRegistry.registerContext(_context)
    }

    @Test
    void build_callShStep() {
        // prepare
        String solutionPath = "some/path/to.sln"
        MsBuild build = new MsBuild(solutionPath)

        // execute
        build.build()

        // verify
        verify(_steps).sh(anyString())
    }

    @Test
    void build_shStepReturnsStatusNotEqualsZero_callsErrorStep() {
        // prepare
        String solutionPAth = "some/path/to.sln"
        MsBuild build = new MsBuild(solutionPAth)

        when(_steps.sh(anyString())).thenReturn(-1)

        // execute
        build.build()

        // verify
        verify(_steps).error(anyString())
    }
}
