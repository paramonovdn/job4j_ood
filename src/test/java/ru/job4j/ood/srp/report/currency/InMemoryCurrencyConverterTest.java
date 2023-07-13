package ru.job4j.ood.srp.report.currency;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryCurrencyConverterTest {
    @Test
    public void whenConvertingAllValutes() {
        InMemoryCurrencyConverter inMemoryCurrencyConverter = new InMemoryCurrencyConverter();
        Double value = 100D;

        double rubToUsd = inMemoryCurrencyConverter.convert(Currency.RUB, value, Currency.USD);
        double rubToEur = inMemoryCurrencyConverter.convert(Currency.RUB, value, Currency.EUR);
        double usdToRub = inMemoryCurrencyConverter.convert(Currency.USD, value, Currency.RUB);
        double usdToEur = inMemoryCurrencyConverter.convert(Currency.USD, value, Currency.EUR);
        double eurToURub = inMemoryCurrencyConverter.convert(Currency.EUR, value, Currency.RUB);
        double eurToUsd = inMemoryCurrencyConverter.convert(Currency.EUR, value, Currency.USD);

        assertThat(rubToUsd).isEqualTo(1.6199999999999999);
        assertThat(rubToEur).isEqualTo(1.66);
        assertThat(usdToRub).isEqualTo(6500.0);
        assertThat(usdToEur).isEqualTo(102.18);
        assertThat(eurToURub).isEqualTo(6300.0);
        assertThat(eurToUsd).isEqualTo(97.86);
    }
}
