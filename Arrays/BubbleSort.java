class BubbleSort {
    public static void main(String[] args) {
        int array[] = { 2, 1, 6, 5, 2 };
        int i, j;
        int n = array.length;
        for (i = 0; i < n - 1; i++) {
            for (j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int a : array)
            System.out.print(a + " ");
    }
}