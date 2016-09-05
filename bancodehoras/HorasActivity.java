package usuario.app.bancodehoras;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


public class HorasActivity extends AppCompatActivity {

    EditText horaChegada,horaSaida,minSaida,minChegada ;
    Button bttela2, bttelaprincipal,btcalendario,btsalva,bttconsulta;
    int year_x,month_x,day_x;
    static final int DILOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horas);


        CarregarTelaPrincipal(); //chama a tela principal

    }

    public void CarregarTelaPrincipal() { //a função em si
        setContentView(R.layout.activity_horas);
        bttela2 = (Button) findViewById(R.id.bttela2);
        bttela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cal = Calendar.getInstance();
                year_x = cal.get(Calendar.YEAR);
                month_x = cal.get(Calendar.MONTH);
                day_x  = cal.get(Calendar.DAY_OF_MONTH);
                CarregarTela2();
                //showDialogOnButtonClick();//qnd a tela 2 é carrega chama essa função do calendario

            }
        });
    }

    public void CarregarTela2() {
        setContentView(R.layout.tela2);
        bttelaprincipal = (Button) findViewById(R.id.bttelaprincipal);
        bttelaprincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarregarTelaPrincipal();

            }
        });


        //funcao botao salva
        horaChegada = (EditText) findViewById(R.id.horaChegada);
        horaSaida = (EditText) findViewById(R.id.horaSaida);
        minChegada = (EditText) findViewById(R.id.minChegada);
        minSaida = (EditText) findViewById(R.id.minSaida);
        btsalva = (Button) findViewById(R.id.btsalva);
        btsalva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BDcontrola crud = new BDcontrola(getBaseContext());


                //funções para o botão salva

                String hora1 = horaChegada.getText().toString();
                //int horachega = Integer.parseInt(hora1);
                String hora2 = horaSaida.getText().toString();
                // int horasaida = Integer.parseInt(hora2);
                String min1 = minChegada.getText().toString();
                // int minchega = Integer.parseInt(min1);
                String min2 = minSaida.getText().toString();
                //int minsaida = Integer.parseInt(min2);
                String resultado;
                resultado = crud.insereDado(hora1,hora2,min1,min2);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();






            }
        });
    }
    /*

        //meu codigo que faz abrir o calendário

    public void showDialogOnButtonClick(){
        btcalendario = (Button) findViewById(R.id.btcalendario);

        btcalendario.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DILOG_ID);

                    }
                });

    }
    @Override
    protected Dialog onCreateDialog(int id){
        if (id == DILOG_ID)
            return new DatePickerDialog(this, dpickerListner,year_x,month_x,day_x);
        return null;


    }
    private DatePickerDialog.OnDateSetListener dpickerListner
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear + 1;
            day_x = dayOfMonth;
            Toast.makeText(HorasActivity.this,year_x  + "/" + month_x + "/" + day_x, Toast.LENGTH_LONG).show();
        }
    };*/


}







