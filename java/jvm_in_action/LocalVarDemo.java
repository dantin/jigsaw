public class LocalVarDemo {

    /*
     * local variables: 3
     * content: this, a, b
     */
    public void localvar1() {
        int a = 0;
        System.out.println(a);
        int b = 0;
    }

    /*
     * local variables: 2
     * content: this, a, b
     * b reuse a
     */
    public void localvar2() {
        {
            int a = 0;
            System.out.println(a);
        }
        int b = 0;
    }

}