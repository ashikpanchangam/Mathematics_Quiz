package com.example.ashikspc.mathematicsquiz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class scoreActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        String finalScore;
        if (savedInstanceState == null)
        {
            Bundle extras = getIntent().getExtras();
            if(extras == null)
            {
                finalScore= null;
            }
            else
            {
                finalScore= extras.getString("FINAL_SCORE");
            }
        }
        else
        {
            finalScore= (String) savedInstanceState.getSerializable("FINAL_SCORE");
        }

        TextView fs = (TextView) findViewById(R.id.finalScore);
        fs.setText(finalScore);

        Context context = getApplicationContext();
        CharSequence text = "Your Score!!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(scoreActivity.this);
        builder.setTitle("Confirmation!");
        builder.setMessage("Are you sure you want to go to home screen?");
        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface arg0, int arg1)
            {
                startActivity(new Intent(scoreActivity.this, MainActivity.class));
                finish();
            }
        });
        builder.setNegativeButton(android.R.string.no, null);
        builder.show();

    }

    public void okayButton(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(scoreActivity.this);
        builder.setTitle("Confirmation!");
        builder.setMessage("Are you sure you want to go to home screen?");
        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface arg0, int arg1)
            {
                startActivity(new Intent(scoreActivity.this, MainActivity.class));
                finish();
            }
        });
        builder.setNegativeButton(android.R.string.no, null);
        builder.show();
    }
}
