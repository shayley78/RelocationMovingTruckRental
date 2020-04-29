package net.androidbootcamp.relocationmovingtruckrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    float tenFootRate = 19.95f;
    float seventeenFootRate = 29.95f;
    float twentySixFootRate = 39.95f;
    float decTruckChoice;
    int intMiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RadioButton tenFeet = (RadioButton)findViewById(R.id.radTenFeet);
        final RadioButton seventeenFeet = (RadioButton)findViewById(R.id.radSeventeenFeet);
        final RadioButton twentySixFeet = (RadioButton)findViewById(R.id.radTwentySixFeet);
        final EditText miles = (EditText)findViewById(R.id.txtMiles);
        Button button = (Button)findViewById(R.id.btnCalculate);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tenFeet.isChecked()) {
                    decTruckChoice = tenFootRate;
                }
                if (seventeenFeet.isChecked()) {
                    decTruckChoice = seventeenFootRate;
                }
                if (twentySixFeet.isChecked()) {
                    decTruckChoice = twentySixFootRate;
                }
                intMiles = Integer.parseInt(miles.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putFloat("key1", decTruckChoice);
                editor.putInt("key2", intMiles);
                editor.commit();
                startActivity(new Intent(MainActivity.this, Rental.class));
            }
        });



    }
}
