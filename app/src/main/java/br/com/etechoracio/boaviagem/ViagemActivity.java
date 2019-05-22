package br.com.etechoracio.boaviagem;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import br.com.etechoracio.boaviagem.enums.TipoViagemEnum;
import br.com.etechoracio.boaviagem.model.Viagem;
import br.com.etechoracio.boaviagem.utils.DateTimeUtils;

public class ViagemActivity extends AppCompatActivity {
    private Button btnDataSaida;
    private Button btnDataChegada;
    private EditText editDestino;
    private EditText editQuantidadePessoas;
    private EditText editOrcamento;
    private RadioGroup radioTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viagem);
        btnDataChegada = findViewById(R.id.btnDataChegada);
        btnDataSaida = findViewById(R.id.btnDataSaida);
        editDestino = findViewById(R.id.editDestino);
        editQuantidadePessoas = findViewById(R.id.editQuantidadePessoas);
        editOrcamento = findViewById(R.id.editOrcamento);
        radioTipo = findViewById(R.id.radioTipo);

    }

    private DatePickerDialog.OnDateSetListener datachegada = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int ano, int mes, int dia) {

            String data = String.valueOf(dia) + "/" + String.valueOf(mes + 1) + "/" + String.valueOf(ano);
            btnDataChegada.setText(DateTimeUtils.formatDate(dia, mes + 1, ano));
        }
    };
    private DatePickerDialog.OnDateSetListener datasaida = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int ano, int mes, int dia) {

            String data1 = String.valueOf(dia) + "/" + String.valueOf(mes + 1) + "/" + String.valueOf(ano);
            btnDataSaida.setText(DateTimeUtils.formatDate(dia, mes + 1, ano));

        }
    };

    protected Dialog onCreateDialog(int id) {
        Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH);
        int ano = calendario.get(Calendar.YEAR);


        switch (id) {
            case R.id.btnDataChegada:
                return new DatePickerDialog(this, datachegada, dia, mes, ano);
        }

        switch (id) {
            case R.id.btnDataSaida:
                return new DatePickerDialog(this, datasaida, dia, mes, ano);
        }
        return null;
    }

    public void onSelecionarData(View view) {
        showDialog(view.getId());
    }

    public void onSalvar(View view) {
        Viagem viagem = new Viagem();
        viagem.setDestinoo(editDestino.getText().toString());
        viagem.setDataChegada(DateTimeUtils.toDate(btnDataChegada.getText().toString()));
        viagem.setDataSaida(DateTimeUtils.toDate(btnDataSaida.getText().toString()));
        viagem.setOrcamento(Double.valueOf(editOrcamento.getText().toString()));
        viagem.setQuantidadePessoas(Integer.valueOf(editQuantidadePessoas.getText().toString()));
        viagem.setTipoViagem(TipoViagemEnum.NEGOCIOS);

        int tipo = radioTipo.getCheckedRadioButtonId();
        if (tipo == R.id.radioLazer) {
            viagem.setTipoViagem(TipoViagemEnum.LAZER);
        }
        DatabaseReference myref = FirebaseDatabase.getInstance().getReference("viagens");
        String id = myref.push().getKey();
        viagem.setId(id);
        myref.child(id).setValue(viagem);

        showInsertMessage();
    }
        private void showInsertMessage()
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Confirmação");
            builder.setMessage("Registro inserido com sucesso");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int a) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
}
