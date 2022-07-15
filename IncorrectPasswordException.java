package proga;

public class IncorrectPasswordException extends Exception{

    String password;

    public IncorrectPasswordException(String message, String password){
        super(message);
        this.password = password;
    }

}
