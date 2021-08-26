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
"John", "1255", // John 在12:55登录进系统
"Caisey", "5",// Caisey在00:05登录进系统
"John", "105"
"John", "1230"
"Robert", "240"
]

output: ["John", "1230 1255 105"]
大概题目的意思‍‍‍‍‍‍‍‍‌‍‌‌‍‌‌‌‌‌是这样，可能会有好几个人都符合条件。如果一个人在好几个时间段内满足条件只要记录第一个符合的时间段即可。

*
*
* 找出一个小时之类出入building 最多的人。
Notice： 这个是按小时group ， 每个人都有一个进出building record： name，[time1,time2,time3,time4]
可以先‍‍‍‍‍‍‍‍‌‍‌‌‍‌‌‌‌‌sort 一下这个时间， 然后计算每个小时出入building 次数  比如：  john ,  [1,6,61,71,81,100,120,300]   那么johon 一个小时之类 出入次数最高：【61，71，81，100】 =4

*
* 然后开始coding，题目是badge 打卡的题。给定很多<name, time> pairs, 表明某个人打卡记录，让找出是否有人一个小时内打卡了三次及以上。如果有人有多次 一小时内打卡三次及以上，只需要输出最早的一次即可。
eg.
["A", "1000"],
["B", "900"],
["B", "850"],
["B", "950"],
["B", "1200"],
["A", "1100"‍‍‍‍‍‍‍‍‌‍‌‌‍‌‌‌‌‌]

输出 B: 850, 900, 950.

原始问题是给name和timestamp，返回所有在一小时内打卡超过三次的name和对应的timestamp。一个tricky的点是timestamp是24小时制，比如855代表8:55am，1325代表1:35pm，在比较时间的时候不能直接相减，而要先做转化。
    *
    * */
    // 假设所有的time 都在一天，也就是从["0000", "2359"]
    // https://leetcode.com/playground/4XbjenvM 某人的答案

    public List<String> threeTimesOneHour (String[][] input) {
        // 我这里是返回所有的满足一小时之内刷了三次的人的名字。
        // 这个题的输出是没有按照输入顺序排列的。
        // 思考了一下，绝对不能按照string 排序。
        // 需要把时间转换为相对于00：00 的分钟
        Map<String, PriorityQueue<String>> map = new HashMap<>(); // <name, list<time>>
        // 上来就是排序，用PQ，对每个人排
        for (String[] s : input) {
            map.putIfAbsent(s[0], new PriorityQueue<>((a, b) -> convertTime(a).compareTo(convertTime(b))));
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
        // 这里题目要求输出一个结果就行，那么找到这么一个3个的tuple，立即返回就行
        for (int i = 1; i < temp.size() - 1; i++) {
            if (convertTime(temp.get(i + 1)) - convertTime(temp.get(i - 1)) <= 60) {
                return new ArrayList<>(Arrays.asList(temp.get(i - 1), temp.get(i), temp.get(i + 1)));
            }
        }
        return null;
    }

    private Integer convertTime(String a) {
        Integer min = 0;
        for (int i = 1; i <= 2; i++) {
            if (a.length() - i >= 0) {
                min = Character.digit(a.charAt(a.length() - i), 10) * (int)(Math.pow(10, i - 1)) + min;
            }
        }
        Integer hour = 0;
        for (int i = 1; i <= 2; i++) {
            if (a.length() - 2 - i >= 0) {
                hour = Character.digit(a.charAt(a.length() - 2 - i), 10) * (int)(Math.pow(10, i - 1)) + hour;
            }
        }
        return hour * 60 + min;
    }

}
