import annotation.*;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import contract.Assertor;
        import contract.SpellChecker;
        import implementation.JUnitAssertor;
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

        bind(Assertor.class).annotatedWith(AssertProviders.assertProvider(Other)).to(JUnitAssertor.class);
        bind(Assertor.class).annotatedWith(AssertProviders.assertProvider(JUnit)).to(JUnitAssertor.class);
        bind(Assertor.class).annotatedWith(AssertProviders.assertProvider(TestNG)).to(TestNGAssertor.class);
//        AnnotatedElement.

    }
}
