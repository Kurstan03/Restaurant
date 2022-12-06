import java.util.List;
import java.util.Scanner;

public class Cafe {
    private String name;
    private String description;
    private List<Menu> menu;

    public Cafe(String name, String description, List<Menu> menu) {
        this.name = name;
        this.description = description;
        this.menu = menu;
    }

    public Cafe() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return   name +
                "\ndescription: " + description +
                "\nmenu: " + menu;
    }
}
