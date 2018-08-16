package com.example.a94981.myapplication.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;

import java.lang.ref.WeakReference;

public class CustomImageSpan extends DynamicDrawableSpan {

    public static final int ALIGN_CENTER = -1;

    private Drawable mDrawable;

    public CustomImageSpan(Drawable d) {
        this(d, ALIGN_CENTER);
    }

    public CustomImageSpan(Drawable d, int verticalAlignment) {
        super(verticalAlignment);
        mDrawable = d;
    }

    @Override
    public Drawable getDrawable() {
        return mDrawable;
    }

    @Override
    public void draw(
            Canvas canvas,
            CharSequence text,
            int start,
            int end,
            float x,
            int top,
            int y,
            int bottom,
            Paint paint) {
        Drawable b = getCachedDrawable();
        if (b == null) {
            return;
        }
        canvas.save();
        Paint.FontMetricsInt fm = paint.getFontMetricsInt();
        int transY = y;
        switch (getVerticalAlignment()) {
            case ALIGN_BASELINE:
                transY -= paint.getFontMetricsInt().descent;
            case ALIGN_BOTTOM:
                transY += fm.bottom - b.getBounds().bottom;
                break;
            default:
                transY += (fm.ascent + fm.descent) / 2 - b.getBounds()
                        .height() / 2 - b.getBounds().top;
                break;
        }
        canvas.translate(x, transY);
        b.draw(canvas);
        canvas.restore();
    }

    private Drawable getCachedDrawable() {
        WeakReference<Drawable> wr = mDrawableRef;
        Drawable d = null;
        if (wr != null)
            d = wr.get();
        if (d == null) {
            d = getDrawable();
            mDrawableRef = new WeakReference<>(d);
        }
        return d;
    }

    private WeakReference<Drawable> mDrawableRef;
}
