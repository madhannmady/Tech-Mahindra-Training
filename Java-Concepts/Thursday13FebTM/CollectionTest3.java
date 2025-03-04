import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class CollectionTest3 {
    public static void main(String[] args) {
        // HashSet with 8 elements (divisible by 7)
        HashSet<Integer> set = new HashSet<>();
        set.add(7);
        set.add(1);
        set.add(21);
        set.add(28);
        set.add(35);
        set.add(412);
        set.add(49);
        set.add(566);
        System.out.println("HashSet's Values are before removal: " + set);
        setSample(set);
        System.out.println("HashSet's Values are after removal: " + set);
        divSevenHashSet(set);

        // LinkedHashSet with 8 elements
        LinkedHashSet<String> lSet = new LinkedHashSet<>();
        lSet.add("Hi");
        lSet.add("Hello");
        lSet.add("Bye");
        lSet.add("Good Morning");
        lSet.add("Good Night");
        lSet.add("Welcome");
        lSet.add("See you");
        lSet.add("Take care");
        System.out.println("LinkedHashSet's Values are before removal: " + lSet);
        setSample(lSet);
        System.out.println("LinkedHashSet's Values are after removal: " + lSet);

        // TreeSet with 8 elements
        TreeSet<Float> tSet = new TreeSet<>();
        tSet.add(1.1f);
        tSet.add(2.1f);
        tSet.add(3.1f);
        tSet.add(4.1f);
        tSet.add(5.1f);
        tSet.add(6.1f);
        tSet.add(7.1f);
        tSet.add(8.1f);
        System.out.println("TreeSet's Values are before removal: " + tSet);
        setSample(tSet);
        System.out.println("TreeSet's Values are after removal: " + tSet);
    }

    public static void setSample(HashSet<Integer> hm) {
        Iterator<Integer> it = hm.iterator();
        if (it.hasNext()) {
            Integer removedElement = it.next();
            hm.remove(removedElement);
            System.out.println("Removed from HashSet: " + removedElement);
        }
    }

    public static void setSample(LinkedHashSet<String> hm) {
        Iterator<String> it = hm.iterator();
        if (it.hasNext()) {
            String removedElement = it.next();
            hm.remove(removedElement);
            System.out.println("Removed from LinkedHashSet: " + removedElement);
        }
    }

    public static void setSample(TreeSet<Float> hm) {
        Iterator<Float> it = hm.iterator();
        if (it.hasNext()) {
            Float removedElement = it.next();
            hm.remove(removedElement);
            System.out.println("Removed from TreeSet: " + removedElement);
        }
    }

    public static void divSevenHashSet(HashSet<Integer> hm) {
        Iterator<Integer> it = hm.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (i % 7 == 0) {
                it.remove();
            }
        }
        System.out.println("HashSet after removing multiples of 7: " + hm);
    }
}
