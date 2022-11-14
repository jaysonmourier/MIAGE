package TDTDD;

import org.example.Dictionary;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.MatcherAssert.assertThat;

public class DictionaryTest {
    private Dictionary dict;
    @Before
    public void initialize()
    {
        dict = new Dictionary("Example");
        dict.addTranslation("contre", "against");
    }
    @Test
    public void testDictionaryName()
    {
        assertThat(dict.getName(), equalTo("Example"));
    }

    @Test
    public void testDictionaryEmpty()
    {
        assertThat(dict.isEmpty(), equalTo(false));
    }

    @Test
    public void testOneTranslation()
    {
        assertThat(dict.getTranslation("contre"), equalTo("against"));
    }

    @Test
    public void testMultipleTranslation()
    {
        assertThat(List.of("x", "y"), containsInAnyOrder("y", "x"));
    }

}
