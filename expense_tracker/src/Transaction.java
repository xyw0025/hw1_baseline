
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

  /** Initializes the class variables to the value passed to the constructor  
   * @param amount consists of the default value for class variable amount
   * @param category is the default value for class variable category
  */
  public Transaction(double amount, String category) {
    this.amount = amount;
    this.category = category;
    this.timestamp = generateTimestamp();
  }

  /** 
   * Function to access value of the amount variable
   * @return  value of amount class variable is returned 
   */
  public double getAmount() {
    return amount;
  }

  /** Function to set a value to the amount variable
   * @param amount the value to be assigned to class variable amount
    */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  /** Function to access the value of category variable  
   * @return the current value of category is returned
  */
  public String getCategory() {
    return category;
  }

  /** function to assign/set a value to the category variable  
   * @param category contains the value to be assigned to the category variable
  */
  public void setCategory(String category) {
    this.category = category; 
  }
  
  /** function to return the timestamp value  
   * @return returns the current timestamp
  */
  public String getTimestamp() {
    return timestamp;
  }

  /** Generates and returns the current timestamp in the pattern "dd-MM-yyyy HH:mm"  
   * @return Returns the timestamp in a formatted pattern
  */
  private String generateTimestamp() {
    // Formatter to load the timestamp according to a specific pattern
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
    return sdf.format(new Date());
  }

}