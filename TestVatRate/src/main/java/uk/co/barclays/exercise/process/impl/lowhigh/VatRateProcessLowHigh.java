package uk.co.barclays.exercise.process.impl.lowhigh;

import static java.util.Comparator.*;

import uk.co.barclays.exercise.common.ent.VatRate;
import uk.co.barclays.exercise.process.VatRateProcess;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Find 3 lowest and 3 Highest VAT Rates
 *
 * @author Ficek Daniel
 */
public class VatRateProcessLowHigh implements VatRateProcess {

    private static int PRINT_COUNT = 3;

    @Override
    public void processRates(List<VatRate> listVatRates) {
        System.out.println();
        System.out.println("EU VAT Rates effective on: " + LocalDate.now());
        System.out.println();

        // Find 3 highest
        List<VatRate> listOrdered = findTop(listVatRates, true);
        System.out.println("Highest: ");
        listOrdered.stream().forEach(item -> System.out.println(String.format("%s ... %s", item.getName(), item.getRate().doubleValue())));
        System.out.println();

        // Find 3 lowest
        listOrdered = findTop(listVatRates, false);
        System.out.println("Lowest: ");
        listOrdered.stream().forEach(item -> System.out.println(String.format("%s ... %s", item.getName(), item.getRate().doubleValue())));
        System.out.println();
    }

    /**
     * Find top N items from VAT rate list.
     * @param listVatRates List with VAT rates
     * @param highest True if find highst rates, otherwise False
     * @return "Filtered" List with VAT Rates
     */
    protected List<VatRate> findTop(List<VatRate> listVatRates, boolean highest) {
        List<VatRate> listRateTop = new ArrayList<>();

        int counter = 0;
        double valueLast = highest ? Double.MAX_VALUE : Double.MIN_VALUE;
        List<VatRate> listOrdered = highest ?
                listVatRates.stream().sorted(comparing(VatRate::getRate).reversed()).collect(Collectors.toList()) :
                listVatRates.stream().sorted(comparing(VatRate::getRate)).collect(Collectors.toList());

        // .limit(PRINT_COUNT) is not solution ... more than one country have same vat rate
        for (VatRate item: listOrdered) {
            if (counter++ < PRINT_COUNT || valueLast == item.getRate().doubleValue()) {
                listRateTop.add(item);
                valueLast = item.getRate().doubleValue();
            }
        }

        return listRateTop;
    }

}
