package TDTDD;

import org.example.Dictionary;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class DictionaryTest {
    @Test
    public void testDictionaryName()
    {
        assertThat((new Dictionary("Example")).getName(), equalTo("Example"));
    }

    @Test
    public void testDictionaryEmpty()
    {
        assertThat((new Dictionary("testDictionaryEmpty")).isEmpty(), equalTo(true));
    }

    @Test
    public void testOneTranslation()
    {
        Dictionary dict = new Dictionary("French2English");
        dict.addTranslation("contre", "against");
        assertThat(dict.getTranslation("contre"), equalTo("against"));
    }
}
