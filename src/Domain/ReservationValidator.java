package Domain;

public class ReservationValidator {

    /**
     * Validates the room, the number of booking days, the guest number, the feedback and the rating
     *
     * @param reservation Raises RuntimeException if there are validation errors
     */
    public void validateCheckIn(Reservation reservation) {
        if (reservation.getNoOfDays() <= 0) {
            throw new RuntimeException("A room must be booked for at last one day");
        }

        if (reservation.getRoomNo() <= 0) {
            throw new RuntimeException("This is an invalid room number");
        }

        if (reservation.getGuestNo() <= 0) {
            throw new RuntimeException("We need at least one guest per reservation");
        }
    }

    public void validateCheckOut(Reservation reservation) {
        if (reservation.getFeedback() == null || reservation.getFeedback().isEmpty()) {
            throw new RuntimeException("Feedback should be given");
        }

        if (reservation.getRating() < 1 || reservation.getRating() > 5) {
            throw new RuntimeException("The rating should be between 1 and 5");
        }
    }

}
