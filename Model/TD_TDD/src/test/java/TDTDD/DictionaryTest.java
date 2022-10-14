package TDTDD;

import org.example.Dictionary;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class DictionaryTest {
    private Dictionary dict;
    @Before
    public void initialize()
    {
        dict = new Dictionary("Example");
    }
    @Test
    public void testDictionaryName()
    {
        assertThat(dict.getName(), equalTo("Example"));
    }

    @Test
    public void testDictionaryEmpty()
    {
        assertThat(dict.isEmpty(), equalTo(true));
    }

    @Test
    public void testOneTranslation()
    {
        dict.addTranslation("contre", "against");
        assertThat(dict.getTranslation("contre"), equalTo("against"));
    }
}
