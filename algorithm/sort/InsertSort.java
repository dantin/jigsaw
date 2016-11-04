public class InsertSort extends Sort {

    public InsertSort() {
    }

    private void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int idx = i;
            for (int j = i; j >= 1; j--) {
                if (array[j - 1] > num) {
                    array[j] = array[j - 1];
                    idx = j - 1;
                }
            }
            array[idx] = num;
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: InsertSort <file>");
        }

        InsertSort sort = new InsertSort();

        int[] array = sort.getInput(args[0]);
        System.out.println("original array:");
        sort.printArray(array);
        sort.insertSort(array);
        System.out.println("insert sorted:");
        sort.printArray(array);

    }

}