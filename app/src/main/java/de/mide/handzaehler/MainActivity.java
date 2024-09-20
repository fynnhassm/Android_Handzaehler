package de.mide.handzaehler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Die Haupt-Activity der Anwendung "Handzähler". Diese Activity stellt eine einfache Benutzeroberfläche
 * bereit, mit der der Benutzer einen Zählerwert erhöhen oder verringern kann. Die aktuelle Zahl
 * wird in einem TextView-Element angezeigt.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    /** Aktueller Zählerwert. */
    protected int _zahl = 0;

    /** Button-Element, um Zählerwert um +1 zu erhöhen. */
    protected Button _plusButton  = null;

    /** Button-Element, um Zählerwert um -1 zu verringern. */
    protected Button _minusButton = null;

    protected Button _resetButton = null;

    /** TextView-Element, in dem der aktuelle Zählerwert angezeigt wird. */
    protected TextView _zahlTextView = null;


    /**
     * Lifecycle-Methode:
     * Layout-Datei laden und Referenzen auf UI-Elemente holen und
     * Event-Handler für Buttons setzen.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _plusButton  = findViewById(R.id.plusButton);
        _minusButton = findViewById(R.id.minusButton);
        _resetButton = findViewById(R.id.resetButton);

        _zahlTextView = findViewById(R.id.zahlTextView);

        _plusButton.setOnClickListener (this);
        _minusButton.setOnClickListener(this);
        _resetButton.setOnClickListener(this);

        if (_zahl == 0) {
            _minusButton.setVisibility(View.GONE);
        }
    }

    public void onZahlChanged() {
        if (_zahl == 0) {
            _minusButton.setVisibility(View.GONE);
        } else {
            _minusButton.setVisibility(View.VISIBLE);
        }
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

        } else if (view == _resetButton) {
            if (_zahl != 0) {
                _zahl = 0;
            }
        } else {

            return; // Event ignorieren, weil von unbekanntem UI-Element ausgelöst
        }

        String anzeigeText = _zahl + ""; // Trick: int nach String umwandeln
        _zahlTextView.setText( anzeigeText );
        onZahlChanged();
    }

}