package Service;

import Domain.Reservation;
import Domain.RoomAverageRatingViewModel;
import Repository.ReservationRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationService {
    private ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    /**
     * Create a new check in
     *
     * @param id
     * @param guestNo
     * @param roomNo
     * @param noOfDays
     */
    public void checkin(int id, int guestNo, int roomNo, int noOfDays) {

        //we will make sure that the room is not already booked
        for (Reservation i : repository.getAll()) {
            if (i.getRoomNo() == roomNo && i.isBooked()) {
                throw new RuntimeException("The room is already booked!");
            }
        }
        Reservation reservation = new Reservation(id, guestNo, roomNo, noOfDays, true);
        repository.add(reservation);
    }

    /**
     * Create a new checkout
     *
     * @param roomNo
     * @param feedback
     * @param rating
     */
    public void checkout(int roomNo, String feedback, double rating) {

        //we will make sure that the room is booked
        for (Reservation i : repository.getAll()) {
            if (i.getRoomNo() == roomNo && i.isBooked()) {

                Reservation testReservation = new Reservation(i.getId(), i.getGuestNo(), i.getRoomNo(), i.getNoOfDays(), i.isBooked());
                testReservation.setBooked(false);
                testReservation.setFeedback(feedback);
                testReservation.setRating(rating);
                repository.update(testReservation);
                return;
            }
        }
        throw new RuntimeException("There is no room with the given number!");
    }

    /**
     * generate a room report - sorted by  average rating
     * @return
     */
    public List<RoomAverageRatingViewModel> getRoomsReport() {

        Map<Integer, List<Double>> roomGroups = new HashMap<>();
        for (Reservation i : repository.getAll()) {
            if (!i.isBooked()) {
                int roomNumber = i.getRoomNo();
                if (roomGroups.containsKey(roomNumber)) {
                    roomGroups.get(roomNumber).add(i.getRating());
                } else {
                    List<Double> firstRating = new ArrayList<>();
                    firstRating.add(i.getRating());
                    roomGroups.put(roomNumber, firstRating);
                }
            }
        }

        List<RoomAverageRatingViewModel> result = new ArrayList<>();
        for (Integer roomNumber : roomGroups.keySet()) {
            double average = 0;
            for (Double rating : roomGroups.get(roomNumber)) {
                average += rating;
            }
            average /= roomGroups.get(roomNumber).size();

            result.add(new RoomAverageRatingViewModel(roomNumber, average));
        }

        result.sort((v1, v2) -> v1.getAverageRating() > v2.getAverageRating() ? -1 : 0);
        return result;
    }
}




