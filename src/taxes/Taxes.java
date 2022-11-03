package taxes;

import java.util.*;
import java.util.stream.Collectors;
import java.util.logging.Logger;

public class Taxes extends Income {

    public List<Income> taxes = new ArrayList<>();
    public Taxes(){}
    public Taxes(Logger logger){
        taxes = createListOfTax(logger);
    }


   public ArrayList<Income> createListOfTax(Logger logger){

        logger.finest("Creating list of taxes for person");
        ArrayList<Income> taxes = new ArrayList<>();

        Income income1 = new Income("award", 1970.00);
        Income income2 = new Income("main income", 65200.00);
        Income income3 = new Income("financial aid", 2460.00);

        addIncome(taxes, income1,logger);
        addIncome(taxes, income2,logger);
        addIncome(taxes, income3,logger);

        return taxes;
    }
    public void addIncome(ArrayList<Income> taxes, Income income, Logger logger){
        logger.fine("Getting size of tax by giving income and adding tax information to list of taxes");
        income.getPercentageOfTax();
        income.getSizeOfTax();
        taxes.add(income);

    }

    public Set<Double> defineSetTaxes(Logger logger){

        if (taxes.isEmpty()) {
            logger.info("List of tax is empty");
            return null;
        }

        logger.info("Defining set of size of taxes");
        Set<Double> taxesSet = new HashSet<>();
        for(Income tax: taxes){
            taxesSet.add(tax.getSizeOfTax());
        }
        System.out.println("\n Set of taxes:");
        for (Double obj : taxesSet)
            System.out.println(obj);

        return taxesSet;
    }

    public double defineSumTaxes(Logger logger){

        logger.info("Defining sum of tax");
        if (taxes.isEmpty()) {
            logger.info("List of tax is empty");
            return -1;
        }

        double total = 0.0;
        for(Income tax: taxes){
            total += tax.getSizeOfTax();
        }
        System.out.println("\n Sum of taxes: " + total);

        return total;
    }
    public List<Income> sortTaxes(String choice, Logger logger){

        List<Income> sortedTaxes = new ArrayList<>(taxes);

        if (Objects.equals(choice, "Asc")) {
            logger.info("Sorting taxes by size of tax and by ascending");
            System.out.println("\n Sorted taxes by ascending:");
            sortedTaxes.sort(new ComparatorSortAsc());
        } else {
            logger.info("Sorting taxes by size of tax and by descending");
            System.out.println("\n Sorted taxes by descending:");
            sortedTaxes.sort(new ComparatorSortDes());
        }
        info(sortedTaxes, logger);

        return sortedTaxes;
    }
    public List<Income> searchTaxes(String type, double a, double b, Logger logger){

        if (Objects.equals(type, "ByIncome")){
            logger.info("Searching taxes by income");
            System.out.println("\n Taxes searched by income in range [" + a +"; "+ b +"]:");
        }
        else {
            logger.info("Searching taxes by size of tax");
            System.out.println("\n Taxes searched by tax in range [" + a + "; " + b + "]:");
        }
        taxes = filterTaxes(type,a,b);

        info(taxes, logger);
        return taxes;
    }

    public List<Income> filterTaxes(String type, double a, double b){

        if (Objects.equals(type, "ByIncome")){
            return taxes.stream().filter(k -> k.getSizeOfIncome() > a && k.getSizeOfIncome() < b).collect(Collectors.toCollection(ArrayList::new));
        }
        else{
            return taxes.stream().filter(k -> k.getSizeOfTax() > a && k.getSizeOfTax() < b ).collect(Collectors.toCollection(ArrayList::new));
        }

    }

    public void info(List<Income> taxes, Logger logger){
        logger.info("Printing List of taxes");
        for(int i = 0; i < taxes.size(); i++) {
        System.out.print((i + 1) + ". " + taxes.get(i).toString() + "\n");
        }
    }

}
