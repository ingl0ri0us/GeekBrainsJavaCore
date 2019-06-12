package Lesson_3;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ListOfWords {
    public static void main(String[] args) {

        ArrayList<String> listOfWords = new ArrayList<>();
        addDifferent20(listOfWords);
        addSame10(listOfWords);
        System.out.println(listOfWords);

        HashSet<String> uniqueWords = new HashSet<>(listOfWords);
        System.out.println(uniqueWords);

        HashMap <String, Integer> map = new HashMap<>();

        for(String word : listOfWords) {

            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        printMap(map);
    }

    private static void addDifferent20(ArrayList<String> list) {
        for(int i = 0; i < 20; i++) {
            list.add("word" + i);
        }
    }
    private static void addSame10(ArrayList<String> list) {
        for(int i = 0; i < 10; i++) {
            list.add("TheSameWord");
        }
    }
    private static void printMap(HashMap<String, Integer> mapToPrint) {
        for (Map.Entry<String, Integer> pair : mapToPrint.entrySet()) {
            System.out.println(pair.getKey() + " повторяется " + pair.getValue() + " раз.");
        }
    }
}
