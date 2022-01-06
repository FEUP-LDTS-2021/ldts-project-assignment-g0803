package g0803.bindingofshiba.model.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String title;
    private List<String> options;
    private int choice;

    public Menu(String title, List<String> options) {
        this.title = title;
        this.options = new ArrayList<>(options);
        this.choice = 0;
    }

    public String getTitle() {
        return this.title;
    }

    public List<String> getOptions() {
        return this.options;
    }

    public void addOption(String option) {
        this.options.add(option);
    }

    public void incrementChoice() {
        this.choice++;
    }

    public void decrementChoice() {
        this.choice--;
    }

}
