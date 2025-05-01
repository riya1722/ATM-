import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int userId;
    private int pinCode;
    private double checkBalance = 0.0;
    private double saveBalance = 0.0;

    Scanner scanner = new Scanner(System.in);
    DecimalFormat formatter = new DecimalFormat("'$'###,##0.00");

    // Setters and Getters
    public void setUserId(int id) {
        this.userId = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setPinCode(int pin) {
        this.pinCode = pin;
    }

    public int getPinCode() {
        return pinCode;
    }

    public double getCheckBalance() {
        return checkBalance;
    }

    public double getSaveBalance() {
        return saveBalance;
    }

    // Balance Operations
    public void withdrawFromChecking(double amount) {
        checkBalance -= amount;
    }

    public void withdrawFromSaving(double amount) {
        saveBalance -= amount;
    }

    public void depositToChecking(double amount) {
        checkBalance += amount;
    }

    public void depositToSaving(double amount) {
        saveBalance += amount;
    }

    // User Interaction Methods
    public void processCheckingWithdrawal() {
        System.out.println("Current Checking Balance: " + formatter.format(checkBalance));
        System.out.print("Enter amount to withdraw from checking: ");
        double amount = scanner.nextDouble();

        if (checkBalance >= amount) {
            withdrawFromChecking(amount);
            System.out.println("Updated Checking Balance: " + formatter.format(checkBalance));
        } else {
            System.out.println("Insufficient funds in checking account.");
        }
    }

    public void processSavingWithdrawal() {
        System.out.println("Current Saving Balance: " + formatter.format(saveBalance));
        System.out.print("Enter amount to withdraw from saving: ");
        double amount = scanner.nextDouble();

        if (saveBalance >= amount) {
            withdrawFromSaving(amount);
            System.out.println("Updated Saving Balance: " + formatter.format(saveBalance));
        } else {
            System.out.println("Insufficient funds in saving account.");

