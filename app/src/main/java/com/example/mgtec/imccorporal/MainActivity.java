package com.example.mgtec.imccorporal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        findViewById(R.id.btnCalcular).setOnClickListener(calcular());
    }
    private View.OnClickListener calcular() {
        return new  View.OnClickListener(){
            @Override
            public void onClick (View v){
                String resultado = "";
                EditText edtAltura = (EditText) findViewById(R.id.edtAltura);
                EditText edtPeso = (EditText) findViewById(R.id.edtPeso);
                double infAltura = Double.parseDouble(edtAltura.getText().toString());
                double infPeso = Double.parseDouble(edtPeso.getText().toString());
                double total = infPeso / (infAltura * infAltura);
                if( total < 18.5 ) {
                     resultado =(getString(R.string.resultado) + String.format("%.2f", total) + " - " + getResources().getString(R.string.Abaixo_peso));
                } else if( total >= 18.5 && total <= 24.9 ) {
                      resultado = ( getString(R.string.resultado) + String.format("%.2f",total) +  " - " +getResources().getString(R.string.peso_ideal) );
                } else if( total >= 25 && total <= 29.9 ) {
                    resultado = ( getString(R.string.resultado) + String.format("%.2f",total) +  " - " +getResources().getString(R.string.acima_peso) );
                } else if( total >= 30 && total <= 34.9 ) {
                    resultado = ( getString(R.string.resultado) + String.format("%.2f",total) +  " - " +getResources().getString(R.string.obesidade_grauI) );
                } else if( total >= 35 && total <= 39.9 ) {
                    resultado = ( getString(R.string.resultado) + String.format("%.2f",total) +  " - " +getResources().getString(R.string.obesidade_grauII) );
                } else {
                    resultado = ( getString(R.string.resultado) + String.format("%.2f",total) +  " - " +getResources().getString(R.string.obsidade_grauIII) );
                }

                TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
                txtResultado.setText(resultado);
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
