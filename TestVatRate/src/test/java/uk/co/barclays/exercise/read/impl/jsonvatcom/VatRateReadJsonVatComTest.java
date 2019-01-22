package uk.co.barclays.exercise.read.impl.jsonvatcom;

import org.junit.Assert;
import org.junit.Test;
import uk.co.barclays.exercise.common.ent.VatRate;
import uk.co.barclays.exercise.common.exception.VatRateReadException;

import java.util.List;

/**
 * JUnit test {@Link uk.co.barclays.exercise.read.impl.jsonvatcom.VatRateReadJsonVatCom}
 *
 * @author Ficek Daniel
 */
public class VatRateReadJsonVatComTest {

    @Test
    public void testReadDataFromUrl() {
        VatRateReadJsonVatCom vatRateReadJsonVatCom = new VatRateReadJsonVatCom();

        try {
            List<VatRate> data = vatRateReadJsonVatCom.readRates();
            Assert.assertTrue(data.size() > 0);
        } catch (VatRateReadException ex) {
            // An exception Cannot Read VAT Rates throws
            Assert.assertTrue(false);
        }
    }

}
