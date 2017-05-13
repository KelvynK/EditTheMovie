package com.video.startup.projetovideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Diogo on 21/04/2017.
 */

public class LoginActivity extends  Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonCriar = (Button) findViewById(R.id.buttonCadastrar);
        Button buttonLogar = (Button) findViewById(R.id.buttonLogar);}

        public void telaCadastrar(View v){
            Intent intent = new Intent(LoginActivity.this,CriarUsuario.class);
            startActivity(intent);
        }
        public void telaPrincipal(View v){
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
    }
    }


