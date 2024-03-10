package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#vratKdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.vratKdyMaSvatek("Nataša"));
        assertEquals(MonthDay.of(5,5), svatky.vratKdyMaSvatek("Claudia"));
        assertEquals(MonthDay.of(5,12), svatky.vratKdyMaSvatek("Pankrác"));
        assertEquals(MonthDay.of(5,24), svatky.vratKdyMaSvatek("Vanesa"));
        assertEquals(MonthDay.of(5,28), svatky.vratKdyMaSvatek("Viliam"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        // Otestovat, že najde v seznamu existující jméno a nenajde neexistující jméno
        Svatky svatky = new Svatky();

        assertFalse(svatky.jeVSeznamu("Sabína"));
        assertFalse(svatky.jeVSeznamu("Eva"));
        assertFalse(svatky.jeVSeznamu("Jan"));
        assertTrue(svatky.jeVSeznamu("Kamila"));
        assertTrue(svatky.jeVSeznamu("Zbyšek"));
        assertTrue(svatky.jeVSeznamu("Ivo"));
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        // Otestovat, že vrací počet jmen, která máme v seznamu
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getPocetJmen());
    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        // Zkontrolovat, že seznam jmen má správný počet položek.
        Svatky svatky = new Svatky();
        assertEquals(svatky.getPocetJmen(), svatky.getSeznamJmen().size());
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, int)}
     */
    @Test
    void pridatSvatekDenMesicInt() {
        // Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Františka", 4, 6);
        assertTrue(svatky.jeVSeznamu("Františka"));
        assertEquals(svatky.vratKdyMaSvatek("Františka"), MonthDay.of(6, 4));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        // Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Dobroslav", 5, Month.JUNE);
        assertTrue(svatky.jeVSeznamu("Dobroslav"));
        assertEquals(svatky.vratKdyMaSvatek("Dobroslav"), MonthDay.of(6, 5));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void prridatSvatekMonthDay() {
        // Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Norbert", MonthDay.of(6, 6));
        assertTrue(svatky.jeVSeznamu("Norbert"));
        assertEquals(svatky.vratKdyMaSvatek("Norbert"), MonthDay.of(6, 6));
    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        // Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu.
        Svatky svatek = new Svatky();
        int pocetJmen = svatek.getPocetJmen();
        svatek.smazSvatek("Ferdinand");
        assertEquals(pocetJmen-1, svatek.getPocetJmen());
    }
}
