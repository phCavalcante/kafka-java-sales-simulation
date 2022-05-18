package util;

/**
 * @author pablo.cavalcante - pablohenriq100@gmail.com
 * @date 07/11/2021 08:45
 */

public class MailSenderSimulator {

  public static void send(String email) {
    if (email == null) {
      System.out.println("Sending ticket sales confirmation email...");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Sending confirmation email sent!");
      return;
    }
  }
}
