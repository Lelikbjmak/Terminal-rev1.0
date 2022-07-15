package proga;

public class NotEnoughLedger extends Exception{

    double order;

    public double getOrder() {
        return order;    // to get a summa of a person ho makes a transaction
    }

    public NotEnoughLedger(String message, double num){   // constructor for a new exception
    super(message);
    order = num;
    }
}
