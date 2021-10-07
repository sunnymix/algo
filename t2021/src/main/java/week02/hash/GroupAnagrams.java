package week02.hash;

import common.Print;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Print.list(groupAnagrams(new String[]{"a"}));
        Print.list(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        for (String str : strs) {
            char[] copy = str.toCharArray();
            Arrays.sort(copy);
            String key = String.valueOf(copy);
            if (!group.containsKey(key)) {
                group.put(key, new ArrayList<>());
            }
            group.get(key).add(str);
        }
        return new ArrayList<>(group.values());
    }
}
