package uk.co.barclays.exercise.read.impl.jsonvatcom;

import java.util.List;

public class JsonVatRate {
    String name;
    String code;
    String country_code;
    List<JsonVatPeriod> periods;
}
