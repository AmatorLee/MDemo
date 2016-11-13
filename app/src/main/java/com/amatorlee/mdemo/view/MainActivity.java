package com.amatorlee.mdemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.amatorlee.mdemo.R;
import com.amatorlee.mdemo.model.NewInfo;
import com.amatorlee.mdemo.presenter.Presenter;

import it.sephiroth.android.library.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements ViewLogic {

    private Button mButton;
    private Presenter mPresenter = new Presenter(this);
    private ProgressBar mProgress;
    private TextView mTitle,mTime;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mTitle = (TextView) findViewById(R.id.title);
        mTime = (TextView) findViewById(R.id.time);
        img = (ImageView) findViewById(R.id.img);
        mProgress = (ProgressBar) findViewById(R.id.progress);
        mButton = (Button) findViewById(R.id.btn_get);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getInfo();
            }
        });
    }

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void showInfo(NewInfo newInfo) {
        mTitle.setText(newInfo.getResult().getData().get(0).getTitle());
        mTime.setText(newInfo.getResult().getData().get(0).getDate());
        Picasso.with(this).load(newInfo.getResult().getData().get(0).getThumbnail_pic_s()).into(img);
    }

    @Override
    public void showError(String 获取新闻信息失败) {
        Toast.makeText(this, "获取新闻信息失败", Toast.LENGTH_SHORT).show();
    }
}
