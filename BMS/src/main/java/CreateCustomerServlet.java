import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminreg")
public class CreateCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String mobileNo = request.getParameter("mobileNumber");
        String emailID = request.getParameter("emailId");
        String accountType = request.getParameter("accountType");
        String balanceStr = request.getParameter("initialBalance");
        String dateOfBirth = request.getParameter("dob");
        String idProofType = request.getParameter("idProofType");
        String idProofNumber = request.getParameter("idProofNumber");

        // Validate form data
        if (fullName == null || address == null || mobileNo == null || emailID == null || accountType == null || 
            balanceStr == null || dateOfBirth == null || idProofType == null || idProofNumber == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing required parameters");
            return;
        }

        // Validate mobile number
        if (!mobileNo.matches("\\d{10}")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid mobile number format");
            return;
        }

        // Validate email
        if (!Pattern.compile("^[a-zA-Z0-9._%+-]+@gmail\\.com$").matcher(emailID).matches()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid email format. Only @gmail.com allowed");
            return;
        }

        // Validate date of birth
        LocalDate dob;
        try {
            dob = LocalDate.parse(dateOfBirth);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid date of birth format");
            return;
        }

        if (Period.between(dob, LocalDate.now()).getYears() < 18) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Customer must be at least 18 years old");
            return;
        }

        // Validate balance
        double balance;
        try {
            balance = Double.parseDouble(balanceStr);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid balance format");
            return;
        }

        if (balance < 1000) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Initial balance must be at least 1000");
            return;
        }

        // Validate ID proof number
        if (!idProofNumber.matches("\\d{12}")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID proof number format");
            return;
        }

        // Generate account number and password
        String accountNo = generateAccountNumber();
        String password = generateTemporaryPassword();

        String jdbcURL = "jdbc:mysql://localhost:3306/bas";
        String dbUser = "root";
        String dbPassword = "Sonu@2004";

        String sql = "INSERT INTO Customer (FullName, Address, MobileNo, EmailID, AccountType, Balance, DateOfBirth, IDProof, AccountNo, Password) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, fullName);
            statement.setString(2, address);
            statement.setString(3, mobileNo);
            statement.setString(4, emailID);
            statement.setString(5, accountType);
            statement.setDouble(6, balance);
            statement.setString(7, dateOfBirth);
            statement.setString(8, idProofType + " - " + idProofNumber);
            statement.setString(9, accountNo);
            statement.setString(10, password); // Ensure password is hashed and salted in a real application

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                response.sendRedirect("adminopr.jsp");
            } else {
                response.getWriter().println("Error occurred while inserting the customer.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error occurred: " + e.getMessage());
        }
    }

    private String generateAccountNumber() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(12);
        for (int i = 0; i < 12; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    private String generateTemporaryPassword() {
        SecureRandom random = new SecureRandom();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
}
