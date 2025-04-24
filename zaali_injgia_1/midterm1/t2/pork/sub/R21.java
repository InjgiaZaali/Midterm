package zaali_injgia_1.midterm1.t2.pork.sub;
import zaali_injgia_1.midterm1.t2.pork.A21;
import zaali_injgia_1.midterm1.t2.stove.stage.A22;


public class R21 {
    public static void main(String[] args) {
        A21 rectangle = new A21();

        int width = rectangle.getWidth();
        int height = rectangle.getHeight();

        int area = width * height;

        System.out.printf("The area of rectangle is: %d", area);

        A22 date = new A22();
        int monthNumber = date.getMonth();

        String monthName = getMonthName(monthNumber);
        System.out.println("The month is: " + monthName);


    }

    private static String getMonthName(int month) {
        if (month < 1 || month > 12) {
            return "invalid month number";
        }

        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        return months[month - 1];
    }
}