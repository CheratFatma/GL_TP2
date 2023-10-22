package theatricalplays;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

  //print : une déclaration basé sur les données de la facture et des pièces de théâtre associées.
  public String print(Invoice invoice, Map<String, Play> plays) { //methode d'affichage (facture + ids de pièces associes aux "type et nom" de la pièce)
    int totalAmount = 0;
    int volumeCredits = 0;
    StringBuffer result = new StringBuffer();
     result.append( String.format("Statement for %s\n", invoice.customer));

    NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);//convertir en $

    for (Performance perf : invoice.performances) {
      Play play = plays.get(perf.playID);
      int thisAmount = 0;



      //En fonction du type (tragedy ou comedy), la méthode calcule le coût de la performance.
      //construit le relevé sous forme d'une chaîne de caractères 
      //inclut le montant total dû + le nombre de crédits gagnés sur chaque performance,
      switch (play.type) {
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
          throw new Error("unknown type: ${play.type}");
      }

      // add volume credits
      volumeCredits += Math.max(perf.audience - 30, 0); //nombre de credit gagnes pour tragedy
      // add extra credit for every ten comedy attendees
      if ("comedy".equals(play.type)) volumeCredits += Math.floor(perf.audience / 5); //nombre de credit gagne pour comedy

      // print line for this order
      result.append( String.format("  %s: %s (%s seats)\n", play.name, frmt.format(thisAmount / 100), perf.audience));
      totalAmount += thisAmount;
    }
    result.append( String.format("Amount owed is %s\n", frmt.format(totalAmount / 100)));
    result.append (String.format("You earned %s credits\n", volumeCredits));
    return result.toString();
  }

}
