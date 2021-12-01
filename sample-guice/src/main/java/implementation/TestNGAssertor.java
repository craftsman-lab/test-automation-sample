package implementation;

import contract.Assertor;

public class TestNGAssertor implements Assertor {
    @Override
    public void equal(int expectedValue, int factValue) {
        System.out.println("TestNG Assertor equal... ...");
    }
}
