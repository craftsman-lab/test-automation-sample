import com.google.inject.Guice;
import com.google.inject.Injector;
import domain.TextEditor;

public class GuiceSample {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new TextEditorModule());
        TextEditor textEditor = injector.getInstance(TextEditor.class);
        textEditor.makeSpellCheck();
    }
}
