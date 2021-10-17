package week02.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode: https://leetcode-cn.com/problems/subdomain-visit-count/
 */
public class SubdomainVisitCount {
    public static void main(String[] args) {
        System.out.println(subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
        System.out.println(subdomainVisits(new String[]{
                "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"
        }));
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] countAndDomain = cpdomain.split(" ");
            Integer count = Integer.valueOf(countAndDomain[0]);
            String[] subDomains = countAndDomain[1].split("\\.");
            String domain = "";
            // 倒序、依次更新子域的计数
            for (int i = subDomains.length; i > 0; i--) {
                domain = subDomains[i - 1] + (domain.isBlank() ? "" : ".") + domain;
                int newCount = countMap.getOrDefault(domain, 0) + count;
                countMap.put(domain, newCount);
            }
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            res.add(String.format("%d %s", entry.getValue(), entry.getKey()));
        }
        return res;
    }
}
