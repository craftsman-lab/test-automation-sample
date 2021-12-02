package implementation;

import contract.SampleProvider;

public class SampleProviderImp implements SampleProvider {
    private String dbUrl;
    private String user;
    public SampleProviderImp(String dbUrl,String user){
        this.dbUrl = dbUrl;
        this.user = user;
    }
    @Override
    public void someAction() {
        System.out.println("SampleProviderImp - someAction... ... | " + dbUrl);
    }
}
