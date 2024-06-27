
import br.com.conversor.controllers.ConversorController;
import br.com.conversor.modelos.MeuHttpClient;
import br.com.conversor.views.ConversorView;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConversorView view = new ConversorView();
        MeuHttpClient meuHttpClient = new MeuHttpClient();
        ConversorController controller = new ConversorController(view, meuHttpClient);

        controller.iniciar();
    }
}
