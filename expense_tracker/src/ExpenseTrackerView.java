
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List; 

/**
 * ExpenseTrackerView class is responsible for updating the view when user adds a transaction.
 */
public class ExpenseTrackerView extends JFrame {

  /** variable to display tabel values in the app */
  private JTable transactionsTable;
  /** variable to store the Add Transaction action button */
  private JButton addTransactionBtn;
  /** variable to store the amount field of the transaction (entered by the user) */
  private JTextField amountField;
  /** variable to store the category field of the transaction (entered by the user) */
  private JTextField categoryField;
  /** variable to store table values */
  private DefaultTableModel model;
  /** variable storing all the transactions entered by the user */
  private List<Transaction> transactions = new ArrayList<>();

  
  /** Function to get the Transaction Table 
   * @return returns the table to be displayed
  */
  public JTable getTransactionsTable() {
    return transactionsTable;
  }

  /** Function to get the value entered in the TextField for amount by the user. 
   * @return Amount inserted in the text field corresponding to the amountField variable (if empty returns 0).
   */
  public double getAmountField() {
    if(amountField.getText().isEmpty()) {
      return 0;
    }else {
    double amount = Double.parseDouble(amountField.getText());
    return amount;
    }
  }

  /** Function to set the value of variable amountField (Nothing is returned) 
   * @param amountField assigns a value to the class variable amountField
  */
  public void setAmountField(JTextField amountField) {
    this.amountField = amountField;
  }

  /** Function to get the value entered in the TextField for category by the user. 
   * @return value entered in the category field by the user in GUI
  */
  public String getCategoryField() {
    return categoryField.getText();
  }

  /** Function to set the value of variable categoryField.
   * @param categoryField contains value to be assigned to the class variable categoryField 
  */
  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }

  /** Function returns the 'Add transaction button' as a variable 
   * @return Returns the add transaction button 
  */
  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }

  /** Returns the default table model 
   * @return returns the table model (consists of values to be displayed)
  */
  public DefaultTableModel getTableModel() {
    return model;
  }

  /**
   * Constructor method. Used to set default values for the several UI components in the application.
   * @param model Used to initialize the structure of the view table model
   */
  public ExpenseTrackerView(DefaultTableModel model) {
    setTitle("Expense Tracker"); // Set title
    setSize(600, 400); // Make GUI larger
    this.model = model;

    addTransactionBtn = new JButton("Add Transaction");

    // Create UI components 
    JLabel amountLabel = new JLabel("Amount:");
    amountField = new JTextField(10);
    
    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);
    transactionsTable = new JTable(model);
  
    // Layout components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel); 
    inputPanel.add(categoryField);
    inputPanel.add(addTransactionBtn);
  
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addTransactionBtn);
  
    // Add panels to frame
    add(inputPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER); 
    add(buttonPanel, BorderLayout.SOUTH);
  
    // Set frame properties
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  
  }

  /** Builds the custom table from start, i.e., from the first transaction, and calculates the new total 
   * @param transactions consists of a list of transactions made by the user in GUI
  */
  public void refreshTable(List<Transaction> transactions) {
      // model.setRowCount(0);
      model.setRowCount(0);
      int rowNum = model.getRowCount();
      double totalCost=0;
      for(Transaction t : transactions) {
        totalCost+=t.getAmount();
      }
  
      // Add rows from transactions list
      for(Transaction t : transactions) {
        model.addRow(new Object[]{rowNum+=1,t.getAmount(), t.getCategory(), t.getTimestamp()});

      }
      Object[] totalRow = {"Total", null, null, totalCost};
      model.addRow(totalRow);
  
      // Fire table update
      transactionsTable.updateUI();
  
    }  

  /** Collects the updated list of transactions and calls refreshTable function 
  */
  public void refresh() {

    // Get transactions from model 
    List<Transaction> transactions = getTransactions();
  
    // Pass to view
    refreshTable(transactions);
  
  }

  /** Method to return the list of transactions 
   * @return List of transactions made by the user 
  */
  public List<Transaction> getTransactions() {
    return transactions;
  }
  
  /** Adds the new transaction to the list of transactions. Updates the default table model with the latest transaction. 
   * @param t the latest transaction added by the user in GUI
   */ 
  public void addTransaction(Transaction t) {
    transactions.add(t);
    getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()});
    refresh();
  }
  


  // Other view methods
}
