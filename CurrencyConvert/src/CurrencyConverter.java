import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private Map<String, Currency> currencies;
    private Currency baseCurrency;

    public CurrencyConverter() {
        currencies = new HashMap<>();

        baseCurrency = new Currency("IDR", 1.0);
        currencies.put("IDR", baseCurrency);

        currencies.put("USD", new Currency("USD", 16450.0));
        currencies.put("EUR", new Currency("EUR", 16450.0));
    }

    public void addCurrency(String code, double exchangeRate){
        currencies.put(code, new Currency(code, exchangeRate));
    }

    public void updateCurrency(String code, double newRate){
        Currency currency = currencies.get(code);
        if(currency != null){
            currency.setExchangeRate(newRate);
        } else {
            System.out.println("Error: Currency " + code + " not found");
        }
    }

    public double convert(double amount, String fromCode, String toCode) throws IllegalArgumentException{
        Currency fromCurrency = currencies.get(fromCode);
        Currency toCurrency = currencies.get(toCode);

        if (fromCurrency == null || toCurrency == null) {
            throw new IllegalArgumentException("Error: Currency " + fromCode + " not found");
        }

        double amountInBase = amount * fromCurrency.getExchangeRate();
        double result = amountInBase / toCurrency.getExchangeRate();
        return result;
    }

    public void printConversion(double amount, String fromCode, String toCode) {
        try {
            double result = convert(amount, fromCode, toCode);
            String format =  String.format("%.2f", result);
            System.out.println(amount + " " + fromCode + " Equals To: " + format + " " + toCode);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
