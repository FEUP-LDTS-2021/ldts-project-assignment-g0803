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

    public int getChoice() {
        return this.choice;
    }

    public void addOption(String option) {
        this.options.add(option);
    }

    public void getNextOption() {
        if (this.choice != this.options.size() - 1)
            this.choice++;
    }

    public void getPreviousOption() {
        if (this.choice != 0)
            this.choice--;
    }

}
