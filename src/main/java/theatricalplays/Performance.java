package theatricalplays;

public class Performance {

  public static final String TRAGEDY = "tragedy";
  public static final String COMEDY = "comedy";
  public static final String HISTORY = "history";

  public String playID;
  public int audience;

  private Play play;


  public Performance(String playID, int audience, Play play) {
    this.playID = playID; 
    this.audience = audience; 
    this.play = play;
  }

  
  public Play getPlay(){
    return play;
  }
}
