import java.util.*;

class Atm {
    public String name, tname, tid, id, id1, tranhistory = "";
    public int pin, pin1;
    double amt, tamt, wamt, totamt = 0d;

    public void registration() {
        Scanner sc = new Scanner(System.in);
        System.out.println("*Registration process*");
        System.out.print("Enter your name : ");
        name = sc.nextLine();
        while (!name.matches("[a-zA-Z]+")) {
            System.out.println("Please enter a valid name!");
            name = sc.nextLine();
        }
        System.out.print("Enter user id : ");
        id = sc.nextLine();
        while (!id.matches("[a-zA-Z]+")) {
            System.out.println("Please enter a valid id!");
            id = sc.nextLine();
        }
        System.out.print("Enter user pin : ");
        try {
            pin = Integer.parseInt(sc.next());
        } catch (NumberFormatException e) {
            System.out.print("Enter integer value only!\nEnter pin again : ");
            pin = Integer.parseInt(sc.next());
        }
        System.out.println("Registration completed......Now use the above entered info to login");
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter following information in order to login to your account : ");
        System.out.print("Enter your user id : ");
        id1 = sc.nextLine();
        while (true) {
            if (id1.equals(id)) {
                break;
            } else {
                System.out.print("Wrong id \nEnter user id again : ");
                id1 = sc.nextLine();
            }
        }
        System.out.print("Enter your user pin : ");
        // pin1 = sc.nextInt();
        try {
            pin1 = Integer.parseInt(sc.next());
        } catch (NumberFormatException e) {
            System.out.print("Enter integer value only!\nEnter pin again : ");
            pin1 = Integer.parseInt(sc.next());
        }
        while (true) {
            if (pin == pin1) {
                break;
            } else {
                System.out.print("Wrong pin \nEnter user pin again : ");
                pin1 = sc.nextInt();
            }
        }
        if (pin1 == pin && id.equals(id1)) {
            System.out.println("----------------------------------");
            System.out.print("\tWelcome '" + name + "'");
            System.out.println("\n----------------------------------");
        }
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount your want to deposit : ");
        amt = sc.nextDouble();
        if (amt > 150000) {
            System.out.print("Sorry....Deposit limit is Rs. 150000.\nEnter Deposit amount again : ");
            amt = sc.nextDouble();
        }
        totamt = amt + totamt;
        System.out.println("-----------------------------------------------");
        System.out.println("Your entered sum was successfully deposited :)");
        System.out.println("-----------------------------------------------");
        String s = "\nRs. " + amt + " Deposited.";
        tranhistory = tranhistory.concat(s);
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount you want to withdraw : ");
        wamt = sc.nextInt();
        if (wamt > totamt) {
            System.out.print("Insufficient Balance....Enter withdraw amount again : ");
            wamt = sc.nextInt();
        }
        totamt = totamt - wamt;
        System.out.println("-----------------------------------------------");
        System.out.println("Your entered sum was successfully Withdrawn :)");
        System.out.println("-----------------------------------------------");
        String s1 = "\nRs. " + wamt + " Withdrawn.";
        tranhistory = tranhistory.concat(s1);
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name and user id of the person you want to transfer money - ");
        System.out.print("Name : ");
        tname = sc.nextLine();
        System.out.print("User id : ");
        tid = sc.nextLine();
        System.out.print("Enter the amount you want to transfer : ");
        tamt = sc.nextInt();

        try {
            if (totamt >= tamt) {
                if (tamt <= 70000) {
                    totamt = totamt - tamt;
                    System.out.println("-----------------------------------------------");
                    System.out.println("Rs. " + tamt + " Successfully tranfered to " + tname + ".");
                    System.out.println("-----------------------------------------------");
                    String s2 = "\nRs. " + tamt + " Transfered to " + tname + ".";
                    tranhistory = tranhistory.concat(s2);
                } else {
                    System.out.println("Sorry limit is Rs. 50000.");
                }
            } else {
                System.out.println("Insufficient balance.");
            }
        } catch (Exception e) {
        }
    }

    public void transactionHistory() {
        if (tranhistory == "") {
            System.out.println("-----------------------------");
            System.out.println("No transaction history.");
            System.out.println("-----------------------------");
        } else {
            System.out.println("-----------------------------");
            System.out.println("Your transaction history : ");
            System.out.println(tranhistory);
            System.out.println("-----------------------------");
        }
    }

    public void balance() {
        System.out.println("-----------------------------");
        System.out.println("Your Balance is : Rs. " + totamt);
        System.out.println("-----------------------------");
    }
}

public class oibsip_taskno3 {
    public static void main(String[] args) {
        int c3, c, c1;
        Scanner sc = new Scanner(System.in);
        Atm a = new Atm();
        System.out.println("\n######### Welcome to HDFC BANK ATM #########");
        System.out.println("1.Register \n2.Exit");
        System.out.print("Enter your choice(from 1 and 2) : ");
        try {
            c1 = Integer.parseInt(sc.next());
        } catch (NumberFormatException e) {
            System.out.print("Enter integer value only!(from 1 or 2)\nEnter your choice again :");
            c1 = Integer.parseInt(sc.next());
        }
        if (c1 != 1 && c1 != 2) {
            System.out.print("Choose only from 1 or 2....Enter your choice again : ");
            c1 = sc.nextInt();
        }
        if (c1 == 1) {
            a.registration();
        } else if (c1 == 2) {
            System.out.println("--------Thank you--------");
            System.exit(0);
        }
        while (true) {
            System.out.println("1.Login \n2.Exit");
            System.out.print("Enter your choice(from 1 and 2) : ");
            try {
                c3 = Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                System.out.print("Enter integer value only!(from 1 or 2)\nEnter your choice again :");
                c3 = Integer.parseInt(sc.next());
            }
            if (c3 != 1 && c3 != 2) {
                System.out.print("Choose only from 1 or 2....Enter your choice again : ");
                c3 = sc.nextInt();
            }
            if (c3 == 1) {
                a.login();
            } else if (c3 == 2) {
                System.out.println("--------Thank you--------");
                System.exit(0);
            }
            while (true) {

                System.out.println(
                        "\n1.Transaction History \n2.Withdraw \n3.Deposit \n4.Transfer \n5.Check Balance \n6.Quit");
                System.out.print("\nEnter your choice : ");
                c = sc.nextInt();
                if (c > 6 || c < 1) {
                    System.out.println("Invalid Entry!!");
                }
                switch (c) {
                    case 1:
                        a.transactionHistory();
                        break;
                    case 2:
                        a.withdraw();
                        break;
                    case 3:
                        a.deposit();
                        break;
                    case 4:
                        a.transfer();
                        break;
                    case 5:
                        a.balance();
                        break;
                    case 6:
                }
                if (c == 6) {
                    break;
                }
            }
        }
    }
}
