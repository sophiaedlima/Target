import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AnaliseFaturamentoMultiFormato {
    
    static class DadoFaturamento {
        int dia;
        double valor;
        
        public DadoFaturamento(int dia, double valor) {
            this.dia = dia;
            this.valor = valor;
        }
    }
    
    public static void main(String[] args) {
        // Definir caminhos completos para os arquivos
        String caminhoXML = "c:\\Users\\sophi\\Target\\Target\\Questão 3\\faturamento.xml";
        String caminhoJSON = "c:\\Users\\sophi\\Target\\Target\\Questão 3\\faturamento.json";
        
        // Analisar dados do arquivo XML
        List<DadoFaturamento> dadosXML = lerArquivoXML(caminhoXML);
        analisarEExibirResultados(dadosXML, "XML");
        
        System.out.println("\n----------------------------------------\n");
        
        // Analisar dados do arquivo JSON
        List<DadoFaturamento> dadosJSON = lerArquivoJSON(caminhoJSON);
        analisarEExibirResultados(dadosJSON, "JSON");
    }
    

    private static List<DadoFaturamento> lerArquivoXML(String nomeArquivo) {
        List<DadoFaturamento> dados = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            StringBuilder conteudo = new StringBuilder();
            String linha;
            
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha.trim());
            }
            
            Pattern pattern = Pattern.compile("<row>\\s*<dia>(\\d+)</dia>\\s*<valor>([\\d.]+)</valor>\\s*</row>");
            Matcher matcher = pattern.matcher(conteudo);
            
            while (matcher.find()) {
                int dia = Integer.parseInt(matcher.group(1));
                double valor = Double.parseDouble(matcher.group(2));
                dados.add(new DadoFaturamento(dia, valor));
            }
            
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo XML: " + e.getMessage());
        }
        
        return dados;
    }
    
    private static List<DadoFaturamento> lerArquivoJSON(String nomeArquivo) {
        List<DadoFaturamento> dados = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            StringBuilder conteudo = new StringBuilder();
            String linha;
            
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha.trim());
            }
            
            Pattern pattern = Pattern.compile("\\{\\s*\"dia\"\\s*:\\s*(\\d+)\\s*,\\s*\"valor\"\\s*:\\s*([\\d.]+)\\s*\\}");
            Matcher matcher = pattern.matcher(conteudo);
            
            while (matcher.find()) {
                int dia = Integer.parseInt(matcher.group(1));
                double valor = Double.parseDouble(matcher.group(2));
                dados.add(new DadoFaturamento(dia, valor));
            }
            
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }
        
        return dados;
    }
    
    private static void analisarEExibirResultados(List<DadoFaturamento> dados, String formato) {
        if (dados.isEmpty()) {
            System.out.println("Nenhum dado de faturamento encontrado no formato " + formato);
            return;
        }
        
        double menorFaturamento = calcularMenorFaturamento(dados);
        
        double maiorFaturamento = calcularMaiorFaturamento(dados);
        
        double mediaMensal = calcularMediaMensal(dados);
        
    
        int diasAcimaMedia = contarDiasAcimaMedia(dados, mediaMensal);
        
  
        System.out.println("=== Análise de Faturamento Diário (" + formato + ") ===");
        System.out.printf("Menor valor de faturamento: R$ %.2f%n", menorFaturamento);
        System.out.printf("Maior valor de faturamento: R$ %.2f%n", maiorFaturamento);
        System.out.printf("Média mensal de faturamento (ignorando dias sem faturamento): R$ %.2f%n", mediaMensal);
        System.out.printf("Número de dias com faturamento acima da média mensal: %d%n", diasAcimaMedia);
    }
    
    private static double calcularMenorFaturamento(List<DadoFaturamento> dados) {
        double menor = Double.MAX_VALUE;
        
        for (DadoFaturamento dado : dados) {
            
            if (dado.valor > 0 && dado.valor < menor) {
                menor = dado.valor;
            }
        }
        
        return menor;
    }
    
 
    private static double calcularMaiorFaturamento(List<DadoFaturamento> dados) {
        double maior = 0;
        
        for (DadoFaturamento dado : dados) {
            if (dado.valor > maior) {
                maior = dado.valor;
            }
        }
        
        return maior;
    }
    
    private static double calcularMediaMensal(List<DadoFaturamento> dados) {
        double soma = 0;
        int diasComFaturamento = 0;
        
        for (DadoFaturamento dado : dados) {

            if (dado.valor > 0) {
                soma += dado.valor;
                diasComFaturamento++;
            }
        }
        
        if (diasComFaturamento == 0) {
            return 0;
        }
        
        return soma / diasComFaturamento;
    }
    
   
    private static int contarDiasAcimaMedia(List<DadoFaturamento> dados, double mediaMensal) {
        int count = 0;
        
        for (DadoFaturamento dado : dados) {
            if (dado.valor > mediaMensal) {
                count++;
            }
        }
        
        return count;
    }
}