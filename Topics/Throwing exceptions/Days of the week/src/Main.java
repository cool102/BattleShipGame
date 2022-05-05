import java.util.Scanner;

public class Main {

    public static String getDayOfWeekName(int number) {
        String res = "";
        switch (number) {
            case 1:
                res = "Mon";
                break;
            case 2:
                res = "Tue";
                break;
            case 3:
                res = "Wed";
                break;
            case 4:
                res = "Thu";
                break;
            case 5:
                res = "Fri";
                break;
            case 6:
                res = "Sat";
                break;
            case 7:
                res = "Sun";
                break;
            default:
                throw new IllegalArgumentException();

        }
        return res;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayNumber = scanner.nextInt();
        try {
            System.out.println(getDayOfWeekName(dayNumber));
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }
    }
}