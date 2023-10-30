package theatricalplays;

public abstract class Play {

  protected String name;
  protected String type;
  public int audience;
  public Performance performance;

  public static final String COMEDY = "comedy";
  public static final String TRAGEDY = "tragedy";
  
  public Play(String name, String type,Performance performance) {
    this.name = name; 
    this.type = type; 
    this.performance = performance; 
  }
  
  public abstract double calculateAmount(Customer customer);
  public abstract int calculateVolumeCredits();

  
}





















