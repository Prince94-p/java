import java.util.Scanner;
import java.util.Random;

public class RPSLS {

    enum Move {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK
    }

    static int winner(Move a, Move b) {

        if (a == b)
            return 0;

        switch (a) {
            case ROCK:
                if (b == Move.SCISSORS || b == Move.LIZARD)
                    return 1;
                break;

            case PAPER:
                if (b == Move.ROCK || b == Move.SPOCK)
                    return 1;
                break;

            case SCISSORS:
                if (b == Move.PAPER || b == Move.LIZARD)
                    return 1;
                break;

            case LIZARD:
                if (b == Move.SPOCK || b == Move.PAPER)
                    return 1;
                break;

            case SPOCK:
                if (b == Move.ROCK || b == Move.SCISSORS)
                    return 1;
                break;
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int you = 0;
        int computer = 0;

        Move[] moves = Move.values();

        for (int i = 1; i <= 5; i++) {

            System.out.println("1. ROCK");
            System.out.println("2. PAPER");
            System.out.println("3. SCISSORS");
            System.out.println("4. LIZARD");
            System.out.println("5. SPOCK");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            Move player = moves[choice - 1];
            Move comp = moves[r.nextInt(5)];

            System.out.println("You: " + player);
            System.out.println("Computer: " + comp);

            int result = winner(player, comp);

            if (result == 1) {
                System.out.println("You win this round");
                you++;
            }
            else if (result == -1) {
                System.out.println("Computer wins this round");
                computer++;
            }
            else {
                System.out.println("Tie");
            }

            System.out.println();
        }

        System.out.println("Score: You " + you + "-" + computer);

        if (you > computer)
            System.out.println("You win " + you + "-" + computer);
        else if (computer > you)
            System.out.println("Computer wins " + computer + "-" + you);
        else
            System.out.println("Tie");
    }
}