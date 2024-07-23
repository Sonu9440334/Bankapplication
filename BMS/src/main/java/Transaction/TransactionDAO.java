package Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class TransactionDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/bas";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Sonu@2004";

    private static final String SELECT_LAST_10_TRANSACTIONS_BY_ACCOUNT_NO = 
        "SELECT * FROM Transaction WHERE AccountNo = ? ORDER BY Date DESC LIMIT 10";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Transaction> selectLast10Transactions(String accountNo) {
        List<Transaction> transactions = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAST_10_TRANSACTIONS_BY_ACCOUNT_NO);) {
            preparedStatement.setString(1, accountNo);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int transactionID = rs.getInt("TransactionID");
                String transactionType = rs.getString("TransactionType");
                BigDecimal amount = rs.getBigDecimal("Amount");
                Timestamp date = rs.getTimestamp("Date");

                transactions.add(new Transaction(transactionID, accountNo, transactionType, amount, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
