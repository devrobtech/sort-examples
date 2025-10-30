import java.util.Arrays;

public class ShellSort
{
    private static void insertionSortInterleaved(int[] numbers, int startIndex, int gap)
    {
        for (int i = startIndex + gap; i < numbers.length; i += gap)
        {
            int j = i;
            while (j - gap >= startIndex && numbers[j] < numbers[j - gap])
            {
                int temp = numbers[j];
                numbers[j] = numbers[j - gap];
                numbers[j - gap] = temp;
                j -= gap;
            }
        }
    }

    private static void shellSort(int[] numbers, int[] gapValues)
    {
        for (int g = 0; g < gapValues.length; g++)
        {
            int gap = gapValues[g];
            for (int startIndex = 0; startIndex < gap; startIndex++)
            {
                insertionSortInterleaved(numbers, startIndex, gap);
            }
            System.out.println("After gap " + gap + ": " + Arrays.toString(numbers));
        }
    }

    public static void main(String[] args)
    {
        int[] array1 = {33, 18, 78, 64, 45, 32, 70, 11, 27};
        int[] array2 = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int[] array3 = {99, 88, 77, 66, 55, 44, 33, 22, 11};

        int[] gapValues = {5, 3, 1};

        System.out.println("Demo 1 - Unsorted array: ");
        System.out.println("Before sorting: " + Arrays.toString(array1));
        shellSort(array1, gapValues);
        System.out.println("After sorting: " + Arrays.toString(array1));
        System.out.println();

        System.out.println("Demo 2 - Array sorted in ascending order: ");
        System.out.println("Before sorting: " + Arrays.toString(array2));
        shellSort(array2, gapValues);
        System.out.println("Before sorting: " + Arrays.toString(array2));
        System.out.println();

        System.out.println("Demo 3 - Array sorted in descending order: ");
        System.out.println("Before sorting: " + Arrays.toString(array3));
        shellSort(array3, gapValues);
        System.out.println("After sorting: " + Arrays.toString(array3));
    }
}
