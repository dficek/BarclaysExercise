package uk.co.barclays.exercise.read.impl.jsonvatcom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import uk.co.barclays.exercise.common.ent.VatRate;
import uk.co.barclays.exercise.common.exception.VatRateReadException;
import uk.co.barclays.exercise.read.VatRateRead;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Read data from http://jsonvat.com/
 *
 * @author Ficek Daniel
 */
public class VatRateReadJsonVatCom implements VatRateRead {

    private static String URL_SOURCE = "http://jsonvat.com/";

    @Override
    public List<VatRate> readRates() throws VatRateReadException {
        List<VatRate> data = new ArrayList<>();

        String rawData = readDataFromUrl();
        Gson gson = new GsonBuilder().setLenient().create();
        JsonVatRoot jsonVatRoot = gson.fromJson(rawData, JsonVatRoot.class);

        if (jsonVatRoot.rates != null) {
            data = jsonVatRoot.rates.stream().map(rate -> findRate(rate)).filter(rate -> rate.getRate() != null).collect(Collectors.toList());
        }

        return data;
    }

    private String readDataFromUrl() throws VatRateReadException {
        InputStream inputStream = null;
        try {
            inputStream = new URL(URL_SOURCE).openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));

            StringBuilder buffer = new StringBuilder();
            int readChar;
            while ((readChar = bufferedReader.read()) != -1) {
                buffer.append((char) readChar);
            }

            return buffer.toString();
        } catch (IOException ex) {
            throw new VatRateReadException("Cannot read data from URL " + URL_SOURCE, ex);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    System.out.println("Fatal exception: Cannot close stream to the source URL: " + ex.getMessage());
                }
            }
        }
    }

    private VatRate findRate(JsonVatRate jsonVatRate) {
        String name = jsonVatRate.name == null ? "" : jsonVatRate.name;
        BigDecimal rate = null;

        if (jsonVatRate.periods != null && jsonVatRate.periods.size() > 0) {
            Comparator<JsonVatPeriod> comparatorEffectiveFrom = (p1, p2) -> p1.effective_from.compareTo(p2.effective_from);
            jsonVatRate.periods.sort(comparatorEffectiveFrom.reversed());
            rate = BigDecimal.valueOf(jsonVatRate.periods.get(0).rates.standard);
        }

        return new VatRate(name, rate);
    }

}
