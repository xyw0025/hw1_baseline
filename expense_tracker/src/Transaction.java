
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Transaction class provides a basic structure to a transaction made by the user
 */
public class Transaction {
  /** variable to store the amount present in the transaction  */
  private double amount;
  /** variable to store type of transaction. Example - food, entertainment, etc.  */
  private String category;
  /** variable to store the timestamp (time and date) of the new transaction  */
  private String timestamp;

  /** Initializes the class variables to the value passed to the constructor  */
  public Transaction(double amount, String category) {
    this.amount = amount;
    this.category = category;
    this.timestamp = generateTimestamp();
  }

  /** Function to access value of the amount variable  */
  public double getAmount() {
    return amount;
  }

  /** Function to set a value to the amount variable  */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  /** Function to access the value of category variable  */
  public String getCategory() {
    return category;
  }

  /** function to assign/set a value to the category variable  */
  public void setCategory(String category) {
    this.category = category; 
  }
  
  /** function to return the timestamp value  */
  public String getTimestamp() {
    return timestamp;
  }

  /** Generates and returns the current timestamp in the pattern "dd-MM-yyyy HH:mm"  */
  private String generateTimestamp() {
    // Formatter to load the timestamp according to a specific pattern
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
    return sdf.format(new Date());
  }

}