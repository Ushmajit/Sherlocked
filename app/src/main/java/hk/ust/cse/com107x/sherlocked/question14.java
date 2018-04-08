package hk.ust.cse.com107x.sherlocked;

import android.app.ActionBar;
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
import android.widget.Toast;


public class question14 extends ActionBarActivity {
    int score;
    Button btn;
    CheckBox a,b,c,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question14);
       score=getIntent().getExtras().getInt("score");
        btn=(Button)findViewById(R.id.next14);
        a=(CheckBox)findViewById(R.id.fourteen4);
        b=(CheckBox)findViewById(R.id.fourteen3);
        c=(CheckBox)findViewById(R.id.fourteen2);
        d=(CheckBox)findViewById(R.id.fourteen1);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.fourteen2)
                    score += 10;
                c.setChecked(true);

                b.setChecked(false);
                a.setChecked(false);
                d.setChecked(false);            }
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
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent q5 = new Intent(question14.this, question15.class);

                q5.putExtra("score", score);
                startActivity(q5);
            }
        });
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setLogo(R.mipmap.gameicon);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater savegame = getMenuInflater();
        savegame.inflate(R.menu.activity_menu_actions, menu);
        getMenuInflater().inflate(R.menu.menu_question14, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id)
        {
            case R.id.savegame:
                Toast.makeText(getApplicationContext(), "Can't Save Game Right Now", Toast.LENGTH_SHORT).show();
                break;
            case R.id.loadgame:
                Toast.makeText(getApplicationContext(), "Trying to Load Game!", Toast.LENGTH_SHORT).show();
                SharedPreferences loadgame = getSharedPreferences("SAVE", 0);
                score = loadgame.getInt("score", 0);
                if(score!=0)
                {
                    Intent q4=new Intent(this,Levels.class);
                    q4.putExtra("score", score);
                    startActivity(q4);

                    Toast.makeText(getApplicationContext(),"Game Loaded Successfully!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Can't Load Game Now!!",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.newgame:
                Intent in=new Intent(question14.this,Home.class);
                SharedPreferences savegam=getSharedPreferences("SAVE",0);
                SharedPreferences.Editor edit=savegam.edit();
                edit.putInt("score",0);
                edit.apply();
                startActivity(in);
                Toast.makeText(getApplicationContext(),"New Game Started",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
