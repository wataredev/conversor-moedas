import br.com.conversor.modelos.ResultadoConversao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MeuHttpClient {

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private double valor;
    private double brlUsd;
    private double usdBrl;
    private double brlArs;
    private double eurBrl;
    private double cnyBrl;


 public double getBrlUsd() {
  return brlUsd;
 }

 public double getUsdBrl() {
  return usdBrl;
 }

 public double getBrlArs() {
  return brlArs;
 }

 public double getEurBrl() {
  return eurBrl;
 }

 public double getCnyBrl() {
  return cnyBrl;
 }

 public void setBrlUsd(double brlUsd) {
  this.brlUsd = brlUsd;
 }

 public void setUsdBrl(double usdBrl) {
  this.usdBrl = usdBrl;
 }

 public void setBrlArs(double brlArs) {
  this.brlArs = brlArs;
 }

 public void setEurBrl(double eurBrl) {
  this.eurBrl = eurBrl;
 }

 public void setCnyBrl(double cnyBrl) {
  this.cnyBrl = cnyBrl;
 }

 public void setValor(double valor) {
  this.valor = valor;
 }



 public void httpRequest() throws IOException, InterruptedException {

    String endereco1 = "https://v6.exchangerate-api.com/v6/a9983693c0461fc01d73dc66/pair/BRL/USD/" + valor;
    String endereco2 = "https://v6.exchangerate-api.com/v6/a9983693c0461fc01d73dc66/pair/USD/BRL/" + valor;
    String endereco3 = "https://v6.exchangerate-api.com/v6/a9983693c0461fc01d73dc66/pair/BRL/ARS/" + valor;
    String endereco4 = "https://v6.exchangerate-api.com/v6/a9983693c0461fc01d73dc66/pair/EUR/BRL/" + valor;
    String endereco5 = "https://v6.exchangerate-api.com/v6/a9983693c0461fc01d73dc66/pair/CNY/BRL/" + valor;

    java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();

    HttpRequest request1 = HttpRequest.newBuilder().uri(URI.create(endereco1)).build();
    HttpRequest request2 = HttpRequest.newBuilder().uri(URI.create(endereco2)).build();
    HttpRequest request3 = HttpRequest.newBuilder().uri(URI.create(endereco3)).build();
    HttpRequest request4 = HttpRequest.newBuilder().uri(URI.create(endereco4)).build();
    HttpRequest request5 = HttpRequest.newBuilder().uri(URI.create(endereco5)).build();

    HttpResponse<String> response1 = client.send(request1, HttpResponse.BodyHandlers.ofString());
    HttpResponse<String> response2 = client.send(request2, HttpResponse.BodyHandlers.ofString());
    HttpResponse<String> response3 = client.send(request3, HttpResponse.BodyHandlers.ofString());
    HttpResponse<String> response4 = client.send(request4, HttpResponse.BodyHandlers.ofString());
    HttpResponse<String> response5 = client.send(request5, HttpResponse.BodyHandlers.ofString());


    String json1 = response1.body();
    String json2 = response2.body();
    String json3 = response3.body();
    String json4 = response4.body();
    String json5 = response5.body();

    ResultadoConversao resultadoConversao1 = gson.fromJson(json1, ResultadoConversao.class);
    ResultadoConversao resultadoConversao2 = gson.fromJson(json2, ResultadoConversao.class);
    ResultadoConversao resultadoConversao3 = gson.fromJson(json3, ResultadoConversao.class);
    ResultadoConversao resultadoConversao4 = gson.fromJson(json4, ResultadoConversao.class);
    ResultadoConversao resultadoConversao5 = gson.fromJson(json5, ResultadoConversao.class);

    this.setBrlUsd(resultadoConversao1.conversionResult());
    this.setUsdBrl(resultadoConversao2.conversionResult());
    this.setBrlArs(resultadoConversao3.conversionResult());
    this.setEurBrl(resultadoConversao4.conversionResult());
    this.setCnyBrl(resultadoConversao5.conversionResult());

        }




}
