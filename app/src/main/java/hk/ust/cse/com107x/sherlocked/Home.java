package hk.ust.cse.com107x.sherlocked;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class Home extends ActionBarActivity implements View.OnClickListener {

    ImageButton greetButton;
    int score;
    String a;
    SharedPreferences loadgame, saveage;
    EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        greetButton = (ImageButton) findViewById(R.id.greetButton);
        greetButton.setOnClickListener(this);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.gameicon);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        loadgame = getSharedPreferences("SAVE", 0);
        score = loadgame.getInt("score", 0);
        age = (EditText) findViewById(R.id.age);
        a = age.getText().toString();
        saveage = getSharedPreferences("age", 0);
        SharedPreferences.Editor editor = saveage.edit();
        editor.putString("age", a);
        editor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater savegame = getMenuInflater();
        savegame.inflate(R.menu.activity_menu_actions, menu);
        getMenuInflater().inflate(R.menu.menu_home, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        // score = getIntent().getExtras().getInt("score2");

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

                Toast.makeText(getApplicationContext(), "Can't Start New Game Now", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        EditText name = (EditText) findViewById(R.id.name);
        EditText age = (EditText) findViewById(R.id.age);
        String friendName = name.getText().toString();
        String agee = age.getText().toString();
        //Intent out=new Intent(this,question15.class);
        //out.putExtra("age",agee);


        if (v.getId() == R.id.greetButton) {

            Intent in = new Intent(this, home1.class);
            in.putExtra("message", getString(R.string.hello) + " " + friendName + " " + getString(R.string.greet));
            startActivity(in);


        }
    }
}
