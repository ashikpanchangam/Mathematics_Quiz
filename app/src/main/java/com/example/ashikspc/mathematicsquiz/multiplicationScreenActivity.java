package com.example.ashikspc.mathematicsquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class multiplicationScreenActivity extends AppCompatActivity
{
    public int counter = 1;
    public int questionNumber = 0;
    public int currentResult;
    public int score = 0;
    public String finalScore;
    private int num1;
    private int num2;
    boolean scoreDialog;
    boolean backPressed;
    boolean ancestralBack;

    EditText editText;

    private TextView timeRemaining;

    CountDownTimer countTimer;

    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b0;
    Button del;
    Button enter;
    private long time;
    Boolean paused = false;
    TextView textViewTime;
    TextView questionNumbers;
    TextView myText1;
    TextView myText2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        DisplayMetrics dm = this.getApplicationContext().getResources().getDisplayMetrics();
        float activityWidth = dm.widthPixels / dm.xdpi;
        float activityHeight = dm.heightPixels / dm.xdpi;
        if(Math.min(activityHeight,activityWidth) <  2.5){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        setContentView(R.layout.activity_multiplication_screen);
        textViewTime = (TextView) findViewById(R.id.textViewTime);
        editText = (EditText)findViewById(R.id.editText);
        questionNumbers = (TextView) findViewById(R.id.questionNumber);
        myText1 = (TextView) findViewById(R.id.num1);
        myText2 = (TextView) findViewById(R.id.num2);


        if(savedInstanceState == null){


            randomNumbersOperation();

        }


        b1 = (Button)findViewById(R.id.n1);
        b2 = (Button)findViewById(R.id.n2);
        b3 = (Button)findViewById(R.id.n3);
        b4 = (Button)findViewById(R.id.n4);
        b5 = (Button)findViewById(R.id.n5);
        b6 = (Button)findViewById(R.id.n6);
        b7 = (Button)findViewById(R.id.n7);
        b8 = (Button)findViewById(R.id.n8);
        b9 = (Button)findViewById(R.id.n9);
        b0 = (Button)findViewById(R.id.n0);
        del = (Button)findViewById(R.id.del);
        enter = (Button)findViewById(R.id.enter);

        b0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editText.setText(editText.getText().insert(editText.getText().length(),"0"));
                verifyUserInput();
            }
        });

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editText.setText(editText.getText().insert(editText.getText().length(),"1"));
                verifyUserInput();
            }
        });

        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editText.setText(editText.getText().insert(editText.getText().length(),"2"));
                verifyUserInput();
            }
        });

        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editText.setText(editText.getText().insert(editText.getText().length(),"3"));
                verifyUserInput();
            }
        });

        b4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editText.setText(editText.getText().insert(editText.getText().length(),"4"));
                verifyUserInput();
            }
        });

        b5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editText.setText(editText.getText().insert(editText.getText().length(),"5"));
                verifyUserInput();
            }
        });

        b6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editText.setText(editText.getText().insert(editText.getText().length(),"6"));
                verifyUserInput();
            }
        });

        b7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editText.setText(editText.getText().insert(editText.getText().length(),"7"));
                verifyUserInput();
            }
        });

        b8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editText.setText(editText.getText().insert(editText.getText().length(),"8"));
                verifyUserInput();
            }
        });

        b9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editText.setText(editText.getText().insert(editText.getText().length(),"9"));
                verifyUserInput();
            }
        });

        del.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try {
                    editText.setText(editText.getText().delete(editText.getText().length() - 1, editText.getText().length()));
                }
                catch (Exception e)
                {
                    editText.setText("");
                }
                verifyUserInput();
            }
        });



        enter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editText = (EditText)findViewById(R.id.editText);
                int usersAns;
                try{
                    usersAns = Integer.parseInt(editText.getText().toString());
                }
                catch(Exception e){
                    usersAns = -1;
                }
                if(currentResult!=usersAns)
                {
                    final Toast toast = Toast.makeText(multiplicationScreenActivity.this,"Wrong Answer",Toast.LENGTH_SHORT);
                    toast.show();
                    Handler h = new Handler();
                    h.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    },500);
                }
                countTimer.cancel();
                randomNumbersOperation();

            }
        });
    }

    public void verifyUserInput()
    {
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                editText = (EditText)findViewById(R.id.editText);
                int usersAns;
                try{
                    usersAns = Integer.parseInt(editText.getText().toString());
                }
                catch(Exception e){
                    usersAns = -1;
                }
                if(currentResult == usersAns) {
                    final Toast toast = Toast.makeText(multiplicationScreenActivity.this, "Right Answer", Toast.LENGTH_SHORT);
                    toast.show();
                    Handler h = new Handler();
                    h.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 200);
                    score++;
                    countTimer.cancel();
                    randomNumbersOperation();

                }
            }
        },200);

    }

    public void randomNumbersOperation()
    {
        if(questionNumber < 10)
        {
            timeRemaining = (TextView) findViewById(R.id.timeRemaining);

            editText = (EditText) findViewById(R.id.editText);

            questionNumber++;

            questionNumbers.setText(String.valueOf("Question " + questionNumber+"/10"));

            if (counter > 0)
            {
                int usersAns;
                try
                {
                    usersAns = Integer.parseInt(editText.getText().toString());
                }
                catch(Exception e)
                {
                    usersAns = -1;
                }
            }

            Random rand = new Random();

            num1 = rand.nextInt(10);

            String myString1 = String.valueOf(num1);
            myText1.setText(myString1);

            num2 = rand.nextInt(10);
            String myString2 = String.valueOf(num2);
            myText2.setText(myString2);

            currentResult = num1 * num2;

            editText.setText("");

            counter++;

            countTimer = new CountDownTimer(5000, 500)
            {
                public void onTick(long millisUntilFinished)
                {
                    time = millisUntilFinished;
                    textViewTime.setText("Time Left " + String.valueOf(time / 1000));
                }

                public void onFinish()
                {
                    randomNumbersOperation();
                }
            };
            countTimer.start();
        }

        else
        {
            /*Intent intent = new Intent(additionScreenActivity.this, scoreActivity.class);
            finalScore = String.valueOf(score);
            intent.putExtra("FINAL_SCORE", finalScore);
            startActivity(intent);
            finish();*/
            scoreDialog();

        }
    }

    public void scoreDialog()
    {
        scoreDialog = true;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("                    You scored "+score+"/10")
                .setCancelable(false)
                .setPositiveButton("OK                                      ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(multiplicationScreenActivity.this, MainActivity.class));
                        finish();
                    }
                });
        builder.show();
    }

    @Override
    public void onPause(){
        super.onPause();
        countTimer.cancel();
        paused = true;


    }

    @Override
    public void onResume(){
        super.onResume();
//        final TextView textViewTime = (TextView) findViewById(R.id.textViewTime);
        if(paused == true){
            countTimer = new CountDownTimer(time, 500)
            {
                public void onTick(long millisUntilFinished)
                {
                    time = millisUntilFinished;
                    textViewTime.setText(String.valueOf(millisUntilFinished / 1000));
                }

                public void onFinish()
                {
                    randomNumbersOperation();
                }
            };
            countTimer.start();
            paused = false;

        }

    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){

        savedInstanceState.putInt("score",score);
        savedInstanceState.putLong("timer",time);
        savedInstanceState.putInt("questionNumber",questionNumber);
        savedInstanceState.putInt("num1",num1);
        savedInstanceState.putInt("num2",num2);
        savedInstanceState.putBoolean("scoreDialog",scoreDialog);
        savedInstanceState.putBoolean("backPressed",backPressed);
        savedInstanceState.putBoolean("ancestralBack",ancestralBack);


        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);

        score = saveInstanceState.getInt("score");
        time = saveInstanceState.getLong("timer");
        scoreDialog = saveInstanceState.getBoolean("scoreDialog");
        backPressed = saveInstanceState.getBoolean("backPressed");
        ancestralBack = saveInstanceState.getBoolean("ancestralBack");
        questionNumber = saveInstanceState.getInt("questionNumber");
        questionNumbers.setText(String.valueOf("Question " + questionNumber +"/10"));
        num1 = saveInstanceState.getInt("num1");
        myText1.setText(String.valueOf(num1));
        num2 = saveInstanceState.getInt("num2");
        myText2.setText(String.valueOf(num2));
        currentResult = num1 * num2;

        countTimer = new CountDownTimer(time, 500)
        {
            public void onTick(long millisUntilFinished)
            {
                time = millisUntilFinished;
                textViewTime.setText(String.valueOf("Time Left " +millisUntilFinished / 1000));
            }

            public void onFinish()
            {
                randomNumbersOperation();
            }
        };
        countTimer.start();

        if(backPressed == true)
        {
            onBackPressed();
        }
        if(scoreDialog == true)
        {
            scoreDialog();
        }
        if(ancestralBack == true)
        {
            onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        ancestralBack = true;
        switch (item.getItemId())
        {
            case android.R.id.home:
                countTimer.cancel();
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                startActivity(new Intent(multiplicationScreenActivity.this, MainActivity.class));
                                finish();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                countTimer = new CountDownTimer(time, 500)
                                {
                                    public void onTick(long millisUntilFinished)
                                    {
                                        time = millisUntilFinished;
                                        textViewTime.setText(String.valueOf("Time Left "+millisUntilFinished / 1000));
                                    }

                                    public void onFinish()
                                    {
                                        randomNumbersOperation();
                                    }
                                };
                                countTimer.start();
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(multiplicationScreenActivity.this);
                builder.setMessage("Are you sure you want to quit?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed()
    {
        backPressed = true;
        countTimer.cancel();
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int option) {
                switch (option){
                    case DialogInterface.BUTTON_POSITIVE:
                        startActivity(new Intent(multiplicationScreenActivity.this, MainActivity.class));
                        finish();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        countTimer = new CountDownTimer(time, 500)
                        {
                            public void onTick(long millisUntilFinished)
                            {
                                time = millisUntilFinished;
                                textViewTime.setText(String.valueOf("Time Left "+millisUntilFinished / 1000));
                            }

                            public void onFinish()
                            {
                                randomNumbersOperation();
                            }
                        };
                        countTimer.start();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(multiplicationScreenActivity.this);
        builder.setMessage("Are you sure you want to quit?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }

}