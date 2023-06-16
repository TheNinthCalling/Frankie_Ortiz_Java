package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        //Create an array of customers
        List<Customer> customers = new ArrayList<>();


        //Iterate through the list of customer records
        for(int i =0; i<customerData.size(); i++){
            int custID = Integer.parseInt(customerData.get(i)[0]);
            String custName = customerData.get(i)[1];
            int custCharge = Integer.parseInt(customerData.get(i)[2]);
            String custDate = customerData.get(i)[3];

            //Create a record
            AccountRecord accRec = new AccountRecord();
            accRec.setCharge(custCharge); //Charge
            accRec.setChargeDate(custDate); //Charge Date

            int j;
            for( j = 0; j<customers.size(); j++){
                //If customer already exists, simply add charge
                if(customers.get(j).getId() == custID){
                    customers.get(j).getCharges().add(accRec);
                    break;
                }
            }
            //Else, create a new cst
            if( j == customers.size()){
                Customer cust = new Customer();
                cust.setId(custID); //ID
                cust.setName(custName); //Name
                cust.getCharges().add(accRec); //Add account charge to customer

                customers.add(cust); //Add customer to list of customers
            }

        }

        //Print out Positive and Negative accounts
        ArrayList<Customer> posAcc = new ArrayList<Customer>();
        ArrayList<Customer> negAcc = new ArrayList<Customer>();

        for(int i = 0; i<customers.size(); i++){
            if(customers.get(i).getBalance() >= 0){
                posAcc.add(customers.get(i));
            }
            else{
                negAcc.add(customers.get(i));
            }
        }

        System.out.println("Positive accounts:" + posAcc);
        System.out.println("Negative accounts:" + negAcc);
    }
}
