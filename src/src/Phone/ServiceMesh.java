package Phone;


import java.util.*;
public class ServiceMesh {
    /*
    * x

给一堆service call relations和一个entrypoint，比如 [a:b,c, b:c] a意思就是a会call b和c，b还会call c，然后assume entrypoint a有一个request，这样a的load就是1，b也是1，c是2。就是每个service都会completely fanout它收到的requests，比如如果c要有downstream的话，c给他每个downstream的load就是2.

用topological sort做，要注意除了entrypoint之外还有别的service可能没有ind‍‍‍‍‍‍‍‍‌‍‌‌‍‌‌‌‌‌egree，这些service 的load要是0，不然漏掉的话graph traverse不完

还要注意有些service的downstream是不存在的，ignore就好

就按照该帖楼主的解法宽搜做没问题，一定要注意楼主说的“要注意除了entrypoint之外还有别的service可能没有indegree，这些service 的load要是0，不然漏掉的话graph traverse不完”。否则有的测试用例不过的。
https://www.1point3acres.com/bbs/thread-714435-1-1.html 感觉bfs 不对
    * */

    public Map<String, Integer> findLoadFactor(List<String> relations, String entryPoint) {
        // 不知道要这个entry point 的意义在哪
        // 如果有交叉点，那么从a 到c 可能load 的值会比从b 到c 多。这个时候算哪一个？
        Map<String, Integer> res = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String,Integer> indegree = new HashMap<>();
        for (String relation : relations) {
            putRelation(relation, graph, indegree);
        }
        Queue<String> queue = new PriorityQueue<>();
        for (String key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.offer(key);
            }
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int l = 0; l < size; l++) {
                String cur = queue.remove();
                res.put(cur, level);
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
            level ++;
        }
        return res;
    }

    private void putRelation(String relation,  Map<String, List<String>> graph,  Map<String,Integer> indegree) {
        String[] r = relation.split(":");
        graph.putIfAbsent(r[0], new ArrayList<>());
        String[] neighbors = r[1].split(",");
        graph.get(r[0]).addAll(Arrays.asList(neighbors));
        indegree.putIfAbsent(r[0], 0);
        for (String n : neighbors) {
            indegree.put(n, indegree.getOrDefault(n, 0) + 1);
        }
    }
}
