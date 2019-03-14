import Domain.ReservationValidator;
import Repository.ReservationRepository;
import Service.ReservationService;
import UI.Console;

public class Main {


    public static void main(String[] args){
        ReservationValidator reservationValidator = new ReservationValidator();
        ReservationRepository reservationRepository = new ReservationRepository(reservationValidator);
        ReservationService reservationService = new ReservationService(reservationRepository);
        Console console = new Console(reservationService);
        console.run();
    }
}
