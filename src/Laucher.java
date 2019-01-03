import java.util.HashMap;

public class Laucher {
    public static void main(String[] args) {
        String base = "fsrnsyv";

        HashMap<Character, Character> map = new HashMap<>();
        map.put('e', 'a');
        Key key = new Key(map);
        key.associerAuto();
        System.out.println(key.decode(base));
    }
}
