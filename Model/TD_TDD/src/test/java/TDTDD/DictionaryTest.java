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
        assertThat((new Dictionary("isEmpty")).isEmpty(), equalTo(true));
    }
}
