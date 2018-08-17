package com.multitagtext.views.activites;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

import com.multitagtext.R;
import com.multitagtext.utils.CommonUtil;
import com.multitagtext.utils.CustomDrawableSpan;


public class Example5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example5);
        TextView tvTitle = findViewById(R.id.tv_title);
        SpannableStringBuilder builder = new SpannableStringBuilder(" " + tvTitle.getText()
                .toString());
        View view = View.inflate(this, R.layout.tag, null);
        view.findViewById(R.id.tv_tag2)
                .setVisibility(View.GONE);
        builder.setSpan(new CustomDrawableSpan(CommonUtil.getDrawingCache(this, view)),
                0,
                1,
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tvTitle.setText(builder);
    }
}
