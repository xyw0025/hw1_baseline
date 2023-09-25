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

    /** Function to validate amount field on the GUI
     * @param amount value inserted by the user on GUI in amount field
     */
    private static void checkAmount(double amount) {
        if (amount <= 0 || amount >= 1000) {
            throw new IllegalArgumentException("Invalid input - amount");
        }
    }
    /**
     * Function to calidate category value on GUI
     * @param category value inserted by the user in category field on GUI
     */
    private static void checkCategory(String category) {
        // raise error if the category name is not in the array
       if (!Arrays.asList(categories).contains(category)) {
           throw new IllegalArgumentException("Invalid input - category");
       }
    }

    /**
     * Function to receive values from amount and category field of GUI and validate them
     * @param amount user's amount value on GUI
     * @param category_name user's category value on GUI
     */
    public static void check(double amount, String category_name) {
        checkAmount(amount);
        checkCategory(category_name);
    }
}
