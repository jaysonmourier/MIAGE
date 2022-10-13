package TDTDD;

import org.example.Main;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void appHasAGreeting()
    {
        Main classUnderTest = new Main();
        assertNotNull("App should have a greeting!", classUnderTest.getGreeting());
    }
}
