package proga;

import java.util.ArrayList;
import java.util.Scanner;

public class Bill <t>{ // with generics

    t bill;
    private final String id;
    private double summ;
    final String name_surname;

    private final Currency currency;
    private final String password;

    private
    Bill(String id, t bill, String name, String password, Currency currency){

        this.bill = bill;
        this.id = id;
        this.name_surname = name;
        this.summ = Math.random()*(1000-10) + 10;   // [10;1000)
        this.password = password;
        this.currency = currency;
    }

    public void gainSumm(double summ) {
        this.summ += summ;
    }

    public double getSumm() {
        return summ;
    }

    public void sentSumm(double summ) {
        this.summ -= summ;
    }

    public String getName_surname() {
        return name_surname;
    }

    public t getBill() {
        return bill;
    }

    public String getPassword() {
        return password;
    }

    public String getCurrency() {
        return currency.currency;
    }

    public static void add_bills(ArrayList<Bill> Bills, Scanner sc){

        System.out.print("Name, Surname: ");
        String name = sc.nextLine();

        System.out.print("Bill: ");
        String bill = sc.nextLine();

        System.out.print("ID: ");
        String ID = sc.nextLine();

        System.out.print("Currency: ");
        String curr = sc.nextLine();
        Currency currency1 = Currency.valueOf(curr);

        System.out.print("Create a password to confirm transactions: ");
        String password = sc.nextLine();

        Bills.add(new Bill<>(ID, bill, name, password, currency1));

        System.out.println("----------------");

    }

}
