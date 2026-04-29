public class LongestCommonPrefix {
    
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        // Soluzione a "Bruteforce", ordina e confronta primo e ultimo elemento fino a che riesce a trovare un prefisso valido
        // O(n * m log m)
        // Arrays.sort(strs);
        // String shortest = strs[0];
        // String longest = strs[strs.length - 1];
        // for (int i = 0; i < shortest.length(); i++) {
        //     if (shortest.charAt(i) != longest.charAt(i)) {
        //         return shortest.substring(0, i); 
        //     }
        // }
        // return shortest;


        // Soluzione Vertical Scanning, confronto a colonne ogni carattere
        for (int i = 0; i < strs[0].length(); i++) {
            for (String s: strs) {
                if (i == s.length() || strs[0].charAt(i) != s.charAt(i))
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }



    public static void main(String ...args) {

        String[] strs = new String[]{"bat","bag","bank","band"};
        System.out.println("Il prefisso più lungo comune è: " + longestCommonPrefix(strs));

        strs = new String[]{"dance","dag","danger","damage"};
        System.out.println("Il prefisso più lungo comune è: " + longestCommonPrefix(strs));

        strs = new String[]{"neet","feet"};
        System.out.println("Il prefisso più lungo comune è: " + longestCommonPrefix(strs));



    }

}
