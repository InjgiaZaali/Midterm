package t1;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Task 1 - Selecting Strings Based on Integer Values
 *
 * <p>This program selects strings from list2 using values from list1 as adjusted indices.</p>
 *
 * <p>The algorithm works as follows:</p>
 * <ol>
 *   <li>For each integer <code>n</code> in list1 (processed in original order):</li>
 *   <li>Calculate the index in list2 as <code>(n - 1) % list2.size()</code> (to ensure it stays within bounds).</li>
 *   <li>Select the string at the computed index in list2.</li>
 * </ol>
 *
 * <p>Example:</p>
 * <ul>
 *   <li>If list1 contains [5, 7, ...], the selected strings are list2[4], list2[6], etc.</li>
 *   <li>If an index exceeds list2's size, it wraps around (e.g., index 15 in a size-17 list becomes 15).</li>
 * </ul>
 */
public class Task1 {

    public static void main(String[] args) {
        // Initialize list1 (Integers)
        List<Integer> list1 = Arrays.asList(5, 7, 9, 1, 2, 6, 4, 8, 10, 3);

        // Initialize list2 (Strings)
        List<String> list2 = Arrays.asList(
                "ukc", "emx", "cdp", "snu", "lqq", "hot", "hgd", "hom", "dqo", "tue", "dqd", "avm"
        );

        List<String> list3 = processLists(list1, list2);

        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        System.out.println("list3 (Result): " + list3);
    }
    /**
     * Processes two lists to create a result list where strings are selected from list2
     * based on adjusted values from list1.
     *
     * @param list1 The list of integers used as indices (after adjustment).
     * @param list2 The list of strings to select from.
     * @return A new list containing strings selected from list2 based on list1's values.
     */
    public static List<String> processLists(List<Integer> list1, List<String> list2) {
        List<String> result = new ArrayList<>();

        for (Integer n : list1) {
            // Calculate index: (n - 1) with wrap-around
            int index = (n - 1) % list2.size();
            // Ensure index is non-negative (handles n = 0 case)
            index = (index + list2.size()) % list2.size();
            result.add(list2.get(index));
        }

        return result;
    }
}