package com.example.liaoxiaomin.mynohttptest;

import android.app.VoiceInteractor;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView mImageView;
    private Button mButton;
    private int WHAT=0;
    private final String url = "https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=false&word=%E8%83%A1%E6%AD%8C%E5%9B%BE%E7%89%87&hs=2&pn=1&spn=0&di=199640852400&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=1405695701%2C3108249107&os=2699849798%2C2628821121&simid=4148232293%2C885342282&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=star&bdtype=0&oriquery=%E8%83%A1%E6%AD%8C%E5%9B%BE%E7%89%87&objurl=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201603%2F29%2F20160329123454_th4nZ.jpeg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3B17tpwg2_z%26e3Bv54AzdH3Fks52AzdH3F%3Ft1%3Dccn9mlmnd&gsm=0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView=findViewById(R.id.myImageView_id);
        mButton=findViewById(R.id.mybutton_id);
        mImageView.setOnClickListener(this);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mybutton_id:
                reques();
                break;
            default:
                break;
        }
    }
    public void reques(){
        Request<Bitmap> request=NoHttp.createImageRequest(url, RequestMethod.GET);

        MyApplication.mQueue.add(WHAT, request, new OnResponseListener<Bitmap>() {

            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, Response<Bitmap> response) {
                if(what==WHAT){
                    mImageView.setImageBitmap(response.get());
                }
            }

            @Override
            public void onFailed(int what, Response<Bitmap> response) {

            }

            @Override
            public void onFinish(int what) {

            }
        });

    }
}
