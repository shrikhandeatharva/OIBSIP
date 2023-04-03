import java.util.*;
import javax.swing.JOptionPane;

class outofrangeexception extends Exception {   
    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        return "Your entered number should lie in range 1-100.";
    }
}

class Guess {
    public int cnum, anum, bnum, counter = 0; // cnum -> computer number , anum -> above number , bnum -> below number
    double mynum; // mynum -> number entered by me

    public void randomnum() {        
        Random num = new Random();
        cnum = 1 + num.nextInt(100);
    }

    public void mynumber(double mynum) {
        this.mynum = mynum;
    }

    public String iscorrect() {
        if (mynum == cnum) {
            return "correct";
        } else if (mynum > cnum) {
            return "above";
        } else {
            return "below";
        }
    }

    public void hint() {
        Random rnum = new Random();
        anum = 1 + rnum.nextInt(4);
        bnum = 1 + rnum.nextInt(4);
        int canum = cnum + anum;
        int cbnum = cnum - bnum;
        JOptionPane.showMessageDialog(null,
                "HINT : The number chosen by computer lies between " + cbnum + " and " + canum);
    }
}

public class oibsip_taskno2 {
    public static void no1(double mynum) throws outofrangeexception {
        throw new outofrangeexception();
    }

    public static void main(String[] args) {
        double mynum;
        int count = 0; //counter
        Scanner sc = new Scanner(System.in);
        JOptionPane.showMessageDialog(null, "# GUESS THE NUMBER GAME # ");
        JOptionPane.showMessageDialog(null,
                "IMPORTANT INSTRUCTIONS : \n1. Here you have to guess the number choosen by computer between 1 to 100.\n2. There will be 2 rounds each containing 5 attempts.\n3. You have to guess number correctly within these 5 attempts otherwise you will lose that particular round. \n4. 5 points for right guess within first three attempts,3 points for correct guess after taking hint(i.e for 4th or 5th attempt),no points for all 5 incorrect attempts.\n5. Your Score i.e points will be displayed at the end of both the rounds.");
        Guess game = new Guess();
        for (int j = 1; j < 3; j++) {
            JOptionPane.showMessageDialog(null, "Round " + j);
            game.randomnum();
            int i;
            for (i = 1; i < 6; i++) {
                String input;
                input = JOptionPane.showInputDialog("ATTEMPT NO. " + i + " \n Enter any number between 1 to 100 :");
                mynum = Double.parseDouble(input);
                if (mynum < 1 || mynum > 100) {
                    try {
                        no1(mynum);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,
                                "Your entered number cannot be out of range 1-100 \nEnter your number of Attempt " + i
                                        + " again :");
                        input = JOptionPane
                                .showInputDialog("ATTEMPT NO. " + i + " \n Enter any number between 1 to 100 :");
                        mynum = Double.parseDouble(input);
                    }
                }
                game.mynumber(mynum);
                if (game.iscorrect() == "correct") {
                    JOptionPane.showMessageDialog(null, "Congratulations :) You have guessed the number correctly!");
                    if (i < 4) {
                        count = count + 5;
                    } else if (i < 6 && i > 3) {
                        count = count + 3;
                    }
                    break;
                } else if (game.iscorrect() == "above") {
                    if (i < 5) {
                        JOptionPane.showMessageDialog(null, "Enter smaller number : ");
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry! You lost this round :(");
                    }
                } else if (game.iscorrect() == "below") {
                    if (i < 5) {
                        JOptionPane.showMessageDialog(null, "Enter larger number : ");
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry! You lost this round :(");
                    }
                }
                while (i == 3) {
                    if (game.iscorrect() == "above" || game.iscorrect() == "below") {
                        int result = JOptionPane.showConfirmDialog(null,
                                "You have guessed wrong 3 times in a row \n Would you like to take a hint ?",
                                "Confirmation", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            game.hint();
                            break;
                        } else if (result == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(null, "Salute to your confidence!");
                            break;
                        }
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Your total points are : " + count + " out of 10");
        sc.close();
    }
}