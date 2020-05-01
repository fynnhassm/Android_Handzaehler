package de.mide.handzaehler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * App repräsentiert einen einfachen Handzähler (Tally Counter). Hiermit
 * sollen die Grundlagen des Event-Handlings für UI-Elemente demonstriert
 * werden.
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class MainActivity extends Activity
                          implements View.OnClickListener {

    /** Enthält immer aktuellen Zähler-Wert. */
    protected int _zahl = 0;

    /** Button zum Erhöhen des Zählers (+1). */
    protected Button _plusButton  = null;

    /** Button zum Erniedrigen des Zählers (-1). */
    protected Button _minusButton = null;

    /** UI-Element für Darstellung aktueller Zähler-Wert. */
    protected TextView _zahlTextView = null;


    /**
     * Lifecycle-Methode. Lädt Layout-Datei, füllt Member-Variablen
     * mit Referenzen auf UI-Elemente, und setzt Event-Handler-Objekt
     * für die beiden Buttons.
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
        }
        else if (view == _minusButton) {

            _zahl--;

        } else {

            return; // Event ignorieren, weil von unbekanntem UI-Element ausgelöst
        }

        String anzeigeText = _zahl + ""; // Trick: int nach String wandeln
        _zahlTextView.setText( anzeigeText );
    }

}



