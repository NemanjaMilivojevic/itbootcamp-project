import java.util.*;

public class Application {
    public static void main(String[] args) {
        boolean flag = true;
        int option;
        Scanner sc = new Scanner(System.in);
        Fridge fridge = new Fridge();
        RecipeBook recipeBook = new RecipeBook();
        FavoriteRecipesBook favoriteRecipes = new FavoriteRecipesBook();
        var recipes = recipeBook.getRecipeBok();
        var favRecipes = favoriteRecipes.getFavoriteRecipes();

        while (flag) {
            System.out.println("-".repeat(40));
            System.out.println("Dobro dosli u kuhinju molimo Vas izaberite opciju od 0 do 2 - ");
            System.out.println("1 - Dodaj namernicu u frizider \n" +
                    "2 - Brisanje namernice iz frizidera \n" +
                    "3 -  Koje sve namernice mozemo da napravimo iz frizidera\n" +
                    "4 -  Proveri koja sve jela mogu da se naprave skalirana za 50%\n" +
                    "5 -  Pravljenje jela\n" +
                    "6 -  Koja sve jela mogu da se naprave za X dinara\n" +
                    "7 -  Koja sve jela mogu da se naprave X tezine\n" +
                    "8 -  Koja sve jela mogu da se naprave X tezine i za X dinara\n" +
                    "9 -  Sortirajte recepte po tezini\n" +
                    "10 - Sortirajte recepte po ceni\n" +
                    "11 - Omiljena jela" +
                    "0 - Izlaz\n" +
                    "-".repeat(40));
            option = sc.nextInt();

            switch (option) {

                case 1: {
                    System.out.println("Unesite ime sastojka - ");
                    var name = sc.next();
                    System.out.println("Unesite tezinu sastojka u kilogramima - ");
                    var weight = sc.nextDouble();
                    System.out.println("Unesite cenu po kilogramu - ");
                    var price = sc.nextDouble();
                    fridge.addIngredientinFridge(new WeightedIngredient(name, weight, price));
                    fridge.printFridge();
                    break;
                }
                case 2: {
                    System.out.println("Molimo Vas izaberite opciju - \n" +
                            "1 - Da izbrisete namernicu iz frizidera\n" +
                            "2 - Da smanjite kolicinu");
                    int num = sc.nextInt();
                    switch (num) {
                        case 1: {
                            fridge.printFridge();
                            System.out.println("Unesite naziv sastojka koji zelite da uklonite - ");
                            fridge.removeIngredientFromFridge(new WeightedIngredient(sc.next()));
                            fridge.printFridge();
                            break;
                        }
                        case 2: {
                            fridge.printFridge();
                            System.out.println("Unesite naziv sastojka ciju kolicinu zelite da smanjite - ");
                            var name = sc.next();
                            System.out.println("Unesite kolicinu za koju zelite da smanjite - ");
                            var weight = sc.nextDouble();
                            fridge.subIngredientinFridge(new WeightedIngredient(name), weight);
                            fridge.printFridge();
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Mozemo da napravimo ova jela sa sastojcima iz frizidera:");
                    int count = 1;
                    for (var el : recipes) {
                        if (fridge.canWeMake(el)) {
                            System.out.println(count + "-" + el.getRecipeName());
                            count++;
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("Mozemo da napravimo ova jela skalirana za 50% sa sastojcima iz frizidera:");
                    int count = 1;
                    for (var el : recipes) {
                        if (fridge.canWeMake(el.scale(50))) {
                            System.out.println(count + "-" + el.getRecipeName());
                            count++;
                        }
                        el.scale(200);
                    }
                    break;

                }
                case 5: {
                    System.out.println("Molimo Vas izaberite opciju: \n" +
                            "1 - Da napravite jelo\n" +
                            "2 - Da napravite jelo skalirano za 50%");
                    int option1 = sc.nextInt();
                    switch (option1) {
                        case 1: {
                            System.out.println("Mozemo da napravimo ova jela sa sastojcima iz frizidera:");
                            int count = 1;
                            for (var el : recipes) {
                                if (fridge.canWeMake(el)) {
                                    System.out.println(count + "-" + el.getRecipeName());
                                    count++;
                                }
                            }
                            System.out.println("Unesite ime jela koje zelite da napravite: ");
                            var name = sc.next();
                            for (var el : recipes) {
                                if (el.getRecipeName().equals(name)) {
                                    fridge.makeMeal(el);
                                    System.out.println("Uspesno ste napravili jelo - " + el.getRecipeName());
                                }
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Mozemo da napravimo ova jela skalirana za 50% sa sastojcima iz frizidera:");
                            int count = 1;
                            System.out.println(recipes);
                            for (var el : recipes) {
                                if (fridge.canWeMake(el.scale(50))) {
                                    System.out.println(count + "-" + el.getRecipeName());
                                    count++;
                                }
                                el.scale(200);
                            }
                            System.out.println("Unesite ime jela koje zelite da napravite: ");
                            var name = sc.next();
                            for (var el : recipes) {
                                if (el.getRecipeName().equals(name)) {
                                    fridge.makeMeal(el.scale(50));
                                    System.out.println("Uspesno ste napravili skalirano za 50 jelo - ");
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
                case 6: {
                    System.out.print("Unesite cifru X do koje zelite da proverite sta sve mozete napraviti od jela- \n" +
                            "X - ");
                    double x = sc.nextDouble();
                    int count = 1;
                    System.out.println("Jela koja mozete da napravite do " + x + " dinara su: ");
                    for (var el : recipes) {
                        if (el.getPrice() <= x) {
                            System.out.println(count + "- " + el.getRecipeName());
                            count++;
                        }
                    }
                    if (count == 1) {
                        System.out.println("Do " + x + " dinara ne mozete da napravite nijedno jelo!");
                    }
                    break;
                }
                case 7: {
                    System.out.println("Unesite ID za tezinu koju zelite da vidite jela: \n" +
                            "ID:1 - BEGGINER\n" +
                            "ID:2 - EASY\n" +
                            "ID:3 - MEDIUM\n" +
                            "ID:4 - HARD\n" +
                            "ID:5 - PRO");
                    RecipeLevel level = null;
//                    String level = sc.next();
                    int z = sc.nextInt();
                    switch (z) {
                        case 1: {level = RecipeLevel.BEGGINER;break;}
                        case 2: {level = RecipeLevel.EASY;break;}
                        case 3: {level = RecipeLevel.MEDIUM;break;}
                        case 4: {level = RecipeLevel.HARD;break;}
                        case 5: {level = RecipeLevel.PRO;break;}

                    }
                    System.out.println("Jela sa tezinom " + level + " su: ");
                    int count = 1;
                    for (var el : recipes) {
                        if (el.getLevel().equals(level)) {
                            System.out.println(count + "- " + el.getRecipeName());
                            count++;
                        }
                    }
                    break;
                }
                case 8:{
                    System.out.println("Unesite ID za tezinu koju zelite da vidite jela: \n" +
                            "ID:1 - BEGGINER\n" +
                            "ID:2 - EASY\n" +
                            "ID:3 - MEDIUM\n" +
                            "ID:4 - HARD\n" +
                            "ID:5 - PRO");
                    RecipeLevel level = null;
//                    String level = sc.next();
                    int z = sc.nextInt();
                    switch (z) {
                        case 1: {level = RecipeLevel.BEGGINER;break;}
                        case 2: {level = RecipeLevel.EASY;break;}
                        case 3: {level = RecipeLevel.MEDIUM;break;}
                        case 4: {level = RecipeLevel.HARD;break;}
                        case 5: {level = RecipeLevel.PRO;break;}
                }
                    System.out.print("Unesite cifru X do koje zelite da proverite sta sve mozete napraviti od jela- \n" +
                            "X - ");
                    int count =1;
                    double x = sc.nextDouble();
                    for (var el :recipes){
                        if(el.getPrice() <= x && el.getLevel().equals(level)){
                            System.out.println(count + "- " + el.getRecipeName());
                            count++;
                        }
                    }
                    if(count == 1){
                        System.out.println("Nazalost nema recepata za takve uslove.");
                    }
                    break;
                }
                case 9:{
                    recipes.sort(Comparator.comparing(Recipe::getLevel));
                    int count =1;
                    for(var el : recipes){
                        System.out.println(count + "- " + el.getRecipeName() + ": " + el.getLevel());
                        count++;
                    }
                    break;
                }
                case 10:{
                    recipes.sort(Comparator.comparingDouble(Recipe::getPrice));
                    int count =1;
                    for(var el : recipes){
                        System.out.println(count + "- " + el.getRecipeName() + ": " + el.getPrice() + " dinara.");
                        count++;
                    }
                    break;
                }
                case 11:{
                    System.out.println("Molimo Vas izaberite opciju: \n" +
                            "1 - Da vidite sva omiljena jela\n" +
                            "2 - Dodaj omiljeni recept\n" +
                            "3 - Izbrisi omiljeni recept\n" +
                            "4 - Omiljeni recepti do X dinara");
                    int optionFav = sc.nextInt();
                    switch (optionFav){
                        case 1: {favoriteRecipes.print();break;}
                        case 2: {
                            System.out.println("Unesite ime omiljenog recepta");
                            recipeBook.printRecie();
                            String nameFav = sc.next();
                            for(var el : recipes){
                                if (el.getRecipeName().equals(nameFav))
                                    favoriteRecipes.addToFavorite(el);
                            }
                            break;
                        }
                        case 3: {
                            System.out.println("Unesite ime recepta koji zelite da izbacite -");
                            favoriteRecipes.print();
                            String nameFav = sc.next();
                            for(var el : recipes){
                                if (el.getRecipeName().equals(nameFav))
                                    favoriteRecipes.removeFromFavorite(el);
                            }
                            break;
                        }
                        case 4:{
                            int count = 1;
                            System.out.print("Unesite cifru X do koje zelite da Vam pokaze omiljena jela - \n" +
                                    "X - ");
                            double price = sc.nextDouble();
                            for (var el : favRecipes){
                                if(el.getPrice() <= price){
                                    System.out.println(count + "- " +el.getRecipeName());
                                }
                            }
                            break;
                        }
                    }
                    break;
                }

                case 0: {
                    flag = false;
                }
            }
        }
    }
}
