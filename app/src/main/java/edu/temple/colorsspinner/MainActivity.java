package edu.temple.colorsspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Object Declaration

        //This is the object declared as a view to make it easier to change colors
        final View window = this.getWindow().getDecorView();
        //This is the Dropdown Spinner
        Spinner spinner = findViewById(R.id.spinner);

        //Color Array
        String[] colors = {"White", "Blue", "Magenta", "Cyan", "Black", "Yellow", "Purple",
                "Lime", "Red", "Gray"};

        ColorAdapter adapter = new ColorAdapter(MainActivity.this, colors);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                window.setBackgroundColor(Color.parseColor(adapterView.getItemAtPosition(position).toString()));
                view.setBackgroundColor(Color.parseColor("White"));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}