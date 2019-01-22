package uk.co.barclays.exercise.common.exception;

/**
 * Base application exception.
 *
 * @author Ficek Daniel
 */
public abstract class VatRateException extends Exception {

    public VatRateException(String message) {
        super(message);
    }

    public VatRateException(String message, Throwable cause) {
        super(message, cause);
    }

}
