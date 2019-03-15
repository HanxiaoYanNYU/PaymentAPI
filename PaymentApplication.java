//package com.glassdoor.test.intern.first;

public class PaymentApplication {
  public static void main(String[] args) {
    IncomingRequest incomingRequest = new IncomingRequest();
    incomingRequest.userId = 1;
    incomingRequest.userName = "ABC";
    incomingRequest.billingAddress = "123 Some Street, City Name, ST";
    incomingRequest.amount = 1;
    boolean successfulPayment = new PaymentProcessor().process_payment(incomingRequest);
    System.out.println(successfulPayment);
  }
}