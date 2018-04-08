package hk.ust.cse.com107x.sherlocked;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class Levels extends ActionBarActivity {
  int score,score1,score2,scoreend;
    ImageButton l1,l2,l3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setLogo(R.mipmap.gameicon);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
       // score2=getIntent().getExtras().getInt("score3");
        score=getIntent().getExtras().getInt("score");

         // scoreend=getIntent().getExtras().getInt("scoreend");

       // score=score2;
        l1=(ImageButton)findViewById(R.id.level1);
        l2=(ImageButton)findViewById(R.id.l2ans1);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Levels.this, Level1intro.class);
                if (score >= 0 && score < 90) {

                    a.putExtra("score", score);
                    startActivity(a);
                }
                if (score >= 90) {

                    Toast.makeText(getApplicationContext(), "Already Completed Level 1", Toast.LENGTH_SHORT).show();
                    score = 0;
                    a.putExtra("score", score);
                    startActivity(a);
                }
            }
        });


        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(score<90) {
                        Toast.makeText(getApplicationContext(), "Restricted Access", Toast.LENGTH_SHORT).show();
                    }
                else
                    {
                        Intent l=new Intent(Levels.this,level2intro.class);
                        l.putExtra("score",score);
                        startActivity(l);
                    }
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater savegame = getMenuInflater();
        savegame.inflate(R.menu.activity_menu_actions, menu);
        getMenuInflater().inflate(R.menu.menu_levels, menu);
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
                Toast.makeText(getApplicationContext(), "Game Saved Successfully", Toast.LENGTH_SHORT).show();
                SharedPreferences savegame=getSharedPreferences("SAVE",0);
                SharedPreferences.Editor editor=savegame.edit();
                editor.putInt("score",score);
                editor.apply();
                break;
            case R.id.loadgame:
                Toast.makeText(getApplicationContext(),"Game Loaded Successfully",Toast.LENGTH_SHORT).show();
                SharedPreferences loadgame=getSharedPreferences("SAVE",0);
                score=loadgame.getInt("score",0);
                break;
            case R.id.newgame:
                SharedPreferences savegam=getSharedPreferences("SAVE",0);
                SharedPreferences.Editor edit=savegam.edit();
                edit.putInt("score",0);
                edit.apply();
                Intent in=new Intent(Levels.this,Home.class);
                startActivity(in);
                Toast.makeText(getApplicationContext(),"New Game Started",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
