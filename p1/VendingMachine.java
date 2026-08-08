import java.util.Scanner;

class VendingMachine {
    enum Coin { ONE, TWO, FIVE, TEN }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = 0;

        while (total < 15) {
            System.out.print("Enter coin: ");
            Coin c = Coin.valueOf(sc.next().toUpperCase());

            int value = switch (c) {
                case ONE -> 1;
                case TWO -> 2;
                case FIVE -> 5;
                case TEN -> 10;
            };

            total += value;
            System.out.println("Total: " + total);
        }

        System.out.println("Paid. Change: " + (total - 15));
    }
}