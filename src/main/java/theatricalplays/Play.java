package theatricalplays;

public class Play {

  protected String name;
  protected String type;
  public int audience;
  public Performance performance;

  

  public static final String TRAGEDY = "tragedy";
  public static final String COMEDY = "comedy";


  public Play(String name, String type,Performance performance) {
    this.name = name; 
    this.type = type; 
    this.performance = performance; 
  }
  

  //Montant cumulé
  public double calculateAmount(){
    
    double totalAmount = 0.0;

    switch (type) {
      case TRAGEDY:
        totalAmount = calculateTragedyAmount(performance);
        break;
      case COMEDY:
        totalAmount = calculateComedyAmount(performance);
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
  private double calculateComedyAmount(Performance performance) {
    double totalAmount;
    totalAmount = 300.0;
    if (performance.getAudience() > 20) {
      totalAmount += 100.0 + 5.0 * (performance.getAudience() - 20);
    }
    totalAmount += 3.0 * performance.getAudience();
    return totalAmount;
  }

  //Montant cumulé pour TRAGEDY
  private double calculateTragedyAmount(Performance performance) {
    double totalAmount;
    totalAmount = 400.0;
    if (performance.getAudience() > 30) {
      totalAmount += 10.0 * (performance.getAudience() - 30);
    }
    return totalAmount;
  }

  //Crédits cumulés pour Comedy
  private int calculateVolumeCreditsForComedy(int volumeCredits) {
    if ("comedy".equals(type)) volumeCredits +=(int) Math.floor(performance.getAudience() / 5);
    return volumeCredits;
  }

  //Crédits cumulés pour Tragedy
  private int calculateVolumeCreditsForTragedy(int volumeCredits) {
    volumeCredits += Math.max(performance.getAudience() - 30, 0);
    return volumeCredits;
  }

}





















