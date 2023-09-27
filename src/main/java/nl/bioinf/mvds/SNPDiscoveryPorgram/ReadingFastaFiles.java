package nl.bioinf.mvds.SNPDiscoveryPorgram;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingFastaFiles {
    public List<String> readFastaFile (String filename) throws FileNotFoundException {

        boolean first = true;
        List<String> seqs = new ArrayList<String>();
        String body = "";

        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.charAt(0) == '>') {
                    if (first)
                        first = false;
                    else
                        seqs.add(body);
                        body = "";
                } else {
                    body += line;
                }
            }
        }
        return seqs;
    }
}
