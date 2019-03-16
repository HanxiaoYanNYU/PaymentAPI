public class PaymentApplication {

  private static AbstractDatabase DATABASE;
  private static PaymentProcessor PAYMENT_PROCESSOR;

  public PaymentApplication(AbstractDatabase database, PaymentProcessor paymentProcessor) {
    this.DATABASE = database;
    this.PAYMENT_PROCESSOR = paymentProcessor;
  }

  private IncomingRequest generateRequest(int userid, String userName, String billingAddress, int amount, String cardNumber) {
    IncomingRequest request = new IncomingRequest();
    request.userId = userid;
    request.userName = userName;
    request.billingAddress = billingAddress;
    request.amount = amount;
    request.cardNumber = cardNumber;
    return request;
  }

  private boolean pay(IncomingRequest request, UserInfo userInfo) {
    if (userInfo == null) return false;
    return PAYMENT_PROCESSOR.process_payment(request, userInfo);
  }

  private void execute(PaymentApplication app) {
    Runnable task1 = () -> {
      IncomingRequest request1 = app.generateRequest(1, "ABC", "123 Some Street, City Name, ST", 1, "111");
      boolean res1 = app.pay(request1, DATABASE.getUserInfo(request1.userId));
      System.out.println(res1);
    };

    Runnable task2 = () -> {
      IncomingRequest request2 = app.generateRequest(2, "XYZ", "456 Other Street, Cool City, SS", 1, "222");
      boolean res2 = app.pay(request2, DATABASE.getUserInfo(request2.userId));
      System.out.println(res2);
    };

    new Thread(task1).start();
    new Thread(task2).start();
  }

  public static void main(String[] args) {
    UserDatabase database = new UserDatabase();
    database.setup("user_database.txt");
    PaymentApplication app = new PaymentApplication(database, new PaymentProcessor());
    app.execute(app);
  }
}