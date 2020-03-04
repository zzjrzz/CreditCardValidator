import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LuhnRuleTests {
    @Test
    public void Valid_Luhn(){
        assertTrue(new LuhnRule().isValid(4408041234567893L));
    }

    @Test
    public void Invalid_Luhn(){
        assertFalse(new LuhnRule().isValid(4417123456789112L));
    }
}
