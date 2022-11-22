package step.definitions;

import io.cucumber.java.After;

public class TestCasesSteps extends BaseClass{
    public TestCasesSteps(TestContext context) {
        this.driver = context.driver;
    }

    /*@After
    public void close_browser() {
        super.close_browser();
    }*/
}
