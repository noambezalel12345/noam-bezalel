package com.example.eggapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;

public class MainActivity extends AppCompatActivity {


    private int counter;
    private Button btnGetOut;
    private String Tag;

    private void EvantHandler(){

        btnGetOut.setOnClickListener(new View.onClickListener(){
            public void onClick(View v){
                AlertDialog.Builder Builder=new AlertDialog.Builder(MainActivity.this);
                Builder.setMessage("Are you sure you wanna leave?")
                        //////////////////
            finish();
            }
        });
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(Tag, "MainActivity::OnCreate!!!!");

        EdgeToEdge.enable(this);
        counter = 10;
        TextView counterTextView = findViewById(R.id.textview_counter);
        counterTextView.setText(""+counter);
        btnGetOut = (Button)findViewById(R.id.btnGETOUT);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void knock(View view) {
        if(counter>0){
            counter--;
            TextView counterTextView = findViewById(R.id.textview_counter);
            counterTextView.setText(""+counter);
            if(counter==0){
                ImageView eggImageView = findViewById(R.id.imageview_egg);
                eggImageView.setImageResource(R.drawable.dog_1);
            }
        }
    }

    public void reset(View view) {
        counter = 10;
        TextView counterTextView = findViewById(R.id.textview_counter);
        counterTextView.setText(""+counter);
        ImageView eggImageView = findViewById(R.id.imageview_egg);
        eggImageView.setImageResource(R.drawable.egg_2);

    }
}