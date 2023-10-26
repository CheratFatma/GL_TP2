package theatricalplays;

import java.text.NumberFormat;
import java.util.Locale;

public class StatementPrinter {

  public String print(Invoice invoice) { 
    int totalAmount = 0;
    int volumeCredits = 0;
    StringBuffer result = new StringBuffer();
     result.append( String.format("Statement for %s\n", invoice.customer));

    NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

    for (Performance perf : invoice.performances) {

      String playID = perf.getPlayID(); //id
      String playType = perf.getPlayTypeById(playID);//type
      String playName = perf.getPlayNameById(playID);//nom
      int thisAmount = 0;

      switch (playType) {
        case "tragedy":
          thisAmount = 40000;
          if (perf.audience > 30) {
            thisAmount += 1000 * (perf.audience - 30);
          }
          break;
        case "comedy":
          thisAmount = 30000;
          if (perf.audience > 20) {
            thisAmount += 10000 + 500 * (perf.audience - 20);
          }
          thisAmount += 300 * perf.audience;
          break;
        default:
          throw new Error("unknown type: ${playType}");
      }

      // add volume credits
      volumeCredits += Math.max(perf.audience - 30, 0); 
      // add extra credit for every ten comedy attendees
      if ("comedy".equals(playType)) volumeCredits += Math.floor(perf.audience / 5); 

      // print line for this order
      result.append( String.format("  %s: %s (%s seats)\n", playName, frmt.format(thisAmount / 100), perf.audience));
      totalAmount += thisAmount;
    }
    result.append( String.format("Amount owed is %s\n", frmt.format(totalAmount / 100)));
    result.append (String.format("You earned %s credits\n", volumeCredits));
    return result.toString();
  }


}
