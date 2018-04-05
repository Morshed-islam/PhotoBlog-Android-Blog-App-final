package in.com.techmorshed.blogapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailsActivity extends AppCompatActivity {


    private TextView desc;
    private ImageView imgV;

    private String TAG = "morshed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        desc = findViewById(R.id.description);
     //   imgV = findViewById(R.id.details_img);



        Intent intent = getIntent();
        String url = intent.getStringExtra("title");
        String imgThumb = intent.getStringExtra("imgThumb");
        String imgUrl = intent.getStringExtra("imgUrl");

        setBlogImage(imgUrl,imgThumb);

        Log.i(TAG,"Intent value : "+url);


          desc.setText(url);

//        Glide.with(getApplicationContext()).applyDefaultRequestOptions(placeholderOption).load(image).into(blogUserImage);


    }

    public void setBlogImage(String downloadUri, String thumbUri){

        imgV = findViewById(R.id.details_img);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.image_placeholder);

        Glide.with(getApplicationContext()).applyDefaultRequestOptions(requestOptions).load(downloadUri).thumbnail(
                Glide.with(getApplicationContext()).load(thumbUri)
        ).into(imgV);

    }
}
