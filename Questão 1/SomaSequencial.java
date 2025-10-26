public class SomaSequencial {
    public static void main(String[] args) {
        final int INDICE = 13;
        int soma = calcularSoma(INDICE);

        System.out.println("Cálculo da soma de 1 até " + INDICE + ":");
        System.out.println("SOMA = " + soma);
    }

    private static int calcularSoma(int n) {
        int soma = 0;
        int k = 0;
        while (k < n) {
            k = k + 1;
            soma = soma + k;
        }
        return soma;
    }
}