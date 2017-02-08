public class ReferenceRawTest {
    public static void main(String[] args) {
        int i1 = 3;
        int i2 = i1;
        i2 = 4;
        System.out.printf("i1 = %d but i2 = %d\n", i1, i2);

        Value v1 = new Value();
        v1.val = 5;
        Value v2 = v1;
        v2.val = 6;
        System.out.printf("v1.val = %d and v2.val = %d\n", v1.val, v2.val);
    }
}

class Value {
    int val;
}