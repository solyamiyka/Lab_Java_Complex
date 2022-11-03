package taxes;

import java.util.Comparator;

class ComparatorSortDes implements Comparator<Income>
{
    @Override
    public int compare(Income o1, Income o2) {

        return (int)(o2.sizeOfTax - o1.sizeOfTax);
    }
}