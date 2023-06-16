package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    public Customer cust;
    @BeforeEach
    public void setUp(){cust = new Customer();}


    @Test
    void getPosBalance() {
        for(int i = 1; i< 4; i++){
            AccountRecord accRec = new AccountRecord();
            accRec.setCharge(i * 10000);
            cust.getCharges().add(accRec);
        }
        assertEquals(60000, cust.getBalance());
    }
    @Test
    void getNegBalance(){
        for(int i=1; i<3; i++){
            AccountRecord accRec = new AccountRecord();
            accRec.setCharge(i * -10000);
            cust.getCharges().add(accRec);
        }
        assertEquals(-30000, cust.getBalance());
    }


    @Test
    void testToString() {
        Customer cust2 = new Customer();
        cust2.setId(5);
        cust2.setName("Bob");

        AccountRecord accountRec = new AccountRecord();
        accountRec.setCharge(10000);
        AccountRecord accountRec2 = new AccountRecord();
        accountRec2.setCharge(-5000);
        cust2.getCharges().add(accountRec2);
        cust2.getCharges().add(accountRec);

        assertEquals("{5, Bob, 5000}", cust2.toString());


    }
}