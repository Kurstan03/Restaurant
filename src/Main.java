import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList <Menu> menu = new LinkedList<>();
        menu.add(new ForBreakfast("ОМЛЕТ БАЙСКИЙ СО ШПИНАТОМ", 300, 265, 10));
        menu.add(new ForBreakfast("БЛИНЧИКИ СО СМЕТАНОЙ", 350, 150, 5));
        menu.add(new ForBreakfast("ЯИЧНИЦА ГЛАЗУНЬЯ", 230, 115, 7));
        menu.add(new ForKids("НАГГЕТСЫ КУРИНЫЕ", 340, 240, 15));
        menu.add(new ForKids("СЛАДКИЕ БООРСОКИ", 200, 105, 15));
        menu.add(new FirstMeal("ЧЕЧЕВИЧНЫЙ СУП", 300, 205, 13));
        menu.add(new FirstMeal("МЯСО ПО-КАЗАХСКИ", 300, 235, 17));
        menu.add(new FirstMeal("ШОРПО", 300, 245, 10));
        menu.add(new Pizza("ПЕППЕРОНИ", 600, 360, 20));
        menu.add(new Pizza("СУРРИМ", 600, 370, 23));
        menu.add(new Pizza("МАРГАРИТА", 600, 330, 20));
        menu.add(new Beverages("PEPSI",1,135,0));
        menu.add(new Beverages("ASU",1,135,0));

        Cafe cafe = new Cafe("Ala-Too","kruglo sutochnyi chaihana",menu);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            mainCatalog(cafe);
            switch (scanner.nextInt()) {
                case 1 -> System.out.println(cafe.getDescription());
                case 2 -> {
                    commands(menu);
                }
            }
        }

    }
    public static void mainCatalog(Cafe cafe){
        System.out.println("\n#########################");
        System.out.println("        " + cafe.getName());
        System.out.println("""
                 Welcome our restaurant!
                 
                Press 1 to read about us
                Press 2 to view the menu""");
    }
    public static void menuCatalog(){
        System.out.println("""
                \n####################################\n
                        Menu commands
                Press 1 to view all meals
                Press 2 to find meal by name
                Press 3 to view breakfast meals
                Press 4 to view meals for kids
                Press 5 to view first meal
                Press 6 to view pizza
                Press 7 to view beverages
                Press 8 to sort by price
                Press 9 to order food
                Press 10 to create food
                Press 11 to go main page""");
    }
    public static void commands(List<Menu> menu){
        Scanner scanner = new Scanner(System.in);
        while (true) {

            Menu food = new Menu();
            menuCatalog();
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    food.getAllFood(menu).forEach(System.out::println);

                    break;
                case 2:
                    food.findFoodByName(menu);
                    break;
                case 3:
                    for (Menu m : menu) {
                        if (m instanceof ForBreakfast) {
                            System.out.println(m);
                        }
                    }
                    break;
                case 4:
                    for (Menu m : menu) {
                        if (m instanceof ForKids) {
                            System.out.println(m);
                        }
                    }
                    break;
                case 5:
                    for (Menu m : menu) {
                        if (m instanceof FirstMeal) {
                            System.out.println(m);
                        }
                    }
                    break;
                case 6:
                    for (Menu m : menu) {
                        if (m instanceof Pizza) {
                            System.out.println(m);
                        }
                    }
                    break;
                case 7:
                    for (Menu m : menu) {
                        if (m instanceof Beverages) {
                            System.out.println(m);
                        }
                    }
                    break;
                case 8:
                    food.sortByPrice(menu);
                    break;
                case 9:
                    Scanner scanner1 = new Scanner(System.in);
                    List<String> orders = new ArrayList<>();
                    while (true) {

                        System.out.println("Will you still order?");
                        if (scanner1.nextLine().trim().toUpperCase().equals("YES")) {
                            String order = scanner1.nextLine();
                            orders.add(order);
                        } else {
                            System.out.println(food.check(menu, orders));
                            break;
                        }
                    }
                    break;
                case 10:
                    System.out.println(food.createFood(menu));
                    break;
            }
            if (number == 11) {
                break;
            }
        }
    }
}