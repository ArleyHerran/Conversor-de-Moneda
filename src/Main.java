import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        ExchangeRateService exchangeRateService = new ExchangeRateService();
        HashMap<String, Double> rates = exchangeRateService.getRates();

        if (rates.isEmpty()) {
            System.out.println("No se pudieron obtener las tasas de cambio.");
            return;
        }

        CurrencyConverter converter = new CurrencyConverter(rates);
        CurrencyMenu menu = new CurrencyMenu(converter);

        menu.showMenu();
    }
}
