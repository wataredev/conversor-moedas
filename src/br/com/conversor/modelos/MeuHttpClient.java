package br.com.conversor.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MeuHttpClient {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public double obterConversao(String from, String to, double valor) throws IOException, InterruptedException {
        String endereco = "https://v6.exchangerate-api.com/v6/a9983693c0461fc01d73dc66/pair/" + from + "/" + to + "/" + valor;

        java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        ResultadoConversao resultadoConversao = gson.fromJson(json, ResultadoConversao.class);

        return resultadoConversao.conversionResult();
    }
}