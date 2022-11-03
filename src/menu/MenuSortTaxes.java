package menu;

import taxes.Taxes;

import java.util.logging.Logger;

public class MenuSortTaxes implements MenuItem{
    public String type;

    public MenuSortTaxes(String type) {
        this.type = type;
    }

    @Override
    public void execute(Logger logger){
        new Taxes(logger).sortTaxes(type, logger);
    }
}
