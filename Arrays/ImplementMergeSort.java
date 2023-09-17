public class ImplementMergeSort {
    static void print(int[] array) {
        for (int k : array)
            System.out.print(k + " ");
        System.out.println();
    }

    static void mergeSort(int[] array) {
        divide(array, 0, array.length - 1);
    }

    static void divide(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex)
            return;

        int midIndex = lowIndex + (highIndex - lowIndex) / 2;
        divide(array, lowIndex, midIndex);
        divide(array, midIndex + 1, highIndex);
        merge(array, lowIndex, midIndex, highIndex);
    }

    static void merge(int[] array, int lowIndex, int midIndex, int highIndex) {
        // System.out.println("line 23");
        // print(array);
        // System.out.println("lowIndex " + lowIndex + " highIndex " + highIndex);
        int leftLength = midIndex - lowIndex + 1;
        int rightLength = highIndex - midIndex;
        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];
        int i = lowIndex, j = midIndex + 1, k = 0;
        for (k = 0; k < leftLength; k++)
            leftArray[k] = array[k + i];
        // System.out.println("line 32");
        // print(leftArray);
        for (k = 0; k < rightLength; k++)
            rightArray[k] = array[k + j];
        // System.out.println("line 36");
        // print(rightArray);
        i = 0;
        j = 0;
        k = lowIndex;
        while (i < leftLength || j < rightLength) {

            if (i < leftLength && j < rightLength) {

                if (leftArray[i] <= rightArray[j])
                    array[k] = leftArray[i++];
                else
                    array[k] = rightArray[j++];
            }

            else if (j >= rightLength && i < leftLength)
                array[k] = leftArray[i++];

            else if (i >= leftLength && j < leftLength)
                array[k] = rightArray[j++];

            k++;
        }

        // System.out.println("line 60");
        // print(array);
    }

    public static void main(String[] args) {
        int[] data = { 2, 9, 8, 4, 5, 6 };
        mergeSort(data);
        print(data);
    }
}
