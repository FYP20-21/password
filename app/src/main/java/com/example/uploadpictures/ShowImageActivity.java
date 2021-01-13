package com.example.uploadpictures;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class ShowImageActivity extends AppCompatActivity {
    private RecyclerView showImage;
    private List<ShowImage> imageList;
    private Button btnShow;
    DatabaseReference myRef;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        /*btnShow = (Button)findViewById(R.id.btnShow);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        showImage = findViewById(R.id.imageView);
        showImage.setHasFixedSize(true);
        showImage.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration deco = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        showImage.addItemDecoration(deco);
        imageList = new ArrayList<>();
        myRef = FirebaseDatabase.getInstance().getReference("Datas");
        getImageData();*/
    }

    /*private void getImageData() {
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
    }*/
}
