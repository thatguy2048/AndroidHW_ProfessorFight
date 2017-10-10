package us.aaron_johnson.professorfight;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class BattleActivity extends AppCompatActivity {

    private Intent this_intent;
    private String professor_name;
    private ProgressBar pb;
    private Button attackButton;
    private final AppCompatActivity thisActivity = this;
    private ImageView professorImage;

    void LOG_V(String str){ Log.v("PF_BATTLE",str); }
    void LOG(String str){   Log.d("PF_BATTLE", str);    }

    public void setProgressBar(final int p){
        if(p < 0){
            pb.setProgress(0);
        }else{
            pb.setProgress(p);
        }


        if(pb.getProgress() <= 0){
            LOG("Victory");
            Toast.makeText(pb.getContext(),professor_name +" "+getResources().getString(R.string.victory_label)+" Morris Katz", Toast.LENGTH_SHORT)
                    .show();

            AlertDialog.Builder bldr = new AlertDialog.Builder(pb.getContext());
            bldr.setTitle("VICTORY")
                    .setMessage(professor_name +" "+getResources().getString(R.string.victory_label)+" Morris Katz")
                    .setPositiveButton("YES!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            thisActivity.onBackPressed();
                        }
                    })
                    .setNegativeButton("NO!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            setProgressBar(100);
                        }
                    })
                    .show();


        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("proff_name", professor_name);
        outState.putInt("progress", pb.getProgress());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LOG_V("onCreate");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_battle);

        this_intent = getIntent();
        professor_name = this_intent.getStringExtra("selected_professor_name");

        if(professor_name == null && savedInstanceState != null){
            professor_name = savedInstanceState.getString("proff_name");
        }

        pb = (ProgressBar)this.findViewById(R.id.progressBar);
        attackButton = (Button)this.findViewById(R.id.button);
        professorImage = (ImageView)this.findViewById(R.id.professorImage);
        int containerWidth = ((LinearLayout)this.findViewById(R.id.imageLayout)).getWidth();
        professorImage.setMinimumWidth(containerWidth/2);
        ((ImageView)this.findViewById(R.id.katzImage)).setMinimumWidth(containerWidth/2);

        professorImage.setImageResource(this_intent.getIntExtra("selected_professor_image_id",R.drawable.farnsworth));

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LOG("Attack The Cat");
                setProgressBar(pb.getProgress()-10);
            }
        });

        if(savedInstanceState != null){
            int tmp_pb = savedInstanceState.getInt("progress");
            if(tmp_pb > 0){
                pb.setProgress(tmp_pb);
            }
        }

    }

    @Override
    protected void onRestart() {
        LOG_V("onRestart");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        LOG_V("onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        LOG_V("onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        LOG_V("onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        LOG_V("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        LOG_V("onDestroy");
        super.onDestroy();
    }
}
