enum DaysOfWeek {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class EnumExample {
    public static void main(String[] args) {
        DaysOfWeek today = DaysOfWeek.SUNDAY;

        if (today == DaysOfWeek.SATURDAY || today == DaysOfWeek.SUNDAY) {
            System.out.println("Holiday");
        } else {
            System.out.println("Not Holiday");
        }
    }
}
