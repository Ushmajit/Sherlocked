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
import android.widget.TextView;
import android.widget.Toast;


public class home1 extends ActionBarActivity {
    int score = 0,virtual;
    ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
        Intent in = getIntent();
        String message = in.getStringExtra("message");
        TextView text = (TextView) findViewById(R.id.displaytext);
        text.setText(message);
        btn = (ImageButton) findViewById(R.id.next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {

                    case R.id.next:
                        Intent a = new Intent(home1.this, Levels.class);
                       a.putExtra("score", score);
                        startActivity(a);
                        break;
                    default:
                        break;
                }
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
        getMenuInflater().inflate(R.menu.menu_home1, menu);
        MenuInflater savegame = getMenuInflater();
        savegame.inflate(R.menu.activity_menu_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.savegame:
                Toast.makeText(getApplicationContext(), "Game Saved Successfully", Toast.LENGTH_SHORT).show();
                SharedPreferences savegame = getSharedPreferences("SAVE", 0);
                SharedPreferences.Editor editor = savegame.edit();
                editor.putInt("score", score);
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
                SharedPreferences savegam = getSharedPreferences("SAVE", 0);
                SharedPreferences.Editor edit = savegam.edit();
                edit.putInt("score", 0);
                edit.apply();
                Intent in = new Intent(home1.this, Home.class);
                startActivity(in);
                Toast.makeText(getApplicationContext(), "New Game Started", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

}