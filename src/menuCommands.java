import java.util.List;

public interface menuCommands {
    String createFood(List<Menu> menu);
    String removeFood(List<Menu> menu);
    List<Menu> getAllFood(List<Menu> menu);
    void sortByPrice(List<Menu> menu);
    void findFoodByName(List<Menu> menu);
    StringBuilder check (List<Menu> menu, List<String> meals);
}
