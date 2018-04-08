package hk.ust.cse.com107x.sherlocked;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class levels2 extends ActionBarActivity {

        int score;
    ImageButton l1,l2,l3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels2);
        score=getIntent().getExtras().getInt("score");
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setLogo(R.mipmap.gameicon);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        l1=(ImageButton)findViewById(R.id.level1);
        l2=(ImageButton)findViewById(R.id.l2ans1);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(levels2.this, Level1intro.class);
                if (score >= 10) {

                    Toast.makeText(getApplicationContext(), "Already Completed Level 1", Toast.LENGTH_SHORT).show();
                    score = 0;
                    a.putExtra("score", score);
                    startActivity(a);
                }
            }

    });
        l2.setOnClickListener(new View.OnClickListener() {

            Intent b=new Intent(levels2.this,level2q1.class);

            @Override
            public void onClick(View view) {
                Intent b=new Intent(levels2.this,level2intro.class);
                 if (score>=90)
                 {
                     b.putExtra("score", score);
                     startActivity(b);

                 }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_levels2, menu);
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
                Intent in=new Intent(levels2.this,Home.class);
                startActivity(in);
                Toast.makeText(getApplicationContext(),"New Game Started",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
