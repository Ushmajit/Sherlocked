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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class question15 extends ActionBarActivity{
    String answer; int score;
    Button btn;
    EditText ans;
 TextView v;
    SharedPreferences loadage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question15);
   //     Intent out=getIntent();
 //     answer=out.getStringExtra("age");
        score=getIntent().getExtras().getInt("score");
         ans=(EditText)findViewById(R.id.ans2);

        btn=(Button)findViewById(R.id.last);

        loadage=getSharedPreferences("age",0);
        answer=loadage.getString("age",answer);
        //score
//q15.putExtra("score", score


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=ans.getText().toString();
                if(user.equalsIgnoreCase(answer))
                    score += 10;

                Intent q5 = new Intent(question15.this, Score1.class);

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
        getMenuInflater().inflate(R.menu.menu_question15, menu);
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
                Intent in=new Intent(question15.this,Home.class);
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
