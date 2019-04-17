package com.example.johnniecooper.stockquoteproject_cooper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputSymbol;

    private TextView stockLabel;
    private TextView nameLabel;
    private TextView lastTradeLabel;
    private TextView changeLabel;
    private TextView rangeLabel;

    private TextView stockValue;
    private TextView nameValue;
    private TextView lastTradeValue;
    private TextView chaneValue;
    private TextView rangeValue;

    private ImageButton searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputSymbol = findViewById(R.id.inputSymbol);

        stockLabel = findViewById(R.id.stocksymbollabel);
        stockValue = findViewById(R.id.stocksymbolvalue);

        nameLabel = findViewById(R.id.namelabel);
        nameValue = findViewById(R.id.namevalue);

        lastTradeLabel = findViewById(R.id.tradepricelabel);
        lastTradeValue = findViewById(R.id.tradepricevalue);

        changeLabel = findViewById(R.id.changeLabel);
        chaneValue = findViewById(R.id.changevalue);

        rangeLabel = findViewById(R.id.rangeLabel);
        rangeValue = findViewById(R.id.rangevalue);

        searchButton = findViewById(R.id.search);

        stockLabel.setText("");
        nameLabel.setText("");
        lastTradeLabel.setText("");
        changeLabel.setText("");
        rangeLabel.setText("");


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GetStockInfoAsyncTask asyncTask = new GetStockInfoAsyncTask(inputSymbol.getText().toString(),stockValue,nameValue,lastTradeValue,chaneValue,rangeValue);
                asyncTask.execute();

                stockLabel.setText("Stock Symbol");
                nameLabel.setText("Company Name");
                lastTradeLabel.setText("Last Trade Price");
                changeLabel.setText("Change");
                rangeLabel.setText("52 Week Range");
            }
        });




    }
}
