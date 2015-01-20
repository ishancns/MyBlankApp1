package com.icssoft.test.myblankapp1;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by ishan_000 on 1/18/2015.
 */
public class Search extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        //if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(MainActivity.EXTRA_QUERY);
            //use the query to search your data somehow
            TextView displayMessageView=(TextView) findViewById(R.id.searchMessageView);
            displayMessageView.setText("No items found for the search query \""+query+"\"");
        //}
    }
}
