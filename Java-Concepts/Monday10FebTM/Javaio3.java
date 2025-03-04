public class Javaio3 {
    public static void sop(String s) {
        System.out.print(s);
    }

    public static void sopln(String s) {
        System.out.println(s);
    }

    public void soerr(String s) {
        System.err.print(s);
    }

    public static void main(String[] args) {
        Javaio3 j = new Javaio3();
        j.soerr("This is an error message using print().\n");
        j.soerr("This is another error message using println().\n");
        sop("Hello SOP");
        sop("Java SOP");
        sopln("Hello SOPln");
        sopln("World SOPln");
        sopln("User SOPln");
    }
}