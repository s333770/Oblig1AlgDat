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
        int a [] =new int [n];
        for(int i=0; i<n; i++) {
            a[i] = r.nextInt(n) + 1;
            for(int j=0; j<i; j++){
                if(a[i]==a[j]){
                    i--;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(a));
        return a;
    }
    private static int[] randPermBoolean(int n){ //Kopiert fra boken for generering av testverdier
        Random r= new Random();
        int []a =new int[n];
        boolean [] har = new boolean[n];

        for(int i=0; i<n;){
            int k=r.nextInt(n);
            if(har[k]==false){
                har[k]=true;
                a[i++]=k+1;
            }
        }
        System.out.println(Arrays.toString(a));
        return a;
    }

    // Lager et globalt test-Array:
    //Oppgave 1
    private static int [] testArray={4,51,1,3,7,10,17,2};
    // Oppgave 2
    private static int [] sortertArray={1,2,3,4,7,10,17,51};
    private static int [] tomArray={};

    private static int[] sortertGjentatt={1,1,4,4,10,10,51,51,98,98,100,1000,1000};
    private static int[] ikkeSortertGjentatt={4,4,1,1,3,10,10,98,51,98};
     private static int [] oppgave4Array = {6,10,9,4,1,3,8,5,2,7};
     private static int [] getOppgave4Array2={5,4,10,1,3,7,10,-3,-6};
     public String tall="abcdefghijklmnopq";
     private static char[] oppgave5Tekst={'a','b','c','d','e'};
     private static char []oppgave6Tekst={'A','B','C','D','E','F','G','H','I','J'};
     private static String a= "ABC";
     private static String b="DEFGH";
     private static String c="IJKLMN";
     private static String d="OPG";
     private static String e="AB";
     private static  String algdat[]={"AM","L","GEDS","ORATKRR","","R TRTE","IO","TGAUU"};
     private static int [] oppgave8= {6,10,16,11,7,12,3,9,8,5};

//Oppgave 1
    /*
    Det blir flest ombyttinger hvis det største tallet er størst.
    Det blir færrest hvis det største tallet er sist
    I gjennomsnitt blir det ca: Må spørre i timen om dette.

     */

    public static int maks(int [] a){
        if(a.length<1){
            throw new NoSuchElementException("Tabellen er tom");
        }
        for(int i=0; i<a.length-1;i++){
            if(a[i]>a[i+1]){
                int temp=a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
            }
        }
        System.out.println(a[a.length-1]);
        return a[a.length-1];
    }

    public static int ombyttinger(int []a){
        if(a.length<1){
            throw new NoSuchElementException("Tabellen er tom");
        }
        int antallOmbyttinger=0;
        for(int j=0; j<a.length-1;j++){
            if(a[j]>a[j+1]){
                int temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
                antallOmbyttinger++;
            }

        }
        System.out.println(antallOmbyttinger);
        return antallOmbyttinger;

    }
        //Oppgave 2
    public static int antallUlikeSortert(int [] a){
        int teller=1;
        if(a.length==0){
            return 0;
        }
        for(int x=0; x<a.length-1;x++){
            if(a[x]>a[x+1]){
                throw new IllegalStateException("Arrayen er ikke sortert");
            }
        }

        for(int x=0;x<a.length-1;x++){
            if(a[x]!=a[x+1]){
                teller++;
            }
        }
        System.out.println(teller);
        return teller;
    }
    //Oppgave 3
    public static int antallUlikeIkkeSortert(int [] a){
        int teller=1;
        if(a.length==0){
            return 0;
        }
        for (int i=1; i<a.length; i++){
            int j=0;
            for(j=0;j<i; j++) {
                if (a[i] == a[j]) {
                    break;
                }
            }
                if(i==j){
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
    public static void delsortering(int [] a){

        //Gjør først oppdeling av par og oddetall
        int start=0, slutt=a.length-1;
        int oddetallTeller=0;
        while(start<slutt){
            while(a[start]%2==0){
                start++;
            }
            while(a[slutt]%2==1){
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

        for(int i=0; i<oddetallTeller; i++){
            int temp=a[i];
            int j=i;
            while(j>0 && temp <a[j-1]){
                a[j]=a[j-1];
                j=j-1;
            }
            a[j]=temp;
        }
        for(int j=oddetallTeller+1; j<a.length; j++){
            int temp=a[j];
            int x=j;
            while(x>0 && temp <a[x-1]){
                a[x]=a[x-1];
                x=x-1;
            }
            a[x]=temp;
        }
        System.out.println(Arrays.toString(a));
    }

        public static void rotasjon(char[] a){
        char[] rotertArray= new char [a.length];
        int j=0;
        for(int i=a.length-1; i>=0;i--){
            rotertArray[j]=a[i];
            j++;
        }
            System.out.println(Arrays.toString(rotertArray));
        }
//Mye bedre og mer effektiv
        public static void rotasjonMedIndividuelleElementer(char []a){
            int j=0;
            for(int i=oppgave5Tekst.length-1;i>((oppgave5Tekst.length)/2); i--){
                char temp=a[i];
                      a[i]=a[j];
                      a[j]=temp;
                      j++;
            }
            System.out.println(Arrays.toString(a));
        }

    //Oppgave 6
    public static void rotasjonHoyreVenstre(char[] a, int k)
    {
        int n = a.length;  if (n < 2) return;
        if ((k %= n) < 0){
            k += n;
        }

        char[] b = Arrays.copyOfRange(a, n -k, n);
        for (int i = n - 1; i >= k; i--) {
            a[i] = a[i - k];
        }
        System.arraycopy(b, 0, a, 0, k);
        System.out.println(a);
    }


    // Oppgave 7
    public static String flett(String s, String t){
        String output="";
        if(s.length()<=0 || t.length()<=0){
            throw new IllegalArgumentException("En av strengene er tomme");
        }
        for( int i=0; i<s.length() || i<t.length(); i++){
            if(i<s.length()){
                output+= String.valueOf(s.charAt(i));
            }
            if(i<t.length()){
                output+=String.valueOf(t.charAt(i));
            }
        }
        System.out.println(output);
        return output;
    }

    // Oppgave 7 B
    public static String flettEnString2(String [] st){
        String output="";
        int x=0;
        int y=0;
        for(int i=0; i<st.length; i++) {
            while (st[i].length() > x) {
                output += st[i].charAt(x);

            }

            }
        x++;
        System.out.println(output);
        return output;
        // Må se litt mer på denne
    }

    public static String flettEnString(String[] s){ // Ingen eller flere elementer
        String ut="";
        int []arr=new int [s.length];
        for(int i=0; i<s.length; i++){
            for(int j=0; j<s.length;j++){
                if(arr[j]<s[j].length()){
                    ut+=s[j].toCharArray()[arr[j]];
                    arr[j]++;
                }
            }
        }
        System.out.println(ut);
        return ut;
    }



    public static int[] indekssortering(int []a) { // Bruker først insertionsort
        int[] indexer = new int[a.length];
        for(int i=1;i<a.length;i++){
            int j=i;
            for(;j>=1 && a[j]<a[j-1];j--){
                int temp = a[j];
                a[j] = a[j-1];
                indexer[j]=indexer[j-1];
                a[j-1] = temp;
            }
            indexer[j]=i;
        }
        System.out.println(Arrays.toString(indexer));

        return indexer;//indices of sorted elements
    }

    //Oppgave9
    public static int[] tredjeMin(int[] a) // ny versjon
    {
        int n = a.length;     // tabellens lengde
        if (n < 3) throw      // må ha minst to verdier
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = 0;      // m er posisjonen til største verdi
        int nm = 1;     // nm er posisjonen til nest største verdi
        int nnm=2;      //Posisjonen til tredje største verdi

        // bytter om m og nm hvis a[1] er større enn a[0]
        if (a[1] > a[0]) { m = 1; nm = 0; }

        int maksverdi = a[m];                // største verdi
        int nestmaksverdi = a[nm];           // nest største verdi

        for (int i = 2; i < n; i++)
        {
            if (a[i] > nestmaksverdi)
            {
                if (a[i] > maksverdi)
                {
                    nm = m;
                    nestmaksverdi = maksverdi;     // ny nest størst

                    m = i;
                    maksverdi = a[m];              // ny størst
                }
                else
                {
                    nm = i;
                    nestmaksverdi = a[nm];         // ny nest størst
                }
            }
        } // for

        return new int[] {m,nm};    // n i posisjon 0, nm i posisjon 1

    } // nestMaks
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
       // int a[] = Oblig1.randPermBoolean(5);
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
        System.out.println(Arrays.toString(oppgave8));
        Oblig1.indekssortering(oppgave8);
        //System.out.println(Oblig1.inneholdt("ABBC", "BABB"));
        //Oblig1.flettEnString(algdat);
    }

}
