
class quicksort {

    static void sortByQuickSort(int array[]) {
        sortByQuickSort(array, 0, array.length - 1);
    }

    static void sortByQuickSort(int array[], int lowIndex, int highIndex) {
        if (lowIndex >= highIndex)
            return;
        int pivot = array[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swapElements(array, leftPointer, rightPointer);
        }
        swapElements(array, leftPointer, highIndex);
        sortByQuickSort(array, lowIndex, leftPointer - 1);
        sortByQuickSort(array, leftPointer + 1, highIndex);
    }

    static void swapElements(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int array[] = { 5, 8, 10, 2, 4 };
        sortByQuickSort(array);
        for (int num : array)
            System.out.print(num + " ");

    }
}