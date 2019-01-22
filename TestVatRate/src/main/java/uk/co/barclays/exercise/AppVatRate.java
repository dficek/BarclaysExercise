package uk.co.barclays.exercise;

import uk.co.barclays.exercise.common.ent.VatRate;
import uk.co.barclays.exercise.common.exception.VatRateReadException;
import uk.co.barclays.exercise.process.VatRateProcess;
import uk.co.barclays.exercise.process.VatRateProcessFactory;
import uk.co.barclays.exercise.process.VatRateProcessType;
import uk.co.barclays.exercise.read.VatRateRead;
import uk.co.barclays.exercise.read.VatRateReadFactory;
import uk.co.barclays.exercise.read.VatRateReadType;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The main class with main().
 * Little exercise.
 * Download EU VAT rates and find 3 lowest and 3 highest VAT rates.
 *
 * Application has two "parts":
 * A/ Read data
 *      Read data has only one implementation: Read data from external web http://jsonvat.com/
 * B/ Process data
 *      Process data has only one implementation: Find 3 lowest and 3 highest VAT rates
 * Both parts are implemented as Factory pattern. Know nothing about future plants.
 *
 * All communication include logs print messages simply to the console
 *   (can be simply changed to the log4j for example, etc.)
 *
 * @author Ficek Daniel
 */
public class AppVatRate {

    /**
     * The java main().
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        System.out.println(String.format("App start at %s", LocalDateTime.now()));

        try {
            // Read data
            VatRateRead vatRateRead = VatRateReadFactory.createVatRateRead(VatRateReadType.EXTERNAL_WEB_JSONVATCOM);
            List<VatRate> listVatRate = vatRateRead.readRates();

            // Process data
            VatRateProcess vatRateProcess = VatRateProcessFactory.createVatRateProcess(VatRateProcessType.LOW_HIGH);
            vatRateProcess.processRates(listVatRate);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception while running application: " + ex.getMessage());
        } catch (VatRateReadException ex) {
            System.out.println("Cannot read VAT rates: " + ex.getMessage());
        }

        System.out.println(String.format("App finish at %s", LocalDateTime.now()));
    }

}

