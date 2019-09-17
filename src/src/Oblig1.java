import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

import static java.lang.Math.abs;

public class Oblig1 {

    private static int[] randPerm(int n)  // virker, men er svært ineffektiv
    {
        Random r = new Random();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(n) + 1;
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    i--;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(a));
        return a;
    }

    private static int[] randPermBoolean(int n) { //Kopiert fra boken for generering av testverdier
        Random r = new Random();
        int[] a = new int[n];
        boolean[] har = new boolean[n];

        for (int i = 0; i < n; ) {
            int k = r.nextInt(n);
            if (har[k] == false) {
                har[k] = true;
                a[i++] = k + 1;
            }
        }
        System.out.println(Arrays.toString(a));
        return a;
    }



//Oppgave 1
    /*
    Det blir flest ombyttinger hvis det største tallet er størst.
    Det blir færrest hvis det største tallet er sist
    I gjennomsnitt blir det ca: Må spørre i timen om dette.

     */

    public static int maks(int[] a) {
        if (a.length < 1) {
            throw new NoSuchElementException("Tabellen er tom");
        }
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
        System.out.println(a[a.length - 1]);
        return a[a.length - 1];
    }

    public static int ombyttinger(int[] a) {
        if (a.length < 1) {
            throw new NoSuchElementException("Tabellen er tom");
        }
        int antallOmbyttinger = 0;
        for (int j = 0; j < a.length - 1; j++) {
            if (a[j] > a[j + 1]) {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
                antallOmbyttinger++;
            }

        }
        System.out.println(antallOmbyttinger);
        return antallOmbyttinger;

    }

    //Oppgave 2
    public static int antallUlikeSortert(int[] a) {
        int teller = 1;
        if (a.length == 0) {
            return 0;
        }
        for (int x = 0; x < a.length - 1; x++) {
            if (a[x] > a[x + 1]) {
                throw new IllegalStateException("Arrayen er ikke sortert");
            }
        }

        for (int x = 0; x < a.length - 1; x++) {
            if (a[x] != a[x + 1]) {
                teller++;
            }
        }
        System.out.println(teller);
        return teller;
    }

    //Oppgave 3
    public static int antallUlikeIkkeSortert(int[] a) {
        int teller = 1;
        if (a.length == 0) {
            return 0;
        }
        for (int i = 1; i < a.length; i++) {
            int j = 0;
            for (j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    break;
                }
            }
            if (i == j) {
                teller++;
            }
        }
        System.out.println(teller);
        return teller;
    }

    //Oppgave 4
    /*
     public static void delsortering(int [] a) {

       //Gjør først oppdeling av par og oddetall
       int start = 0, slutt = a.length-1;
       int oddetallTeller = 0;
       while (start < slutt) {
           while (Math.floorMod(a[start],2) == 1) {
               start++;
           }
           while (Math.floorMod(a[slutt],2)==0) {
               oddetallTeller++;
               slutt--;
           }
           if(start<slutt){
               int temp=a[start];
               a[start]=a[slutt];
               a[slutt]=temp;
               start++;
               slutt--;
           }
       }
       System.out.println("Først sortert \n"+Arrays.toString(a)+"\n Antall oddetall: "+oddetallTeller);
       for(int i=0; i<oddetallTeller;i++){
           for(int j=i+1; j<oddetallTeller; j++){
               if(a[i]>a[j]){
                   int temp = a[i];
                   a[i] = a[j];
                   a[j] = temp;
               }
           }
       }
        for(int i=a.length-1; i>=oddetallTeller;i--){
            for(int j=i-1; j>=oddetallTeller; j--){
                if(a[i]<a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(a));
   }

    public static void main(String[] args){
        Main.delsortering(getOppgave4Array2);
       }
}
     */
    public static int[] delsortering(int[] a) {

        //Gjør først oppdeling av par og oddetall
        int start = 0, slutt = a.length - 1;
        int oddetallTeller = 0;
        while (start < slutt) {
            while (a[start] % 2 == 1) {
                start++;
            }
            while (a[slutt] % 2 == 0) {
                oddetallTeller++;
                slutt--;
            }
            if (start < slutt) {
                int temp = a[start];
                a[start] = a[slutt];
                a[slutt] = temp;
                start++;
                slutt--;
            }
        }

        for (int i = 0; i < oddetallTeller; i++) {
            int temp = a[i];
            int j = i;
            while (j > 0 && temp < a[j - 1]) {
                a[j] = a[j - 1];
                j = j - 1;
            }
            a[j] = temp;
        }
        for (int j = oddetallTeller + 1; j < a.length; j++) {
            int temp = a[j];
            int x = j;
            while (x > 0 && temp < a[x - 1]) {
                a[x] = a[x - 1];
                x = x - 1;
            }
            a[x] = temp;
        }
        System.out.println(Arrays.toString(a));
        return a;
    }

    public static void rotasjon(char[] a) {
        char[] rotertArray = new char[a.length];
        int j = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            rotertArray[j] = a[i];
            j++;
        }
        System.out.println(Arrays.toString(rotertArray));
    }

    //Mye bedre og mer effektiv
    public static void rotasjonMedIndividuelleElementer(char[] a) {
        int j = 0;
        for (int i = a.length - 1; i > ((a.length) / 2); i--) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            j++;
        }
        System.out.println(Arrays.toString(a));
    }

    //Oppgave 6
    public static void rotasjonHoyreVenstre(char[] a, int k) {
        int n = a.length;
        if (n < 2) return;
        if ((k %= n) < 0) {
            k += n;
        }

        char[] b = Arrays.copyOfRange(a, n - k, n);
        for (int i = n - 1; i >= k; i--) {
            a[i] = a[i - k];
        }
        System.arraycopy(b, 0, a, 0, k);
        System.out.println(a);
    }


    // Oppgave 7
    public static String flett(String s, String t) {
        String output = "";
        if (s.length() <= 0 || t.length() <= 0) {
            throw new IllegalArgumentException("En av strengene er tomme");
        }
        for (int i = 0; i < s.length() || i < t.length(); i++) {
            if (i < s.length()) {
                output += String.valueOf(s.charAt(i));
            }
            if (i < t.length()) {
                output += String.valueOf(t.charAt(i));
            }
        }
        System.out.println(output);
        return output;
    }



    public static String flettEnString(String[] s) { // Ingen eller flere elementer
        String ut = "";
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (arr[j] < s[j].length()) {
                    ut += s[j].toCharArray()[arr[j]];
                    arr[j]++;
                }
            }
        }
        System.out.println(ut);
        return ut;
    }


    public static int[] indekssortering(int[] a) {
        int[] indexer = new int[a.length];
        for (int i = 1; i < a.length; i++) {
            int j = i;
            for (; j >= 1 && a[j] < a[j - 1]; j--) {
                int temp = a[j];
                a[j] = a[j - 1];
                indexer[j] = indexer[j - 1];
                a[j - 1] = temp;
            }
            indexer[j] = i;
        }
        System.out.println(Arrays.toString(indexer));

        return indexer;//indices of sorted elements
    }

    //Oppgave9
    public static int[] tredjeMin(int[] a) // ny versjon
    {
        int[] returTabell = new int[3];
        int i, storste, nestStorste, tredjeStorste;
        if (a.length < 3) {
            throw new IndexOutOfBoundsException("For liten array");
        }
        storste = nestStorste = tredjeStorste = Integer.MIN_VALUE;
        for (i = 0; i < a.length - 1; i++) {
            if (a[i] > storste) {
                tredjeStorste = nestStorste;
                nestStorste = storste;
                storste = a[i];
            } else if (a[i] > nestStorste) {
                tredjeStorste = nestStorste;
                nestStorste = a[i];
            } else if (a[i] > tredjeStorste) {
                tredjeStorste = a[i];
            }
            returTabell[0] = storste;
            returTabell[1] = nestStorste;
            returTabell[2] = tredjeStorste;
        }
        System.out.println(storste + " " + nestStorste + " " + tredjeStorste);
        return returTabell;

    }

    public static int[] tredjeMin213(int[] a) // ny versjon
    {
        int minverdi=0;
        int nestMaksverdi=0;
        int tredjeMaksverdi=0;
        int[] returTabell = new int[3];
        if (a.length < 3) {
            throw new IndexOutOfBoundsException("For liten array");
        }
        if(a[2]>a[1] && a[2]>a[0]&&a[1]>a[0]){ //a2 a1 a0
            maksverdi=a[2];
            nestMaksverdi=a[1];
            tredjeMaksverdi=a[0];
        }
        else if(a[2]>a[1]&&a[2]>a[0]&&a[1]<a[0]){ //a2 a0 a1
             maksverdi=a[2];
             nestMaksverdi=a[0];
             tredjeMaksverdi=a[1];
        }
        else if(a[2]<a[1] && a[1]>a[0] && a[2]>a[0]){ // a1 a2 a0
            maksverdi=a[1];
            nestMaksverdi=a[2];
            tredjeMaksverdi=a[0];

        }
        else if(a[2]<a[1] && a[1]>a[0] && a[0]>a[2]){ //a1 a0 a2
            maksverdi=a[1];
            nestMaksverdi=a[0];
            tredjeMaksverdi=a[2];
        }
        else if(a[2]<a[1] && a[1]<a[0] && a[0]>a[2]){ //a0 a1 a2
            maksverdi=a[0];
            nestMaksverdi=a[1];
            tredjeMaksverdi=a[2];
        }
        else if(a[2]>a[1] && a[1]<a[0] && a[0]>a[2]){ //a0 a2 a1
            maksverdi=a[0];
            nestMaksverdi=a[2];
            tredjeMaksverdi=a[1];
        }
        for(int i=3; i<a.length;i++){
            if(a[i]>tredjeMaksverdi){
                if(a[i]>nestMaksverdi){
                    if(a[i]>maksverdi){
                        tredjeMaksverdi=nestMaksverdi;
                        nestMaksverdi=maksverdi;
                        maksverdi=a[i];
                    }

                }

            }

        }
        System.out.println("Største tall "+maksverdi+" Nest største "+nestMaksverdi+" TredjeStørst "+tredjeMaksverdi);
        return a;
    }

    public static int[] tredjeMin213(int[] a) // ny versjon
    {
        int maksverdi=0;
        int nestMaksverdi=0;
        int tredjeMaksverdi=0;
        int[] returTabell = new int[3];
        if (a.length < 3) {
            throw new IndexOutOfBoundsException("For liten array");
        }
        if(a[2]>a[1] && a[2]>a[0]&&a[1]>a[0]){ //a2 a1 a0
            maksverdi=a[2];
            nestMaksverdi=a[1];
            tredjeMaksverdi=a[0];
        }
        else if(a[2]>a[1]&&a[2]>a[0]&&a[1]<a[0]){ //a2 a0 a1
            maksverdi=a[2];
            nestMaksverdi=a[0];
            tredjeMaksverdi=a[1];
        }
        else if(a[2]<a[1] && a[1]>a[0] && a[2]>a[0]){ // a1 a2 a0
            maksverdi=a[1];
            nestMaksverdi=a[2];
            tredjeMaksverdi=a[0];

        }
        else if(a[2]<a[1] && a[1]>a[0] && a[0]>a[2]){ //a1 a0 a2
            maksverdi=a[1];
            nestMaksverdi=a[0];
            tredjeMaksverdi=a[2];
        }
        else if(a[2]<a[1] && a[1]<a[0] && a[0]>a[2]){ //a0 a1 a2
            maksverdi=a[0];
            nestMaksverdi=a[1];
            tredjeMaksverdi=a[2];
        }
        else if(a[2]>a[1] && a[1]<a[0] && a[0]>a[2]){ //a0 a2 a1
            maksverdi=a[0];
            nestMaksverdi=a[2];
            tredjeMaksverdi=a[1];
        }
        for(int i=3; i<a.length;i++){
            if(a[i]>tredjeMaksverdi){
                if(a[i]>nestMaksverdi){
                    if(a[i]>maksverdi){
                        tredjeMaksverdi=nestMaksverdi;
                        nestMaksverdi=maksverdi;
                        maksverdi=a[i];
                    }

                }

            }

        }
        System.out.println("Største tall "+maksverdi+" Nest største "+nestMaksverdi+" TredjeStørst "+tredjeMaksverdi);
        return a;
    }



    //Oppgave 10, sjekk s1 mot s2
    public static boolean inneholdt(String s1,String s2){
        char [] karakterer1=s1.toCharArray();
        for(int i=0; i<s1.length(); i++){
            char k= s1.charAt(i);
            if(s2.indexOf(k)==-1){//Retunerer indeksen til tallet, hvis tallet ikke eksisterer returner -1
                return false;
            }
        }
        return true;

    }

    public static char[] sortCharArray (char [] a){
        char[] indexer = new char[a.length];
        for(int i=1;i<a.length;i++){
            int j=i;
            for(;j>=1 && a[j]<a[j-1];j--){
                char temp = a[j];
                a[j] = a[j-1];
                indexer[j]=indexer[j-1];
                a[j-1] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
        return a;
    }


    public static void main(String[] args) {

        //int a[] = Oblig1.randPermBoolean(1000);
        //Oblig1.ombyttinger(a);
        //Først generering av randomNumre:
        //Oblig1.maks(a); //Denne koden fungerer nå

        //Oppgave 2
        //Oblig1.antallUlikeSortert(sortertGjentatt);
        //Oppgave 3
       //Oblig1.antallUlikeIkkeSortert(tomArray);
      //Oblig1.delsortering(getOppgave4Array2);
        //Oblig1.rotasjon(oppgave5Tekst);
        //Oblig1.rotasjonMedIndividuelleElementer(oppgave5Tekst);
        //Oblig1.rotasjon(oppgave6Tekst,-2);
        //Oblig1.flett(a,b);
        //Oblig1.flettEnString(algdat);
       // Oblig1.rotasjonHoyreVenstre(oppgave6Tekst,-8);
        //Oblig1.flettEnString(algdat);
       // System.out.println(Arrays.toString(oppgave8));
       // Oblig1.indekssortering(oppgave8);
        //System.out.println(Oblig1.inneholdt("ABBC", "BABB"));
        String algdat[] = {"AM ", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU"};
       int[] oppgave9={3,1,5,5,3,7,6,9,10};

       // Oblig1.flettEnString(algdat);
       // System.out.println(Arrays.toString(oppgave4Array));
        Oblig1.tredjeMin213(oppgave9);
        //Oblig1.tredjeMinAlternativ(oppgave9);
        //int testArray4[]={4,1,2,3,5,10,11,12};
        //Oblig1.delsortering(testArray4);
    }

}
