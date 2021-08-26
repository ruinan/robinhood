package Phone;
import java.util.*;


public class largestGroup {
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
    //    {"Jennifer", "1217", "enter"},
    //    {"John",     "1230", "enter"},
    //    {"Paul",     "1235", "exit"},
    //    {"John",     "1235", "exit"},
    //    {"Jennifer", "1240", "exit"},
    //    {"Curtis",   "1330", "exit"},
// }

    // [Jennifer, John, Paul],[830, 900],[1230, 1235]
    * */


    // 这个题我的理解的意思是，在房间里的人，超过三个，构成组合。如果是四个的话，就是任选三个都构成组合。如果是五个的话，那么四个也构成组合。
    // 然后如果这个组合出现了两次以上，组合的人数三个或者三个以上。选出组合中人数最多的那个。返回这个组合，和这个组合中，所有的intervals

    // 我这里假设所有的名字都是uni key
    // 下面是不对group 排序的方法。

    public List<List<String>> largestGroup(String[][] tuples) {
        List<List<String>> res = new ArrayList<>();
        if (tuples == null || tuples.length == 0) {
            return res;
        }
        // 按照时间排序。这里并没有把同一个人的放在一起
        Arrays.sort(tuples, (a, b) -> a[1].length() == b[1].length() ? a[1].compareTo(b[1]) : Integer.compare(a[1].length(), b[1].length()));
        // 对每一个时刻，存当前时刻所有的人。如果某个时刻的屋子里的人数大于三，则从[0, i - 1] 找到其他区间包含了这个三个人的。如果比当前全局max 的人数多，那么更新全局max 和它对应的interval 集合
        // 这里还有一个问题，是要输出所有的intervals
        // 跟人名group 不排序相比，可能排序更好做。
        // 我们只记录当前group 的起始时间。
        // 包含
        Set<String>[] inRoom = new Set[tuples.length];
        Set<String> max = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < tuples.length; i++) {
            String[] tuple = tuples[i];
            inRoom[i] = new HashSet<>();
            if (i > 0) {
                inRoom[i].addAll(inRoom[i - 1]);
            }
            if (tuple[2].equals("enter")) {
                inRoom[i].add(tuple[0]);
            } else {
                inRoom[i].remove(tuple[0]);
            }
            for (int j = 0; j < i; j++) {
                Set<String> common = new HashSet<>(inRoom[i]);
                Set<String> remove = new HashSet<>(inRoom[i]);

                common.retainAll(inRoom[j]);
                remove.removeAll(inRoom[j]);
//                if (common.size() > 3 && res.) {
//
//                }
            }
        }
        return res;
    }

}
