package Phone;
import java.util.*;

public class Main {
    public static void main(String[] args) {
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
        testCourseSchedule();
    }

    private static void testCourseSchedule() {
        CourseSchedule courseSchedule = new CourseSchedule();
        String[][] s = {{"Data Structures", "Algorithms"}, {"COBOL", "Networking"}, {"Algorithms", "COBOL"}};
        System.out.println(courseSchedule.findMiddle(s));
    }

    private static void testlargestGroup () {

    }

    private static void testThreeTimesOneHour () {
        String[][] records1 = {{"John", "1255"},
                {"Caisey", "5"},
                {"John", "1305"},
                {"John", "1230"},
                {"Robert", "240"}};
        String[][] records = {{"Jame", "1300"}, {"Martha", "1600"}, {"Martha", "1620"}, {"Martha", "1530"}};
        ThreeTimesOneHour threeTimesOneHour = new ThreeTimesOneHour();
        System.out.println(threeTimesOneHour.threeTimesOneHour(records1));
    }


}
