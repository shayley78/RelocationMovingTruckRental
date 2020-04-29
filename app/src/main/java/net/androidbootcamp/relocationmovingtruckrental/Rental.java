package net.androidbootcamp.relocationmovingtruckrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Rental extends AppCompatActivity {
    float decMileageRate = 0.99f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental);
        TextView totalCost = (TextView)findViewById(R.id.txtRentalCost);
        ImageView image = (ImageView) findViewById(R.id.imgTruck);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        float decTruckPrice = sharedPref.getFloat("key1", 0);
        int intMiles = sharedPref.getInt("key2", 0);
        float decTotal;

        decTotal = decTruckPrice + (intMiles * decMileageRate);
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        totalCost.setText("Total Cost plus mileage " + currency.format(decTotal));
        if(decTruckPrice == 19.95f) {
            image.setImageResource(R.drawable.tenfeet);
        }
        if(decTruckPrice == 29.95f) {
            image.setImageResource(R.drawable.seventeenfeet);
        }
        if(decTruckPrice == 39.95f) {
            image.setImageResource(R.drawable.twentysixfeet);
        }
    }
}
