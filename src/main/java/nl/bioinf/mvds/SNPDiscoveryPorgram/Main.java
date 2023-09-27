package nl.bioinf.mvds.SNPDiscoveryPorgram;

import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
        main.start(args);
    }

    private void start(String[] args) throws FileNotFoundException {
        SNPStart snp = new SNPStart(args);
    }
}
