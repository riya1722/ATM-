public class ATM extends OptionMenu {
    public static void main(String[] args) {
        ATM atmInterface = new ATM();
        atmInterface.startSession();
    }

    public void startSession() {
        getLogin();
    }
}
