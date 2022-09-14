public class WeightedIngredient extends Ingredient{
    private double weight;
    private double pricePerUnit;

    public WeightedIngredient(String nameIngredient, double weight, double pricePerUnit) {
        super(nameIngredient);
        this.weight = weight;
        this.pricePerUnit = pricePerUnit;
    }
    public WeightedIngredient(String nameIngredient){
        super(nameIngredient);
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return
                "   Naziv sastojka:    " + super.getNameIngredient() +
                "   Tezina sastojka:   " + weight +
                "   Cena po kilogramu: " + pricePerUnit + "\n";
    }
    @Override
    public double getPrice() {
        return weight*pricePerUnit;
    }
}
