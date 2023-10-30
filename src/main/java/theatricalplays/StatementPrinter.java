package theatricalplays;

import java.text.NumberFormat;
import java.util.Locale;

public class StatementPrinter {
        private Invoice invoice;
        private int totalVolumeCredits;
        private double totalAmount;
        private NumberFormat frmt;
        private Customer customer;
       

        public StatementPrinter(Invoice invoice, Customer customer) {
                this.invoice = invoice;
                this.totalAmount = 0.0;
                this.totalVolumeCredits = 0;
                this.frmt = NumberFormat.getCurrencyInstance(Locale.US);
                this.customer=customer;
        }



        public String toText() {
                StringBuffer result = new StringBuffer();

                result.append(String.format("Statement for %s\n", customer.name));

                for (Performance perf : invoice.performances) {
                        Play play = perf.getPlay();
                        double thisAmount = play.calculateAmount(customer);

                        result.append( String.format("  %s: %s (%s seats)\n",play.name , frmt.format(thisAmount), perf.getAudience()));

                        totalAmount += thisAmount;
                        totalVolumeCredits += play.calculateVolumeCredits();
               
                }
                result.append(String.format("Amount owed is %s\n", frmt.format(totalAmount)));
                result.append(String.format("You earned %s credits\n", totalVolumeCredits));
                result.append(String.format("Your loyalty %s points\n", customer.getLoyaltyPoints()));



                return result.toString();
        }


        public String toHTML() {
                StringBuffer result = new StringBuffer(
                        "<!DOCTYPE html>\n<html>\n<style>\n" +
                        "table, th, td {\nborder: 1px solid black;\n}\n" +
                        "</style>\n<body>\n<h1>Invoice</h1>\n<ul>\n" +
                        "<li><strong>Client : </strong>" + customer.name + "</li>\n</ul>\n<table>\n" +
                        "<tr>\n<th>Piece</th>\n<th>Seats sold</th>\n<th>Price</th>\n</tr>\n"
                );


                for (Performance perf : invoice.performances) {
                        Play play = perf.getPlay();
                        double thisAmount = play.calculateAmount(customer);
                        totalAmount += thisAmount;
                        totalVolumeCredits += play.calculateVolumeCredits();
                        result.append("<tr>\n<td>" + play.name + "</td>\n" +
                        "<td>" + perf.getAudience() + "</td>\n" +
                        "<td>" + frmt.format(thisAmount) + "</td>\n</tr>\n");
                }

                result.append("<tr>\n<th colspan=\"2\" align=\"right\">Total owned:</th>\n" +
                "<td>" + frmt.format(totalAmount) + "</td>\n</tr>\n");
                result.append("<tr>\n<th colspan=\"2\" align=\"right\">Fidelity point earned:</th>\n" +
                "<td>" + totalVolumeCredits + "</td>\n</tr>\n");
                result.append("<tr>\n<th colspan=\"2\" align=\"right\">Your loyalty points:</th>\n" +
                "<td>" + customer.getLoyaltyPoints() + "</td>\n</tr>\n");
                result.append("</table>\n<p><i>Payment is required under 30 days. We can break your knees if you don't do so</i></p>\n</body>\n</html>");

                System.out.println(result.toString());

                return result.toString();
        }
}

