package com.example.a94981.activites;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.TextView;

import com.example.a94981.R;
import com.example.a94981.myapplication.utils.CustomImageSpan;

public class Example4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example4);
        TextView tvTitle = findViewById(R.id.tv_title);
        SpannableStringBuilder builder = new SpannableStringBuilder(" " + tvTitle.getText()
                .toString());
        Drawable drawable = ContextCompat.getDrawable(this, R.mipmap.icon_discount_tag_primary);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        builder.setSpan(new CustomImageSpan(drawable), 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tvTitle.setText(builder);
    }
}
