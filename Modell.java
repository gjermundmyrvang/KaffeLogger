
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class Modell {

    Date dato;
    double volum_dl;
    int coffeineLevel = 80;
    String log = "";
    String filnavn = "kaffeforbruk.txt";

    PrintWriter skriver;

    boolean running = false;



    Modell()  {
        dato = new Date();
        volum_dl = 0;

        try {
            skriver = new PrintWriter(new FileWriter(filnavn, true));
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }

        skriver.println(dato);
    }

    void run() {
        running = !running;
    }


    void oppdaterVolum(double v) {
        volum_dl += v;
    }


    void logKaffeKonsum(double v) {
        oppdaterVolum(v);
        String datostreng = dato.toString();
        String tidspunkt = datostreng.substring(11, 19);
        log = "Kaffe konsumert: " + v + "dl" + "  ---->  kl. " + tidspunkt;
        skriver.println("\n" + log);

    }

    void avslutt() {
        skriver.print("\nTotalt kaffe konsum idag: " + volum_dl + " dl");
        skriver.print("\nTotalt koffein inntak: " + volum_dl*coffeineLevel + " mg");
        skriver.print("\n--------------------------------------------------");
        skriver.println();
        skriver.close();
    }




}


