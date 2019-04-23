package com.recyclebin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends AppCompatActivity {
    CircleImageView cImg;
    TextView tvFullName, tvPhoneNo,tva,tve;
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
       setContentView(R.layout.details_activity);

       cImg = findViewById(R.id.imgProfile);
       tvFullName = findViewById(R.id.tvName);
       tvPhoneNo = findViewById(R.id.tvPhone);
       tva = findViewById(R.id.tvaddress);
       tve = findViewById(R.id.tvemail);

        //Bundles are generally used for passing data between various Android activities

       Bundle bundle = getIntent().getExtras();
       if(bundle != null){
            cImg.setImageResource(bundle.getInt("image"));
            tvFullName.setText(bundle.getString("name"));
            tvPhoneNo.setText(bundle.getString("phone"));
            tva.setText(bundle.getString("address"));
            tve.setText(bundle.getString("email"));
       }
    }

}
