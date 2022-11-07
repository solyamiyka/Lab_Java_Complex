package taxes;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GlobalTest {

    Taxes person = new Taxes();

    @Test
    void testCreateTaxes(){
        List<Income> taxes = new ArrayList<>();

        Income income1 = new Income("award", 1970.00);
        Income income2 = new Income("main income", 65200.00);
        Income income3 = new Income("funds as a gift", 2460.00);

        person.addIncome(taxes, income1);
        person.addIncome(taxes, income2);
        person.addIncome(taxes, income3);

        Assert.assertEquals(taxes.toString(), person.createListOfTax().toString());
    }

    @Test
    void testDefineSet(){

        Set<Double> testSet = new HashSet<>();
        testSet.add(12714.0);
        testSet.add(384.15);
        testSet.add(110.7);
        Assert.assertEquals(testSet, person.defineSetTaxes());

    }

    @Test
    void testDefineSum(){
        Assert.assertEquals(13208.85, person.defineSumTaxes());
    }

    @Test
    void testSortTaxesAsc(){

        List<Income> taxes = new ArrayList<>();

        Income income1 = new Income("funds as a gift",  2460.00);
        Income income2 = new Income("award", 1970.00);
        Income income3 = new Income("main income", 65200.00);

        person.addIncome(taxes, income1);
        person.addIncome(taxes, income2);
        person.addIncome(taxes, income3);

        Assert.assertEquals(taxes.toString(), person.sortTaxes("Asc").toString());

    }
    @Test
    void testSortTaxesDesc(){

        List<Income> taxes = new ArrayList<>();
        Income income1 = new Income("main income", 65200.00);
        Income income2 = new Income("award", 1970.00);
        Income income3 = new Income("funds as a gift", 2460.00);


        person.addIncome(taxes, income1);
        person.addIncome(taxes, income2);
        person.addIncome(taxes, income3);

        Assert.assertEquals(taxes.toString(), person.sortTaxes("Desc").toString());

    }

    @Test
    void testSearchTaxesByIncome(){

        List<Income> taxes = new ArrayList<>();
        Income income1 = new Income("main income", 65200.00);
        Income income2 = new Income("funds as a gift", 2460.00);

        person.addIncome(taxes, income1);
        person.addIncome(taxes, income2);
        Assert.assertEquals(taxes.toString(), person.searchTaxes("ByIncome",2000,70000).toString());
    }
    @Test
    void testSearchTaxesByTax(){

        ArrayList<Income> taxes = new ArrayList<>();
        Income income1 = new Income("award", 1970.00);
        Income income2 = new Income("funds as a gift", 2460.00);
        person.addIncome(taxes, income1);
        person.addIncome(taxes, income2);

        Assert.assertEquals(taxes.toString(), person.searchTaxes("ByTax",100,1000).toString());
    }
    @Test
    void testFilterByIncome(){
        List<Income> taxes = new ArrayList<>();
        Income income1 = new Income("main income", 65200.00);
        Income income2 = new Income("funds as a gift", 2460.00);

        person.addIncome(taxes, income1);
        person.addIncome(taxes, income2);

        Assert.assertEquals(taxes.toString(), person.filterTaxes("ByIncome", 2000,70000).toString());
    }
    @Test
    void testFilterByTax(){
        List<Income> taxes = new ArrayList<>();
        Income income1 = new Income("award", 1970.00);
        Income income2 = new Income("funds as a gift", 2460.00);

        person.addIncome(taxes, income1);
        person.addIncome(taxes, income2);

        Assert.assertEquals(taxes.toString(),person.filterTaxes("ByTax", 100, 1000).toString());
    }

}