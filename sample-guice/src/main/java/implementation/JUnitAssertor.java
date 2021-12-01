package implementation;

import contract.Assertor;

public class JUnitAssertor implements Assertor {
    @Override
    public void equal(int expectedValue, int factValue) {
        System.out.println("JUnit Assertor equal... ...");
    }
}
