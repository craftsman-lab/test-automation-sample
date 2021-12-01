package domain;

import annotation.AssertProvider;
import annotation.Provider;
import annotation.UseJUnit;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import contract.Assertor;
import contract.SpellChecker;


public class TextEditor {
    private SpellChecker spellChecker;
    private Assertor assertorJUnit;
    private Assertor assertorTestNG;
    Assertor assertor;

    @Inject
    public TextEditor(
            SpellChecker spellChecker,
            //@UseJUnit Assertor assertor) {
            @AssertProvider(Provider.Other) Assertor assertor,
            @AssertProvider(Provider.JUnit) Assertor assertorJUnit,
            @AssertProvider(Provider.TestNG) Assertor assertorTestNG) {
        this.spellChecker = spellChecker;
        this.assertorJUnit = assertorJUnit;
        this.assertorTestNG = assertorTestNG;
        this.assertor=assertor;
    }

    public void makeSpellCheck() {
        spellChecker.checkSpelling();
        assertorJUnit.equal(1,1);
        assertorTestNG.equal(1,1);
    }
}