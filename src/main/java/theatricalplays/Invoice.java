package theatricalplays;

import java.util.List;

public class Invoice { //Facture

  public String customer; 
  public List<Performance> performances; 

  public Invoice(String customer, List<Performance> performances) {
    this.customer = customer; //les informations du client (nom+id)
    this.performances = performances; //liste des représentations associées à la facture.
  }

}
