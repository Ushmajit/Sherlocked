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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Score1 extends ActionBarActivity {
    int score,score1;
    ImageButton btn;
    TextView v,dis;
    ImageView im;
    SharedPreferences loadgame,savegame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score1);
        score=getIntent().getExtras().getInt("score");

        v=(TextView)findViewById(R.id.scoredisplay);
        dis=(TextView)findViewById(R.id.messadisplay);
        im=(ImageView)findViewById(R.id.badscore);

            v.setText("Score\n " + "  " + score);


            if (score < 90) {
                dis.setText("HardLuck Detective! Your Score is too low!! TryAgain");
                im.setImageResource(getResources().getIdentifier("sad", "drawable", getPackageName()));

            } else if (score >= 90) {
                dis.setText("Proved Yourself to be a BrainStormer! Now Let's Test Your High Order Thinking Skills!");
                im.setImageResource(getResources().getIdentifier("badge", "drawable", getPackageName()));
            }
        btn=(ImageButton)findViewById(R.id.home);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent q5 = new Intent(Score1.this,levels2.class);
                Intent q4=new Intent(Score1.this,Levels.class);
                if(score>=90) {
                    q5.putExtra("score", score);
                    startActivity(q5);
                }
                else if (score<90)
                {
                    score=0;
                    Toast.makeText(getApplicationContext(),"Try Again!!",Toast.LENGTH_SHORT).show();
                    q4.putExtra("score", score);
                  startActivity(q4);
                }
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
        savegame.inflate(R.menu.activity_menu_actions,menu);
        getMenuInflater().inflate(R.menu.menu_score1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id)
        {
            case R.id.savegame:
                Toast.makeText(getApplicationContext(), "Game Saved Successfully", Toast.LENGTH_SHORT).show();
                 savegame=getSharedPreferences("SAVE",0);
                SharedPreferences.Editor editor=savegame.edit();
                editor.putInt("score",score);
                editor.apply();
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
                Intent in=new Intent(Score1.this,Home.class);
              //  in.putExtra("Scorefromscoreboard",score);
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


    @Override
    protected void onPause() {
        super.onPause();
        savegame=getSharedPreferences("SAVE",0);
        SharedPreferences.Editor editor=savegame.edit();
        editor.putInt("score",score);
        editor.apply();

    }

    @Override
    protected void onStop() {
        super.onStop();
        savegame=getSharedPreferences("SAVE",0);
        SharedPreferences.Editor editor=savegame.edit();
        editor.putInt("score",score);
        editor.apply();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        savegame=getSharedPreferences("SAVE",0);
        SharedPreferences.Editor editor=savegame.edit();
        editor.putInt("score",score);
        editor.apply();


    }
}
