import java.util.Arrays;

public class InputValidation {
//    private enum Category {
//        FOOD,
//        TRAVEL,
//        ENTERTAINMENT,
//        OTHER
//    }

    static String[] categories = {"Food", "Travel", "Entertainment", "Other"};

    private static void checkAmount(double amount) {
        if (amount <= 0 || amount >= 1000) {
            throw new IllegalArgumentException("Invalid input - amount");
        }
    }
    private static void checkCategory(String category) {
        // raise error if the category name's not in the array
       if (!Arrays.asList(categories).contains(category)) {
           throw new IllegalArgumentException("Invalid input- category");
       }
    }
    public static void check(double amount, String category_name) {
        checkAmount(amount);
        checkCategory(category_name);
    }
}
