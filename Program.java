package proga;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

import java.util.ArrayList;


public class Program {

    public static void main(String [] args) throws MoneyBelowZero, NotEnoughLedger, IncorrectPasswordException, UserIsNotExistException{

        Scanner sc = new Scanner(System.in);

        ArrayList<Bill> Bills = new ArrayList<>();   //db for bills
        ArrayList<Transaction> Transactions = new ArrayList<>();  // db for transactions
       // HashMap<Object, String> coll = new HashMap<Object, String>();

        Map<Integer,Transaction> Ttrans = new HashMap<>();


        int count_bills = 0;

        System.out.print("Bills count: ");
        try {
            count_bills = Integer.parseInt(sc.nextLine().trim());
        }catch (NumberFormatException ex){
            System.out.println("Can't transform String into Integer. Invalid input!" + ex.getMessage());
        }
        if(count_bills == 0){
            System.out.println("Count of bills is " + count_bills + "Can't execute next task!");
        }

        for (int i = 0; i < count_bills; i++){
            Bill.add_bills(Bills, sc);
        }



        Transaction.add_transaction((HashMap<Integer, Transaction>) Ttrans,Transactions, Bills, sc);

       // Transactions.get(0).payment_info();
        for (var a: Ttrans.entrySet()) {
            Transaction tp = a.getValue();
            tp.payment_info();
        }

    }

}
