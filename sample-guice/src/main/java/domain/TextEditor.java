package domain;

import annotation.AssertProvider;
import annotation.Provider;
import annotation.UseJUnit;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import contract.Assertor;
import contract.DatabaseAccess;
import contract.SampleProvider;
import contract.SpellChecker;

import static annotation.Provider.TestNG;


public class TextEditor {
    private SpellChecker spellChecker;
    private Assertor assertorJUnit;
    private Assertor assertorTestNG;

    @Inject
    public TextEditor(
            SpellChecker spellChecker,
            //@Named("TestNG") Assertor assertor,
            //@UseTestNG Assertor assertor,
            //@DbAction SampleProvider sampleProvider,
            DatabaseAccess databaseAccess,
            SampleProvider sampleProvider,
            @Named("Context") Context context1,
            @Named("Context") Context context2,
            @AssertProvider(TestNG) Assertor assertor) {
        this.spellChecker = spellChecker;
        sampleProvider.someAction();
        databaseAccess.someAction();
        //System.out.println(context1.hashCode());
        //System.out.println(context2.hashCode());
    }
    public void makeSpellCheck() {
        spellChecker.checkSpelling();
//        assertorJUnit.equal(1,1);
//        assertorTestNG.equal(1,1);
    }
}