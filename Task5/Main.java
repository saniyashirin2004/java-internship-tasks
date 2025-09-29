package task5;
public class Main {
    public static void main(String[] args) {
        SavingsAccount myAccount = new SavingsAccount("123456", 1000, 2.5);
        Bank myBank = new Bank(myAccount);

        myBank.deposit(500);
        myBank.withdraw(200);
        myBank.printBalance();

        myAccount.addInterest();
        myBank.printBalance();

        myBank.printTransactionHistory();
    }
}