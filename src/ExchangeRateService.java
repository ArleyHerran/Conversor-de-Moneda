
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;
import java.util.HashMap;

public class ExchangeRateService {

    private static final String API_KEY = "d091231e8f7d74d76c392a5c"; // Usa tu clave de API de https://www.exchangerate-api.com/
    private static final String BASE_URL = " https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    public HashMap<String, Double> getRates() {
        HashMap<String, Double> rates = new HashMap<>();

        try {
            URL url = new URL(BASE_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Error en la respuesta de la API: " + responseCode);
            }

            StringBuilder inline = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()) {
                inline.append(scanner.nextLine());
            }
            scanner.close();

            JSONObject json = new JSONObject(inline.toString());
            JSONObject conversionRates = json.getJSONObject("conversion_rates");

            rates.put("USD", conversionRates.getDouble("USD"));
            rates.put("ARS", conversionRates.getDouble("ARS"));
            rates.put("BRL", conversionRates.getDouble("BRL"));
            rates.put("COP", conversionRates.getDouble("COP"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rates;
    }
}
