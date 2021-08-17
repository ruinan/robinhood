package Phone;

import java.util.*;

public class ThreeTimesOneHour {
    /*
    *
    more than 3 times within one hour

    给 list of [name, time], time is string format: '1300' //下午一点
    return: list of names and the times where their swipe badges within one hour.
    if there are multiple intervals that satisfy the condition, return any one of them.
    name1: time1, time2, time3...
    name2: time1, time2, time3, time4, time5...
    example:
    input: [['James', '1300'],
            ['Martha', '1600'],
            ['Martha', '1620'],
            ['Martha', '1530']]
    output: {
    'Martha': ['1600', '1620', '1530']
    }


    接下是一个coding题目：找出所有员工里面在一个小时内超过三次登录进系统的人。
input:
[
"John", "1255",  // John 在12:55登录进系统
"Caisey", "5",  // Caisey在00:05登录进系统
"John", "105"
"John", "1230"
"Robert", "240"
]

output: ["John", "1230 1255 105"]
大概题目的意思‍‍‍‍‍‍‍‍‌‍‌‌‍‌‌‌‌‌是这样，可能会有好几个人都符合条件。如果一个人在好几个时间段内满足条件只要记录第一个符合的时间段即可。


    *
    * */
    // 假设所有的time 都在一天，也就是从["0000", "2359"]

    public List<String> threeTimesOneHour (String[][] input) {
        // 我这里是返回所有的满足一小时之内刷了三次的人的名字。
        // 这个题的输出是没有按照输入顺序排列的。
        Map<String, PriorityQueue<String>> map = new HashMap<>(); // <name, list<time>>
        for (String[] s : input) {
            map.putIfAbsent(s[0], new PriorityQueue<>((a, b) -> a.compareTo(b)));
            map.get(s[0]).add(s[1]);
        }
        List<String> res = new ArrayList<>();
        for (String name : map.keySet()) {
            List<String> time = checkTime(map.get(name));
            if (time != null) {
                res.add(name);
                res.addAll(time);
                return res;
            }
        }
        return res;
    }

    private List<String> checkTime(PriorityQueue<String> pq) {
        if (pq.size() < 3) {
            return null;
        }
        List<String> temp = new ArrayList<>(pq);
        for (int i = 1; i < temp.size() - 1; i++) {
            if (Integer.parseInt(temp.get(i + 1)) - Integer.parseInt(temp.get(i - 1)) <= 100) {
                return new ArrayList<>(Arrays.asList(temp.get(i - 1), temp.get(i), temp.get(i + 1)));
            }
        }
        return null;
    }
}
