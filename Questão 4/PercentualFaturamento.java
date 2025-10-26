public class PercentualFaturamento {
    
    public static void main(String[] args) {
      
        double faturamentoSP = 67836.43;
        double faturamentoRJ = 36678.66;
        double faturamentoMG = 29229.88;
        double faturamentoES = 27165.48;
        double faturamentoOutros = 19849.53;
        
        double valorTotal = faturamentoSP + faturamentoRJ + faturamentoMG + faturamentoES + faturamentoOutros;
        
        double percentualSP = (faturamentoSP / valorTotal) * 100;
        double percentualRJ = (faturamentoRJ / valorTotal) * 100;
        double percentualMG = (faturamentoMG / valorTotal) * 100;
        double percentualES = (faturamentoES / valorTotal) * 100;
        double percentualOutros = (faturamentoOutros / valorTotal) * 100;
        
        System.out.println("Percentual de representação por estado no faturamento total:");
        System.out.printf("SP: %.2f%%\n", percentualSP);
        System.out.printf("RJ: %.2f%%\n", percentualRJ);
        System.out.printf("MG: %.2f%%\n", percentualMG);
        System.out.printf("ES: %.2f%%\n", percentualES);
        System.out.printf("Outros: %.2f%%\n", percentualOutros);
        
        System.out.printf("\nValor total do faturamento: R$ %.2f\n", valorTotal);
    }
}