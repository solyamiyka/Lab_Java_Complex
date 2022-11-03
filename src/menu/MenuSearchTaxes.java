package menu;

import taxes.Taxes;
import java.util.logging.Logger;

public class MenuSearchTaxes implements MenuItem{
    public String type;
    public double a,b;

    public MenuSearchTaxes(String type, double a, double b) {
        this.type = type;
        this.a = a;
        this.b = b;
    }

    @Override
    public void execute(Logger logger){
        new Taxes(logger).searchTaxes(type,a,b, logger);
    }

}