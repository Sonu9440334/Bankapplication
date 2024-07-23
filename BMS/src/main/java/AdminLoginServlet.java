import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Connection connection = DatabaseConnection.initializeDatabase();
            String sql = "SELECT * FROM admin WHERE Username = ? AND Password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Admin authenticated, set session attribute and redirect to admin dashboard
                HttpSession session = request.getSession();
                session.setAttribute("adminUsername", username);
                response.sendRedirect("adminopr.jsp");  // Ensure this path is correct
            } else {
                // Invalid credentials, redirect back to login with error message
            	
            	response.getWriter().println("Error occurred while inserting the customer.");
                request.setAttribute("error", "Invalid username or password");
                request.getRequestDispatcher("/adminlogin.jsp").forward(request, response);  // Ensure this path is correct
            }

            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
