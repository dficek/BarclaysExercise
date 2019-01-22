package uk.co.barclays.exercise.process.impl.lowhigh;

import org.junit.Assert;
import org.junit.Test;
import uk.co.barclays.exercise.common.ent.VatRate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * JUnit test {@Link uk.co.barclays.exercise.process.impl.lowhigh.VatRateProcessLowHighTest}
 *
 * @author Ficek Daniel
 */
public class VatRateProcessLowHighTest {

    @Test(expected = NullPointerException.class)
    public void tesProcessDataNullArgument() {
        VatRateProcessLowHigh vatRateProcessLowHigh = new VatRateProcessLowHigh();

        vatRateProcessLowHigh.processRates(null);
    }

    @Test
    public void tesProcessDataValidArgument() {
        VatRateProcessLowHigh vatRateProcessLowHigh = new VatRateProcessLowHigh();

        List<VatRate> listVatRates = new ArrayList<>();
        vatRateProcessLowHigh.processRates(listVatRates);
    }

    @Test
    public void tesProcessDataHighest() {
        VatRateProcessLowHigh vatRateProcessLowHigh = new VatRateProcessLowHigh();

        List<VatRate> listVatRates = new ArrayList<>();
        listVatRates.add(new VatRate("Test 1", BigDecimal.valueOf(10.0)));
        listVatRates.add(new VatRate("Test 2", BigDecimal.valueOf(11.0)));
        listVatRates.add(new VatRate("Test 3", BigDecimal.valueOf(15.0)));
        listVatRates.add(new VatRate("Test 4", BigDecimal.valueOf(18.0)));
        listVatRates.add(new VatRate("Test 5", BigDecimal.valueOf(16.0)));
        listVatRates.add(new VatRate("Test 6", BigDecimal.valueOf(15.0)));

        List<VatRate> listVatTop = vatRateProcessLowHigh.findTop(listVatRates, true);
        Assert.assertTrue(listVatTop.size() == 4);
        Assert.assertTrue("Test 4".equals(listVatTop.get(0).getName()));
    }

    @Test
    public void tesProcessDataLowest() {
        VatRateProcessLowHigh vatRateProcessLowHigh = new VatRateProcessLowHigh();

        List<VatRate> listVatRates = new ArrayList<>();
        listVatRates.add(new VatRate("Test 1", BigDecimal.valueOf(10.0)));
        listVatRates.add(new VatRate("Test 2", BigDecimal.valueOf(11.0)));
        listVatRates.add(new VatRate("Test 3", BigDecimal.valueOf(15.0)));
        listVatRates.add(new VatRate("Test 4", BigDecimal.valueOf(18.0)));
        listVatRates.add(new VatRate("Test 5", BigDecimal.valueOf(16.0)));
        listVatRates.add(new VatRate("Test 6", BigDecimal.valueOf(15.0)));

        List<VatRate> listVatTop = vatRateProcessLowHigh.findTop(listVatRates, false);
        Assert.assertTrue(listVatTop.size() == 4);
        Assert.assertTrue("Test 1".equals(listVatTop.get(0).getName()));
    }

}
