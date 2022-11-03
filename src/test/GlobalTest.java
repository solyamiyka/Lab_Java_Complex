package test;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import taxes.Income;
import taxes.Taxes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

class GlobalTest {

    private static final Logger logger = Logger.getLogger(GlobalTest.class.getName());
    Taxes person = new Taxes(logger);

    @Test
    void testCreateTaxes(){
        List<Income> taxes = new ArrayList<>();

        Income income1 = new Income("award", 1970.00);
        Income income2 = new Income("main income", 65200.00);
        Income income3 = new Income("financial aid", 2460.00);

        addIncome(taxes, income1);
        addIncome(taxes, income2);
        addIncome(taxes, income3);

        Assert.assertEquals(taxes.toString(), person.createListOfTax(logger).toString());
    }
    public void addIncome(List<Income> taxes, Income income){
        income.getPercentageOfTax();
        income.getSizeOfTax();
        taxes.add(income);

    }

    @Test
    void testDefineSet(){

        Set<Double> testSet = new HashSet<>();
        testSet.add(12714.0);
        testSet.add(384.15);
        testSet.add(479.7);

        Assert.assertEquals(testSet, person.defineSetTaxes(logger));

    }

    @Test
    void testDefineSum(){

        double expectedSum = 13577.85;
        Assert.assertEquals(expectedSum, person.defineSumTaxes(logger));
    }

    @Test
    void testSortTaxesAsc(){

        ArrayList<Income> taxes = new ArrayList<>();

        Income income1 = new Income("award", 1970.00);
        Income income2 = new Income("financial aid", 2460.00);
        Income income3 = new Income("main income", 65200.00);

        addIncome(taxes, income1);
        addIncome(taxes, income2);
        addIncome(taxes, income3);

        Assert.assertEquals(taxes.toString(), person.sortTaxes("Asc", logger).toString());
    }
    @Test
    void testSortTaxesDesc(){

        ArrayList<Income> taxes = new ArrayList<>();

        Income income1 = new Income("main income", 65200.00);
        Income income2 = new Income("financial aid", 2460.00);
        Income income3 = new Income("award", 1970.00);

        addIncome(taxes, income1);
        addIncome(taxes, income2);
        addIncome(taxes, income3);

        Assert.assertEquals(taxes.toString(), person.sortTaxes("Desc", logger).toString());

    }

    @Test
    void testSearchTaxesByIncome(){

        ArrayList<Income> taxes = new ArrayList<>();

        Income income1 = new Income("main income", 65200.00);
        Income income2 = new Income("financial aid", 2460.00);

        addIncome(taxes, income1);
        addIncome(taxes, income2);

        Assert.assertEquals(taxes.toString(), person.searchTaxes("ByIncome",2000,70000, logger).toString());
    }

    @Test
    void testSearchTaxesByTax(){

        ArrayList<Income> taxes = new ArrayList<>();

        Income income1 = new Income("award", 1970.00);
        Income income2 = new Income("financial aid", 2460.00);

        addIncome(taxes, income1);
        addIncome(taxes, income2);

        Assert.assertEquals(taxes.toString(), person.searchTaxes("ByTax",100,1000, logger).toString());
    }

}