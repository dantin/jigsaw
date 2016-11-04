import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        // populate hash map
        map.put(1, "tutorials");
        map.put(2, "point");
        map.put(3, "is best");

        System.out.println("Map value before change: "+ map);
      
       // put new values at key 3
       String prev=map.put(3,"is great");
          
       // check returned previous value
       System.out.println("Returned previous value: "+ prev);
          
       System.out.println("Map value after change: "+ map);
    }
}