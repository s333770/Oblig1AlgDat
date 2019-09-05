import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Oblig1 {

    // Lager et globalt test-Array:
    private static int [] testArray={4,51,1,3,7,10,17,2};
    private static int [] sortertArray={1,2,3,4,7,10,17,51};
    private static int[] sortertGjentatt={1,1,1,2,2,2,4,4,10,10,51};
    public int testArrayLengde=testArray.length;

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
        int str=sortertGjentatt.length;
        int [] arrayMedVerdier=new int[str];
        int teller=0;
        for (int i=0; i<a.length; i++){
            if(a[i]>a[i+1]){
                throw new IllegalStateException("Arrayen er ikke sortert");
            }
            for(int j=0;j<i; j++){
                if(a[i]==a[j]){
                    break;
                }
                if(i==j){

                }
            }
        }
        System.out.println(teller);
    return teller;

    }

    public static void main(String[] args) {
       // Oblig1.maks(testArray); //Denne koden fungerer nå
       // Oblig1.ombyttinger(testArray); // Denne koden fungerer nå
        Oblig1.antallUlikeSortert(sortertGjentatt);
    }

}
