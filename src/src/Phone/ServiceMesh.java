package Phone;

public class ServiceMesh {
    /*
    * 新鲜罗兵侠店面，新题，用topological sort算一个service mesh的loadfactor

给一堆service call relations和一个entrypoint，比如 [a:b,c, b:c] a意思就是a会call b和c，b还会call c，然后assume entrypoint a有一个request，这样a的load就是1，b也是1，c是2。就是每个service都会completely fanout它收到的requests，比如如果c要有downstream的话，c给他每个downstream的load就是2.

用topological sort做，要注意除了entrypoint之外还有别的service可能没有ind‍‍‍‍‍‍‍‍‌‍‌‌‍‌‌‌‌‌egree，这些service 的load要是0，不然漏掉的话graph traverse不完

还要注意有些service的downstream是不存在的，ignore就好

就按照该帖楼主的解法宽搜做没问题，一定要注意楼主说的“要注意除了entrypoint之外还有别的service可能没有indegree，这些service 的load要是0，不然漏掉的话graph traverse不完”。否则有的测试用例不过的。

    * */
}
