import java.util.HashMap;

public class CurrencyConverter {

    private HashMap<String, Double> rates;

    public CurrencyConverter(HashMap<String, Double> rates) {
        this.rates = rates;
    }

    public double convert(String from, String to, double amount) {
        double rate = rates.get(to) / rates.get(from);
        return amount * rate;
    }
}
