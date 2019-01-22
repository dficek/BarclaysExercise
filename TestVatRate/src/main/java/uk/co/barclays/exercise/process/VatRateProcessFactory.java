package uk.co.barclays.exercise.process;

import uk.co.barclays.exercise.process.impl.lowhigh.VatRateProcessLowHigh;

/**
 * The factory - create implementation of the {@link uk.co.barclays.exercise.process.VatRateProcessType}
 *
 * @author Ficek Daniel
 */
public class VatRateProcessFactory {

    /**
     * Create new implementation of the {@link uk.co.barclays.exercise.process.VatRateProcessType}
     *
     * @param processType Type of implementation
     * @return New VatRateRead implementation
     */
    public static VatRateProcess createVatRateProcess(VatRateProcessType processType) {
        switch (processType) {
            case LOW_HIGH:
                return new VatRateProcessLowHigh();
            default:
                throw new IllegalArgumentException("Cannot create new VatRateProcess for type " + processType);
        }
    }

}
