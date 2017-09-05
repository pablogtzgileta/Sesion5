package pablogtzgileta.com.sesion5;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import pablogtzgileta.com.sesion5.beans.Alumno;

public class ActivityMain extends AppCompatActivity {

    RadioButton femaleRadioBtn;
    RadioButton maleRadioBtn;
    EditText userName;
    EditText userPhone;
    Spinner userGrade;
    Button cleanBtn;
    AutoCompleteTextView booksET;
    CheckBox userSport;
    Alumno student;

    private static final String[] BOOKS = new String[] {
            "The Sixth Extinction", "Business Adventures", "The Vital Question", "String Theory", "Tap Dancing to Work"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cleanBtn = (Button) findViewById(R.id.clean_btn);
        userName = (EditText) findViewById(R.id.input_name);
        userPhone = (EditText) findViewById(R.id.input_phone);
        userGrade = (Spinner) findViewById(R.id.input_grade);
        booksET = (AutoCompleteTextView) findViewById(R.id.input_book);
        maleRadioBtn = (RadioButton) findViewById(R.id.radio_male);
        userSport = (CheckBox) findViewById(R.id.input_sport);
        femaleRadioBtn = (RadioButton) findViewById(R.id.radio_female);
        femaleRadioBtn.toggle();

        cleanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ActivityMain.this);
                dialog.setMessage("Desea limpiar el contenido?")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                cleanValues();
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Do nothing
                            }
                        }).show();
            }
        });

        ArrayAdapter<String> booksAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, BOOKS);
        booksET.setAdapter(booksAdapter);
    }

    public void cleanValues() {
        userName.setText("");
        userPhone.setText("");
        userGrade.setSelection(0);
        booksET.setText("");
        femaleRadioBtn.setChecked(true);
        userSport.setChecked(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.activity_main_save:
                saveValues();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void saveValues() {
        String sex = (femaleRadioBtn.isChecked()) ? "Femenino" : "Masculino";
        student = new Alumno(userName.getText().toString(),
                userPhone.getText().toString(), userGrade.getSelectedItem().toString(),
                sex, booksET.getText().toString(), userSport.isChecked());

        Toast.makeText(ActivityMain.this, student.toString(), Toast.LENGTH_LONG).show();
        cleanValues();
    }
}
