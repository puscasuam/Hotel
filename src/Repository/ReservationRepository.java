package Repository;

import Domain.Reservation;
import Domain.ReservationValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationRepository {

    private Map<Integer, Reservation> storage = new HashMap<>();
    private ReservationValidator validator;

    /**
     * Instantiates a repository for reservation
     *
     * @param validator
     */
    public ReservationRepository(ReservationValidator validator) {
        this.validator = validator;
    }


    /**
     * Add a new reservation, if id reservation doesn't exist
     *
     * @param reservation
     */
    public void add(Reservation reservation) {
        if (storage.containsKey(reservation.getId())) {
            throw new RuntimeException("A reservation with this id already exists!");
        }
        validator.validateCheckIn(reservation);
        storage.put(reservation.getId(), reservation);
    }


    /**
     * Update an existing reservation
     *
     * @param reservation
     */
    public void update(Reservation reservation) {
        if (!storage.containsKey(reservation.getId())) {
            throw new RuntimeException("\"There is no reservation with id=%s\", reservation.getId())");
        }

        //validator.validateCheckIn(reservation);
        validator.validateCheckOut(reservation);
        storage.put(reservation.getId(), reservation);
    }

    /**
     * Delete a reservation with a specific id
     *
     * @param id
     */
    public void remove(int id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("\"There is no reservation with id=%s\", reservation.getId())");
        }
        storage.remove(id);
    }

    /**
     * Get a list with all reservations
     *
     * @return
     */
    public List<Reservation> getAll() {
        return new ArrayList<>(storage.values());
    }

}
