import org.junit.Test;

import static org.junit.Assert.*;

public class AmexRuleTests {
    @Test
    public void Length_Of_16_Is_Valid(){
        assertTrue(new AmexRule().isValid(1234567890123456L));
    }

    @Test
    public void If_Length_Is_Not_16_Return_Invalid(){
        assertFalse(new AmexRule().isValid(12345L));
    }

    @Test
    public void Is_Amex_Type_If_Begins_With_34_or_37(){
        assertEquals(CreditCardType.AMEX, new AmexRule().isCardType(3400L));
        assertEquals(CreditCardType.AMEX, new AmexRule().isCardType(3700L));
    }

    @Test
    public void Is_Unknown_Type_If_Not_Starting_With_34_or_37(){
        assertEquals(CreditCardType.Unknown, new AmexRule().isCardType(558700L));
    }
}
