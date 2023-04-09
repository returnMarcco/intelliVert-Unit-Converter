package com.example.intellivert_unit_converter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate and initialise widgetIDs (from layout) to the Widget objects
        Spinner sourceUnitSpinner = findViewById(R.id.idSourceUnitSpinner);
        Spinner targetUnitSpinner = findViewById(R.id.idTargetUnitSpinner);
        EditText editText = findViewById(R.id.idNumberSourceInput);
        Button convertBtn = findViewById(R.id.idConvertButton);

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



        // Set Event Listeners
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Exception-Handling
                // onClick convert logic here
                String inputVal = editText.getText().toString();
                double inputValDbl = Double.parseDouble(inputVal);

                int sourceUnitSelection = sourceUnitSpinner.getSelectedItemPosition();
                int targetUnitSelection = targetUnitSpinner.getSelectedItemPosition();

                CharSequence sourceUnitLabel = sourceUnitAdapter.getItem(sourceUnitSelection);
                CharSequence targetUnitLabel = targetUnitAdapter.getItem(targetUnitSelection);

                double convertLength = convertLength(inputValDbl, sourceUnitSelection, targetUnitSelection);
                System.out.println(convertLength);

                // then check sourceSpinner val
                // then check targetSpinner val
                // then call appropriate conversion logic
                // Toast popup showing converted value

            }
        });
    }
    public double convertLength(double input, int sourceUnitPos, int targetUnitPos) {

        if (sourceUnitPos == targetUnitPos) {
            return input;
        // Inch -> Foot
        } else if (sourceUnitPos == 0 && targetUnitPos == 1) {
            return (input / 12);
        // Foot -> Inch
        } else if (sourceUnitPos == 1 && targetUnitPos == 0) {
            return (input * 12);
        // Inch -> Yard
        } else if (sourceUnitPos == 0 && targetUnitPos == 2) {
            return (sourceUnitPos / 36);
        // Yard -> Inch
        } else if (sourceUnitPos == 2 && targetUnitPos == 0) {
            return (sourceUnitPos * 36);
        // Inch -> Mile
        } else if (sourceUnitPos == 0 && targetUnitPos == 3) {
            return (sourceUnitPos / 63360);
        // Mile -> Inch
        } else if (sourceUnitPos == 3 && targetUnitPos == 0) {
            return (sourceUnitPos * 63360);
         // Foot -> Yard
        } else if (sourceUnitPos == 1 && targetUnitPos == 2) {
            return (sourceUnitPos / 3);
        // Yard -> Foot
        } else if (sourceUnitPos == 2 && targetUnitPos == 1) {
            return (sourceUnitPos * 3);
        // Foot -> Mile
        }
        return -100;
    }

    // Event-handlers required for implementing the Listener Interface
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    void testCallback() {
        System.out.println("Hello World");
    }

}