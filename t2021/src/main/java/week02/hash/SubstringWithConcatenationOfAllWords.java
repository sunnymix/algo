package week02.hash;

import common.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode: https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 * <p>
 * 思路：
 * 与 GroupAnagrams 相似。
 */
public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Print.line(findSubstring("", new String[]{}));
        Print.line(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        Print.line(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        Print.line(findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        int tot = 0;
        Map<String, Integer> wordsMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int wordLen = 0;
        if (words.length > 0) {
            wordLen = words[0].length();
        }
        for (String word : words) {
            tot += word.length();
            int cnt = wordsMap.getOrDefault(word, 0) + 1;
            wordsMap.put(word, cnt);
        }
        for (int i = 0; i + tot <= s.length(); i++) {
            if (_valid(s.substring(i, i + tot), wordsMap, wordLen)) {
                res.add(i);
            }
        }
        return res;
    }

    private static boolean _valid(String words, Map<String, Integer> wordsMap, int wordLen) {
        Map<String, Integer> splitWordsMap = new HashMap<>();
        for (int i = 0; i < words.length(); i += wordLen) {
            String word = words.substring(i, i + wordLen);
            int cnt = splitWordsMap.getOrDefault(word, 0) + 1;
            splitWordsMap.put(word, cnt);
        }
        return _equalsMap(wordsMap, splitWordsMap);
    }

    private static boolean _equalsMap(Map<String, Integer> map1, Map<String, Integer> map2) {
        for (Map.Entry<String, Integer> i : map1.entrySet()) {
            String k = i.getKey();
            Integer v = i.getValue();
            if (map2.get(k) == null || !map2.get(k).equals(v)) {
                return false;
            }
        }
        for (Map.Entry<String, Integer> i : map2.entrySet()) {
            String k = i.getKey();
            Integer v = i.getValue();
            if (map1.get(k) == null || !map1.get(k).equals(v)) {
                return false;
            }
        }
        return true;
    }
}
