package theatricalplays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


import static org.approvaltests.Approvals.verify;

public class StatementPrinterTests {


    Performance p1 = new Performance("hamlet", 55,null);
    Performance p2 = new Performance("as-like", 35,null);
    Performance p3 = new Performance("Othello", 40,null);
    Performance p4 = new Performance("henry-v", 53,null);

    Performance p5 = new Performance("hamlet", 30,null);
    Performance p6 = new Performance("as-like", 20,null);



    Play HamletPlay = new Play("Hamlet","tragedy",p1);
    Play AsYouLikeItPlay = new Play("As You Like It","comedy",p2);
    Play OthelloPlay = new Play("Othello","tragedy",p3);
    Play HenryVPlay = new Play("Henry V","history",p4);

    Play HamletPlay30 = new Play("Hamlet","tragedy",p5);
    Play AsYouLikeItPlay20 = new Play("As You Like It","comedy",p6);



    @Test
    void toTextTest() {
       
        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance("hamlet", 55,HamletPlay),
                new Performance("as-like", 35,AsYouLikeItPlay),
                new Performance("Othello", 40,OthelloPlay)
        ));
        StatementPrinter statementPrinter = new StatementPrinter(invoice);
        var result = statementPrinter.toText();
        verify(result);
    }
     
    @Test
    void toTextTestWithNewPlayTypes() {
        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance("henry-v", 53,HenryVPlay),
                new Performance("as-like", 55,AsYouLikeItPlay)));

        StatementPrinter statementPrinter = new StatementPrinter(invoice);
        Assertions.assertThrows(Error.class, () -> {
            statementPrinter.toText();
        });
    }

    @Test
    void toTextTestForTragedyWithAudienceEqual30() {
        Invoice invoice = new Invoice("BigCo", List.of(
            new Performance("hamlet", 30,HamletPlay30)));

        StatementPrinter statementPrinter = new StatementPrinter(invoice);
        String result = statementPrinter.toText();
        verify(result);
    }

    @Test
    void toTextTestForTragedyWithAudienceEqual20() {
        Invoice invoice = new Invoice("BigCo", List.of(
            new Performance("as-like", 20,AsYouLikeItPlay20)));

        StatementPrinter statementPrinter = new StatementPrinter(invoice);
        String result = statementPrinter.toText();
        verify(result);
    }


   



    @Test
    void toHTMLTest() {
        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance("hamlet", 55,HamletPlay),
                new Performance("as-like", 35,AsYouLikeItPlay),
                new Performance("Othello", 40,OthelloPlay)));
       
        StatementPrinter statementPrinter = new StatementPrinter(invoice);
        String result = statementPrinter.toHTML();
        verify(result);
    }
}
 
/* 
 @Test
    void toHTMLTest2() {
        Invoice invoice = new Invoice("BigCo", List.of(
            new Performance("hamlet", 55),
            new Performance("as-like", 35),
            new Performance("Othello", 40),
            new Performance("henry-v", 53),
            new Performance("hamlet", 30),
            new Performance("as-like", 20)       
        ));
        
        StatementPrinter statementPrinter = new StatementPrinter(invoice);
        String result = statementPrinter.toHTML();
        verify(result);
    }
} */