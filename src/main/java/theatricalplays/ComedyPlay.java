package theatricalplays;

public class ComedyPlay extends Play {

    public ComedyPlay(String name, String type,Performance performance){
        super(name, type, performance);
    }

    @Override
    public double calculateAmount(){
    double totalAmount = 0.0;

    switch (type) {
      case COMEDY:
        totalAmount = 300.0;
        if (performance.getAudience() > 20) {
        totalAmount += 100.0 + 5.0 * (performance.getAudience() - 20);
        }
        totalAmount += 3.0 * performance.getAudience();
        break;
      default:
        throw new Error("unknown type: ${playType}");
    }
    return totalAmount;
  }

   @Override
   public int calculateVolumeCredits(){
    int volumeCredits = 0;
    volumeCredits += (int) Math.floor(performance.getAudience()/5) +  Math.max(performance.getAudience() - 30, 0);
    return volumeCredits;
  }


    
}
