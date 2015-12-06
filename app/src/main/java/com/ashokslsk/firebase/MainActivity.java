package com.ashokslsk.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView fireData;
    Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        fireData = (TextView) findViewById(R.id.firedata);
        mRef = new Firebase("https://dazzling-inferno-6462.firebaseio.com/condition");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String SuperData = (String) dataSnapshot.getValue();
                fireData.setText(SuperData);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
}
