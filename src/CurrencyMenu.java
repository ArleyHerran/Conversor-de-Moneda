import java.util.Scanner;

public class CurrencyMenu {

    // Códigos de color ANSI
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";


    private CurrencyConverter converter;

    public CurrencyMenu(CurrencyConverter converter) {
        this.converter = converter;
    }



    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean continueConverting = false;

        // Mostrar primera opción de mostrar el menú o salir
        do {
            System.out.println(CYAN + " ___________________________________" + RESET);
            System.out.println(CYAN + "|        CONVERSOR DE MONEDA        |" + RESET);
            System.out.println(CYAN + "|           By Arley Herran         |" + RESET);
            System.out.println(CYAN + "|___________________________________|" + RESET);
            System.out.println(YELLOW + "\n1. Mostrar menú" + RESET);
            System.out.println(RED + "2. Salir" + RESET);
            System.out.print(YELLOW + "Seleccione una opción: " + RESET);
            option = scanner.nextInt();

            if (option == 1) {
                continueConverting = true; // Si elige '1', entramos al bucle del menú
            } else if (option == 2) {
                System.out.println(RED + "Saliendo..." + RESET);
                return; // Terminamos el programa
            } else {
                System.out.println(RED + "Opción no válida. Intente de nuevo." + RESET);
            }
        } while (!continueConverting);

        // Bucle para mostrar el menú y realizar conversiones
        do {
            System.out.println(CYAN + " ___________________________________" + RESET);
            System.out.println(CYAN + "|        CONVERSOR DE MONEDA        |" + RESET);
            System.out.println(CYAN + "|           By Arley Herran         |" + RESET);
            System.out.println(CYAN + "|___________________________________|" + RESET);
            System.out.println(YELLOW + "\nSeleccione la opción de conversión:" + RESET);
            System.out.println(GREEN + "1. Dólar a Peso Argentino" + RESET);
            System.out.println(GREEN + "2. Peso Argentino a Dólar" + RESET);
            System.out.println(GREEN + "3. Real Brasileño a Dólar" + RESET);
            System.out.println(GREEN + "4. Dólar a Real Brasileño" + RESET);
            System.out.println(GREEN + "5. Dólar a Peso Colombiano" + RESET);
            System.out.println(GREEN + "6. Peso Colombiano a Dólar" + RESET);
            System.out.println(RED + "7. Salir" + RESET);
            System.out.print(YELLOW + "Opción: " + RESET);
            int conversionOption = scanner.nextInt();

            if (conversionOption >= 1 && conversionOption <= 6) {
                System.out.print("Ingrese la cantidad a convertir: ");
                double amount = scanner.nextDouble();
                performConversion(conversionOption, amount); // Realiza la conversión
            } else if (conversionOption == 7) {
                System.out.println(RED + "Saliendo..." + RESET);
                return; // Termina el programa si elige '7'
            } else {
                System.out.println(RED + "Opción no válida." + RESET);
            }

            // Después de la conversión, preguntar si desea hacer otra
            System.out.print(YELLOW + "\n¿Desea hacer una nueva conversión? Presione '1' para sí o '2' para salir: " + RESET);
            option = scanner.nextInt();
            if (option == 2) {
                System.out.println(RED + "Saliendo..." + RESET);
                continueConverting = false; // Salir del bucle
            }

        } while (continueConverting);
    }


    private void performConversion(int option, double amount) {
        String fromCurrency = "";
        String toCurrency = "";

        switch (option) {
            case 1:
                fromCurrency = "USD";
                toCurrency = "ARS";
                break;
            case 2:
                fromCurrency = "ARS";
                toCurrency = "USD";
                break;
            case 3:
                fromCurrency = "BRL";
                toCurrency = "USD";
                break;
            case 4:
                fromCurrency = "USD";
                toCurrency = "BRL";
                break;
            case 5:
                fromCurrency = "USD";
                toCurrency = "COP";
                break;
            case 6:
                fromCurrency = "COP";
                toCurrency = "USD";
                break;
        }

        double result = converter.convert(fromCurrency, toCurrency, amount);
        System.out.printf("Resultado: %.2f %s\n", result, toCurrency);
    }
}

