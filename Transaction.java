package proga;


import java.io.FileInputStream;
import java.util.*;

public class Transaction {

    private double payment;   //summ of transaction
    private final int Transaction_id;   //№ of transaction

    Bill from;
    Bill to;

    public void setPayment(double payment) {
        this.payment = payment;
    }

    private void payment(Scanner sc) throws NotEnoughLedger, MoneyBelowZero, IncorrectPasswordException {

        //System.out.println("1st bill: " + from.getSumm() + "\t2nd bill: " + to.getSumm());

        System.out.println("\n#Order info#\n" + "Transaction id: " + Transaction_id +"\nSender: " + from.getName_surname() + "\nRecipient: " + to.getName_surname() + ",\tbill: " + to.bill);
        System.out.print("Summa to transfer: ");


        Double pay = null;

        boolean approval = true;  // to confirm the deal

        try {
            if(pay instanceof Double){
                approval = false;
                //pay = setPayment();  // summma which u gonna transfer
            }

            if (pay.doubleValue() < 0) {
                approval = false;
                throw new MoneyBelowZero("Incorrect data! Summa is negative! ", pay);
            }
        }catch (NullPointerException po){
            System.err.println(po.getMessage());
            System.err.println("Using of empty object!");
        }
        catch (NumberFormatException e) {
            System.err.println("Incorrect data unput!");
        } catch (MoneyBelowZero e) {
            System.out.println(e.getMessage());
        }
        catch (Exception ik){
            System.out.println(ik.getMessage());
        }

        double current_ledge_to = to.getSumm();   // current ledger of 2nd bill
        double current_ledge_from = from.getSumm();   // current ledger of 1st bill

        try {

            from.sentSumm(pay); // sent money from 1st bill

            if (pay > from.getSumm()) {   // if u don't have enough money to struck a deal
                approval = false;
                throw new NotEnoughLedger("Not enough money on your ledger!", pay);
            }
            String password;
            System.out.println("Confirm the transaction with your password.");
            try {
                password = sc.nextLine();
                if (!(password.equals(from.getPassword()))) {
                    approval = false;
                    throw new IncorrectPasswordException("Incorrect password!", password);
                }
            } catch (IncorrectPasswordException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (NotEnoughLedger ex) {
            System.out.println(ex.getMessage() + "Your ladger: " + current_ledge_from);
        } finally {
            System.out.println("Verification...");
            if (approval) {
                System.out.println("Successful!");
            } else {
                System.out.println("Deal isn't accomplished!");
            }
        }

        to.gainSumm(pay);   // to obtain money on the 2nd bill
        this.payment = pay;

//        System.out.print("Receive detailed information about transaction?");
//        String answer = sc.nextLine();
//        if(answer.equals("yes")){

        //}

        System.out.println("1st bill: " + "\nBefore: " + current_ledge_from + " After: " + from.getSumm() + "\n2nd bill: " + "\nBefore: " + current_ledge_to + " After: " + to.getSumm());

    }

    Transaction() {
        this.Transaction_id = (int) (Math.random() * (100000000 - 1000000)) + 1000000;

    }

    public double getPayment() {
        return payment;
    }

    public void payment_info() {
        System.out.println("\nTransaction: " + Transaction_id + "\nSender: " + from.getName_surname() + ", bill:" + from.getBill() + "\nRecipient: " + to.getName_surname() + ",bill: " + to.getBill() + "\nPayment: " + getPayment() + from.getCurrency());
    }

    public static void add_transaction(HashMap<Integer, Transaction> tr, ArrayList<Transaction> Transactions, ArrayList<Bill> Bills, Scanner sc) throws MoneyBelowZero, NotEnoughLedger, IncorrectPasswordException, UserIsNotExistException {

        Transaction temp = new Transaction();

        System.out.println("\n#Cash transfer#");
        System.out.print("Sender: ");
        String name_from = sc.nextLine();
        int index_from = -1;



        for (int i = 0; i < Bills.size(); i++) {
            if (name_from.trim().equals(Bills.get(i).getName_surname())) {
                index_from = i;
                break;
            }
        }

        try {
            if (index_from == -1) {
                throw new UserIsNotExistException("User is not found!");
            }
        } catch (UserIsNotExistException ex) {
            ex.getMessage();
        }

        System.out.printf("Ledger: %.2f %s\n", Bills.get(index_from).getSumm(), Bills.get(index_from).getCurrency());

        System.out.print("Recipient: ");
        String name_to = sc.nextLine();
        int index_to = -1;



        for (int i = 0; i < Bills.size(); i++) {
            if (name_to.equals(Bills.get(i).getName_surname())) {
                index_to = i;
                break;
            }
        }

        try {
            if (index_to == -1) {
                throw new UserIsNotExistException("User is not found!");
            }
        } catch (UserIsNotExistException ex) {
            ex.getMessage();
        }

        temp.from = Bills.get(index_from);
        temp.to = Bills.get(index_to);

        // Transaction temp = new Transaction();
        temp.payment(sc);

        Transactions.add(temp.Transaction_id,temp);
        tr.put(temp.Transaction_id, temp);

    }

    public static <t> void find_user(List bills){   // to find a user, who wanna to accomplish a transaction

    }


}