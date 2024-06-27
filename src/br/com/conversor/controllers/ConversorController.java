package br.com.conversor.controllers;
import br.com.conversor.modelos.MeuHttpClient;
import br.com.conversor.views.ConversorView;
import java.io.IOException;

public class ConversorController {

    private final ConversorView view;
    private final MeuHttpClient meuHttpClient;

    public ConversorController(ConversorView view, MeuHttpClient meuHttpClient) {
        this.view = view;
        this.meuHttpClient = meuHttpClient;
    }
    public void iniciar() throws IOException, InterruptedException {
        view.mostrarMenu();
        int escolha = 0;

        while (escolha != 6) {
            escolha = view.lerOpcao();

            switch (escolha) {
                case 1:
                    processarConversao("BRL", "USD", "US$");
                    break;
                case 2:
                    processarConversao("USD", "BRL", "R$");
                    break;
                case 3:
                    processarConversao("BRL", "ARS", "ARS$");
                    break;
                case 4:
                    processarConversao("EUR", "BRL", "R$");
                    break;
                case 5:
                    processarConversao("CNY", "BRL", "R$");
                    break;
                case 6:
                    break;
                default:
                    view.mostrarMensagem("\n*** Digite uma opção válida! ***");
                    break;
            }
        }
        view.fecharScanner();
    }

    private void processarConversao(String from, String to, String simbolo) throws IOException, InterruptedException {
        double valor = view.lerValor();
        double resultado = meuHttpClient.obterConversao(from, to, valor);
        view.mostrarResultado(simbolo, resultado);
    }
}