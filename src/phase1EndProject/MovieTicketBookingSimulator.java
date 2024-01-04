package phase1EndProject;

import java.util.*;

class Movie {
    private String title;
    private String genre;
    private int durationMinutes;

    public Movie(String title, String genre, int durationMinutes) {
        this.title = title;
        this.genre = genre;
        this.durationMinutes = durationMinutes;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }
}

class Theatre {
    private Map<String, String> frontDeskCredentials;
    private Map<String, List<ShowTime>> moviesSchedule;

    public Theatre() {
        frontDeskCredentials = new HashMap<>();
        frontDeskCredentials.put("admin", "password");

        moviesSchedule = new HashMap<>();

        Movie movie1 = new Movie("Inception", "Sci-Fi", 150);
        Movie movie2 = new Movie("The Dark Knight", "Action", 152);

        List<ShowTime> showTimes1 = Arrays.asList(
                new ShowTime("2024-01-04_15:00", "2024-01-04", "15:00", 5),
                new ShowTime("2024-01-04_18:00", "2024-01-04", "18:00", 5)
        );

        List<ShowTime> showTimes2 = Arrays.asList(
                new ShowTime("2024-01-04_16:30", "2024-01-04", "16:30", 7),
                new ShowTime("2024-01-04_20:00", "2024-01-04", "20:00", 7)
        );

        moviesSchedule.put(movie1.getTitle(), showTimes1);
        moviesSchedule.put(movie2.getTitle(), showTimes2);
    }

    public boolean login(String username, String password) {
        return frontDeskCredentials.containsKey(username) && frontDeskCredentials.get(username).equals(password);
    }

    public void updatePassword(String username, String newPassword) {
        if (frontDeskCredentials.containsKey(username)) {
            frontDeskCredentials.put(username, newPassword);
            System.out.println("Password updated successfully.");
        } else {
            System.out.println("Invalid username.");
        }
    }

    public void listMovies() {
        System.out.println("\nAvailable Movies:");
        for (String movieTitle : moviesSchedule.keySet()) {
            System.out.println("- " + movieTitle);
        }
    }

    public void viewMovieSchedule(String movieTitle) {
        if (moviesSchedule.containsKey(movieTitle)) {
            List<ShowTime> showTimes = moviesSchedule.get(movieTitle);

            System.out.println("\nShowtimes for " + movieTitle + ":");
            for (ShowTime showTime : showTimes) {
                System.out.println(showTime);
            }
        } else {
            System.out.println("Invalid movie title.");
        }
    }

    public void bookTicket(String movieTitle, String showTime, List<String> seatNumbers) {
        if (moviesSchedule.containsKey(movieTitle)) {
            List<ShowTime> showTimes = moviesSchedule.get(movieTitle);

            for (ShowTime scheduledShowTime : showTimes) {
                if (scheduledShowTime.getShowTime().equals(showTime)) {
                    scheduledShowTime.bookTicket(seatNumbers);
                    return;
                }
            }

            System.out.println("Invalid show time.");
        } else {
            System.out.println("Invalid movie title.");
        }
    }

    public void checkBookingStatus(String movieTitle, String showTime) {
        if (moviesSchedule.containsKey(movieTitle)) {
            List<ShowTime> showTimes = moviesSchedule.get(movieTitle);

            for (ShowTime scheduledShowTime : showTimes) {
                if (scheduledShowTime.getShowTime().equals(showTime)) {
                    scheduledShowTime.displayBookingStatus();
                    return;
                }
            }

            System.out.println("Invalid show time.");
        } else {
            System.out.println("Invalid movie title.");
        }
    }
}
class Seat {
    private String seatNumber;
    private boolean isBooked;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookSeat() {
        this.isBooked = true;
    }

    @Override
    public String toString() {
        return seatNumber + (isBooked ? " (Booked)" : " (Available)");
    }
}


public class MovieTicketBookingSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Theatre theatre = new Theatre();

        // Front desk login
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (theatre.login(username, password)) {
            System.out.println("Login successful.");

            while (true) {
                System.out.println("\n1. Update Password\n2. List Movies\n3. View Movie Schedule\n4. Book Ticket\n5. Check Booking Status\n6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter new password: ");
                        String newPassword = scanner.next();
                        theatre.updatePassword(username, newPassword);
                        break;
                    case 2:
                        theatre.listMovies();
                        break;
                    case 3:
                        System.out.print("Enter movie title: ");
                        String movieTitle = scanner.next();
                        theatre.viewMovieSchedule(movieTitle);
                        break;
                    case 4:
                        System.out.print("Enter movie title: ");
                        String bookMovieTitle = scanner.next();
                        System.out.print("Enter show time (e.g., 2024-01-04_18:00): ");
                        String bookShowTime = scanner.next();
                        System.out.print("Enter seat numbers (comma-separated): ");
                        String seatNumbersInput = scanner.next();
                        List<String> seatNumbers = Arrays.asList(seatNumbersInput.split(","));
                        theatre.bookTicket(bookMovieTitle, bookShowTime, seatNumbers);
                        break;
                    case 5:
                        System.out.print("Enter movie title: ");
                        String statusMovieTitle = scanner.next();
                        System.out.print("Enter show time (e.g., 2024-01-04_18:00): ");
                        String statusShowTime = scanner.next();
                        theatre.checkBookingStatus(statusMovieTitle, statusShowTime);
                        break;
                    case 6:
                        System.out.println("Exiting the application. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid credentials. Exiting the application.");
        }
    }
}

class ShowTime {
    private String showTime;
    private String date;
    private String time;
    private List<Seat> seats;

    public ShowTime(String showTime, String date, String time, int numSeats) {
        this.showTime = showTime;
        this.date = date;
        this.time = time;
        this.seats = new ArrayList<>();

        for (int i = 1; i <= numSeats; i++) {
            seats.add(new Seat("B" + i));
        }
    }

    public String getShowTime() {
        return showTime;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void bookTicket(List<String> seatNumbers) {
        for (String seatNumber : seatNumbers) {
            Seat seat = seats.stream()
                    .filter(s -> s.getSeatNumber().equals(seatNumber) && !s.isBooked())
                    .findFirst()
                    .orElse(null);

            if (seat != null) {
                seat.bookSeat();
            } else {
                System.out.println("Invalid seat number or seat already booked: " + seatNumber);
                return;
            }
        }

        System.out.println("Ticket booked successfully for " + showTime + ".");
    }

    public void displayBookingStatus() {
        System.out.println("Booking Status for " + date + " " + time + ":");
        for (Seat seat : seats) {
            System.out.println(seat);
        }
    }
}