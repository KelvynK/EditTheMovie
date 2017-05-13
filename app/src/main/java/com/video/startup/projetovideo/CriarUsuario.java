package com.video.startup.projetovideo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.video.startup.projetovideo.Models.Usuario;
import com.video.startup.projetovideo.Util.Util;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by Diogo on 24/04/2017.
 */

public class CriarUsuario extends Activity {

    EditText editTextNome;
    EditText editTextTelefone;
    EditText editTextEmail;
    EditText editTextLogin;
    EditText editTextSenha;
    Usuario usuario;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criarusuario);

    }
    public void buttoCriar(View v) {
        usuario = new Usuario();

        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextLogin = (EditText) findViewById(R.id.editTextLogin);
        editTextSenha = (EditText) findViewById(R.id.editTextSenha);

        usuario.setNome(editTextNome.getText().toString());
        usuario.setTelefone(editTextTelefone.getText().toString());
        usuario.setEmail(editTextEmail.getText().toString());
        usuario.setLogin(editTextLogin.getText().toString());
        usuario.setSenha(editTextSenha.getText().toString());
        new UploadToJson().execute(usuario);


    }
    private class UploadToJson extends AsyncTask<Usuario, Void, String>
    {
        boolean isConnected = false;
        ProgressDialog progress;
        int serverResponseCode;
        String serverResponseMessage;

        protected void onPreExecute(){

            ConnectivityManager cm =
                    (ConnectivityManager)CriarUsuario.this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            isConnected = activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();

            if(isConnected) {
                progress = new ProgressDialog(CriarUsuario.this);
                progress.setMessage("Aguarde o Download dos Dados");
                progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progress.setProgress(0);
                progress.show();
            }
            else{
                Toast.makeText(CriarUsuario.this, "Verifique a conexão com a internet...", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected String doInBackground(Usuario... params) {
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL("http://10.0.3.2:9999/ProjetoStartUP2/WS/Usuario/Cadastrar");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-type", "application/json");
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);

                DataOutputStream outputStream = new DataOutputStream(urlConnection.getOutputStream());

                String result = Util.convertUsuariotoJSON(params[0]);
                outputStream.writeBytes(result);

                serverResponseCode = urlConnection.getResponseCode();
                serverResponseMessage = urlConnection.getResponseMessage();

                outputStream.flush();
                outputStream.close();

                return result;
            } catch (Exception e) {
                Log.e("Error", "Error ", e);
                return null;
            } finally{
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
        }
    }

        }





