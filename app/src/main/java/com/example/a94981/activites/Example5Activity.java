package com.example.a94981.activites;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

import com.example.a94981.R;
import com.example.a94981.myapplication.utils.CommonUtils;
import com.example.a94981.myapplication.utils.CustomImageSpan;

public class Example5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example5);
        TextView tvTitle = findViewById(R.id.tv_title);
        SpannableStringBuilder builder = new SpannableStringBuilder(" " + tvTitle.getText().toString());
        View view = View.inflate(this, R.layout.tag, null);
        view.findViewById(R.id.tv_tag2).setVisibility(View.GONE);
        builder.setSpan(new CustomImageSpan(CommonUtils.getDrawingCache(this, view)), 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tvTitle.setText(builder);
    }
}
