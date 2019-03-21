package junit.exemple1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactureTest {

    boolean thrown;

    @Before
    public void setUp() throws Exception {
        thrown = false;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void ajouterTaxe1() throws IllegalArgumentException {
        long exp = 114;
        long actual = Facture.ajouterTaxe(100, true, true);
        assertEquals(114, actual);
    }

    @Test
    public void ajouterTaxe2() throws IllegalArgumentException {
        assertEquals(105, Facture.ajouterTaxe(100, true, false));
    }

    @Test
    public void ajouterTaxe3() throws IllegalArgumentException {
        assertEquals(109, Facture.ajouterTaxe(100, false, true));
    }

    @Test
    public void ajouterTaxe4() throws IllegalArgumentException {
        assertNotEquals(109, Facture.ajouterTaxe(100, true, true));
    }

    @Test
    public void ajouterTaxe5() {

        try {
            Facture.ajouterTaxe(0, false, true);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        assertTrue(thrown);

    }

    @Test
    public void ajouterTaxe6() {

        try {
            Facture.ajouterTaxe(-12, false, true);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        assertTrue(thrown);

    }


}