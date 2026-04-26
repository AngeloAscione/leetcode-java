import java.util.HashMap;

public class ValidAnagram {
    
    // Bruteforce
    // public static boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) return false;
    //     char[] s_arr = s.toCharArray();
    //     char[] t_arr = t.toCharArray();
    //     Arrays.sort(s_arr);
    //     Arrays.sort(t_arr);
    //     for (int i = 0; i < s_arr.length; i++) {
    //         if (s_arr[i] != t_arr[i]) return false;
    //     }
    //     return true;
    // }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            // char c = s.charAt(i);
            // int count = charCount.getOrDefault(c, 0);
            // count++;
            // charCount.put(c, count);
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer count = charCount.get(c);
            if (count == null) return false;
            count--;
            if (count == 0) { 
                charCount.remove(c);
            } else {
                charCount.put(c, count);
            }
        }

        return charCount.isEmpty();
    }

    public static void main(String ...args) {

        String s = "racecar";
        String t = "carrace";

        if (isAnagram(s, t))
            System.out.println("TRUE");
        else
            System.out.println("FALSE");

    }

}
