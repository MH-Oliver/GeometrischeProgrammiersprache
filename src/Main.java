import java.awt.*;

public class Main {
    public static void main(String[] args) {


       Scanner lScanner = new Scanner();
       Repetition lRepetition = lScanner.scanne("WH 2 [ WH 4 [ VW 7 RE 4 VW 6 LI 8 ] RE 2 ]");
        List<Befehl> lList = new List<Befehl>();
        lRepetition.convertToCommandList(lList);
        System.out.println("Ausgabe der fertigen Liste:");
        lList.toFirst();
        while (lList.hasAccess()) {
            System.out.println(lList.getContent().typ + " " + lList.getContent().wert);
            lList.next();
        }
        





        /*System.out.println("Hello world!");
        long lZeit = System.currentTimeMillis();
        for ( long i = 0; i<Integer.MAX_VALUE;++i) {

        }
        System.out.println("++i: "+ (System.currentTimeMillis() - lZeit));
        lZeit = System.currentTimeMillis();
        for (long   g = 0; g<Integer.MAX_VALUE;g++) {

        }
        System.out.println("i++: "+ (System.currentTimeMillis() - lZeit));*/
    }
}