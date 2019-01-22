package uk.co.barclays.exercise.common.exception;

/**
 * Cannot read VAT Rates exception.
 *
 * @author Ficek Daniel
 */
public class VatRateReadException extends VatRateException {

    public VatRateReadException(String message) {
        super(message);
    }

    public VatRateReadException(String message, Throwable cause) {
        super(message, cause);
    }

}
