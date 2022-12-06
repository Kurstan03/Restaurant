import java.util.*;

public class Menu implements menuCommands{
    private String foodName;
    private double weight;
    private double price;
    private double timeForPreparing;

    public Menu(String foodName, double weight, double price, double timeForPreparing) {
        this.foodName = foodName;
        this.weight = weight;
        this.price = price;
        this.timeForPreparing = timeForPreparing;
    }

    public Menu() {
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTimeForPreparing() {
        return timeForPreparing;
    }

    public void setTimeForPreparing(double timeForPreparing) {
        this.timeForPreparing = timeForPreparing;
    }

    @Override
    public String createFood(List<Menu> menu) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("food name: ");
        String foodName = scanner.nextLine();
        System.out.print("weight: ");
        double weight = scanner.nextDouble();
        System.out.print("price: ");
        double price = scanner.nextDouble();
        System.out.print("time for preparing: ");
        double timeForPreparing = scanner.nextDouble();
        Menu food = new Menu(foodName,weight,price,timeForPreparing);
        menu.add(food);
        return "Food successfully saved!";
    }

    @Override
    public String removeFood(List<Menu> menu) {
        return null;
    }

    @Override
    public List<Menu> getAllFood(List<Menu> menu) {
        return menu;
    }

    @Override
    public void sortByPrice(List<Menu> menu) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 to sort by ascending\nPress 2 to sort by descending");
        switch (scanner.nextInt()){
            case 1 -> {
                menu.sort(Menu.sortByPriceAscending);
                System.out.println(menu);
            }
            case 2 -> {
                menu.sort(Menu.sortByPriceDescending);
                System.out.println(menu);
            }
        }
    }

    @Override
    public void findFoodByName(List<Menu> menu) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for (Menu m : menu) {
            if (m.getFoodName().trim().toLowerCase().contains(name.trim().toLowerCase())){
                System.out.println(m);
            }
        }
    }

    @Override
    public StringBuilder check(List<Menu> menu, List<String> meals) {
        StringBuilder check = new StringBuilder("~~~~~~~~~~~~~check~~~~~~~~~~~~~\n");
        double counter = 0;
        List<Double> time = new ArrayList<>();
        for (Menu m : menu) {
            for (int i = 0; i < meals.size(); i++) {
                if (m.foodName.trim().toUpperCase().contains(meals.get(i).trim().toUpperCase())){
                    check.append(m.foodName).append("     ").append(m.price).append("\n");
                    counter += m.price;
                    time.add(m.timeForPreparing);
                }
            }
        }
        counter += (counter * 10 / 100);
        Collections.sort(time);
        return check.append("\nоблуживание 10%\n\nВаш заказ будет готов через ").append(time.get((time.size() - 1))).append(" минут\n").append("\nИТОГО: ").append(counter).append( " сом");
    }

    public static Comparator<Menu> sortByPriceAscending = new Comparator<Menu>() {
        @Override
        public int compare(Menu o1, Menu o2) {
            return (int) o1.getPrice() - (int) o2.getPrice();
        }
    };
    public static Comparator<Menu> sortByPriceDescending = new Comparator<Menu>() {
        @Override
        public int compare(Menu o1, Menu o2) {
            return (int) o2.getPrice() - (int) o1.getPrice();
        }
    };

    @Override
    public String toString() {
        return  foodName +
                "    weight: " + weight +
                "    price: " + price +
                "    timeForPreparing: " + timeForPreparing +
                "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
    }
}
