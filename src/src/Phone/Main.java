package Phone;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        testlargestGroup();

    }

    private static void testlargestGroup() {
        String[][] test = {{"Curtis",    "745", "enter"},
                {"Jennifer",  "800", "enter"},
                {"Curtis",    "810", "exit"},
                {"John",      "815", "enter"},
                {"Paul",      "830", "enter"},
                {"Jennifer",  "900", "exit"},
                {"Paul",      "903", "exit"},
                {"John",      "908", "exit"},
                {"Curtis",   "1100", "enter"},
                {"Paul",     "1214", "enter"},
                {"Jennifer", "1217", "enter"},
                {"John",     "1230", "enter"},
                {"Paul",     "1235", "exit"},
                {"John",     "1235", "exit"},
                {"Jennifer", "1240", "exit"},
                {"Curtis",   "1330", "exit"},
        };
        LargestGroup largestGroup = new LargestGroup();
        System.out.println(largestGroup.largestGroup(test));
    }

    private static void testBadgeAndCompany() {
        String[][] badge_records = {{"Martha", "exit"},
     {"Paul", "enter"},
     {"Martha", "enter"},
     {"Martha", "exit"},
     {"Jennifer", "enter"},
     {"Paul", "enter"},
     {"Curtis", "enter"},
     {"Paul", "exit"},
     {"Martha", "enter"},
     {"Martha", "exit"},
     {"Jennifer", "exit"}
     };

        BadgeAndCompany badgeAndCompany = new BadgeAndCompany();
        System.out.println(   badgeAndCompany.findMismatchedEntries(badge_records));


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
        System.out.println(unsortedLogFile.getAdjListWithProbability(logs2));

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
        System.out.println(unsortedLogFile.highestNumberOfAccess(log2));

    }

    private static void testCourseSchedule2() {
        String[][] s1 = {
    {"Logic", "COBOL"},
    {"Data Structures", "Algorithms"},
    {"Creative Writing", "Data Structures"},
    {"Algorithms", "COBOL"},
    {"Intro to Computer Science", "Data Structures"},
    {"Logic", "Compilers"},
    {"Data Structures", "Logic"},
    {"Graphics", "Networking"},
    {"Networking", "Algorithms"},
    {"Creative Writing", "System Administration"},
    {"Databases", "System Administration"},
    {"Creative Writing", "Databases"},
    {"Intro to Computer Science", "Graphics"},
};
        String[][] s2 = {
                {"Course_3", "Course_7"},
                {"Course_0", "Course_1"},
                {"Course_1", "Course_2"},
                {"Course_2", "Course_3"},
                {"Course_3", "Course_4"},
                {"Course_4", "Course_5"},
                {"Course_5", "Course_6"},
        };

        String[][] s3 = new String[][]{
                {"Course_3", "Course_7"},
                {"Course_1", "Course_2"},
                {"Course_2", "Course_3"},
                {"Course_3", "Course_4"},
                {"Course_4", "Course_5"},
                {"Course_5", "Course_6"},
                // {"Course_6", "Course_7"}
        };
        CourseSchedule2 courseSchedule2 = new CourseSchedule2();
        System.out.println(courseSchedule2.findMiddleCourse(s1));
        System.out.println(courseSchedule2.findMiddleCourse(s2));
        System.out.println(courseSchedule2.findMiddleCourse(s3));
    }


    private static void testCourseSchedule() {
        CourseSchedule courseSchedule = new CourseSchedule();
        String[][] s = {{"Data Structures", "Algorithms"}, {"COBOL", "Networking"}, {"Algorithms", "COBOL"}};
        String[][] singleCourseList = new String[][]{
                {"Course_1", "Course_2"},
                // {"Course_3", "Course_4"},
                {"Course_2", "Course_3"}
        };
        System.out.println(courseSchedule.findMiddle(s));
        System.out.println(courseSchedule.findMiddle(singleCourseList));
    }



    private static void testThreeTimesOneHour() {
//        String[][] records1 = {{"John", "1255"},
//                {"Caisey", "5"},
//                {"John", "1305"},
//                {"John", "1230"},
//                {"Robert", "240"}};
//        String[][] records = {{"Jame", "1300"}, {"Martha", "1600"}, {"Martha", "1620"}, {"Martha", "1530"}};

        String[][] records3 = {{"Paul", "1315"}, {"Jennifer", "1910"}, {"John", "830"}, {"Paul", "1355"}, {"John", "835"}, {"Paul", "1405"}, {"Paul", "1630"}, {"John", "855"}, {"John", "915"}, {"John", "930"}, {"Jennifer", "1335"}, {"Jennifer", "730"}, {"John", "163"}};
        ThreeTimesOneHour threeTimesOneHour = new ThreeTimesOneHour();
        System.out.println(threeTimesOneHour.threeTimesOneHour(records3));
    }


}
