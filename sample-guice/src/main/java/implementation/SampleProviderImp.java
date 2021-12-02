package implementation;

import contract.SampleProvider;

public class SampleProviderImp implements SampleProvider {
    public SampleProviderImp(String dbUrl, String user) {
    }

    @Override
    public void someAction() {
        System.out.println("SampleProviderImp - someAction ... ...");
    }
}
