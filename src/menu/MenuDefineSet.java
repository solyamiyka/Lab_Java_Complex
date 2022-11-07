package menu;

import taxes.Taxes;

public class MenuDefineSet implements MenuItem {

    @Override
    public void execute(){
        new Taxes().defineSetTaxes();
    }
}
