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
        testUnsortedLogFile2();
    }

    private static void testUnsortedLogFile2() {
        String[][] logs1 = {
                {"58523", "user_1", "resource_1"},
                {"62314", "user_2", "resource_2"},
                {"54001", "user_1", "resource_3"},
                {"200", "user_6", "resource_5"},
                {"215", "user_6", "resource_4"},
                {"54060", "user_2", "resource_3"},
                {"53760", "user_3", "resource_3"},
                {"58522", "user_22", "resource_1"},
                {"53651", "user_5", "resource_3"},
                {"2", "user_6", "resource_1"},
                {"100", "user_6", "resource_6"},
                {"400", "user_7", "resource_2"},
                {"100", "user_8", "resource_6"},
                {"54359", "user_1", "resource_3"},
        };

        String[][] logs2 = {
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };
        UnsortedLogFile unsortedLogFile = new UnsortedLogFile();
        System.out.println( unsortedLogFile.getAdjListWithProbability(logs2));

    }


    private static void testUnsortedLogFile1() {
        String[][] logs1 = {
        {"58523", "user_1", "resource_1"},
        {"62314", "user_2", "resource_2"},
        {"54001", "user_1", "resource_3"},
        {"200", "user_6", "resource_5"},
        {"215", "user_6", "resource_4"},
        {"54060", "user_2", "resource_3"},
        {"53760", "user_3", "resource_3"},
        {"58522", "user_22", "resource_1"},
        {"53651", "user_5", "resource_3"},
        {"2", "user_6", "resource_1"},
        {"100", "user_6", "resource_6"},
        {"400", "user_7", "resource_2"},
        {"100", "user_8", "resource_6"},
        {"54359", "user_1", "resource_3"},
        };

        String[][] log2 = {
{"300", "user_1", "resource_3"},
{"599", "user_1", "resource_3"},
{"900", "user_1", "resource_3"},
{"1199", "user_1", "resource_3"},
{"1200", "user_1", "resource_3"},
{"1201", "user_1", "resource_3"},
{"1202", "user_1", "resource_3"}
};
        UnsortedLogFile unsortedLogFile = new UnsortedLogFile();
        System.out.println( unsortedLogFile.highestNumberOfAccess(log2));

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
