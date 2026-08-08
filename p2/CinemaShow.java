public class CinemaShow {

    private String title;
    private int seatsAvailable;
    private final int capacity;

    private static int totalBooked = 0;

    CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    CinemaShow(String title) {
        this(title, 100);
    }

    boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable = seatsAvailable - n;
            totalBooked = totalBooked + n;
            return true;
        }

        return false;
    }

    void cancel(int n) {
        seatsAvailable = seatsAvailable + n;

        if (seatsAvailable > capacity)
            seatsAvailable = capacity;
    }

    int getSeatsAvailable() {
        return seatsAvailable;
    }

    static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {

        CinemaShow show = new CinemaShow("Avengers", 10);

        System.out.println(show.book(4));
        System.out.println("Seats: " + show.getSeatsAvailable());

        System.out.println(show.book(3));
        System.out.println("Seats: " + show.getSeatsAvailable());

        System.out.println(show.book(5));
        System.out.println("Seats: " + show.getSeatsAvailable());

        show.cancel(2);
        System.out.println("Seats after cancel: " + show.getSeatsAvailable());

        System.out.println("Total booked: " + CinemaShow.getTotalBooked());
    }
}