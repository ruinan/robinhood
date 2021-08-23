package Phone;

import java.sql.Array;
import java.util.*;

public class CourseSchedule2 {
    /*
有多种track，返回所有path里的中间那门课

Sample input 1:
all_courses_1 = [
    ["Logic", "COBOL"],
    ["Data Structures", "Algorithms"],
    ["Creative Writing", "Data Structures"],
    ["Algorithms", "COBOL"],
    ["Intro to Computer Science", "Data Structures"],
    ["Logic", "Compilers"],
    ["Data Structures", "Logic"],
    ["Graphics", "Networking"],
    ["Networking", "Algorithms"],
    ["Creative Writing", "System Administration"],
    ["Databases", "System Administration"],
    ["Creative Writing", "Databases"],
    ["Intro to Computer Science", "Graphics"],
]

Sample output 1 (in any order):
          ["Data Structures", "Networking", "Creative Writing", "Databases"]

All paths through the curriculum (midpoint *highlighted*):

Intro to C.S. -> Graphics -> *Networking* -> Algorithms -> Cobol
Intro to C.S. -> *Data Structures* -> Algorithms -> COBOL
Intro to C.S. -> *Data Structures* -> Logic -> COBOL
Intro to C.S. -> *Data Structures* -> Logic -> Compiler
Creative Writing -> *Databases* -> System Administration
*Creative Writing* -> System Administration
Creative Writing -> *Data Structures* -> Algorithms -> COBOL
Creative Writing -> *Data Structures* -> Logic -> COBOL
Creative Writing -> *Data Structures* -> Logic -> Compilers

Visual representation:

                    ____________    ______________
                    |          |    |            |
                    | Graphics |    | Networking |
               ---->|__________|--->|____________|
               |                       |
               |                       |
               |                       |  ______________
____________   |                       |  |            |
|          |   |    ______________     >->| Algorithms |--\     _____________
| Intro to |   |    |            |    /   |____________|   \    |           |
| C.S.     |---+    | Data       |   /                      >-->| COBOL     |
|__________|    \   | Structures |--+     ______________   /    |___________|
                 >->|____________|   \    |            |  /
____________    /                     \-->| Logic      |-+      _____________
|          |   /    ______________        |____________|  \     |           |
| Creative |  /     |            |                         \--->| Compilers |
| Writing  |-+----->| Databases  |                              |___________|
|__________|  \     |____________|-\     _________________________
               \                    \    |                       |
                \--------------------+-->| System Administration |
                                         |_______________________|

Sample input 2:
all_courses_2 = [
    ["Course_3", "Course_7"],
    ["Course_0", "Course_1"],
    ["Course_1", "Course_‍‍‍‍‍‍‍‍‌‍‌‌‍‌‌‌‌‌2"],
    ["Course_2", "Course_3"],
    ["Course_3", "Course_4"],
    ["Course_4", "Course_5"],
    ["Course_5", "Course_6"],
]
Sample output 2 (in any order):
["Course_2", "Course_3"]

Complexity analysis variables:

n: number of pairs in the input

*/

    public List<String> findMiddleCourse(String[][] pairs) {
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

        List<String> res = new ArrayList<>();
        dfs(graph, indegree, new ArrayList<>(), res);
        return res;
    }

    void dfs(Map<String, List<String>> graph,  Map<String, Integer> indegree, List<String> cur, List<String> res) {
        if ()
    }



}
