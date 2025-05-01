import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {

    Scanner scanner = new Scanner(System.in);
    DecimalFormat formatter = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> userDatabase = new HashMap<>();

    public void launchLoginMenu() {
        boolean loginLoop = true;

        do {
            try {
                userDatabase.put(123456, 1111);
                userDatabase.put(987654, 2222);

                System.out.println("=== Welcome to Secure ATM ===");
                System.out.print("Enter Customer Number: ");
                setUserId(scanner.nextInt());

                System.out.print("Enter PIN Code: ");
                setPinCode(scanner.nextInt());

                int userId = getUserId();
                int pin = getPinCode();

                if (userDatabase.containsKey(userId) && userDatabase.get(userId) == pin) {
                    showAccountMenu();
                    loginLoop = false;
                } else {
                    System.out.println("Incorrect Customer Number or PIN. Try again.\n");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter numeric values only.\n");
                scanner.nextLine(); // Clear the buffer
            }

        } while (loginLoop);
    }

    private void showAccountMenu() {
        System.out.println("\nSelect Account to Access:");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Exit");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> handleCheckingAccount();
            case 2 -> handleSavingAccount();
            case 3 -> System.out.println("Thank you for using our ATM. Goodbye!");
            default -> {
                System.out.println("Invalid selection. Please try again.");
                showAccountMenu();
            }
        }
    }

    private void handleCheckingAccount() {
        System.out.println("\n=== Checking Account Menu ===");
        System.out.println("1. View Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Return to Main Menu");

        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                System.out.println("Checking Balance: " + formatter.format(getCheckBalance()));
                showAccountMenu();
            }
            case 2 -> {
                processCheckingWithdrawal();
                showAccountMenu();
            }
            case 3 -> {
                processCheckingDeposit();
                showAccountMenu();
            }
            case 4 -> showAccountMenu();
            default -> {
                System.out.println("Invalid option. Please choose again.");
                handleCheckingAccount();
            }
        }
    }

    private void handleSavingAccount() {
        System.out.println("\n=== Savings Account Menu ===");
        System.out.println("1. View Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Return to Main Menu");

        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                System.out.println("Savings Balance: " + formatter.format(getSaveBalance()));
                showAccountMenu();
            }
            case 2 -> {
                processSavingWithdrawal();
                showAccountMenu();
            }
            case 3 -> {
                processSavingDeposit();
                showAccountMenu();
            }
            case 4 -> showAccountMenu();
            default -> {
                System.out.println("Invalid option. Please choose again.");
                handleSavingAccount();
            }
        }
    }
}

