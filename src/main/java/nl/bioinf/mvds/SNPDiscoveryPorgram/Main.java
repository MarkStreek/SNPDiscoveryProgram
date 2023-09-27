package nl.bioinf.mvds.SNPDiscoveryPorgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.start(args);
    }

    private void start(String[] args) {
        SNPStart snp = new SNPStart(args);
    }
}
