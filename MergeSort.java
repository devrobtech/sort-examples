import java.util.Arrays;

public class MergeSort
{
    private static void merge(int[] numbers, int leftFirst, int leftLast, int rightLast)
    {
        int mergedSize = rightLast - leftFirst + 1;
        int[] mergedNumbers = new int[mergedSize];
        int mergePos = 0;
        int leftPos = leftFirst;
        int rightPos = leftLast + 1;

        while (leftPos <= leftLast && rightPos <= rightLast)
        {
            if (numbers[leftPos] <= numbers[rightPos])
            {
                mergedNumbers[mergePos] = numbers[leftPos];
                leftPos++;
            }
            else
            {
                mergedNumbers[mergePos] = numbers[rightPos];
                rightPos++;
            }
            mergePos++;
        }

        while (leftPos <= leftLast)
        {
            mergedNumbers[mergePos] = numbers[leftPos];
            leftPos++;
            mergePos++;
        }

        while (rightPos <= rightLast)
        {
            mergedNumbers[mergePos] = numbers[rightPos];
            rightPos++;
            mergePos++;
        }

        for (mergePos = 0; mergePos < mergedSize; mergePos++)
        {
            numbers[leftFirst + mergePos] = mergedNumbers[mergePos];
        }
    }

    private static void mergeSort(int[] numbers, int startIndex, int endIndex)
    {
        if (startIndex < endIndex)
        {
            int mid = (startIndex + endIndex) / 2;

            mergeSort(numbers, startIndex, mid);
            mergeSort(numbers, mid + 1, endIndex);

            merge(numbers, startIndex, mid, endIndex);
        }
    }

    static void mergeSortDemo(int[] numbersArray)
    {
        System.out.println("Before sorting: " + Arrays.toString(numbersArray));

        mergeSort(numbersArray, 0, numbersArray.length - 1);

        System.out.println("After sorting: " + Arrays.toString(numbersArray));
    }

    public static void main(String[] args)
    {
        int[] array1 = {33, 18, 78, 64, 45, 32, 70, 11, 27};
        int[] array2 = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int[] array3 = {99, 88, 77, 66, 55, 44, 33, 22, 11};

        System.out.println("Demo 1 - Unsorted array: ");
        mergeSortDemo(array1);
        System.out.println();

        System.out.println("Demo 2 - Array sorted in ascending order: ");
        mergeSortDemo(array2);
        System.out.println();

        System.out.println("Demo 3 - Array sorted in descending order: ");
        mergeSortDemo(array3);
    }
}
