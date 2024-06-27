package br.com.conversor.views;

import java.util.Scanner;

public class ConversorView {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
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
        System.out.println(conversorMoedas);
    }

    public int lerOpcao() {
        System.out.println("\nDigite a opção desejada");
        return scanner.nextInt();
    }

    public double lerValor() {
        System.out.println("\nDigite o valor que deseja converter");
        return scanner.nextDouble();
    }

    public void mostrarResultado(String moeda, double valor) {
        System.out.printf("***** Resultado ****\n%s$ %.2f%n", moeda, valor);
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void fecharScanner() {
        scanner.close();
    }
}
