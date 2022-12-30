package lab_SE309.lab12;

public class Appliances extends HouseholdItems{
    private char energyRating;

    Appliances(String name, double price, char energyRating) {
        setEnergyRating(energyRating);
        setName(name);
        setPrice(price);
    }

    public char getEnergyRating() {
        return energyRating;
    }

    public void setEnergyRating(char energyRating) {
        this.energyRating = energyRating;
    }
}
