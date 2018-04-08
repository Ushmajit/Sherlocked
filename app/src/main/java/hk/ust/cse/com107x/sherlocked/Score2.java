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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Score2 extends ActionBarActivity {

   int score1,score;
    SharedPreferences loadgame,savegame;
    ImageButton btn;
    TextView v,dis;
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score2);
        score1=getIntent().getExtras().getInt("score1");
        v=(TextView)findViewById(R.id.scoredisplay007);
        dis=(TextView)findViewById(R.id.messadisplay007);
        im=(ImageView)findViewById(R.id.badscore007);
        btn=(ImageButton)findViewById(R.id.home007);
        v.setText("Score\n" + "  " + score1);

        if (score1>=230){
            dis.setText("          The Mysterious   \n\n"+"Highest Title achieved!");
            im.setImageResource(getResources().getIdentifier("img2","drawable",getPackageName()));}
        else if(score1<230 && score1>=200)
        {
            dis.setText("          The Skillfull   \n\n"+"Someone is always better than you!");
            im.setImageResource(getResources().getIdentifier("img1","drawable",getPackageName()));
        }
        else if(score1<200 && score1>=170)
        {
            dis.setText("          The Admiral   \n\n"+"Every man at the bottom of his heart believes that he is a born detective."
            );
            im.setImageResource(getResources().getIdentifier("img4", "drawable", getPackageName()));
        }
        else if(score1<170 && score1>=140)
        {
            dis.setText("           The Informer   \n\n"+"You can be the last and highest court of appeal in detection.");
            im.setImageResource(getResources().getIdentifier("img7","drawable",getPackageName()));
        }
        else
        {
            dis.setText("           The Weakling      \n\n"+"You can't accept failure, everyone fails at something. But you can't accept not trying.");
            im.setImageResource(getResources().getIdentifier("img6","drawable",getPackageName()));
        }
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                      Toast.makeText(getApplicationContext(),"Congrats!! Game completed Succesfully!! Play again",Toast.LENGTH_SHORT).show();
                                 Intent h=new Intent(Score2.this,Home.class);
                                       startActivity(h);
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
                      getMenuInflater().inflate(R.menu.menu_score2, menu);
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
                              score = loadgame.getInt("score", score);
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
                              Intent in=new Intent(getApplicationContext(),Home.class);
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
