import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LengthRuleTests {
    @Test
    public void Allowed_Length_Is_Equal_To_Length_Of_Value_Return_True() {
        assertTrue(new LengthRule(new int[]{10}).isValid(1234567890L));
    }

    @Test
    public void Allowed_Length_Is_Not_Equal_To_Length_Of_Value_Return_False() {
        assertFalse(new LengthRule(new int[]{1}).isValid(1234567890L));
    }
}
