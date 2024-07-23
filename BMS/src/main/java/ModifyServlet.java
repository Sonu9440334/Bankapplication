import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modifycustomer")
public class ModifyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerID = request.getParameter("customerID");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            String sql = "SELECT * FROM Customer WHERE CustomerID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customerID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                request.setAttribute("customerID", rs.getInt("CustomerID"));
                request.setAttribute("fullName", rs.getString("FullName"));
                request.setAttribute("address", rs.getString("Address"));
                request.setAttribute("mobileNumber", rs.getString("MobileNumber"));
                request.setAttribute("emailId", rs.getString("EmailId"));
                request.setAttribute("accountType", rs.getString("AccountType"));
                request.setAttribute("dob", rs.getDate("DOB"));
                request.setAttribute("initialBalance", rs.getDouble("Balance"));
                request.setAttribute("idProofType", rs.getString("IDProofType"));
                request.setAttribute("idProofNumber", rs.getString("IDProofNumber"));
                request.setAttribute("accountNumber", rs.getString("AccountNumber"));
                request.setAttribute("password", rs.getString("Password"));
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }

        request.getRequestDispatcher("modifycustomer.jsp").forward(request, response);
    }
}