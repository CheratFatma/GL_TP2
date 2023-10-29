package theatricalplays;

import java.text.NumberFormat;
import java.util.Locale;

public class StatementPrinter {
        private Invoice invoice;
        private int totalVolumeCredits;
        private double totalAmount;
        private NumberFormat frmt;

        public StatementPrinter(Invoice invoice) {
                this.invoice = invoice;
                this.totalAmount = 0.0;
                this.totalVolumeCredits = 0;
                this.frmt = NumberFormat.getCurrencyInstance(Locale.US);
        }
        

        public String toText() { 
                StringBuffer result = new StringBuffer();

                result.append(String.format("Statement for %s\n", invoice.customer));

                for (Performance perf : invoice.performances) {
                        double thisAmount = perf.calculateAmount();

                        result.append( String.format("  %s: %s (%s seats)\n", perf.getPlayNameById(perf.getPlayID()), frmt.format(thisAmount), perf.audience));

                        totalAmount += thisAmount;
                        totalVolumeCredits += perf.calculateVolumeCredits();
                }
                result.append(String.format("Amount owed is %s\n", frmt.format(totalAmount)));
                result.append(String.format("You earned %s credits\n", totalVolumeCredits));

                return result.toString();
        }


        public String toHTML() {
                StringBuffer result = new StringBuffer(
                        "<!DOCTYPE html>\n<html>\n<style>\n" +
                        "table, th, td {\nborder: 1px solid black;\n}\n" +
                        "</style>\n<body>\n<h1>Invoice</h1>\n<ul>\n" +
                        "<li><strong>Client : </strong>" + invoice.customer + "</li>\n</ul>\n<table>\n" +
                        "<tr>\n<th>Piece</th>\n<th>Seats sold</th>\n<th>Price</th>\n</tr>\n"
                );

                for (Performance perf : invoice.performances) {
                        double thisAmount = perf.calculateAmount();
                        totalAmount += thisAmount;
                        totalVolumeCredits += perf.calculateVolumeCredits();
                        result.append("<tr>\n<td>" + perf.getPlayNameById(perf.getPlayID()) + "</td>\n" +
                        "<td>" + perf.audience + "</td>\n" +
                        "<td>" + frmt.format(thisAmount) + "</td>\n</tr>\n");
                }

                result.append("<tr>\n<th colspan=\"2\" align=\"right\">Total owned:</th>\n" +
                "<td>" + frmt.format(totalAmount) + "</td>\n</tr>\n");
                result.append("<tr>\n<th colspan=\"2\" align=\"right\">Fidelity point earned:</th>\n" +
                "<td>" + totalVolumeCredits + "</td>\n</tr>\n");
                result.append("</table>\n<p><i>Payment is required under 30 days. We can break your knees if you don't do so</i></p>\n</body>\n</html>");

                return result.toString();
        }
}
