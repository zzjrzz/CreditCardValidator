import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StartsWithRuleTests {
    @Test
    public void Valid_If_Starts_With_Given_String(){
        assertTrue(new StartWithRule(new String[]{"34"}).isValid(345898465L));
    }

    @Test
    public void Invalid_If_Does_Not_Start_With_Given_String(){
        assertFalse(new StartWithRule(new String[]{"34"}).isValid(46558L));
    }
}
