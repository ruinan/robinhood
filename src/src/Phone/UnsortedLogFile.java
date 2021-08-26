package Phone;

import java.text.DecimalFormat;
import java.util.*;

public class UnsortedLogFile {
    /*
    *
    *
    * https://leetcode.com/discuss/interview-question/1144222/Karat-Interview-for-Robinhood-SWE
    * https://leetcode.com/playground/UpvU9DZe 某人的答案
Anonymous User
Anonymous User
Last Edit: April 5, 2021 8:32 PM

2.5K VIEWS


Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID.
The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

For example:
logs1 = [
["58523", "user_1", "resource_1"],
["62314", "user_2", "resource_2"],
["54001", "user_1", "resource_3"],
["200", "user_6", "resource_5"],
["215", "user_6", "resource_4"],
["54060", "user_2", "resource_3"],
["53760", "user_3", "resource_3"],
["58522", "user_22", "resource_1"],
["53651", "user_5", "resource_3"],
["2", "user_6", "resource_1"],
["100", "user_6", "resource_6"],
["400", "user_7", "resource_2"],
["100", "user_8", "resource_6"],
["54359", "user_1", "resource_3"],
]

Example 2:
logs2 = [
["300", "user_1", "resource_3"],
["599", "user_1", "resource_3"],
["900", "user_1", "resource_3"],
["1199", "user_1", "resource_3"],
["1200", "user_1", "resource_3"],
["1201", "user_1", "resource_3"],
["1202", "user_1", "resource_3"]
]

Write a function that takes the logs and returns the resource with the highest number of accesses in any 5 minute window, together with how many accesses it saw.

Expected Output:
most_requested_resource(logs1) # => ('resource_3', 3)

Follow Up
Write a function that takes the logs as input, builds the transition graph and returns it as an adjacency list with probabilities. Add START and END states.

Specifically, for each resource, we want to compute a list of every possible next step taken by any user, together with the corresponding probabilities. The list of resources should include START but not END, since by definition END is a terminal state.

Expected output for logs1:
transition_graph(logs1) # =>
{
'START': {'resource_1': 0.25, 'resource_2': 0.125, 'resource_3': 0.5, 'resource_6': 0.125},
'resource_1': {'resource_6': 0.333, 'END': 0.667},
'resource_2': {'END': 1.0},
'resource_3': {'END': 0.4, 'resource_1': 0.2, 'resource_2': 0.2, 'resource_3': 0.2},
'resource_4': {'END': 1.0},
'resource_5': {'resource_4': 1.0},
'resource_6': {'END': 0.5, 'resource_5': 0.5}
}

For example, of 8 total users, 4 users have resource_3 as a first visit (user_1, user_2, user_3, user_5), 2 users have resource_1 as a first visit (user_6, user_22), 1 user has resource_2 as a first visit (user_7), and 1 user has resource_6 (user_8) so the possible next steps for START are resource_3 with probability 4/8, resource_1 with probability 2/8, and resource_2 and resource_6 with probability 1/8.

These are the resource paths per user for the first logs example, ordered by access time:
{
'user_1': ['resource_3', 'resource_3', 'resource_1'],
'user_2': ['resource_3', 'resource_2'],
'user_3': ['resource_3'],
'user_5': ['resource_3'],
'user_6': ['resource_1', 'resource_6', 'resource_5', 'resource_4'],
'user_7': ['resource_2'],
'user_8': ['resource_6'],
'user_22': ['resource_1'],
}

Expected output for logs2:
transition_graph(logs2) # =>
{
'START': {'resource_3': 1.0},
'resource_3': {'resource_3: 0.857, 'END': 0.143}
}
    *
    * */

    public List<String> highestNumberOfAccess(String[][] data) {
        // 滑动窗口。
        Arrays.sort(data, (a, b) -> Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0])));
        Map<String, Integer> count = new HashMap<>();
        int max = 0, j = 0;
        String value = "";
        for (int i = 0; i < data.length; i++) {
            count.put(data[i][2], count.getOrDefault(data[i][2], 0) + 1);
            while (Integer.parseInt(data[i][0]) - Integer.parseInt(data[j][0]) > 5 * 60) {
                String resource = data[j++][2];
                count.put(resource, count.get(resource) - 1);
                if (count.get(resource) == 0) {
                    count.remove(resource);
                }
            }
            // 这里能不能加速？？
            for (String key : count.keySet()) {
                if (count.get(key) > max) {
                    max= count.get(key);
                    value = key;
                }
            }
        }

        return Arrays.asList(value, max + "");
    }


    public Map<String, List<String[]>> getAdjListWithProbability(String[][] data) {
        Map<String, List<String[]>> map = new HashMap<>(); // <user, <resource, time>>
        Map<String, List<String[]>> res = new HashMap<>();
        // 按照user 统计其resource 和time
        for (String[] d : data) {
            map.putIfAbsent(d[1], new ArrayList<>());
            map.get(d[1]).add(new String[]{d[2], d[0]});
        }
        // 对resource 和time pairs 按照time 排序
        for (List<String[]> v : map.values()) {
            Collections.sort(v, (a, b) -> Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1])));
        }

        // 找到每个节点的下一个节点。
        // 这里为了方便，把start 也看作一个节点。
        // 对于list 的末尾节点，它的下一个节点是end
        Map<String, List<String>> nextNode = new HashMap<>();
        nextNode.put("START", new ArrayList<>());

        for (List<String[]> v : map.values()) {
            for (int i = 1; i < v.size(); i++) {
                nextNode.putIfAbsent(v.get(i - 1)[0], new ArrayList<>());
                nextNode.get(v.get(i - 1)[0]).add(v.get(i)[0]);
            }
            nextNode.putIfAbsent(v.get(v.size() - 1)[0], new ArrayList<>());
            nextNode.get(v.get(v.size() - 1)[0]).add("END");
            nextNode.get("START").add(v.get(0)[0]);
        }

        for (String node : nextNode.keySet()) {
            res.put(node, calculateProbability(nextNode.get(node)));
        }
        return res;
    }

    private List<String[]>  calculateProbability(List<String> temp) {
        Map<String, Integer> map = new HashMap<>();
        for (String t : temp) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        List<String[]> res = new ArrayList<>();
        for (String t : map.keySet()) {
            res.add(new String[]{t, percentage(map.get(t), temp.size())});
        }
        return res;
    }

    private String percentage(int numerator, int denominator) {
        double percentage = (double)numerator / (double) denominator;
        DecimalFormat decimalFormat = new DecimalFormat("0.000");
        return decimalFormat.format(percentage);
    }

}
