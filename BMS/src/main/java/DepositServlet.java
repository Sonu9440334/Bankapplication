import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("accountNumber") == null) {
            response.sendRedirect("Customerlogin.jsp"); // Redirect to login if not logged in
            return;
        }

        String accountNumber = (String) session.getAttribute("accountNumber");
        String amountStr = request.getParameter("depositAmount");

        if (amountStr == null || amountStr.isEmpty()) {
            response.getWriter().println("Amount is required.");
            return;
        }

        double amount = Double.parseDouble(amountStr);

        String jdbcURL = "jdbc:mysql://localhost:3306/bas";
        String dbUser = "root";
        String dbPassword = "Sonu@2004";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.getWriter().println("Error loading JDBC driver: " + e.getMessage());
            return;
        }

        String updateBalanceSQL = "UPDATE Customer SET Balance = Balance + ? WHERE AccountNo = ?";
        String insertTransactionSQL = "INSERT INTO Transaction (AccountNo, TransactionType, Amount) VALUES (?, 'Deposit', ?)";

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            connection.setAutoCommit(false); // Start transaction

            try (PreparedStatement updateBalanceStmt = connection.prepareStatement(updateBalanceSQL);
                 PreparedStatement insertTransactionStmt = connection.prepareStatement(insertTransactionSQL)) {

                // Update balance
                updateBalanceStmt.setDouble(1, amount);
                updateBalanceStmt.setString(2, accountNumber);
                int rowsUpdated = updateBalanceStmt.executeUpdate();

                if (rowsUpdated > 0) {
                    // Insert transaction
                    insertTransactionStmt.setString(1, accountNumber);
                    insertTransactionStmt.setDouble(2, amount);
                    insertTransactionStmt.executeUpdate();

                    connection.commit(); // Commit transaction

                    // Update the balance in the session
                    double newBalance = (double) session.getAttribute("balance") + amount;
                    session.setAttribute("balance", newBalance);

                    // Redirect to customer dashboard servlet
                    response.sendRedirect("CustomerDashboard");
                } else {
                    connection.rollback(); // Rollback transaction
                    response.getWriter().println("Error occurred. Deposit failed.");
                }
            } catch (SQLException e) {
                connection.rollback(); // Rollback transaction
                e.printStackTrace();
                response.getWriter().println("Error occurred: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error occurred: " + e.getMessage());
        }
    }
}
