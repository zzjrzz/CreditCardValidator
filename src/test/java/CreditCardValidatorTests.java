import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CreditCardValidatorTests {
    @Test
    public void Valid_Credit_Card_Numbers() {

        assertTrue(new CreditCardValidator().isValidNumber(4111111111111111L));
        assertTrue(new CreditCardValidator().isValidNumber(4012888888881881L));
        assertTrue(new CreditCardValidator().isValidNumber(378282246310005L));
        assertTrue(new CreditCardValidator().isValidNumber(6011111111111117L));
        assertTrue(new CreditCardValidator().isValidNumber(5105105105105100L));
    }

    @Test
    public void Invalid_Credit_Card_Numbers() {
        assertFalse(new CreditCardValidator().isValidNumber(4111111111111L));
        assertFalse(new CreditCardValidator().isValidNumber(5105105105105106L));
        assertFalse(new CreditCardValidator().isValidNumber(9111111111111111L));
    }

    @Test
    public void Valid_Lengths(){
        assertTrue(new CreditCardValidator().isRightLength(1234567890123L));
        assertTrue(new CreditCardValidator().isRightLength(123456789012345L));
        assertTrue(new CreditCardValidator().isRightLength(1234567890123456L));
    }

    @Test
    public void Invalid_Lengths(){
        assertFalse(new CreditCardValidator().isRightLength(12345678901234L));
    }
}
