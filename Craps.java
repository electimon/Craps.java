import java.util.Scanner;  // Import the Scanner class

public class Craps {
    static int sumRoll;
    static int maxNum = 12;
    static int rolledNum;
    static int wonGames;
    static int dice1Roll;
    static int dice2Roll;
    static boolean pointCase = false;
    static boolean craps = false;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter number of rounds");
        int rounds = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < rounds; i++) {
            System.out.println("\nStart of a new round! Rounds remaining: " + (rounds - i));
            System.out.println("Press enter to roll!");
            scanner.nextLine();
            rolledNum = shoot(2, 6);
            System.out.println("You rolled " + rolledNum);
            if (round()) {
                System.out.println("Congratulations you won!");
                wonGames += 1;
            } else {
                if (craps) {
                    System.out.println("Thats Craps! You Lost!");
                    craps = false;
                } else {
                    System.out.println("You Lost!");
                }
            }
        }
        System.out.println("You won " + wonGames + " Games! Losing " + (rounds - wonGames) + " Games!");
    }
    public static int roll(int maxNum) {
        int randNum = (int)(Math.random() * maxNum) + 1;
        return randNum;
    }
    public static int shoot(int numDice, int maxVal) {
        dice1Roll = roll(6);
        dice2Roll = roll(6);
        return dice2Roll + dice1Roll;
    }
    public static boolean round() {
        if (rolledNum == 2 || rolledNum == 3 || rolledNum == 12) {
            craps = true;
            return false;
        } else if (rolledNum == 7 || rolledNum == 11) {
            return true;
        }
        System.out.println("Point, roll " + rolledNum + " to win! Reroll!");
        scanner.nextLine();
        pointCase = true;
        while (pointCase == true) {
            int _rolledNum = shoot(2, 6);
            if (_rolledNum == rolledNum) {
                System.out.println("You rolled point " + rolledNum + " again!");
                pointCase = false;
                return true;
            } else if (_rolledNum == 7) {
                System.out.println("You rolled " + _rolledNum);
                return false;
            }
            System.out.println("You rolled " + _rolledNum);
            System.out.println("Point, roll " + rolledNum + " to win! Reroll!");
            scanner.nextLine();
        }
        return false;
    }
}
