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
        testCourseSchedule2();
    }
    private static void testCourseSchedule2() {
//        String[][] s = {
//    {"Logic", "COBOL"},
//    {"Data Structures", "Algorithms"},
//    {"Creative Writing", "Data Structures"},
//    {"Algorithms", "COBOL"},
//    {"Intro to Computer Science", "Data Structures"},
//    {"Logic", "Compilers"},
//    {"Data Structures", "Logic"},
//    {"Graphics", "Networking"},
//    {"Networking", "Algorithms"},
//    {"Creative Writing", "System Administration"},
//    {"Databases", "System Administration"},
//    {"Creative Writing", "Databases"},
//    {"Intro to Computer Science", "Graphics"},
//};
        String[][] s = {
    {"Course_3", "Course_7"},
    {"Course_0", "Course_1"},
    {"Course_1", "Course_2"},
    {"Course_2", "Course_3"},
    {"Course_3", "Course_4"},
    {"Course_4", "Course_5"},
    {"Course_5", "Course_6"},
};
        CourseSchedule2 courseSchedule2 = new CourseSchedule2();
        System.out.println( courseSchedule2.findMiddleCourse(s));
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
