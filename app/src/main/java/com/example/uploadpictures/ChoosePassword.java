package com.example.uploadpictures;

import android.os.Build;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChoosePassword extends AppCompatActivity {
    private List<ImageInDatabase> imageList;
    DatabaseReference myRef;

    private ImageButton first;
    private ImageButton second;
    private ImageButton third;
    private ImageButton forth;
    private Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_password);

        first = (ImageButton) findViewById(R.id.imageBtn1);
        second = (ImageButton) findViewById(R.id.imageBtn2);
        third = (ImageButton) findViewById(R.id.imageBtn3);
        forth = (ImageButton) findViewById(R.id.imageBtn4);
        imageList = new ArrayList<>();

        myRef = FirebaseDatabase.getInstance().getReference("Datas").child("Datas");

        //get data from database and add to list
        myRef.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot di : dataSnapshot.getChildren()) {
                    ImageInDatabase showImageList = di.getValue(ImageInDatabase.class);
                    imageList.add(showImageList);

                    final ArrayList<String> list = new ArrayList<String>();
                    for (int i = 0; i < imageList.size(); i++) {
                        ImageInDatabase getData = imageList.get(i);
                        String filename = getData.getFilename();
                        list.add(filename);
                    }

                    ArrayList<String> URLlist = new ArrayList<String>();

                    for (int i = 0; i < imageList.size(); i++) {
                        int random = rnd.nextInt(imageList.size());
                        ImageInDatabase getData = imageList.get(random);
                        String imageURL = getData.getImageUrl();

                        while (list.contains(imageURL)) {
                            random = rnd.nextInt(imageList.size());
                            getData = imageList.get(random);
                            imageURL = getData.getImageUrl();
                        }
                        URLlist.add(imageURL);
                    }


                            Glide.with(ChoosePassword.this).load(URLlist.get(0)).into(first);

                            //Glide.with(ChoosePassword.this).load(URLlist.get(1)).into(second);

                            //Glide.with(ChoosePassword.this).load(URLlist.get(2)).into(third);


                    /*FirebaseStorage mStorage = FirebaseStorage.getInstance();
                    //show image on image button.
                    final long ONE_MEGABYTE = 1024 * 1024;
                    StorageReference mImageRef = mStorage.getReference("Images/" + list.get(rnd.nextInt(2)));

                            mImageRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                                @Override
                                public void onSuccess(byte[] bytes) {
                                    Bitmap bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                                    DisplayMetrics dm = new DisplayMetrics();
                                    getWindowManager().getDefaultDisplay().getMetrics(dm);

                                    first.setMinimumHeight(dm.heightPixels);
                                    first.setMinimumWidth(dm.widthPixels);
                                    first.setImageBitmap(bm);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception exception) {
                                    // Handle any errors
                                }
                            });*/


                            /*mImageRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                                @Override
                                public void onSuccess(byte[] bytes) {
                                    Bitmap bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                                    DisplayMetrics dm = new DisplayMetrics();
                                    getWindowManager().getDefaultDisplay().getMetrics(dm);

                                    second.setMinimumHeight(dm.heightPixels);
                                    second.setMinimumWidth(dm.widthPixels);
                                    second.setImageBitmap(bm);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception exception) {
                                    // Handle any errors
                                }
                            });*/



                    }
                }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}