public class PaymentProcessor {

  public boolean process_payment(IncomingRequest incomingrequest, UserInfo userInfo) {

    if (incomingrequest.userName.equals(userInfo.getUsername()) && validateAddress(incomingrequest.billingAddress, userInfo.getAddress())) {
      try {
        submitPayment(incomingrequest.cardNumber, incomingrequest.amount);
        return true;
      } catch (Exception e) {
        e.printStackTrace();
        return false;
      }
    }
    return false;
  }

  public boolean validateAddress(String addressFromRequest, String addressFromDatabase) {
    boolean isValid = false;
    try {
      if (addressFromRequest.equals(addressFromDatabase)) {
        isValid = true;
      } else throw new Exception("Address from request not match address from database");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      return isValid;
    }
  }

  public void submitPayment(String card, int amount) {
    //Don't implement this.
  }
}