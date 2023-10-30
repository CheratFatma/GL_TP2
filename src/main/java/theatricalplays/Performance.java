package theatricalplays;

public class Performance {
  public String playID;
  public int audience;

  private Play play;


  public Performance(String playID, int audience,Play play) {
    this.playID = playID; 
    this.audience = audience; 
    this.play = play;
  }

  
  public Play getPlay(){
    return play;
  }
  
  public int getAudience(){
    return audience;
  }
 
}
