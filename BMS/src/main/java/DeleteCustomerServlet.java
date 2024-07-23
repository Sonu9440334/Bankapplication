import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/closecustomeraccount")
public class DeleteCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");

        Connection conn = null;
 PreparedStatement stmt = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            String dbURL = "jdbc:mysql://localhost:3306/bas";
            String dbUser = "root";
            String dbPass = "Sonu@2004";
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            // SQL query to delete customer
            String sql = "DELETE FROM Customer WHERE AccountNo = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, accountNumber);

            // Execute the query
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                response.getWriter().println("Customer account deleted successfully.");
            } else {
                response.getWriter().println("Customer account not found.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error deleting customer account: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}