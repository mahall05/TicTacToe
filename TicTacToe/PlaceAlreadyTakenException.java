public class PlaceAlreadyTakenException extends Exception{
    public PlaceAlreadyTakenException(String errorMessage){
        super(errorMessage);
    }
}
