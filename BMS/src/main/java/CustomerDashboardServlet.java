import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CustomerDashboard")
public class CustomerDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("accountNumber") == null) {
            response.sendRedirect("Customerlogin.jsp"); // Redirect to login if not logged in
            return;
        }

        String accountNumber = (String) session.getAttribute("accountNumber");
        String accountType = (String) session.getAttribute("accountType");
        Double balance = (Double) session.getAttribute("balance");

        request.setAttribute("accountNumber", accountNumber);
        request.setAttribute("accountType", accountType);
        request.setAttribute("balance", balance);

        request.getRequestDispatcher("customerdashboardpage.jsp").forward(request, response);
    }
}
