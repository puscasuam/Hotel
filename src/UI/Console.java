package UI;

import Domain.RoomAverageRatingViewModel;
import Service.ReservationService;


import java.util.List;
import java.util.Scanner;

public class Console {
    public ReservationService service;
    private Scanner in = new Scanner(System.in);

    public Console(ReservationService service) {
        this.service = service;
    }

    private void showMenu() {
        System.out.println();
        System.out.println("1. Check-in.");
        System.out.println("2. Check-out.");
        System.out.println("3. Show room report.");
        System.out.println("0. Exit.");
        System.out.print("Your option: ");
    }

    public void run() {

        while (true) {
            showMenu();

            int option = in.nextInt();
            if (option == 1) {
                handleCheckIn();
            } else if (option == 2) {
                handleCheckOut();
            } else if (option == 3) {
                handleReport();
            } else if (option == 0) {
                break;
            } else {
                System.out.println("Invalid option!");
            }
        }
    }

    private void handleCheckIn() {
        System.out.println();
        System.out.print("Enter id reservation: ");
        int id = in.nextInt();
        System.out.print("Enter the number of guests: ");
        int guestNo = in.nextInt();
        System.out.print("Enter the room number: ");
        int roomNo = in.nextInt();
        System.out.print("Enter the days of booking: ");
        int noOfDays = in.nextInt();

        try {
            service.checkin(id, guestNo, roomNo, noOfDays);
            System.out.println("Check-in is done!");
        } catch (RuntimeException rex) {
            System.out.println("We have errors:");
            System.out.println(rex.getMessage());
        }
    }

    private void handleCheckOut() {

        System.out.println();
        System.out.print("Enter the room number: ");
        int roomNo = in.nextInt();
        System.out.print("Leave feedback: ");
        in.nextLine();
        String feedback = in.nextLine();
        System.out.print("Rating: ");
        double rating = in.nextDouble();

        try {
            service.checkout(roomNo, feedback, rating);
            System.out.print("Check-out done!");
        } catch (RuntimeException rex) {
            System.out.println("We have errors:");
            System.out.println(rex.getMessage());

        }
    }

    private void handleReport() {
        List<RoomAverageRatingViewModel> standReports = service.getRoomsReport();
        for (RoomAverageRatingViewModel standReport : standReports) {
            System.out.println(String.format("%d %f", standReport.getRoomNo(), standReport.getAverageRating()));
        }
    }

}