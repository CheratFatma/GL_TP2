package theatricalplays;

public class TragedyPlay extends Play{

    public TragedyPlay(String name, String type,Performance performance){
        super(name, type, performance);
    }

    @Override
    public double calculateAmount(Customer customer){
    double totalAmount = 0.0;

    switch (type) {
      case TRAGEDY:
        totalAmount = 400.0;
        if (customer.getLoyaltyPoints() > 150) {
            totalAmount -= 15;
            customer.setLoyaltyPoints(customer.getLoyaltyPoints() - 150);
        }
        if (performance.getAudience() > 30) {
        totalAmount += 10.0 * (performance.getAudience() - 30);
        }        
        break;
      default:
        throw new Error("unknown type: ${playType}");
    }
    return totalAmount;
  }

   @Override
   public int calculateVolumeCredits(){
    int volumeCredits = 0;
    volumeCredits += Math.max(performance.getAudience() - 30, 0);
    return volumeCredits;
  }
    
}
