package Transaction;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Transaction {
    private int transactionID;
    private String accountNo; // Changed to String to match the data type in the database
    private String transactionType;
    private BigDecimal amount;
    private Timestamp date;

    // Constructor
    public Transaction(int transactionID, String accountNo, String transactionType, BigDecimal amount, Timestamp date) {
        this.transactionID = transactionID;
        this.accountNo = accountNo;
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = date;
    }

    // Getters and setters
    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}