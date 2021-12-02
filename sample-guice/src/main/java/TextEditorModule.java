import annotation.*;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import contract.Assertor;
import contract.SampleProvider;
import contract.SpellChecker;
import domain.Context;
import implementation.JUnitAssertor;
import implementation.SampleProviderImp;
import implementation.SpellCheckerImpl;
import implementation.TestNGAssertor;

import java.lang.reflect.AnnotatedElement;

import static annotation.Provider.*;

public class TextEditorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(SpellChecker.class).to(SpellCheckerImpl.class);
//        bind(Assertor.class).annotatedWith(UseJUnit.class).to(JUnitAssertor.class);
//        bind(Assertor.class).annotatedWith(UseTestNG.class).to(TestNGAssertor.class);
        //bind(Assertor.class).annotatedWith(Names.named("JUnit")).to(JUnitAssertor.class);

        bind(Assertor.class).annotatedWith(AssertProviders.assertProvider(JUnit)).to(JUnitAssertor.class);
        bind(Assertor.class).annotatedWith(AssertProviders.assertProvider(TestNG)).to(TestNGAssertor.class);
//        AnnotatedElement.

        bind(String.class).annotatedWith(Names.named("JDBC")).toInstance("jdbc:mysql://localhost/pizza");
        //bindConstant().annotatedWith(AssertProviders.assertProvider(Other)).to("jdbc:mysql://localhost/pizza");
        //final Context context = new Context("test data");
//        bind(Context.class).annotatedWith(AssertProviders.assertProvider(JDBC)).toInstance(context);
//        bindConstant().annotatedWith(AssertProviders.assertProvider(JDBC)).to(Context.class);
        bind(SampleProvider.class).toProvider(SampleClassProvider.class);
    }

//    @Provides //@UseJUnit
//    public SampleProvider provideSampleProvider(@Named("JDBC") String dbUrl ) {
//        //String dbUrl = "jdbc:mysql://localhost:5326/emp";
//        String user = "user";
//        SampleProvider sampleProvider = new SampleProviderImp(dbUrl, user);
//        return sampleProvider;
//    }
}
