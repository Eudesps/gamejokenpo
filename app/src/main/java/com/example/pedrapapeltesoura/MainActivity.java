package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        verificarGanhador("pedra");
    }
    public void selecionarPapel(View view){
        verificarGanhador("papel");
    }
    public void selecionarTesoura(View view){
        verificarGanhador("tesoura");
    }

    private String gerarEsolhadoAleatoriaApp() {
        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numeroAleatorio = new Random().nextInt(3);

        ImageView imagemApp = findViewById(R.id.img_app);
        String escolaApp = opcoes[numeroAleatorio];
        switch (escolaApp){
            case "pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }

        return  escolaApp;
    }
    int placarApp = 0, placarUsuario = 0;

    public void resetar(View view){
        placarApp = 0;
        placarUsuario = 0;

        TextView resetPlacarApp = findViewById(R.id.placarApp);
        resetPlacarApp.setText(String.valueOf(placarApp));

        TextView resetPlacarUser = findViewById(R.id.placarUsuario);
        resetPlacarUser.setText(String.valueOf(placarUsuario));
    }
    private void verificarGanhador( String escolhaUsuario){
        String escolhaApp = gerarEsolhadoAleatoriaApp();

        if(
            (escolhaApp.equals("pedra") && escolhaUsuario.equals("tesoura"))||
            (escolhaApp.equals("papel") && escolhaUsuario.equals("pedra")) ||
            (escolhaApp.equals("tesoura") && escolhaUsuario.equals("papel"))){

            TextView texto = findViewById(R.id.resultado);
            String resultadoJogo = "você perdeu :(";
            texto.setText(resultadoJogo);

            placarApp += 1;
            TextView placar = findViewById(R.id.placarApp);
            placar.setText(String.valueOf(placarApp));
        }else if(
           (escolhaUsuario.equals("pedra") && escolhaApp.equals("tesoura"))
        || (escolhaUsuario.equals("papel") && escolhaApp.equals("pedra"))
        || (escolhaUsuario.equals("tesoura") && escolhaApp.equals("papel"))
        ){
            TextView texto = findViewById(R.id.resultado);
            String resultadoJogo = "você ganhou :)";
            texto.setText(resultadoJogo);

            placarUsuario += 1;
            TextView placar = findViewById(R.id.placarUsuario);
            placar.setText(String.valueOf(placarUsuario));

        }else{
            TextView texto = findViewById(R.id.resultado);
            String resultadoJogo = "empate";
            texto.setText(resultadoJogo);
        }
    }
}