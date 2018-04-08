package hk.ust.cse.com107x.sherlocked;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;


public class question1 extends ActionBarActivity {
    Button btn;
    int score;
    CheckBox a, b, c, d;
    int f = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_question1);
        score = getIntent().getExtras().getInt("score");
        btn = (Button) findViewById(R.id.next1);
        c = (CheckBox) findViewById(R.id.one_c);
        a = (CheckBox) findViewById(R.id.one_a);
        b = (CheckBox) findViewById(R.id.one_b);
        d = (CheckBox) findViewById(R.id.one_d);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;
                if (v.getId() == R.id.one_c) {
                    score = score + 10;
                    f = 1;


                    c.setChecked(true);

                    a.setChecked(false);
                    b.setChecked(false);
                    d.setChecked(false);

                }

            }


        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent q1 = new Intent(question1.this, question2.class);

                //q1.putExtra("score", score);
                //startActivity(q1);
                //else if (v.getId() == R.id.one_a || v.getId() == R.id.one_b || v.getId() == R.id.one_d) {

                //startActivity(q1);
                // if(f==1)
                //   Toast.makeText(question1.this,"Right!", Toast.LENGTH_SHORT).show();
                q1.putExtra("score", score);
                startActivity(q1);


            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                b.setChecked(true);

                a.setChecked(false);
                c.setChecked(false);
                d.setChecked(false);

            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                d.setChecked(true);

                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);

            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                a.setChecked(true);

                b.setChecked(false);
                c.setChecked(false);
                d.setChecked(false);

            }
        });
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.gameicon);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater savegame = getMenuInflater();
        savegame.inflate(R.menu.activity_menu_actions, menu);
        getMenuInflater().inflate(R.menu.menu_question1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (id) {
            case R.id.savegame:
                Toast.makeText(getApplicationContext(), "Can't Save Game Right Now", Toast.LENGTH_SHORT).show();

                break;
            case R.id.loadgame:
                Toast.makeText(getApplicationContext(), "Trying to Load Game!", Toast.LENGTH_SHORT).show();
                SharedPreferences loadgame = getSharedPreferences("SAVE", 0);
                score = loadgame.getInt("score", 0);
                if (score != 0) {
                    Intent q4 = new Intent(this, Levels.class);
                    q4.putExtra("score", score);
                    startActivity(q4);

                    Toast.makeText(getApplicationContext(), "Game Loaded Successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Can't Load Game Now!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.newgame:
                Intent in = new Intent(question1.this, Home.class);
                SharedPreferences savegam = getSharedPreferences("SAVE", 0);
                SharedPreferences.Editor edit = savegam.edit();
                edit.putInt("score", 0);
                edit.apply();
                startActivity(in);
                Toast.makeText(getApplicationContext(), "New Game Started", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
