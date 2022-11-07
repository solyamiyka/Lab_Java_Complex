package menu;

import taxes.Taxes;


public class MenuDefineSum implements MenuItem {


    @Override
    public void execute(){

        new Taxes().defineSumTaxes();
    }

}