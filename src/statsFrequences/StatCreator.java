package statsFrequences;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class StatCreator {
    public static void createStats() {
        HashMap<Character, Integer> map = new HashMap<>();
        double nbCharacter = 0;
        try {
            Scanner scanner = new Scanner(new FileReader("res/20000_lieux_sous_les_mers.txt"));

            while(scanner.hasNext()) {
                String line = scanner.nextLine().replaceAll(" ", "");
                for (char c : line.toLowerCase().toCharArray()) {
                    if (!map.containsKey(c)) {
                        map.put(c, 1);
                    } else {
                        map.replace(c, map.get(c) + 1);
                    }
                    nbCharacter++;
                }
            }
            System.out.println(nbCharacter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter("res/Stats_FR");
            for (Character c : map.keySet()) {
                double nb = map.get(c);
                fileWriter.write(c + " : " + nb + " : " + String.format("%.3f", nb/nbCharacter * 100) + "%\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createStats();
    }
}
