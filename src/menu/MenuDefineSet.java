package menu;

import taxes.Taxes;

import java.util.logging.Logger;

public class MenuDefineSet implements MenuItem {

    @Override
    public void execute(Logger logger){
        new Taxes(logger).defineSetTaxes(logger);
    }
}
