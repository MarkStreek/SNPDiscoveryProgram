package nl.bioinf.mvds.SNPDiscoveryPorgram;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class SNPStart {
    private final int position;
    private String filename = "homologene.txt";
    private final String mutation;
    private List<String> seqs = new ArrayList<>();
    private final Map<Integer, String> sequences = new HashMap<>();
    private final Map<String, Integer> acids = new HashMap<>();

    public SNPStart(String[] args) throws FileNotFoundException {
        this.position = parseInt(args[0]);
        this.mutation = args[1].toUpperCase();
        
        readingFile();


        creatingHashMap();
        getAminoAcids();
        calculateScoreOfAminoAcids();
    }
    
    public void readingFile() throws FileNotFoundException {
        ReadingFastaFiles file = new ReadingFastaFiles();
        this.seqs = file.readFastaFile(filename);
    }

    public void creatingHashMap() {

        for (String s : seqs) {
            sequences.put(s.length(), s);
            if (position > s.length()) {
                throw new IllegalArgumentException("Position out of range: " + position);
            }
        }
    }

    public void getAminoAcids() {
        for (String value : sequences.values()) {
            char acidIndex = value.charAt(position);
            String acid = String.valueOf(acidIndex);
            if (!acids.containsKey(acid)) {
                acids.put(acid, 0);
            }
            acids.put(acid, acids.get(acid) + 1);
        }
    }

    public void calculateScoreOfAminoAcids() {
        if (acids.containsKey(mutation)) {
            double amount = acids.get(mutation);

            double sum = 0;
            for (double value: acids.values()) {
                sum += value;
            }
            if (amount / sum >= 0.25) {
                System.out.println("Little to no effect!");
            } else {
                System.out.println("Mutation will have a big effect!");
            }
        } else {
            System.out.println("Mutation will have a big effect!");
        }
    }
}
