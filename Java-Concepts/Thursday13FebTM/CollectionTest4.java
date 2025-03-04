import java.util.*;

class CollectionTest4 {
    public static void main(String[] a) {
        // Creation of collections
        // invoke methods with appropriate collections}

        HashSet<Integer> set1 = new HashSet<>();
        setSample(set1);
        System.out.println("Task 1: " + set1);
        for (Integer i : set1) {
            if (i % 7 == 0) {
                System.out.println(i);
            }
        }

        LinkedHashSet<String> set2 = new LinkedHashSet<>();
        setSample(set2);
        System.out.println("Task 2: " + set2);
        for (String i : set2) {
            if (i.length() >= 5) {
                System.out.println(i);
            }
        }

        TreeSet<Double> set3 = new TreeSet<>();
        setSample(set3);
        System.out.println("Task 3: " + set3);
        for (Double i : set3) {
            if (i > 20) {
                System.out.println(i);
            }
        }

    }

    public static void setSample(HashSet<Integer> hs) {
        hs.add(1);
        hs.add(2);
        hs.add(14);
        hs.add(21);
        hs.add(5);
        hs.add(28);
        hs.add(7);
        hs.add(8);

        hs.remove(2);
    }

    public static void setSample(LinkedHashSet<String> hs) {

        hs.add("Hello");
        hs.add("Hello world");
        hs.add("H");
        hs.add("ello");
        hs.add("elcal");
        hs.add("defHeo");
        hs.add("Helvv");
        hs.add("abclo");

        hs.remove("Hello");

    }

    public static void setSample(TreeSet<Double> hs) {
        hs.add(1.0);
        hs.add(2.0);
        hs.add(20.0);
        hs.add(25.0);
        hs.add(35.0);
        hs.add(47.0);
        hs.add(40.0);
        hs.add(45.0);

        hs.remove(2.0);
    }
}