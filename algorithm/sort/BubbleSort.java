public class BubbleSort extends Sort {

    public BubbleSort() {
    }

    private void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: BubbleSort <file>");
        }

        BubbleSort sort = new BubbleSort();

        int[] array = sort.getInput(args[0]);
        System.out.println("original array:");
        sort.printArray(array);
        sort.bubbleSort(array);
        System.out.println("bubble sorted:");
        sort.printArray(array);

    }

}