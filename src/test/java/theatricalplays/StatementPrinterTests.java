package theatricalplays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


import static org.approvaltests.Approvals.verify;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatementPrinterTests {
    //TESTS DONNÉS
    @Test
    void exampleStatement() {
        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance("hamlet", 55),
                new Performance("as-like", 35),
                new Performance("Othello", 40)
        ));

        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice);
        verify(result);
    }
        
    @Test
    void statementWithNewPlayTypes() {
        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance("henry-v", 53),
                new Performance("as-like", 55)));

        StatementPrinter statementPrinter = new StatementPrinter();
        Assertions.assertThrows(Error.class, () -> {
            statementPrinter.print(invoice);
        });
    }

    //TESTS AJOUTÉS
    //if (perf.audience > 30)
    @Test
    void statementForTragedyWithAudienceEqual30() {
        Invoice invoice = new Invoice("BigCo", List.of(
            new Performance("hamlet", 30)
        ));

        StatementPrinter statementPrinter = new StatementPrinter();
        String result = statementPrinter.print(invoice);
    
        assertTrue(result.contains("Statement for BigCo"));
        assertTrue(result.contains("Hamlet: $400.00 (30 seats)"));
        assertTrue(result.contains("Amount owed is $400.00"));
        assertTrue(result.contains("You earned 0 credits"));
    }

    //if (perf.audience > 20)
    @Test
    void statementForTragedyWithAudienceEqual20() {
        Invoice invoice = new Invoice("BigCo", List.of(
            new Performance("as-like", 20)
        ));

        StatementPrinter statementPrinter = new StatementPrinter();
        String result = statementPrinter.print(invoice);

        assertTrue(result.contains("Statement for BigCo"));
        assertTrue(result.contains("As You Like It: $360.00 (20 seats)")); 
        assertTrue(result.contains("Amount owed is $360.00")); 
        assertTrue(result.contains("You earned 4 credits")); 
    }

}








