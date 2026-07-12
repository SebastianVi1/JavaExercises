import java.text.DecimalFormat;

public class Formatter {
    public static String numberToString(double price){
        String number = String.format("%.2f", price);

        return "$%s".formatted(number);
    }
}
