import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        String conversorMoedas = """
                ************* BEM-VINDO/A AO CONVERSOR DE MOEDAS!!! *************
                
                1 - REAL PARA DOLAR * BRL / USD
                2 - DOLAR PARA REAL * USD / BRL
                3 - REAL PARA PESO ARGENTINO * BRL / ARS
                4 - EURO PARA REAL * EUR / BRL
                5 - YUAN PARA REAL * CNY/BRL
                6 - SAIR
                
                *****************************************************************
                """;

        MeuHttpClient meuHttpClient = new MeuHttpClient();
        System.out.println(conversorMoedas);

        int escolha = 0;

        while (escolha != 6) {
            System.out.println("\n Digite a opção desejada");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("\n Digite o valor que deseja converter de Reais para Dólares");
                    meuHttpClient.setValor(scanner.nextDouble());
                    meuHttpClient.httpRequest();
                    System.out.println("***** Resultado ****");
                    System.out.println("US$ " + meuHttpClient.getBrlUsd());
                    break;
                case 2:
                    System.out.println("\nDigite o valor que deseja converter de Dólares para Reais");
                    meuHttpClient.setValor(scanner.nextDouble());
                    meuHttpClient.httpRequest();
                    System.out.println("***** Resultado ****");
                    System.out.println("RS$ " + meuHttpClient.getUsdBrl());
                    break;
                case 3:
                    System.out.println("\nDigite o valor que deseja converter de Reais para Pesos Argentinos");
                    meuHttpClient.setValor(scanner.nextDouble());
                    meuHttpClient.httpRequest();
                    System.out.println("***** Resultado ****");
                    System.out.println("ARS$ " + meuHttpClient.getBrlArs());
                    break;
                case 4:
                    System.out.println("\nDigite o valor que deseja converter de Euro para Reais");
                    meuHttpClient.setValor(scanner.nextDouble());
                    meuHttpClient.httpRequest();
                    System.out.println("***** Resultado ****");
                    System.out.println("RS$ " + meuHttpClient.getEurBrl());
                    break;
                case 5:
                    System.out.println("\nDigite o valor que deseja converter de Yuan para Reais");
                    meuHttpClient.setValor(scanner.nextDouble());
                    meuHttpClient.httpRequest();
                    System.out.println("***** Resultado ****");
                    System.out.println("RS$ " + meuHttpClient.getCnyBrl());
                    break;
                default:
                    if (escolha == 6) {
                        break;
                    } else {
                        System.out.println("\n*** Digite uma opção válida! ***");
                    }

                    break;

            }
        }

        scanner.close();


    }

}
