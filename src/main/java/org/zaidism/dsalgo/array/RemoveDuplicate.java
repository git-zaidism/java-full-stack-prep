import java.util.*;

public class RemoveDuplicate {


    public static void main(String[] args) {
        Integer[] arr = {0, 0, 12, 13, 14, 14, 15, 16};
        Integer[] nums = removeDuplicates(arr);

        Arrays.stream(nums)
                .filter(Objects::nonNull)
                .forEach(System.out::println);


        System.out.println("*********************************************");

        int[] arr1 = {0, 0, 12, 13, 14, 14, 15, 16};
        int[] nums1 = removeDuplicatesUsingStream(arr1);
        Arrays.stream(nums1)
                .filter(Objects::nonNull)
                .forEach(System.out::println);

    }

    private static int[] removeDuplicatesUsingStream(int[] arr) {
        return  Arrays.stream(arr).distinct().toArray();
    }

    private static Integer[] removeDuplicates(Integer[] arr) {
        Set<Integer> numSet = new LinkedHashSet<>(Arrays.asList(arr));
        Integer nums[] = new Integer[arr.length];
        int index = 0;
        for (int x : numSet) {
            nums[index] = x;
            index++;
        }
        return nums;
    }

}
