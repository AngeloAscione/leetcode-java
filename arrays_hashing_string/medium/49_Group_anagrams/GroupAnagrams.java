import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {


    // Non è la più efficiente. 
    // Si potrebbe creare un array di frequenze e trasformarlo in stringhe per ottenere la chiave della mappa, 
    // rimuovendo l'ordinamento

    // RICORDA Molto spesso, quando si ha a che fare con lettere dell'alfabeto, anagrammi ecc... L'array di frequenze può aiutare
    public static List<List<String>> groupAnagrams(String[] strs) {
    
        Map<String, List<String>> groupedAnagrams = new HashMap<>();

        if (strs.length == 1) {
            return List.of(List.of(strs[0]));
        }

        for (String s : strs) {
            // int sIntSum = getStringIntegerSum(s);
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            String key = new String(sArr);
            List<String> anagrams = groupedAnagrams.getOrDefault(key, new ArrayList<>());
            anagrams.add(s);
            groupedAnagrams.put(key, anagrams);
        }
        
        return new ArrayList<>(groupedAnagrams.values());
    }

    public static int getStringIntegerSum(String s) {
        char[] sArr = s.toCharArray();
        int sum = 0;
        for (char c : sArr) {
            sum += c;
        }
        return sum;
    }


    public static void main(String ...args) {
        String[] anagrams = new String[]{"act","pots","tops","cat","stop","hat"};
        System.out.println(groupAnagrams(anagrams));

        anagrams = new String[]{"x"};
        System.out.println(groupAnagrams(anagrams));

        anagrams = new String[]{""};
        System.out.println(groupAnagrams(anagrams));
    }
}
