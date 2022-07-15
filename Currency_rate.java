package proga;

public enum Currency_rate {

    USD_to_EURO(0.99),     // 1usd = 0.99 euro
    EURO_to_USD(1.038),    // same to previous but vice versa
    BYN_to_USD(2.65),   // sale
    USD_to_BYN(2.6),   // buy    FROM THE FACE OF BANK!
    BYN_to_EURO(2.72),  // sale
    EURO_to_BYN(2.61),  // buy
    BYN_to_RUB(4.45),    // on 100 rub   (sale)
    RUB_to_BYN(3.4);     // buy

    double rate;

    Currency_rate(double num){
        this.rate = num;
    }

}
