import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

import static java.lang.Math.abs;

public class Oblig1 {


 private static int[] randPerm(int n)  // virker, men er svært ineffektiv
  {
    Random r = new Random();      // en randomgenerator
      int a [] =new int [n];
      for(int i=0; i<n; i++) {
          int k = r.nextInt() + 1;
          for (int j = 0; j < i; j++) {
              if (a[j] == k) {
                  break;
              }
              if (i == j) {
                  a[i++] = k;

              }
          }
      }
                return a;
  }



    // Lager et globalt test-Array:
    //Oppgave 1
    private static int [] testArray={4,51,1,3,7,10,17,2};
    private static int [] generert= Oblig1.randPerm(1000); // Se litt mer på generering av array

    private static int [] sortertArray={1,2,3,4,7,10,17,51};
    private static int[] sortertGjentatt={1,1,4,4,10,10,51,51,98};
    private static int[] ikkeSortertGjentatt={4,4,1,1,3,10,10,98,51,98};
     private static int [] oppgave4Array = {6,10,9,4,1,3,8,5,2,7};
     private static int [] getOppgave4Array2={5,4,10,1,3,7,10};
     public String tall="abcdefghijklmnopq";
     private static char[] oppgave5Tekst={'a','b','c','d','e'};
     private static char []oppgave6Tekst={'A','B','C','D','E','F','G','H','I','J'};
     private static String a= "ABC";
     private static String b="DEFGH";
     private static String c="IJKLMN";
        private static String d="OPG";
        private static String e="AB";
       private static  String algdat[]={"AM","LL","GEDS","ORATKRR","WL","R TRTE","IO","TGAUU"};
       private static int [] oppgave8= {6,10,16,11,7,12,3,9,8,5};

//Oppgave 1
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
    public static void delsortering(int [] a){

        //Gjør først oppdeling av par og oddetall
        int start=0, slutt=a.length-1;
        int oddetallTeller=1;
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
    public static String flettEnString(String [] st){
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
        //Oblig1.maks(generert); //Denne koden fungerer nå
        //Oblig1.ombyttinger(generert); // Denne koden fungerer nå
        //Oblig1.antallUlikeSortert(sortertGjentatt);
       Oblig1.antallUlikeIkkeSortert(ikkeSortertGjentatt);
      //Oblig1.delsortering(getOppgave4Array2);
        //Oblig1.rotasjon(oppgave5Tekst);
        //Oblig1.rotasjonMedIndividuelleElementer(oppgave5Tekst);
        //Oblig1.rotasjon(oppgave6Tekst,-2);
        //Oblig1.flett(a,b);
       // Oblig1.flettEnString(algdat);
       // Oblig1.rotasjonHoyreVenstre(oppgave6Tekst,-8);
        //Oblig1.flettEnString(algdat);
       // Oblig1.indekssortering(oppgave8);
        //System.out.println(Oblig1.inneholdt("ABBC", "BABB"));
        Oblig1.flettEnString(algdat);
    }

}
