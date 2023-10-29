package theatricalplays;

public class Play {


  protected String name;
  protected String type;
  public int audience;

  public static final String TRAGEDY = "tragedy";
  public static final String COMEDY = "comedy";

  public Play(String name, String type) {
    this.name = name; 
    this.type = type; 
    this.audience = getAudience(); 
  }
  
  public int getAudience(){
     switch (name) {
      case "Hamlet":
          if (audience==55){return 55;}
          if (audience==30) {return 30;}
      case "As You Like It":
          if (audience==35){return 35;}
          if (audience==20){return 20;}
      case "Othello":
          return 40;
      case "Henry V":
          return 53;
      default:
          return 0; 
    }

  }

  //Montant cumulé
  public double calculateAmount(){
    
    double totalAmount = 0.0;//utiliser double

    switch (type) {
      case TRAGEDY:
        totalAmount = calculateTragedyAmount();
        break;
      case COMEDY:
        totalAmount = calculateComedyAmount();
        break;
      default:
        throw new Error("unknown type: ${playType}");
    }
    return totalAmount;
  }

  //Crédits cumulés
  public int calculateVolumeCredits(){
    int volumeCredits = 0;
    volumeCredits = calculateVolumeCreditsForTragedy(volumeCredits); 
    volumeCredits = calculateVolumeCreditsForComedy(volumeCredits); 

    return volumeCredits;
  }

  //Montant cumulé pour COMEDY
  private double calculateComedyAmount() {
    double totalAmount;
    totalAmount = 300.0;
    if (getAudience() > 20) {
      totalAmount += 100.0 + 5.0 * (getAudience() - 20);
    }
    totalAmount += 3.0 * getAudience();
    return totalAmount;
  }

  //Montant cumulé pour TRAGEDY
  private double calculateTragedyAmount() {
    double totalAmount;
    totalAmount = 400.0;
    if (getAudience() > 30) {
      totalAmount += 10.0 * (getAudience() - 30);
    }
    return totalAmount;
  }

  //Crédits cumulés pour Comedy
  private int calculateVolumeCreditsForComedy(int volumeCredits) {
    if ("comedy".equals(type)) volumeCredits +=(int) Math.floor(getAudience() / 5);
    return volumeCredits;
  }

  //Crédits cumulés pour Tragedy
  private int calculateVolumeCreditsForTragedy(int volumeCredits) {
    volumeCredits += Math.max(getAudience() - 30, 0);
    return volumeCredits;
  }

}





















