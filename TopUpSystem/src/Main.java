import java.util.Scanner;

public class Main {
    private static final double DIAMOND_RATE = 300.0;
    private static final double[] DIAMOND_PACKS = {50, 100, 250};
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Your  User ID: ");
        String userID = input.nextLine();
        User user = new User(userID);
    }
}