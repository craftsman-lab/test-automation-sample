package domain;

import annotation.AssertProvider;
import annotation.Provider;
import annotation.UseJUnit;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import contract.Assertor;
import contract.SampleProvider;
import contract.SpellChecker;


public class TextEditor {
    private SpellChecker spellChecker;
    private Assertor assertorJUnit;
    private Assertor assertorTestNG;

    @Inject
    public TextEditor(
            SpellChecker spellChecker,
            SampleProvider sampleProvider,
            //@AssertProvider(Provider.JDBC) Context  jdbc,
            @AssertProvider(Provider.JUnit) Assertor assertorJUnit,
            @AssertProvider(Provider.TestNG) Assertor assertorTestNG) {
        this.spellChecker = spellChecker;
        this.assertorJUnit = assertorJUnit;
        this.assertorTestNG = assertorTestNG;
        //System.out.println(jdbc.hashCode());

        sampleProvider.someAction();
    }
    public void makeSpellCheck() {
        spellChecker.checkSpelling();
        assertorJUnit.equal(1,1);
        assertorTestNG.equal(1,1);
    }
}