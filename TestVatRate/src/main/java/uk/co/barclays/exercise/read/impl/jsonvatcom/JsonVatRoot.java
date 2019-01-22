package uk.co.barclays.exercise.read.impl.jsonvatcom;

import java.util.List;

/**
 * JSON Root Element.
 *
 * @author Ficek Daniel
 */
public class JsonVatRoot {
    String details;
    String version;
    List<JsonVatRate> rates;
}
