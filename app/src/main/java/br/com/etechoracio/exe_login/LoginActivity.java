package br.com.etechoracio.exe_login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.etechoracio.boaviagem.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editUsuario;
    private EditText editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.editSenha = findViewById(R.id.editSenha);
        this.editUsuario = findViewById(R.id.editUsuario);

    }

    public void onLogin(View v){
        Editable usuario = this.editUsuario.getText();
        Editable senha = this.editSenha.getText();
        String user = usuario.toString();
        String pass = senha.toString();
        Toast obj = Toast.makeText(this,"Login efetuado com sucesso",Toast.LENGTH_SHORT);

        if(user.equals("admin") && pass.equals("admin")){
            obj.show();
        }

    }
}
