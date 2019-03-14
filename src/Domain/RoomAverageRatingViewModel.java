package Domain;

public class RoomAverageRatingViewModel {
    private int roomNo;
    private double averageRating;

    public RoomAverageRatingViewModel(int roomNo, double averageRating) {
        this.roomNo = roomNo;
        this.averageRating = averageRating;
    }

    @Override
    public String toString() {
        return "RoomAverageRatingViewModel{" +
                "roomNo=" + roomNo +
                ", averageRating=" + averageRating +
                '}';
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}

