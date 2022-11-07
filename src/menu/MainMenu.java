package menu;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MainMenu {
    private final Map<String, MenuItem> menuItems;

    public MainMenu(){
        menuItems = new LinkedHashMap<>();
        menuItems.put("defineSet", new MenuDefineSet());
        menuItems.put("defineSum", new MenuDefineSum());
        menuItems.put("searchByIncome", new MenuSearchTaxes("ByIncome", 2000,70000));
        menuItems.put("searchByTax", new MenuSearchTaxes("ByTax", 100, 1000));
        menuItems.put("sortAsc", new MenuSortTaxes("Asc"));
        menuItems.put("sortDesc", new MenuSortTaxes("Desc"));

    }
    public void help(String func){

        switch(func){
            case("defineSet")->
                    System.out.println(" defineSet - This function define set of taxes for person");
            case("defineSum")->
                    System.out.println(" defineSum - This function define sum of taxes for person");
            case("searchByIncome")->
                    System.out.println(" searchByIncome - This function search taxes for person in range of income");
            case("searchByTax")->
                    System.out.println(" searchByTax - This function search taxes for person in range of size of tax");
            case("sortAsc")->
                    System.out.println(" sortAsc - This function sort taxes for person by ascending");
            case("sortDesc")->
                    System.out.println(" sortDesc - This function sort taxes for person by descending");
        }

    }

    public void execute(String command, Logger logger){
        if(menuItems.get(command) == null){

            logger.info("Inputting incorrect command");

            System.out.println("Incorrect command!");
            return;
        }
        logger.info("Executing command " + command);
        menuItems.get(command).execute();

    }

    public void printAllCommands(){

        for (Map.Entry<String, MenuItem> entry: menuItems.entrySet()) {
            String func = entry.getKey();
            help(func);
        }

    }
}
