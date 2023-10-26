package theatricalplays;

public class Performance {

  public static final String TRAGEDY = "tragedy";
  public static final String COMEDY = "comedy";

  public String playID;
  public int audience;

  public Performance(String playID, int audience) {
    this.playID = playID; //id de la pièce de théâtre jouée.
    this.audience = audience; //nombre de spectateurs.
  }

  //Getteur pour récupérer playID
  public String getPlayID(){
    return playID;
  }

  //Récupérer le type de la pièce de théâtre à partir de son Id
  public String getPlayTypeById(String playID) {
    if ("hamlet".equals(playID) || "Othello".equals(playID)) {
        return "tragedy";
    } if ("as-like".equals(playID)) {
        return "comedy";
    } if ("as-like".equals(playID)) {
        return "pastoral";
    }
    else if ("henry-v".equals(playID)) {
        return "history";
    }
    else {
        throw new Error("unknown play id: " + playID + "please add it if it is new");
    }
  }

  //Récupérer le type de la pièce de théâtre à partir de son Id
  public String getPlayNameById(String playID) {
    if ("hamlet".equals(playID)) {
        return "Hamlet";
    }
    if ("as-like".equals(playID)) {
        return "As You Like It";
    } 
    if ("henry-v".equals(playID)) {
        return "Henry V";
    } 
    else if ("Othello".equals(playID)){
      return "Othello";
    }
    else {
        throw new Error("unknown play id: " + playID + "please add it if it is new");
    }
  }

  //Methode pour calculer le montant cumulé
  public double calculateAmount(){
    
    double totalAmount = 0;

    switch (getPlayTypeById(playID)) {
      case TRAGEDY:
        totalAmount = 40000;
        if (audience > 30) {
          totalAmount += 1000 * (audience - 30);
        }
        break;
      case COMEDY:
        totalAmount = 30000;
        if (audience > 20) {
          totalAmount += 10000 + 500 * (audience - 20);
        }
        totalAmount += 300 * audience;
        break;
      default:
        throw new Error("unknown type: ${playType}");
    }
    return totalAmount;
  }

  //Methode pour calculer les credits cumulés
  public int calculateVolumeCredits(){
    int volumeCredits = 0;
    volumeCredits += Math.max(audience - 30, 0); 
    if ("comedy".equals(getPlayTypeById(playID))) volumeCredits += Math.floor(audience / 5); 

    return volumeCredits;
  }


}
