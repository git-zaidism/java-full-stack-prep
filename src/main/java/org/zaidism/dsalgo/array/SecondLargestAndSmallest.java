import java.util.Arrays;

public class SecondLargestAndSmallest {
   
  public static void main(String[] args) {
       
        int arr[] = {12, 4, 90, 1, 1, 34, 4, 22, 100, 100};

        usingSortFindingSecondSmallestAndLargest(arr); // this will not work properly with duplicates elements in the array
        usingSortFindingSecondSmallestAndLargestWithStream(arr); // this will not work properly with duplicates elements in the array
        usingSortFindingSecondSmallestAndLargestWithStreamDuplicate(arr); // this will not work properly with duplicates elements in the array
        usingSortFindingSecondSmallestAndLargestWithoutSorting(arr); //without sorting
    }

    private static void usingSortFindingSecondSmallestAndLargestWithoutSorting(int[] arr) {
        int largest = arr[0];
        int secondLargest = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > largest)
                largest = arr[i];
        }

        for(int i = 0; i < arr.length - 1; i++){
            if(largest != arr[i] && secondLargest < arr[i])
                secondLargest = arr[i];

        }

        System.out.println(
                "Second Largest Elements: " + secondLargest
        );

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < smallest)
                smallest = arr[i];
        }

        for(int i = 0; i < arr.length - 1; i++){
            if(smallest != arr[i] && secondSmallest > arr[i])
                secondSmallest = arr[i];

        }

        System.out.println(
                "Second Smallest Elements: " + secondSmallest
        );

    }

    private static void usingSortFindingSecondSmallestAndLargestWithStreamDuplicate(int[] arr) {
        System.out.println(
                "Second Smallest Elements: " + Arrays.stream(arr).distinct().sorted().skip(1).findFirst()
        );

        System.out.println(
                "Second Largest Elements: " + Arrays.stream(arr).distinct().sorted().skip(arr.length - 2).findFirst() // TBD to be correct
        );
    }

    private static void usingSortFindingSecondSmallestAndLargestWithStream(int[] arr) {
        System.out.println(
                "Second Smallest Elements: " + Arrays.stream(arr).sorted().skip(1).findFirst()
        );

        System.out.println(
                "Second Largest Elements: " + Arrays.stream(arr).sorted().skip(arr.length - 2).findFirst()
        );
    }

    private static void usingSortFindingSecondSmallestAndLargest(int[] arr) {
        Arrays.sort(arr);
        System.out.println(
                "Second Smallest Elements: " + arr[1]
        );
        System.out.println(
                "Second Largest Elements: " + arr[arr.length - 2]
        );
    }
}
