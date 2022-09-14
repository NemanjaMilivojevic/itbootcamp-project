import java.util.ArrayList;
import java.util.List;

public class FavoriteRecipesBook {
    private List<Recipe>  favoriteRecipes;

    public FavoriteRecipesBook() {
        this.favoriteRecipes = new ArrayList<>();
    }
    public List<Recipe> getFavoriteRecipes() {
        return favoriteRecipes;
    }
    public void setFavoriteRecipes(List<Recipe> favoriteRecipes) {
        this.favoriteRecipes = favoriteRecipes;
    }
    public void addToFavorite(Recipe recipe){
        favoriteRecipes.add(recipe);
    }
    public void removeFromFavorite(Recipe recipe){
        favoriteRecipes.removeIf(recipe1 -> recipe1.getRecipeName().equals(recipe.getRecipeName()));
    }
    public void print(){
        int count = 1;
        for (var el : favoriteRecipes){
            System.out.println(count+"- "+ el.getRecipeName());
            count++;
        }
    }

}
