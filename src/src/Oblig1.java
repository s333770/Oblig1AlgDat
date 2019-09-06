import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    // Lager et globalt test-Array:
    private static int [] testArray={4,51,1,3,7,10,17,2};
    private static int [] sortertArray={1,2,3,4,7,10,17,51};
    private static int[] sortertGjentatt={1,1,4,4,10,10,51,51,98};
     private static int [] oppgave4Array = {6,10,9,4,1,3,8,5,2,7};
     private static int [] getOppgave4Array2={5,4,10,1,3,7,10};
     public String tall="abcdefghijklmnopq";
     private static char[] oppgave5Tekst={'a','b','c','d','e'};

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




    public static void main(String[] args) {
       // Oblig1.maks(testArray); //Denne koden fungerer nå
       // Oblig1.ombyttinger(testArray); // Denne koden fungerer nå
        //Oblig1.antallUlikeSortert(sortertGjentatt);
       //Oblig1.antallUlikeIkkeSortert(sortertGjentatt);
      //Oblig1.delsortering(getOppgave4Array2);
        //Oblig1.rotasjon(oppgave5Tekst);
        Oblig1.rotasjonMedIndividuelleElementer(oppgave5Tekst);
    }

}
