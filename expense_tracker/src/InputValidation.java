import java.util.Arrays;
/**
 * Class to validate the inputs entered by the user in amount and category field
 */
public class InputValidation {
    // Requirements according to HW1.pdf:
    // The amount should be greater than 0 and less than 1000
    // The amount should be a valid number
    // The category should be a valid string input from list: ”food”, ”travel”, ”bills”, ”entertainment”, and ”other”

    /**
     * List containing all possible values for category field
     */
    static String[] categories = {"food", "bills", "travel", "entertainment", "other"};

    private static void checkAmount(double amount) {
        if (amount <= 0 || amount >= 1000) {
            throw new IllegalArgumentException("Invalid input - amount");
        }
    }
    private static void checkCategory(String category) {
        // raise error if the category name is not in the array
       if (!Arrays.asList(categories).contains(category)) {
           throw new IllegalArgumentException("Invalid input - category");
       }
    }
    public static void check(double amount, String category_name) {
        checkAmount(amount);
        checkCategory(category_name);
    }
}
