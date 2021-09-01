package Phone;
import java.util.*;
//        String[][] test = {{"Curtis",    "745", "enter"},
//            {"Jennifer",  "800", "enter"},
//            {"Curtis",    "810", "exit"},
//            {"John",      "815", "enter"},
//            {"Paul",      "830", "enter"},
//            {"Jennifer",  "900", "exit"},
//            {"Paul",      "903", "exit"},
//            {"John",      "908", "exit"},
//            {"Curtis",   "1100", "enter"},
//            {"Paul",     "1214", "enter"},
//            {"Jennifer", "1217", "enter"},
//            {"John",     "1230", "enter"},
//            {"Paul",     "1235", "exit"},
//            {"John",     "1235", "exit"},
//            {"Jennifer", "1240", "exit"},
//            {"Curtis",   "1330", "exit"},
// };
//        System.out.println(getLargestGroup(test));

public class LargestGroup {
    /*
    是上一题threeTimesOneHour的follow up：
    follow up是给name, timestamp和action (Enter or Exit)，找出在同一时间里 都(这个都真的是无法理解)在房间里超过两次以上的 group里 人最多的那个group，返回里面的所有‍‍‍‍‍‍‍‍‌‍‌‌‍‌‌‌‌‌人和对应的interval。

    follow up是找出超过两次同时出现的最多人数，输出他们的人名和出现的时间段

    * 第二题是 largest group (大家找一下以前的帖子看具体题，我这里就贴一下code）注意 输入不是sorted 的
    这个题要输出的是，因为有人进屋子，有人出屋子，问停留在屋子里的人最多的时间段是哪个时间段，而且这些人都是谁。

    //    {"Curtis",    "745", "enter"}, ["Curtis"]
    //    {"Jennifer",  "800", "enter"}, ["Curtis", "Jennifer"]
    //    {"Curtis",    "810", "exit"},  ["Jennifer"]
    //    {"John",      "815", "enter"}, ["Jennifer", "John"]
    //    {"Paul",      "830", "enter"}, ["Jennifer", "John", "Paul"]
    //    {"Jennifer",  "900", "exit"},  ["John", "Paul"]
    //    {"Paul",      "903", "exit"},  ["John"]
    //    {"John",      "908", "exit"},  []
    //    {"Curtis",   "1100", "enter"}, ["Curtis"]
    //    {"Paul",     "1214", "enter"}, ["Curtis", "Paul"]
    //    {"Jennifer", "1217", "enter"}, ["Jennifer", "Curtis", "Paul"]
    //    {"John",     "1230", "enter"}, ["John", "Jennifer", "Curtis", "Paul"]
    //    {"Paul",     "1235", "exit"},
    //    {"John",     "1235", "exit"},
    //    {"Jennifer", "1240", "exit"},
    //    {"Curtis",   "1330", "exit"},
// }

    // [Jennifer, John, Paul],[830, 900],[1230, 1235]
    * */

// 看样子是找到每一个组合出现的次数大于1 的时候，最长的那个组合的所有的时间区间

    // 我这里假设所有的名字都是uni key
    // 下面是不对group 排序的方法。

    public List<List<String>> largestGroup(String[][] tuples) {
        List<List<String>> res = new ArrayList<>();
        if (tuples == null || tuples.length == 0) {
            return res;
        }
        // 按照时间排序。这里并没有把同一个人的放在一起
        Arrays.sort(tuples, (a, b) -> a[1].length() == b[1].length() ? a[1].compareTo(b[1]) : Integer.compare(a[1].length(), b[1].length()));
        // 从时间开始到结束，记录每个时刻的人数变化
        // 因为tuple 的出现代表了，房屋内的人数一定会变化
        Set<String>[] peopleInTheRoom = new HashSet[tuples.length];

        for (int i = 0; i < tuples.length; i++) {
            Set<String> people = (i == 0 ? new HashSet<>() : new HashSet<>(peopleInTheRoom[i - 1])); // 重新拷贝上一个时间点屋内的人
            if (tuples[i][2].equals("enter")) {
                people.add(tuples[i][0]);
            } else {
                people.remove(tuples[i][0]);
            }
            peopleInTheRoom[i] = people;
        }

        Set<String> p = new HashSet<>();
        List<List<String>> durations = new ArrayList<>();

        // 这里的写法是，比较任意两个时刻，看看这俩时刻的屋子里的人的交集 是不是比现有的结果的人多，如果是，更新备选时刻和屋子里的人
        // 注意，这种做法仅限在两个时刻中比较
        // 如果说要找到任意子集的组合，这个就麻烦了。因为abd +c  和后面某个时刻的abe + c 的交集是abc，满足条件。但是这样需要比较两个集合中的所有子集。计算量大
        // 所以这里就比较两个集合的子集
        for (int i = 0; i < tuples.length - 2; i++) { // 这里是要找到i 到i +1 这个区间的值，所以必须小于长度- 1， 又以为j 在i 的后面，也要留出一个区间，所以j - 2
            for (int j = i+1; j < tuples.length - 1; j++) {
                Set<String> temp = new HashSet<>(peopleInTheRoom[i]);;
                temp.retainAll(peopleInTheRoom[j]);
                if (temp.size() > p.size()) {
                    p = temp;
                    durations = new ArrayList<>();
                    durations.add(new ArrayList<>(Arrays.asList(tuples[i][1], tuples[i + 1][1])));
                    durations.add(new ArrayList<>(Arrays.asList(tuples[j][1], tuples[j + 1][1])));
                }
            }
        }
        res.add(new ArrayList<>(p));
        res.addAll(durations);
        return res;
    }

}
