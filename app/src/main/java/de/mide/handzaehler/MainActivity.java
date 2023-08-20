package de.mide.handzaehler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected int _zahl = 0;

    protected Button _plusButton  = null;

    protected Button _minusButton = null;

    protected TextView _zahlTextView = null;

    /**
     * Lifecycle-Methode
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _plusButton  = findViewById(R.id.plusButton);
        _minusButton = findViewById(R.id.minusButton);

        _zahlTextView = findViewById(R.id.zahlTextView);

        _plusButton.setOnClickListener (this);
        _minusButton.setOnClickListener(this);
    }

    /**
     * Event-Handler-Methode für die beiden Buttons.
     *
     * @param view  Referenz auf UI-Element, das das Event ausgelöst hat.
     */
    @Override
    public void onClick(View view) {

        if (view == _plusButton) {

            _zahl++;

        } else if (view == _minusButton) {

            _zahl--;

        } else {

            return; // Event ignorieren, weil von unbekanntem UI-Element ausgelöst
        }

        String anzeigeText = _zahl + ""; // Trick: int nach String umwandeln
        _zahlTextView.setText( anzeigeText );
    }

}