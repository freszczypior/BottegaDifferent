package pl.com.bottega.splitString;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Split {

    public static void main(String[] args) {

        System.out.println(splitStringVer1("ala   ma kota ala"));
        System.out.println(splitStringVer1("  ala ma kota ala  "));
        System.out.println(splitStringVer1("        "));
        System.out.println(splitStringVer1(""));
        System.out.println("----------------------------------------");
        System.out.println(splitStringVer2("ala   ma kota ala"));
        System.out.println(splitStringVer2("  ala ma kota ala  "));
        System.out.println(splitStringVer2("        "));
        System.out.println(splitStringVer2(""));
    }

    public static Map<String, List<Integer>> splitStringVer1(String text) {
        String[] words = text.split(" +");
        Map<String, List<Integer>> map = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                int wordindex = text.indexOf(word);
                List<Integer> indexes = new LinkedList<>();
                map.put(word, indexes);
                while (wordindex >=0) {
                    indexes.add(wordindex);
                    wordindex = text.indexOf(word, wordindex + word.length());
                }
            }
        }
        return map;
    }

    public static Map<String, List<Integer>> splitStringVer2(String text) {
        String[] words = text.split(" ");
        Map<String, List<Integer>> map = new HashMap<>();
        int wordIndex = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                wordIndex = text.indexOf(word, wordIndex);
                putWord(map, word, wordIndex);
                wordIndex += 1;
            }
        }
        return map;
    }
    private static void putWord(Map<String, List<Integer>> map, String word, int index) {
        List<Integer> currentIndex = map.get(word);
        if (currentIndex == null) {
            currentIndex = new LinkedList<>();
            map.put(word, currentIndex);
        }
        currentIndex.add(index);
    }
}
