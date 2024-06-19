import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.net.URI;

public class Servico {
    double conversion_result;
    static String Chave = "530a8fe8e21bfc754168cd62";
    static String URL = "https://v6.exchangerate-api.com/v6/"+Chave+"/pair/";

    public Servico (Resultado resultado) {
        this.conversion_result = resultado.conversion_result();
    }

    public static void chamarValor(String base, String conversao, double valor) throws IOException, InterruptedException {



        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + base + "/" + conversao + "/" + valor ))
                .build();

        HttpResponse<String> resposta = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = resposta.body();

        Gson gson = new Gson();
        Resultado juno = gson.fromJson(json, Resultado.class);

        Servico servico = new Servico(juno);
        System.out.println("O valor convertido é: ");
        System.out.println(servico.conversion_result);

        FileWriter convertido = new FileWriter("conversão.json");
        convertido.write(gson.toJson(servico));
        convertido.close();

    }
}

