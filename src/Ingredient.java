public abstract class Ingredient implements Pricable {
    private int id;
    static private int idCount = 0;
    private String nameIngredient;

    public Ingredient(String nameIngredient) {
        this.nameIngredient = nameIngredient;
        this.id += idCount++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameIngredient() {
        return nameIngredient;
    }

    public void setNameIngredient(String nameIngredient) {
        this.nameIngredient = nameIngredient;
    }

    @Override
    public String toString() {
        return "Naziv sastojka: " + nameIngredient +
                " ID: " + id;
    }
}
