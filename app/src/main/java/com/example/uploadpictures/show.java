package com.example.uploadpictures;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class show extends AppCompatActivity {
    private RecyclerView showImage;
    private List<ShowImage> imageList;
    private Button btnShow;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        showImage = findViewById(R.id.newimageView);
        showImage.setHasFixedSize(true);
        showImage.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration deco = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        showImage.addItemDecoration(deco);
        imageList = new ArrayList<>();
        myRef = FirebaseDatabase.getInstance().getReference("Datas").child("Datas");
        getImageData();

        btnShow = (Button)findViewById(R.id.btnShow2);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(show.this, ChoosePassword.class);
                startActivity(intent);
            }
        });
    }

    private void getImageData() {
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot di:dataSnapshot.getChildren()){
                    ShowImage showImageList = di.getValue(ShowImage.class);
                    imageList.add(showImageList);
                }
                imageAdapter adapter = new imageAdapter(imageList, getApplicationContext());
                showImage.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}