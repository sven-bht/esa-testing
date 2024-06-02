package Aufgabe3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VerlagTest {

    /*
     * Wenn null als Eingabe gegeben wird, soll eine Exception geworfen werden
     * */
    @Test
    void nullInput() {
        assertThrows(RuntimeException.class, () -> Verlag.berechne(null));
    }

    /*
    * Wenn eine leere Zeichenkette eingegeben wird, muss 0 zuückgegeben werden.
    * */
    @Test
    void emptyString() {
        int money = Verlag.berechne("");
        assertEquals(money, 0);
    }

    /*
     * Wenn die Zeichenkette neun Zeichen enthält müssen immer noch 0 zurückgegeben werden
     * */
    @Test
    void nineChars() {
        int money = Verlag.berechne("abcdefghi");
        assertEquals(money, 0);
    }

    /*
     * Wenn die Zeichenkette zehn Zeichen enthält muss 1 zurückgegeben werden
     * */
    @Test
    void tenChars() {
        int money = Verlag.berechne("abcdefghij");
        assertEquals(money, 1);
    }

    /*
     * Bei 25 Zeichen muss 2 zurückgegeben werden
     * */
    @Test
    void twentyFiveChars() {
        int money = Verlag.berechne("abcdefghijabcdefghijabcde");
        assertEquals(money, 2);
    }

    /*
     * Bei 59 Zeichen muss 5 zurückgegeben werden
     * */
    @Test
    void fiftyNineChars() {
        int money = Verlag.berechne("abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghi");
        assertEquals(money, 5);
    }

    /*
     * Lange Zeichenketten müssen auch erkannt werden
     * */
    @Test
    void longString() {
        int money = Verlag.berechne("abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij " +
                "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
                "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
                "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
                "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
                "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
                "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
                "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
                "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" +
                "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij");
        assertEquals(money, 100);
    }

    /*
     * Spezielle Zeichen müssen auchg erkannt werden
     * */
    @Test
    void specialChars() {
        int money = Verlag.berechne("!!!!!!!!!!@@@@@@@@@@##########$$$$$$$$$$%%%%%%%%%%^^^^^^^^^^&&&&&&&&&&**********(((((((((()))))))))))ääääääääääööööööööööüüüüüüüüüü");
        assertEquals(money, 13);
    }
}
