import java.util.Scanner;
import java.util.InputMismatchException;

public class VerificaFibonacci {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Verificador de Sequência de Fibonacci ===");
        System.out.print("Digite um número para verificar se pertence à sequência de Fibonacci: ");
        
        try {
            int numero = scanner.nextInt();
        
        if (pertenceAFibonacci(numero)) {
            System.out.println("\nO número " + numero + " PERTENCE à sequência de Fibonacci!");
        } else {
            System.out.println("\nO número " + numero + " NÃO pertence à sequência de Fibonacci!");
        }
        
            exibirSequenciaFibonacci(numero);
        } catch (InputMismatchException e) {
            System.out.println("\nErro: Por favor, digite um número inteiro válido!");
        } finally {
            scanner.close();
        }
    }
    

    public static boolean pertenceAFibonacci(int numero) {
       
        if (numero == 0 || numero == 1) {
            return true;
        }
        
        int a = 0;
        int b = 1;
        int c;
        
        while (b < numero) {
            c = a + b;
            a = b;
            b = c;
            
            if (b == numero) {
                return true;
            }
        }
        
        return false;
    }
    
   
    public static void exibirSequenciaFibonacci(int limite) {
        System.out.println("\nSequência de Fibonacci até próximo de " + limite + ":");
        
        int a = 0;
        int b = 1;
        int c;
        
        System.out.print(a + ", " + b);
        
        while (true) {
            c = a + b;
            if (c > limite * 2) break;
            
            System.out.print(", " + c);
            a = b;
            b = c;
        }
        
        System.out.println();
    }
}