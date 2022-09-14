import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeBook {
    private List<Recipe> recipeBook;

    public RecipeBook() {
        this.recipeBook  = new ArrayList<>(Arrays.asList(
                new Recipe("bolonjeze", RecipeLevel.PRO, bolonjeze),
                new Recipe("omlet", RecipeLevel.BEGGINER, omlet),
                new Recipe("rizoto", RecipeLevel.MEDIUM, rizoto),
                new Recipe("pizza", RecipeLevel.BEGGINER, pizza),
                new Recipe("rolovan file", RecipeLevel.HARD, rolovanFile),
                new Recipe("przenice", RecipeLevel.EASY, przenice),
                new Recipe("lazanje", RecipeLevel.PRO, lazanje),
                new Recipe("karbonara", RecipeLevel.MEDIUM, karbonara),
                new Recipe("palacinke", RecipeLevel.MEDIUM, palacinke),
                new Recipe("pire", RecipeLevel.EASY, pire)
                ));
    }
    public List<Recipe> getRecipeBok() {
        return recipeBook;
    }
    public void setRecipeBook(List<Recipe> recipeBook) {
        this.recipeBook = recipeBook;
    }
    public void printRecie(){
        int count = 1;
        for (var el : recipeBook){
            System.out.println(count+"- "+ el.getRecipeName());
            count++;
        }
        }
    ArrayList<WeightedIngredient> omlet = new ArrayList<>(Arrays.asList(new WeightedIngredient("jaja",3,15),
            new WeightedIngredient("kackavalj",0.3,990)));
    ArrayList<WeightedIngredient> przenice = new ArrayList<>(Arrays.asList(new WeightedIngredient("jaja",4,15),
            new WeightedIngredient("mleko",0.2, 180),
            new WeightedIngredient("tost",0.4, 130)));
    ArrayList<WeightedIngredient> pizza = new ArrayList<>(Arrays.asList(new WeightedIngredient("testo",0.5,65),
            new WeightedIngredient("parmezan",0.2, 700),
            new WeightedIngredient("pelat",0.2, 220)));
    ArrayList<WeightedIngredient> rizoto = new ArrayList<>(Arrays.asList(new WeightedIngredient("pirinac",0.5,89),
            new WeightedIngredient("belo meso",0.5, 650)));
    ArrayList<WeightedIngredient> rolovanFile = new ArrayList<>(Arrays.asList(new WeightedIngredient("belo meso",0.8,650),
            new WeightedIngredient("panceta",0.2, 1500),
            new WeightedIngredient("kackavalj",0.2, 990)));
    ArrayList<WeightedIngredient> bolonjeze = new ArrayList<>(Arrays.asList(new WeightedIngredient("mleveno meso",1,900),
            new WeightedIngredient("testenina",0.5, 200),
            new WeightedIngredient("parmezan",0.2, 700),
            new WeightedIngredient("sampinjoni",0.4, 300),
            new WeightedIngredient("luk",0.1, 115),
            new WeightedIngredient("pelat",0.2, 220)));
    ArrayList<WeightedIngredient> lazanje = new ArrayList<>(Arrays.asList(new WeightedIngredient("mleveno meso",0.8,900),
            new WeightedIngredient("kore",0.5, 200),
            new WeightedIngredient("parmezan",0.2, 700),
            new WeightedIngredient("sampinjoni",0.4, 300),
            new WeightedIngredient("luk",0.1, 115),
            new WeightedIngredient("besamel",0.35, 220)));
    ArrayList<WeightedIngredient> karbonara = new ArrayList<>(Arrays.asList(new WeightedIngredient("jaja",4,15),
            new WeightedIngredient("testenina",0.5, 200),
            new WeightedIngredient("parmezan",0.3, 700)));
    ArrayList<WeightedIngredient> palacinke = new ArrayList<>(Arrays.asList( new WeightedIngredient("mleko",0.2, 180),
            new WeightedIngredient("jaja",2,15),
            new WeightedIngredient("krem",0.4, 800),
            new WeightedIngredient("plazma",0.2, 300),
            new WeightedIngredient("brasno",0.3, 115)));
    ArrayList<WeightedIngredient> pire = new ArrayList<>(Arrays.asList(new WeightedIngredient("mleko",0.3,180),
            new WeightedIngredient("krompir", 1,120),
            new WeightedIngredient("maslac",0.2, 450)));
}
