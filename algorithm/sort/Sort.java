import java.io.IOException;
import java.util.List;

public class Sort {

    private InputFileReader text;

    public Sort() {
        this.text = new InputFileReader();
    }

    protected int[] getInput(String fileName) {
        int[] values = null;
        try {
            List<String> content = text.readSmallTextFile(fileName);
            String[] numbers = content.get(0).split(",");

            values = new int[numbers.length];
            int i = 0;
            for (String number : numbers) {
                values[i++] = Integer.parseInt(number);
            }
        } catch (IOException e) {
            System.err.println("read " + fileName + " error!");
            e.printStackTrace();
        } finally {
            if (values == null) {
                values = new int[] {0};
            }
        }

        return values;
    }

    protected void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            } else {
                System.out.println();
            }
        }
    }
}