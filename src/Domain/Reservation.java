package Domain;

public class Reservation {
    private int id, guestNo, roomNo, noOfDays;
    private String feedback;
    private double rating;
    private boolean roomIsBooked;

    public Reservation(int id, int guestNo, int roomNo, int noOfDays, boolean isBooked) {
        this.id = id;
        this.guestNo = guestNo;
        this.roomNo = roomNo;
        this.noOfDays = noOfDays;
        this.roomIsBooked = isBooked;
    }


    public Reservation(int id, int guestNo, int roomNo, int noOfDays, String feedback, double rating, boolean isBooked) {
        this.id = id;
        this.guestNo = guestNo;
        this.roomNo = roomNo;
        this.noOfDays = noOfDays;
        this.feedback = feedback;
        this.rating = rating;
        this.roomIsBooked = isBooked;
    }

    public int getId() {
        return id;
    }

    public int getGuestNo() {
        return guestNo;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public String getFeedback() {
        return feedback;
    }

    public double getRating() {
        return rating;
    }

    public boolean isBooked() {
        return roomIsBooked;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGuestNo(int guestNo) {
        this.guestNo = guestNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setBooked(boolean booked) {
        roomIsBooked = booked;
    }
}
