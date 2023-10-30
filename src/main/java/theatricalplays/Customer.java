package theatricalplays;

public class Customer {
    public String name;
    private String customerNumber;
    private int loyaltyPoints;

    public Customer(String name, String customerNumber, int loyaltyPoints) {
        this.name = name;
        this.customerNumber = customerNumber;
        this.loyaltyPoints = loyaltyPoints;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public int deductLoyaltyPoints(int points) {
        loyaltyPoints -= points;
        if (loyaltyPoints < 0) {
            loyaltyPoints = 0;
        }
        return loyaltyPoints;
    }
    
}
