package theatricalplays;

public class Performance {

  public String playID;
  public int audience;

  public Performance(String playID, int audience) {
    this.playID = playID; //id de la pièce de théâtre jouée.
    this.audience = audience; //nombre de spectateurs.
  }

  //getteur pour recuperer playID
  public String getPlayID(){
    return playID;
  }

  //recuperer le type de la piece de théâtre a partir de son id
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

  //recuperer le type de la piece de théâtre a partir de son id
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


}
