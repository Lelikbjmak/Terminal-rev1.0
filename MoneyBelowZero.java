package proga;

public class MoneyBelowZero extends Exception{

    private double pay;   // summa which we gonna to transit to the other identity(entity)

    public MoneyBelowZero(String message, double num){
        super(message);
        pay = num;
    }

    public double getPay() {
        return pay;
    }
}

