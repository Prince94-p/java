import java.util.Scanner;

class TollBooth {
    record Vehicle(String number, String type) {}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = 0, bike = 0, car = 0, truck = 0;

        while (true) {
            System.out.print("Number: ");
            String number = sc.next();

            if (number.equals("done"))
                break;

            System.out.print("Type: ");
            String type = sc.next();

            Vehicle v = new Vehicle(number, type);

            int toll = switch (v.type()) {
                case "bike" -> { bike++; yield 20; }
                case "car" -> { car++; yield 50; }
                case "truck" -> { truck++; yield 150; }
                default -> 0;
            };

            total += toll;
        }

        System.out.println("Total toll: " + total);

        if (car >= bike && car >= truck)
            System.out.println("Most frequent: car");
        else if (bike >= truck)
            System.out.println("Most frequent: bike");
        else
            System.out.println("Most frequent: truck");
    }
}