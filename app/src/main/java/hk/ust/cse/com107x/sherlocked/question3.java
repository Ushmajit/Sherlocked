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
import android.widget.Toast;


public class question3 extends ActionBarActivity {
  Button btn;
     int score;
    CheckBox c,d,e,f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setLogo(R.mipmap.gameicon);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        score = getIntent().getExtras().getInt("score");
        btn=(Button)findViewById(R.id.next3);
        c=(CheckBox)findViewById(R.id.three2);
        d=(CheckBox)findViewById(R.id.three4);
        e=(CheckBox)findViewById(R.id.three5);
        f=(CheckBox)findViewById(R.id.three6);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.three2 && v.getId()!=R.id.three1 && v.getId()!=R.id.three3)
                    score+=2;
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.three4 && v.getId()!=R.id.three1 && v.getId()!=R.id.three3)
                    score += 3;
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.three5 && v.getId()!=R.id.three1 && v.getId()!=R.id.three3)
                    score += 2;
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.three6 && v.getId()!=R.id.three1 && v.getId()!=R.id.three3)
                    score += 3;
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent q3 = new Intent(question3.this, question4.class);

                q3.putExtra("score", score);
                startActivity(q3);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater savegame = getMenuInflater();
        savegame.inflate(R.menu.activity_menu_actions, menu);
        getMenuInflater().inflate(R.menu.menu_question3, menu);
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
                Intent in=new Intent(question3.this,Home.class);
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
