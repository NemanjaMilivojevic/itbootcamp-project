import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Fridge {
    List<WeightedIngredient> listInFridge;
    public Fridge() {
        this.listInFridge = Database.list;
    }
    public void addIngredientinFridge(WeightedIngredient ingredient) {
        List<WeightedIngredient> temp = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < listInFridge.size(); i++) {
            if (listInFridge.get(i).getNameIngredient().equals(ingredient.getNameIngredient())) {
                temp.add(i, new WeightedIngredient(ingredient.getNameIngredient(), listInFridge.get(i).getWeight() + ingredient.getWeight(), ingredient.getPricePerUnit()));

            } else {
                temp.add(listInFridge.get(i));
            }
        }
        setListInFridge(temp);
        for (int i = 0; i < listInFridge.size(); i++) {
            flag = false;
            if (listInFridge.get(i).getNameIngredient().equals(ingredient.getNameIngredient())) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            listInFridge.add(ingredient);
        }
    }
    public void subIngredientinFridge(WeightedIngredient ingredient, double weight) {
        List<WeightedIngredient> temp = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < listInFridge.size(); i++) {
            if (listInFridge.get(i).getNameIngredient().equals(ingredient.getNameIngredient())) {
                temp.add(i, new WeightedIngredient(listInFridge.get(i).getNameIngredient(), listInFridge.get(i).getWeight() - weight, listInFridge.get(i).getPricePerUnit()));

            }
            else {
                temp.add(listInFridge.get(i));
            }
        }
        setListInFridge(temp);
    }
    public void removeIngredientFromFridge(WeightedIngredient ingredient) {
        this.listInFridge.removeIf(weightedIngredient -> weightedIngredient.getNameIngredient().equals(ingredient.getNameIngredient()));
    }
    public boolean canWeMake(Recipe recipe) {
        var temp = recipe.getIngredientList();
        boolean flag = false;
        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < listInFridge.size(); j++) {
                if (!(temp.get(i).getNameIngredient().equals(listInFridge.get(j).getNameIngredient()))) {
                    flag = false;
                } else {
                    if (temp.get(i).getWeight() <= listInFridge.get(j).getWeight()) {
                        flag = true;
                        break;
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag) {
                break;
            }
        }
        return flag;
    }
    public void makeMeal(Recipe recipe) {
        boolean flag;
        List<WeightedIngredient> list = new ArrayList<>();
        var temp = recipe.getIngredientList();
        if (canWeMake(recipe)) {
            for (int i = 0; i < listInFridge.size(); i++) {
                flag = false;
                for (int j = 0; j < temp.size(); j++) {
                    if (listInFridge.get(i).getNameIngredient().equals(temp.get(j).getNameIngredient())) {
                        list.add(new WeightedIngredient(listInFridge.get(i).getNameIngredient(), listInFridge.get(i).getWeight() - temp.get(j).getWeight(), listInFridge.get(i).getPricePerUnit()));
                        flag = true;
                    }
                }
                if (!flag) {
                    list.add(listInFridge.get(i));
                }
            }
            setListInFridge(list);
        }
        else {
            System.out.println("Nemamo dovoljno sastojaka da napravimo recept!");
        }
    }
    public void setListInFridge(List<WeightedIngredient> listInFridge) {
        this.listInFridge = listInFridge;
    }
    public void printFridge(){
        System.out.println("Stanje sastojaka u frizideru:");
        for (var el : listInFridge){
            System.out.println("Naziv sastojka: " + el.getNameIngredient() + " Trenutno u frizideru ima: " + el.getWeight() + " kilograma.");
        }
    }
    @Override
    public String toString() {
        return "Svi sastojci u frizideru: " + listInFridge;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fridge)) return false;
        Fridge fridge = (Fridge) o;
        return Objects.equals(listInFridge, fridge.listInFridge);
    }
    @Override
    public int hashCode() {
        return Objects.hash(listInFridge);
    }
}
