import com.google.inject.Provider;
import contract.SampleProvider;
import implementation.SampleProviderImp;

public class SampleClassProvider implements Provider<SampleProvider> {
    @Override
    public SampleProvider get() {
        String dbUrl = "jdbc:mysql://localhost:5326/emp";
        String user = "user";
        SampleProvider sampleProvider = new SampleProviderImp(dbUrl, user);
        return sampleProvider;
    }
}
