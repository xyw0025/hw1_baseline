import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {
  //   mock-up code:
  private DefaultTableModel createComponent(Str[] column_names) {
    DefaultTableModel tableModel = new DefaultTableModel();

    for (int i = 0; i < len(column_names); i++) {
      tableModel.addColumn(column_names[i]);
    }
    return tableModel;
  }

  private static void addTransactionListener() {
    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {

      // Get transaction data from view
      double amount = view.getAmountField();
      String category = view.getCategoryField();

      // Create transaction object
      Transaction t = new Transaction(amount, category);

      // Call controller to add transaction
      view.addTransaction(t);
    });
  }

  public static void main(String[] column_names) { // args is the name of variable? -> should rename to column_names
    ExpenseTrackerView view = new createComponent(column_names);
    // Initialize view
    view.setVisible(true);
    addTransactionListener();
  }
}