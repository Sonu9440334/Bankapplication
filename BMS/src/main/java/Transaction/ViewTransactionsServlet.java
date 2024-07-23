package Transaction;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/viewTransactions")
public class ViewTransactionsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private TransactionDAO transactionDAO;

    public void init() {
        transactionDAO = new TransactionDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String accountNo = (String) session.getAttribute("accountNumber");

        if (accountNo == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<Transaction> transactions = transactionDAO.selectLast10Transactions(accountNo);
        request.setAttribute("transactions", transactions);
        request.getRequestDispatcher("transactions.jsp").forward(request, response);
    }
}
