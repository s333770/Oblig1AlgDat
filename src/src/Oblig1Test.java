import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Oblig1Test {
    // Lager et globalt test-Array:
    //Oppgave 1

    // Oppgave 2
    private static int[] sortertArray = {1, 2, 3, 4, 7, 10, 17, 51};
    private static int[] tomArray = {};

    private static int[] sortertGjentatt = {1, 1, 4, 4, 10, 10, 51, 51, 98, 98, 100, 1000, 1000};
    private static int[] ikkeSortertGjentatt = {4, 4, 1, 1, 3, 10, 10, 98, 51, 98};
    private static int[] oppgave4Array = {6, 10, 9, 4, 1, 3, 8, 5, 2, 7};
    private static int[] getOppgave4Array2 = {5, 4, 10, 1, 3, 7, 10, -3, -6};
    public String tall = "abcdefghijklmnopq";
    private static char[] oppgave5Tekst = {'a', 'b', 'c', 'd', 'e'};
    private static char[] oppgave6Tekst = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    private static String a = "ABC";
    private static String b = "DEFGH";
    private static String c = "IJKLMN";
    private static String d = "OPG";
    private static String e = "AB";
    private static String algdat[] = {"AM", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU"};
    private static int[] oppgave8 = {6, 10, 16, 11, 7, 12, 3, 9, 8, 5};
    private static int[] oppgave9={3,1,5,5,3,7,6,9,10};


    @Test
    void maks() {
        int[] values = {4,1,2,3,5,10,11,12};
        assertEquals(Oblig1.maks(values),12);
    }

    @Test
    void ombyttinger() {
         int[] testArray = {4, 51, 1, 3, 7, 10, 17, 2};
        assertEquals(Oblig1.ombyttinger(testArray),6);

    }

    @Test
    void antallUlikeSortert() {

    }

    @Test
    void antallUlikeIkkeSortert() {
    }

    @Test
    void delsortering() {
    }

    @Test
    void rotasjon() {
    }

    @Test
    void rotasjonMedIndividuelleElementer() {
    }

    @Test
    void rotasjonHoyreVenstre() {
    }

    @Test
    void flett() {
    }

    @Test
    void flettEnString2() {
    }

    @Test
    void flettEnString() {
    }

    @Test
    void indekssortering() {
    }

    @Test
    void tredjeMin() {
    }

    @Test
    void tredjeMinAlternativ() {
    }

    @Test
    void inneholdt() {
    }

    @Test
    void sortCharArray() {
    }

    @Test
    void main() {
    }
}