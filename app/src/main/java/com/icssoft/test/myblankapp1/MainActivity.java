package com.icssoft.test.myblankapp1;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    public static final String EXTRA_MESSAGE = "com.icssoft.test.myfirstapp1.MESSAGE";
    public static final String EXTRA_QUERY="com.icssoft.test.myfirstapp1.QUERY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("My Blank App 1","OnCreate");

        // Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // For the main activity, make sure the app icon in the action bar
            // does not behave as a button
            android.support.v7.app.ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setHomeButtonEnabled(false);
            }
        }

/*        // Check if we're running on Android 5.0 or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Call some material design APIs here

            *//*Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.primary_dark));*//*
        } else {
            // Implement this feature without material design
        }*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("My Blank App 1","OnResume called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("My Blank App 1","OnStart called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("My Blank App 1","OnPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("My Blank App 1","OnStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("My Blank App 1","OnDestroy called");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        final MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchItems(searchItem);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        //return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendMessage(View view) {
        Intent intent=new Intent(this,DisplayMessageActivity.class);
        EditText editText=(EditText)findViewById(R.id.edit_message);
        String message=editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }

    public void searchItems(MenuItem item) {
        //Toast.makeText(getApplicationContext(),"Searching",Toast.LENGTH_LONG).show();

        Intent intent=new Intent(this,Search.class);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(item);
        //EditText editText=(EditText)findViewById(R.id.edit_message);
        String message=searchView.getQuery().toString();
        intent.putExtra(EXTRA_QUERY,message);
        startActivity(intent);
    }
}
