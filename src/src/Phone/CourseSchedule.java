package Phone;

import java.sql.Array;
import java.util.*;


/*
*
// 一堆课，找出上课顺序里,中间的那门课，只有一种正确的顺序，并且每个课只会对应另外一个prereq
// 比如

//     ["Data Structures", "Algorithms"],
//     ["COBOL", "Networking"],
//     ["Algorithms", "COBOL"],

// "Data Structures"->"Algorithms" -> "COBOL"-> "Networking"

// 返回 “Algorithms".
// time Complexity O(E + V). V is the number of course, E is number of depency,is the course length
// space complexity is the same*/
public class CourseSchedule {
    public String findMiddle(String[][] pairs) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        for (String[] pair : pairs) {
            for (String p : pair) {
                indegree.put(p, 0);
            }
        }
        for (String[] pair : pairs) {
            graph.putIfAbsent(pair[0], new ArrayList());
            graph.get(pair[0]).add(pair[1]);
            indegree.put(pair[1], indegree.get(pair[1]) + 1);
        }
        List<String> path = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        for (String key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.offer(key);
            }
        }
        while (!queue.isEmpty()) {
            String cur = queue.remove();
            path.add(cur);
            if (!graph.containsKey(cur)) {
                continue;
            }
            for (String neighbor : graph.get(cur)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return path.get((path.size() - 1) / 2);
    }

    public String findMiddleBFS(String[][] pairs) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        for (String[] pair : pairs) {
            for (String p : pair) {
                indegree.put(p, 0);
            }
        }
        for (String[] pair : pairs) {
            graph.putIfAbsent(pair[0], new ArrayList());
            graph.get(pair[0]).add(pair[1]);
            indegree.put(pair[1], indegree.get(pair[1]) + 1);
        }
        List<String> path = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        for (String key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.offer(key);
            }
        }
        while (!queue.isEmpty()) {
            String cur = queue.remove();
            path.add(cur);
            if (!graph.containsKey(cur)) {
                continue;
            }
            for (String neighbor : graph.get(cur)) {
               queue.offer(neighbor);
            }
        }
        return path.get((path.size() - 1) / 2);
    }
}
