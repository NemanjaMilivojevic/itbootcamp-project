import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Recipe implements Pricable {
    private String recipeName;
    private RecipeLevel level;
    private List<WeightedIngredient> ingredientList;

    public Recipe(String recipeName, RecipeLevel level, List<WeightedIngredient> ingredientList) {
        this.recipeName = recipeName;
        this.level = level;
        this.ingredientList = ingredientList;
    }
    public Recipe() {
    }
    public String getRecipeName() {
        return recipeName;
    }
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    public RecipeLevel getLevel() {
        return level;
    }
    public void setLevel(RecipeLevel level) {
        this.level = level;
    }
    public List<WeightedIngredient> getIngredientList() {
        return ingredientList;
    }
    public void setIngredientList(WeightedIngredient x) {
        this.ingredientList.add(x);
    }
    public void addIngredient(WeightedIngredient ingredient) {
        this.ingredientList.add(ingredient);
    }
    public void removeIngredient(WeightedIngredient ingredient) {
        ingredientList.remove(ingredient);
    }
    public Recipe scale(double x) {
        for (var el : ingredientList)
            el.setWeight(el.getWeight() * (x/100));
        return new Recipe(this.recipeName, this.level, this.ingredientList);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;
        Recipe recipe = (Recipe) o;
        return getRecipeName().equals(recipe.getRecipeName()) && getIngredientList().equals(recipe.getIngredientList());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getRecipeName(), getIngredientList());
    }
    @Override
    public double getPrice() {
        double sum = 0;
        for (var p : ingredientList) {
            sum += p.getPrice();
        }
        return sum;
    }
    @Override
    public String toString() {
        return "Ime recepta: " + recipeName
                + " Tezina recepta: " + level
                + " Sastojci recepta: " + ingredientList;
    }
}
