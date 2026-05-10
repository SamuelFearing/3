
//	1. public void add(T newEntry);
//	2. public boolean remove(T anEntry);
//	3. public int getPosition(T anEntry);  (int or negative int)
//	4. public T getEntry(int givenPosition);
//	5. public boolean contains(T anEntry);
//	6. public T remove(int givenPosition); (first instance)
//	7. public int getLength();
//	8. public boolean isEmpty();
//	9. public T[] toArray();
//	10. public void clear();
//

/**
 * ArrayListSortedListTester is a tester class for testing ArrayListSortedList
 * It tests the main class with both integers and Strings. Each data type has 10
 * test cases (as listed above). The method contracts for the
 * "SortedListedInterface" are listed in Chapter 17, Page 493
 */
public class ArrayListSortedListTester {

    public static int total_points = 20;

    // ========================================================
    // Helper method to test the ArrayListSortedList with integers
    // ========================================================
    public static void testForIntegers() {
        // Create a new ArrayListSortedList
        ArrayListSortedList<Integer> sortedList = new ArrayListSortedList<>();

        System.out.println("\n\n=============================");
        System.out.println("Test Case 1. public void add(T newEntry)");
        System.out.println("=============================");
        System.out.println("Adding 5, 3, 8, 99, 88, 77, 44 and 55 to the list");
        sortedList.add(5);
        sortedList.add(3);
        sortedList.add(8);
        sortedList.add(99);
        sortedList.add(88);
        sortedList.add(77);
        sortedList.add(44);
        sortedList.add(55);
        System.out.println(sortedList);

        // Test add
        Integer[] expectedArray_1 = { 3, 5, 8, 44, 55, 77, 88, 99 };
        Integer[] actualArray_1 = sortedList.toArray();
        printTestResult(expectedArray_1, actualArray_1);

        // Test remove(entry)
        System.out.println("\n\n=============================");
        System.out.println("Test Case 2. public boolean remove(T anEntry);");
        System.out.println("=============================");
        System.out.println(sortedList);
        Integer x = 5;
        System.out.println("Remove Integer(5) object? " + sortedList.remove(x));
        System.out.println(sortedList);

        // Test remove(entry)
        Integer[] expectedArray_2 = { 3, 8, 44, 55, 77, 88, 99 };
        Integer[] actualArray_2 = sortedList.toArray();
        printTestResult(expectedArray_2, actualArray_2);

        Integer x1 = 115;
        System.out.println("\nRemove non-existing Integer(115)? " + sortedList.remove(x1));
        System.out.println(sortedList);

        // Test remove(entry)
        Integer[] expectedArray_21 = { 3, 8, 44, 55, 77, 88, 99 };
        Integer[] actualArray_21 = sortedList.toArray();
        printTestResult(expectedArray_21, actualArray_21);

        // Test getPosition(entry)
        System.out.println("\n\n=============================");
        System.out.println("Test Case 3. public int getPosition(T anEntry);");
        System.out.println("=============================");
        System.out.println(sortedList);
        Integer x3 = 44;
        int position_of_44 = sortedList.getPosition(x3);
        System.out.println("Position of 44: " + position_of_44);
        if (position_of_44 == 3) {
            System.out.println("Test Case 3 passed");
        } else {
            System.out.println("Test Case 3 Failed");
            total_points--;
        }

        Integer x4 = 45;
        int position_of_45 = sortedList.getPosition(x4);
        System.out.println("Position of 45: " + position_of_45);
        if (position_of_45 == -4) {
            System.out.println("Test Case 3 passed");
        } else {
            System.out.println("Test Case 3 Failed; Expected Value is  -4");
            total_points--;
        }

        // Test getEntry(int givenPosition);
        System.out.println("\n\n=============================");
        System.out.println("Test Case 4. public T getEntry(int givenPosition);");
        System.out.println("=============================");
        System.out.println(sortedList);
        int x_4_actual = sortedList.getEntry(5);
        int x_4_expected = 77;
        System.out.println("get the Entry at position 5: " + x_4_actual);
        if (x_4_actual == x_4_expected) {
            System.out.println("Test Case 4 passed");
        } else {
            System.out.println("Test Case 4 Failed. Expected value = 77");
            total_points--;
        }

        // Test contains(T anEntry)
        System.out.println("\n\n=============================");
        System.out.println("Test Case 5. public boolean contains(T anEntry);");
        System.out.println("=============================");
        System.out.println(sortedList);

        boolean contains_99 = sortedList.contains(99);
        System.out.println("Contains 99? " + contains_99);
        if (contains_99) {
            System.out.println("Test Case 5 passed");
        } else {
            System.out.println("Test Case 5 failed");
            total_points--;
        }

        boolean contains_189 = sortedList.contains(189);
        System.out.println("Contains 189? " + contains_189);
        if (contains_189 == false) {
            System.out.println("Test Case 5 passed");
        } else {
            System.out.println("Test Case 5 failed");
            total_points--;
        }

        // Test remove
        System.out.println("\n\n=============================");
        System.out.println("Test Case 6. public T remove(int givenPosition);");
        System.out.println("=============================");
        System.out.println(sortedList);

        int removed_5 = sortedList.remove(5);
        System.out.println("Removed the element at position 5? " + removed_5);
        System.out.println(sortedList);
        Integer[] expected_array_6 = { 3, 8, 44, 55, 88, 99 };
        Integer[] actual_array_6 = sortedList.toArray();
        printTestResult(expected_array_6, actual_array_6);

        if (removed_5 == 77) {
            System.out.println("Test Case 6 passed");
        } else {
            System.out.println("Test Case 6 failed");
            total_points--;
        }

        // Test getLength
        System.out.println("\n\n=============================");
        System.out.println("Test Case 7. public int getLength();");
        System.out.println("=============================");
        System.out.println(sortedList);
        int len = sortedList.getLength();
        System.out.println("Length of the sorted list: " + len);
        if (len == 6) {
            System.out.println("Test Case 7 passed");
        } else {
            System.out.println("Test Case 7 failed");
            total_points--;
        }

        // Test isEmpty()
        System.out.println("\n\n=============================");
        System.out.println("Test Case 8. public boolean isEmpty();");
        System.out.println("=============================");
        System.out.println(sortedList);
        boolean empty_8 = sortedList.isEmpty();
        System.out.println("is the SortedList empty? " + empty_8);
        if (empty_8 == false) {
            System.out.println("Test Case 8 passed");
        } else {
            System.out.println("Test Case 8 failed");
            total_points--;
        }

        // Test toArray()
        System.out.println("\n\n=============================");
        System.out.println("Test Case 9. public T[] toArray();");
        System.out.println("=============================");
        System.out.println(sortedList);
        Integer[] expected_array_9 = { 3, 8, 44, 55, 88, 99 };
        Integer[] actual_array_9 = sortedList.toArray();
        printTestResult(expected_array_9, actual_array_9);

        // Test clear
        System.out.println("\n\n=============================");
        System.out.println("Test Case 10. public void clear();");
        System.out.println("=============================");
        sortedList.clear();
        boolean is_empty = sortedList.isEmpty();
        if (is_empty) {
            System.out.println("Test Case 10 passed");
        } else {
            System.out.println("Test Case 10 failed");
            total_points--;
        }
    }

    // ========================================================
    // Helper method to test the ArrayListSortedList with strings
    // ========================================================
    public static void testForStrings() {
        // Create a new ArrayListSortedList
        ArrayListSortedList<String> sortedList = new ArrayListSortedList<>();

        System.out.println("\n\n=============================");
        System.out.println("Test Case 1. public void add(T newEntry)");
        System.out.println("=============================");
        System.out.println(
                "Adding \"chris\", \"barb\", \"alissa\", \"zack\", \"nikhil\", \"yared\", \"anna\", \"peter\" to the list");
        sortedList.add("chris");
        sortedList.add("barb");
        sortedList.add("alissa");
        sortedList.add("zack");
        sortedList.add("nikhil");
        sortedList.add("yared");
        sortedList.add("anna");
        sortedList.add("peter");

        System.out.println(sortedList);

        // Test add
        String[] expectedArray_1 = { "alissa", "anna", "barb", "chris", "nikhil", "peter", "yared", "zack" };
        String[] actualArray_1 = sortedList.toArray();
        printTestResult(expectedArray_1, actualArray_1);
        // Test remove(entry)
        System.out.println("\n\n=============================");
        System.out.println("Test Case 2. public boolean remove(T anEntry);");
        System.out.println("=============================");
        System.out.println(sortedList);
        String x = "chris";
        System.out.println("Remove String(\"chris\") object? " + sortedList.remove(x));
        System.out.println(sortedList);

        // Test remove(entry)
        String[] expectedArray_2 = { "alissa", "anna", "barb", "nikhil", "peter", "yared", "zack" };
        String[] actualArray_2 = sortedList.toArray();
        printTestResult(expectedArray_2, actualArray_2);

        String x1 = "james";
        System.out.println("\nRemove non-existing String(\"james\")? " + sortedList.remove(x1));
        System.out.println(sortedList);

        // Test remove(entry)
        String[] expectedArray_21 = { "alissa", "anna", "barb", "nikhil", "peter", "yared", "zack" };
        String[] actualArray_21 = sortedList.toArray();
        printTestResult(expectedArray_21, actualArray_21);

        // Test getPosition(entry)
        System.out.println("\n\n=============================");
        System.out.println("Test Case 3. public int getPosition(T anEntry);");
        System.out.println("=============================");
        System.out.println(sortedList);
        String x3 = "barb";
        int position_of_barb = sortedList.getPosition(x3);
        System.out.println("Position of \"barb\": " + position_of_barb);
        if (position_of_barb == 3) {
            System.out.println("Test Case 3 passed");
        } else {
            System.out.println("Test Case 3 Failed. Expected Value = 3");
            total_points--;
        }

        String x4 = "zebra";
        int position_of_zebra = sortedList.getPosition(x4);
        System.out.println("Position of \"zebra\": " + position_of_zebra);
        if (position_of_zebra == -8) {
            System.out.println("Test Case 3 passed");
        } else {
            System.out.println("Test Case 3 Failed; Expected Value = -8");
            total_points--;
        }

        // Test getEntry(int givenPosition);
        System.out.println("\n\n=============================");
        System.out.println("Test Case 4. public T getEntry(int givenPosition);");
        System.out.println("=============================");
        System.out.println(sortedList);
        int y = 4;
        String x_4_actual = sortedList.getEntry(y);
        String x_4_expected = "nikhil";
        System.out.println("Entry for position 4: " + x_4_actual);
        if (x_4_actual.equals(x_4_expected)) {
            System.out.println("Test Case 4 passed");
        } else {
            System.out.println("Test Case 4 Failed. Expected Value = 'nikhil'");
            total_points--;
        }

        // Test contains(T anEntry)
        System.out.println("\n\n=============================");
        System.out.println("Test Case 5. public boolean contains(T anEntry);");
        System.out.println("=============================");
        System.out.println(sortedList);

        boolean contains_peter = sortedList.contains("peter");
        System.out.println("Contains \"peter\"? " + contains_peter);
        if (contains_peter) {
            System.out.println("Test Case 5 passed");
        } else {
            System.out.println("Test Case 5 failed");
            total_points--;
        }

        boolean contains_john = sortedList.contains("john");
        System.out.println("Contains \"john\"? " + contains_john);
        if (!contains_john) {
            System.out.println("Test Case 5 passed");
        } else {
            System.out.println("Test Case 5 failed");
            total_points--;
        }

        // Test remove
        System.out.println("\n\n=============================");
        System.out.println("Test Case 6. public T remove(int givenPosition);");
        System.out.println("=============================");
        System.out.println(sortedList);

        String removed_at_5 = sortedList.remove(5);
        System.out.println("Removed the element at position 5? " + removed_at_5);
        System.out.println(sortedList);
        String[] expected_array_6 = { "alissa", "anna", "barb", "nikhil", "yared", "zack" };
        String[] actual_array_6 = sortedList.toArray();
        printTestResult(expected_array_6, actual_array_6);

        if (removed_at_5.equals("peter")) {
            System.out.println("Test Case 6 passed");
        } else {
            System.out.println("Test Case 6 failed");
            total_points--;
        }

        // Test getLength
        System.out.println("\n\n=============================");
        System.out.println("Test Case 7. public int getLength();");
        System.out.println("=============================");
        System.out.println(sortedList);
        int len = sortedList.getLength();
        System.out.println("Length of the sorted list: " + len);
        if (len == 6) {
            System.out.println("Test Case 7 passed");
        } else {
            System.out.println("Test Case 7 failed");
            total_points--;
        }

        // Test isEmpty()
        System.out.println("\n\n=============================");
        System.out.println("Test Case 8. public boolean isEmpty();");
        System.out.println("=============================");
        System.out.println(sortedList);
        boolean empty_8 = sortedList.isEmpty();
        System.out.println("is the SortedList empty? " + empty_8);
        if (!empty_8) {
            System.out.println("Test Case 8 passed");
        } else {
            System.out.println("Test Case 8 failed");
            total_points--;
        }

        // Test toArray()
        System.out.println("\n\n=============================");
        System.out.println("Test Case 9. public T[] toArray();");
        System.out.println("=============================");
        System.out.println(sortedList);
        String[] expected_array_9 = { "alissa", "anna", "barb", "nikhil", "yared", "zack" };
        String[] actual_array_9 = sortedList.toArray();
        printTestResult(expected_array_9, actual_array_9);

        // Test clear
        System.out.println("\n\n=============================");
        System.out.println("Test Case 10. public void clear();");
        System.out.println("=============================");
        sortedList.clear();
        boolean is_empty = sortedList.isEmpty();
        if (is_empty) {
            System.out.println("Test Case 10 passed");
        } else {
            System.out.println("Test Case 10 failed");
            total_points--;
        }
    }

    // Helper method to compare expected and actual arrays
    private static <T> void printTestResult(T[] expected, T[] actual) {
        boolean passed = true;
        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual[i])) {
                passed = false;
                break;
            }
        }
        if (passed) {
            System.out.println("Passed: Actual and Expected Arrays are equal.");
        } else {
            System.out.println("Failed: Actual and Expected Arrays are not equal.");
            total_points--;
        }
    }

    // main method to test the ArrayListSortedList for integers and strings
    public static void main(String[] args) {
        System.out.println("-------------------------------------------------");
        System.out.println("--------- Testing with Integers -----------------");
        System.out.println("-------------------------------------------------");
        testForIntegers();

        System.out.println("\n\n-------------------------------------------------");
        System.out.println("--------- Testing with Strings -----------------");
        System.out.println("-------------------------------------------------\n");
        testForStrings();

        System.out.println("\n\n-------------------------------------------------");
        System.out.println("--------- Your final score -----------------");
        System.out.println("-------------------------------------------------\n");
        System.out.println("Your final score for ArrayListSortedList (out of 50 points) = " + (total_points * 2.5));

    }

}
