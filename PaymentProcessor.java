//package com.glassdoor.test.intern.first;

public class PaymentProcessor {

  public boolean process_payment(IncomingRequest incomingrequest) {
    UserDatabase userDatabase = new UserDatabase();
    if (userDatabase.userNames.containsKey(incomingrequest.userId)) {
      if (incomingrequest.userName.equals(userDatabase.userNames.get(incomingrequest.userId))
          && validateAddress(incomingrequest.billingAddress, userDatabase.addresses.get(incomingrequest.userId))) {
        try {
          submitPayment(incomingrequest.cardnumber, incomingrequest.amount);
          return true;
        } catch (Exception e) {
          return false;
        }
      }
    }
    return false;
  }

  public boolean validateAddress(String addressFromRequest, String addressFromDatabase) {
    if (addressFromRequest.equals(addressFromDatabase)) {
      return true;
    } else {
      return false;
    }
  }

  public void submitPayment(String card, int amount) {
    //Don't implement this.
  }
}