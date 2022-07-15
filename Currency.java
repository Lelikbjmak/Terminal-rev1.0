package proga;

public enum Currency {

    USD("$"),
    EURO("€"),
    BYN("BYN"),
    RUB("RUB");

    String currency;
    Currency(String a){
        this.currency = a;
    }
}

