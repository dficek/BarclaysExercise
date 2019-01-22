package uk.co.barclays.exercise.read;

import uk.co.barclays.exercise.read.impl.jsonvatcom.VatRateReadJsonVatCom;

/**
 * The factory - create implementation of the {@link uk.co.barclays.exercise.read.VatRateRead}
 *
 * @author Ficek Daniel
 */
public class VatRateReadFactory {

    /**
     * Create new implementation of the {@link uk.co.barclays.exercise.read.VatRateRead}
     *
     * @param readType Type of implementation
     * @return New VatRateRead implementation
     */
    public static VatRateRead createVatRateRead(VatRateReadType readType) {
        switch (readType) {
            case EXTERNAL_WEB_JSONVATCOM:
                return new VatRateReadJsonVatCom();
            default:
                throw new IllegalArgumentException("Cannot create new VatRateRead for type " + readType);
        }
    }

}
