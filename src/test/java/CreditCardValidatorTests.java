import org.junit.Test;

import static org.junit.Assert.*;

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
    public void Valid_Luhn(){
        assertTrue(new CreditCardValidator().isValidLuhn(4408041234567893L));
    }

    @Test
    public void Invalid_Luhn(){
        assertFalse(new CreditCardValidator().isValidLuhn(4417123456789112L));
    }

    @Test
    public void Should_Output_Valid_Cards(){
        assertEquals("VISA: 4111111111111111    (valid)", new CreditCardValidator().validateCard(4111111111111111L));
        assertEquals("VISA: 4012888888881881    (valid)", new CreditCardValidator().validateCard(4012888888881881L));
        assertEquals("AMEX: 378282246310005    (valid)", new CreditCardValidator().validateCard(378282246310005L));
        assertEquals("Discover: 6011111111111117    (valid)", new CreditCardValidator().validateCard(6011111111111117L));
        assertEquals("MasterCard: 5105105105105100    (valid)", new CreditCardValidator().validateCard(5105105105105100L));
    }

    @Test
    public void Should_Output_Invalid_Cards(){
        assertEquals("VISA: 4111111111111    (invalid)", new CreditCardValidator().validateCard(4111111111111L));
        assertEquals("MasterCard: 5105105105105106    (invalid)", new CreditCardValidator().validateCard(5105105105105106L));
        assertEquals("Unknown: 9111111111111111    (invalid)", new CreditCardValidator().validateCard(9111111111111111L));
    }
}
