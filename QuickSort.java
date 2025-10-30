import java.util.Arrays;

public class QuickSort
{
    private static int partition (int[] numbers, int lowIndex, int highIndex)
    {
        //pick middle element as pivot
        int midpoint = lowIndex + (highIndex - lowIndex) / 2;
        int pivot = numbers[midpoint];

        boolean done = false;

        while(!done)
        {
            while(numbers[lowIndex] < pivot)
            {
                lowIndex++;
            }
            while(pivot < numbers[highIndex])
            {
                highIndex--;
            }

            // If lowIndex and highIndex have met or crossed each other,
            // then partitioning is done
            if(lowIndex >= highIndex)
            {
                done = true;
            }
            else
            {
                int temp = numbers[lowIndex];
                numbers[lowIndex] = numbers[highIndex];
                numbers[highIndex] = temp;

                lowIndex++;
                highIndex--;
            }
        }
        return highIndex;
    }

    private static void quickSort(int[] numbers, int lowIndex, int highIndex)
    {
        if (highIndex <= lowIndex)
        {
            return;
        }

        int lowEndIndex = partition(numbers, lowIndex, highIndex);
        quickSort(numbers, lowIndex, lowEndIndex);
        quickSort(numbers, lowEndIndex + 1, highIndex);
    }

    static void quickSortDemo(int[] numbersArray)
    {
        System.out.println("Before sorting: " + Arrays.toString(numbersArray));

        quickSort(numbersArray, 0, numbersArray.length - 1);

        System.out.println("After sorting: " + Arrays.toString(numbersArray));
    }

    public static void main(String[] args)
    {
        int[] array1 = {33, 18, 78, 64, 45, 32, 70, 11, 27};
        int[] array2 = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int[] array3 = {99, 88, 77, 66, 55, 44, 33, 22, 11};

        System.out.println("Demo 1 - Unsorted Array:");
        quickSortDemo(array1);
        System.out.println();

        System.out.println("Demo 2 - Array sorted in ascending order:");
        quickSortDemo(array2);
        System.out.println();

        System.out.println("Demo 3 - Array sorted in descending order:");
        quickSortDemo(array3);
        System.out.println();
    }
}
