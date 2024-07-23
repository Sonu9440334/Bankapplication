import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Customerlogin")
public class CustomerLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        String password = request.getParameter("password");

        if (accountNumber == null || password == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing required parameters");
            return;
        }

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

        String sql = "SELECT * FROM Customer WHERE AccountNo = ? AND Password = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, accountNumber);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("accountNumber", accountNumber);
                session.setAttribute("accountType", resultSet.getString("AccountType"));
                session.setAttribute("balance", resultSet.getDouble("Balance"));
                response.sendRedirect("CustomerDashboard");
            } else {
                request.setAttribute("error", "Invalid account number or password");
                request.getRequestDispatcher("/Customerlogin.jsp").forward(request, response);  
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error occurred: " + e.getMessage());
        }
    }
}