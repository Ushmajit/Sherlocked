package hk.ust.cse.com107x.sherlocked;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class level2q1b extends ActionBarActivity {
        int score1,score;
    ImageButton i;
    String answer="Dabid";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        score1 = getIntent().getExtras().getInt("score1");
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.gameicon);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_level2q1b);
        i=(ImageButton)findViewById(R.id.level2q1b);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText a=(EditText)findViewById(R.id.l2ans1);
                String ans=a.getText().toString();
                if(answer.equalsIgnoreCase(ans))
                {
                    score1=score1+10;
                }
                Intent n=new Intent(level2q1b.this,level2q2a.class);
                n.putExtra("score1",score1);
                startActivity(n);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        MenuInflater savegame = getMenuInflater();
        savegame.inflate(R.menu.activity_menu_actions,menu);
        getMenuInflater().inflate(R.menu.menu_level2q1b, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

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
                Intent in=new Intent(level2q1b.this,Home.class);
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
