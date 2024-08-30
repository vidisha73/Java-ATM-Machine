import java.util.Scanner;

class AtmMachine {
    final static int password = 1234;
    static int balance = 0;

    public static void CheckBalance() {
        System.out.println("Balance : " + balance);
    }

    public static void deposit(int amt) {
        balance = balance + amt;
        System.out.println("Amount deposited successfully\n");
    }

    public static void withdraw(int amt) {
        if (balance < amt) {
            System.out.println("Balance insufficient");
        } else if (amt <= balance) {
            balance = balance - amt;
            System.out.println("Amount withdrawn successfully\n");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Please insert your atm card!!");

            System.out.println("\nPlease enter your pin :");
            int pin = sc.nextInt();

            int attempt = 3;
                while (pin!=password && attempt > 0) {
                    attempt--;
                    System.out.println("\nWrong password entered!");
                    if (attempt > 0) {
                        System.out.println("You have remaining " + attempt + " try!");
                        System.out.println("please try again");
                    } else {
                        System.out.println("\nAcess denied");
                        System.out.println("No attempts left");
                        System.out.println("Please try after some time\n");
                    }
                    pin = sc.nextInt();
                }

            if (pin == password) {
                System.out.println("Password entered correctly");
                char c = 'y';
                do {
                    System.out.println("1 : Check Balance");
                    System.out.println("2 : Withdraw amount");
                    System.out.println("3 : Deposit Amount");
                    System.out.println("4 : Exit\n");

                    System.out.println("Please enter your choice : ");
                    int ch = sc.nextInt();

                    switch (ch) {
                        case 1:
                            CheckBalance();
                            break;
                        case 2:
                            System.out.println("please enter amount to be withdrawn");
                            int amt = sc.nextInt();
                            withdraw(amt);
                            CheckBalance();
                            break;
                        case 3:
                            System.out.println("please enter amount to be deposited");
                            int amount = sc.nextInt();
                            deposit(amount);
                            CheckBalance();
                            break;
                        case 4:
                            System.exit(0);

                        default:
                            System.out.println("Wrong choice entered\n");
                    }

                    System.out.println("\nDo you wish to continue(y/n)?");
                    c = sc.next().charAt(0);

                } while (c == 'y');

            } else {
                
            }
            sc.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}