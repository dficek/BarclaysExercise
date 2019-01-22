package uk.co.barclays.exercise.process;

import uk.co.barclays.exercise.common.ent.VatRate;

import java.util.List;

/**
 * Interface for "process" part of the application.
 *
 * @author Ficek Daniel
 */
public interface VatRateProcess {

    /**
     * Process VAT Rates.
     *
     * @param listVatRates List with VAT Rates to process.
     */
    void processRates(List<VatRate> listVatRates);

}
