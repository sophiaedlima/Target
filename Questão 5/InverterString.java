import java.util.Scanner;

public class InverterString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string para inverter: ");
        String input = scanner.nextLine();
        scanner.close();

        if (input == null || input.isEmpty()) {
            System.out.println("Entrada vazia. Nada para inverter.");
            return;
        }

        String invertida = inverterString(input);
        System.out.println("Original: " + input);
        System.out.println("Invertida: " + invertida);
    }
    private static String inverterString(String str) {
        char[] caracteres = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            caracteres[i] = str.charAt(str.length() - 1 - i);
        }
        return new String(caracteres);
    }
}