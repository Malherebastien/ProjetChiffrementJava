import java.util.HashMap;

public class Key {

    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    private HashMap<Character, Character> map;

    public Key(HashMap<Character, Character> map) {
        this.map = map;
    }

    public Key() {
        this.map = new HashMap<Character, Character>();
    }

    /**
     * Ajoute une association dans la hashmap
     * @param key : Le caractère qu'on associe
     * @param association : le caractère qui se retrouve associé
     */
    public void creerAssociation(Character key, Character association) {
        this.map.put(key, association);
    }

    /**
     * Recupère le caractère associé à la clé
     * @param key : la clé
     * @return Le caractère associé
     */
    public Character getCharAssocie(Character key) {
        return this.map.get(key);
    }

    public void associerAuto() {
        if (this.map.isEmpty())
            return;

        int espacement = (char)(map.get(map.keySet().toArray()[0])) - (char)map.keySet().toArray()[0];
        System.out.println(espacement);

        for (int i = 97; i < 123; i++) {
            map.put((char)i, ALPHABET.charAt((i + 7 + espacement)%26));
        }

        for (Character key : map.keySet()) {
            System.out.println("key : " + key + "\tvalue : " + map.get(key));
        }
    }

    public String decode(String code) {
        String toReturn = "";
        for (char c : code.toCharArray()) {
            toReturn += map.get(c);
        }
        return toReturn;
    }
}
