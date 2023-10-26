package theatricalplays;

import java.text.NumberFormat;
import java.util.Locale;

public class StatementPrinter {
 
  public String print(Invoice invoice) { 
    double totalAmount = 0.0;//utiliser double
    int totalVolumeCredits = 0;
    StringBuffer result = new StringBuffer();

    NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);
    result.append(String.format("Statement for %s\n", invoice.customer));

    for (Performance perf : invoice.performances) {
        double thisAmount = perf.calculateAmount();

        result.append( String.format("  %s: %s (%s seats)\n", perf.getPlayNameById(perf.getPlayID()), frmt.format(thisAmount / 100), perf.audience));

        totalAmount += thisAmount;
        totalVolumeCredits += perf.calculateVolumeCredits();
    }
        result.append(String.format("Amount owed is %s\n", frmt.format(totalAmount / 100)));
        result.append(String.format("You earned %s credits\n", totalVolumeCredits));

        return result.toString();
  }   
}



