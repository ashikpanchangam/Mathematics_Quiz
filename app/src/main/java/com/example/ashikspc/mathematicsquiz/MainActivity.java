package com.example.ashikspc.mathematicsquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* if(getSupportActionBar()!= null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }*/
    }

    /** Called when the user clicks the additionButton button */
    public void additionButton(View view) {
        Intent intent = new Intent(MainActivity.this, additionScreenActivity.class);
        MainActivity.this.startActivity(intent);
    }

    public void subtractionButton(View view)
    {
        Intent intent = new Intent(MainActivity.this, subtractionScreenActivity.class);
        MainActivity.this.startActivity(intent);
    }

    public void multiplicationButton(View view)
    {
        Intent intent = new Intent(MainActivity.this, multiplicationScreenActivity.class);
        MainActivity.this.startActivity(intent);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }*/


    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.quit_dig_confirmation_title);
        builder.setMessage(R.string.quit_dig_confirmation_msg);
        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface arg0, int arg1)
            {
                finish();
            }
        });
        builder.setNegativeButton(android.R.string.no, null);
        builder.show();
    }

}