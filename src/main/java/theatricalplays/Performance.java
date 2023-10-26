package theatricalplays;

public class Performance {

  public static final String TRAGEDY = "tragedy";
  public static final String COMEDY = "comedy";
  public static final String HISTORY = "history";

  public String playID;
  public int audience;
  private String playType;

  public Performance(String playID, int audience) {
    this.playID = playID; //id de la pièce de théâtre jouée.
    this.audience = audience; //nombre de spectateurs.
    this.playType = getPlayTypeById(playID); // recuperer playType

    //contrôle sur le type de pièce à la création de l'objet
    if (this.playType == null) { 
      throw new IllegalArgumentException("Unknown play type for play ID: " + playID + "please add it if it is new");
    }
  }

  //Getteur pour récupérer playID
  public String getPlayID(){
    return playID;
  }

  //Getteur pour récupérer playType
  public String getPlayType(){
    return playType;
  }




  //Récupérer le type de la pièce de théâtre à partir de son Id
  public String getPlayTypeById(String playID) {
    switch (playID) {
      case "hamlet":
      case "Othello":
          return TRAGEDY;
      case "as-like":
          return COMEDY; 
      case "henry-v":
          return HISTORY;
      default:
          return null; 
    }
  }

  //Récupérer le type de la pièce de théâtre à partir de son Id
  public String getPlayNameById(String playID) {
    switch (playID) {
      case "hamlet":
          return "Hamlet";
      case "as-like":
          return "As You Like It"; 
      case "Othello" :
          return "Othello";
      case "henry-v":
          return "Henry V";
      default:
          return null; 
    }
  }

  //Montant cumulé
  public double calculateAmount(){
    
    double totalAmount = 0.0;//utiliser double

    switch (getPlayTypeById(playID)) {
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
    if (audience > 20) {
      totalAmount += 100.0 + 5.0 * (audience - 20);
    }
    totalAmount += 3.0 * audience;
    return totalAmount;
  }

  //Montant cumulé pour TRAGEDY
  private double calculateTragedyAmount() {
    double totalAmount;
    totalAmount = 400.0;
    if (audience > 30) {
      totalAmount += 10.0 * (audience - 30);
    }
    return totalAmount;
  }

  //CREDIT COMEDY
  private int calculateVolumeCreditsForComedy(int volumeCredits) {
    if ("comedy".equals(getPlayTypeById(playID))) volumeCredits +=(int) Math.floor(audience / 5);//utiliser cast pour obtenir un entier
    return volumeCredits;
  }

  //CREDIT TRAGEDY
  private int calculateVolumeCreditsForTragedy(int volumeCredits) {
    volumeCredits += Math.max(audience - 30, 0);
    return volumeCredits;
  }

  
  


}
