

public class Kontroll {

    Modell m;
    GUI gui;


    Kontroll() {
        gui = new GUI(this);
        m = new Modell();
    }

    void oppdaterVolum(double V) {
        m.oppdaterVolum(V);
    }

    void logKaffe(double V) {
        m.logKaffeKonsum(V);
    }


    void quit() {
        m.avslutt();
        System.exit(9);
    }

    void run() {
        m.run();
    }

    boolean isRunning() {
        return m.running;
    }



}
