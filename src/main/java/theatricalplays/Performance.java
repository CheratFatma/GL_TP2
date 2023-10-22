package theatricalplays;

public class Performance {

  public String playID;
  public int audience;

  public Performance(String playID, int audience) {
    this.playID = playID; //id de la pièce de théâtre jouée.
    this.audience = audience; //nombre de spectateurs.
  }
}
