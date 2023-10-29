package theatricalplays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


import static org.approvaltests.Approvals.verify;

public class StatementPrinterTests {
    
    @Test
    void toTextTest() {
        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance("hamlet", 55),
                new Performance("as-like", 35),
                new Performance("Othello", 40)
        ));
        StatementPrinter statementPrinter = new StatementPrinter(invoice);
        var result = statementPrinter.toText();
        verify(result);
    }
        
    @Test
    void toTextTestWithNewPlayTypes() {
        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance("henry-v", 53),
                new Performance("as-like", 55)));

        StatementPrinter statementPrinter = new StatementPrinter(invoice);
        Assertions.assertThrows(Error.class, () -> {
            statementPrinter.toText();
        });
    }

    @Test
    void toTextTestForTragedyWithAudienceEqual30() {
        Invoice invoice = new Invoice("BigCo", List.of(
            new Performance("hamlet", 30)));

        StatementPrinter statementPrinter = new StatementPrinter(invoice);
        String result = statementPrinter.toText();
        verify(result);
    }

    @Test
    void toTextTestForTragedyWithAudienceEqual20() {
        Invoice invoice = new Invoice("BigCo", List.of(
            new Performance("as-like", 20)));

        StatementPrinter statementPrinter = new StatementPrinter(invoice);
        String result = statementPrinter.toText();
        verify(result);
    }

    @Test
    void toHTMLTest() {
        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance("hamlet", 55),
                new Performance("as-like", 35),
                new Performance("Othello", 40)));
        
        StatementPrinter statementPrinter = new StatementPrinter(invoice);
        String result = statementPrinter.toHTML();
        verify(result);
    }
    
}








