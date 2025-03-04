
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class CollectionTest2 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println("Set's Values are :" + set);

        LinkedHashSet<String> lSet = new LinkedHashSet<>();
        lSet.add("Hi");
        lSet.add("Hello");
        lSet.add("Bye");
        System.out.println("Linked HashSet's Values are :" + lSet);

        TreeSet<Float> tSet = new TreeSet<>();
        tSet.add((float) 1.1);
        tSet.add((float) 2.1);
        tSet.add((float) 3.1);
        System.out.println("Tree Set's Values are :" + tSet);
    }
}
