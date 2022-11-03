package menu;

import taxes.Income;
import taxes.Taxes;

import java.util.ArrayList;
import java.util.logging.Logger;

public class MenuDefineSum implements MenuItem {


    @Override
    public void execute(Logger logger){

        new Taxes(logger).defineSumTaxes(logger);
    }

}