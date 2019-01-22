package uk.co.barclays.exercise.read.impl.jsonvatcom;

import java.util.List;

/**
 * JSON Element with one VAT Rate.
 *
 * @author Ficek Daniel
 */
public class JsonVatRate {
    String name;
    String code;
    String country_code;
    List<JsonVatPeriod> periods;
}
