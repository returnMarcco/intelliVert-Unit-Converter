package com.example.intellivert_unit_converter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign spinnerIds (from layout) to the value of these Spinner objects
        Spinner sourceUnitSpinner = findViewById(R.id.idSourceUnitSpinner);
        Spinner targetUnitSpinner = findViewById(R.id.idTargetUnitSpinner);

        // Define ArrayAdapters for populating spinners from a hard-coded String array
        ArrayAdapter<CharSequence> sourceUnitAdapter = ArrayAdapter.createFromResource(
                this, R.array.unitArray, android.R.layout.simple_spinner_item
        );

        sourceUnitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sourceUnitSpinner.setAdapter(sourceUnitAdapter);
        sourceUnitSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> targetUnitAdapter = ArrayAdapter.createFromResource(
                this, R.array.unitArray, android.R.layout.simple_spinner_item
        );

        targetUnitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        targetUnitSpinner.setAdapter(targetUnitAdapter);
        targetUnitSpinner.setOnItemSelectedListener(this);
    }

    // Callback methods required for implementing the Listener Interface
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        int unitName = (int)parent.getItemAtPosition(position);

    }
    // Watch Deakin videos to see if we can avoid implementing the above interface -
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}