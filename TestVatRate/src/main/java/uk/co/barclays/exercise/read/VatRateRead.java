package uk.co.barclays.exercise.read;

import uk.co.barclays.exercise.common.ent.VatRate;
import uk.co.barclays.exercise.common.exception.VatRateReadException;

import java.util.List;

/**
 * Interface for "read" part of the application.
 *
 * @author Ficek Daniel
 */
public interface VatRateRead {

    /**
     * Read VAT Rates.
     *
     * @return List with VAT rates
     * @throws VatRateReadException Cannot read VAT Rates
     */
    List<VatRate> readRates() throws VatRateReadException;

}
