package com.example.firstproject;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    EditText name;
    Button ok;
    TextView result;
    String username;
    ImageView image;
    CheckBox male, female;
    RadioGroup radioGroup;
    RadioButton green, red, yellow;
    LinearLayout linearLayout;
    ToggleButton toggleButton;
    Spinner spinner;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ok = findViewById(R.id.buttonOK);
        image = findViewById(R.id.imageExample);
        radioGroup = findViewById(R.id.group);
        linearLayout = findViewById(R.id.linear);
        toggleButton = findViewById(R.id.toggleButtonShow);
        spinner = findViewById(R.id.spinnerCountry);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);
        // define three parameters in here
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String country = adapterView.getItemAtPosition(i).toString();
                result.setText(country);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(green.isChecked()){
                    linearLayout.setBackgroundColor(Color.GREEN);
                }
                else if(red.isChecked()){
                    linearLayout.setBackgroundColor(Color.RED);
                }
                else if(yellow.isChecked()){
                    linearLayout.setBackgroundColor(Color.YELLOW);
                }
            }
        });

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(male.isChecked()){
                    result.setText("Male");
                    female.setChecked(false);
                }
                else{
                    result.setText("What is your gender?");
                }
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(male.isChecked()){
                    result.setText("Female");
                    male.setChecked(false);
                }
                else{
                    result.setText("What is your gender?");
                }
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.spaceship);
                Toast.makeText(getApplicationContext(), "Toast message will be displayed", Toast.LENGTH_SHORT).show();
                Snackbar.make(linearLayout, "Snack bar message displayed.", Snackbar.LENGTH_INDEFINITE).setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).show();
                showDialogMessage();
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    image.setVisibility(View.INVISIBLE);
                    result.setText("Image is hidden");
                }
                else{
                    image.setVisibility(View.VISIBLE);
                    result.setText("Image is shown");
                }
            }
        });
    }

    private void showDialogMessage() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Delete")
                .setMessage("Wanna delete text?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        result.setText("");
                    }
                }).show();
        alertDialog.create();
    }
}