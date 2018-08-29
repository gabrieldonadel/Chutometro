package br.com.fr0mspace.chutometro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView texto;
    private Button botaoChute;
    private Button easy;
    private Button medium;
    private Button hard;
    private Button expert;
    private EditText chute;
    private int count;
    private int n;
    private int minimo = 0;
    private int maximo = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        geraNumero();
        atualizaTexto();
        botaoChute = (Button) findViewById(R.id.botaoChute) ;
        botaoChute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chutar();
            }
        });
        easy = (Button) findViewById(R.id.easy) ;
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alteraDificuldade(1);
            }
        });
        medium = (Button) findViewById(R.id.medium) ;
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alteraDificuldade(2);
            }
        });
        hard = (Button) findViewById(R.id.hard) ;
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alteraDificuldade(3);
            }
        });
        expert = (Button) findViewById(R.id.expert) ;
        expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alteraDificuldade(5);
            }
        });
    }

    private void atualizaTexto(){
        texto = (TextView) findViewById(R.id.texto);
        texto.setText("Seu numero está entre "+minimo+" e "+maximo);
    }

    private void chutar(){
        chute = (EditText) findViewById(R.id.chute);
        int numeroChutado = Integer.parseInt(chute.getText().toString());
        if(numeroChutado == n){
            venceu();
        }else {
            if (numeroChutado > n && numeroChutado < maximo){
                maximo = numeroChutado;
            }else if(numeroChutado < n && numeroChutado > minimo){
                minimo = numeroChutado;
            }
            atualizaTexto();
            count++;
        }
    }

    private void venceu(){
        texto = (TextView) findViewById(R.id.texto);
        texto.setText("Caraca em não é q você acertou? Mas também depois de "+count +" tentativas.");
    }

    private void alteraDificuldade(int expoente){
        minimo = 0;
        maximo = (int) Math.pow(10,expoente);
        count=0;
        geraNumero();
        atualizaTexto();
    }

    private void geraNumero(){
        Random rand = new Random();
        n = rand.nextInt(maximo) + minimo;
    }
}
