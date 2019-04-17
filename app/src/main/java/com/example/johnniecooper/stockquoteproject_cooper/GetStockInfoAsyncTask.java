package com.example.johnniecooper.stockquoteproject_cooper;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.johnniecooper.stockquoteproject_cooper.model.Stock;


public class GetStockInfoAsyncTask extends AsyncTask<Void, Void, Stock> {

    private String stockToSearch;
    private TextView stockSymbol;
    private TextView name;
    private TextView lastTradePrice;
    private TextView change;
    private TextView weekRange;



    public GetStockInfoAsyncTask(String stockToSearch, TextView stockSymbol, TextView name, TextView lastTradePrice, TextView change, TextView weekRange) {

        this.stockToSearch = stockToSearch;
        this.stockSymbol = stockSymbol;
        this.name = name;
        this.lastTradePrice = lastTradePrice;
        this.change = change;
        this.weekRange = weekRange;

    }

    @Override
    protected Stock doInBackground(Void... voids) {

        Stock stock = new Stock(stockToSearch);
        try {
            stock.load();
        }
        catch (Exception ex){
            Log.e("ERROR!!!", "doInBackground: "+ ex);
        }
        return stock;


    }

    @Override
    protected void onPostExecute(Stock stockInfo) {

        super.onPostExecute(stockInfo);

        stockSymbol.setText(stockInfo.getSymbol());
        name.setText(stockInfo.getName());
        lastTradePrice.setText(stockInfo.getLastTradePrice());
        change.setText(stockInfo.getChange());
        weekRange.setText(stockInfo.getRange());
    }
}
