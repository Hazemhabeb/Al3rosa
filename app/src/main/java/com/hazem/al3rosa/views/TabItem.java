//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hazem.al3rosa.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

import com.ss.bottomnavigation.R.color;
import com.ss.bottomnavigation.R.drawable;
import com.ss.bottomnavigation.R.styleable;
import com.ss.bottomnavigation.events.OnTabItemClickListener;
import com.ss.bottomnavigation.utils.AnimationHelper;
import com.ss.bottomnavigation.utils.LayoutParamsHelper;
import com.ss.bottomnavigation.utils.Util;

public class TabItem extends FrameLayout implements OnClickListener {
    private OnTabItemClickListener onTabItemClickListener;
    private int position;
    private String text;
    private Drawable selectedTabIcon;
    private int selectedTabTextColor;
    private Drawable unselectedTabIcon;
    private int unselectedTabTextColor;
    private TextView textView;
    private ImageView iconImageView;
    private boolean isActive = false;
    private int type = 1;
    private AnimationHelper animationHelper;
    private BottomNavigation bottomNavigation;

    public TabItem(Context context) {
        super(context);
        this.parseCustomAttributes((AttributeSet)null);
    }

    public TabItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.parseCustomAttributes(attrs);
    }

    public TabItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.parseCustomAttributes(attrs);
    }

    @TargetApi(21)
    public TabItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.parseCustomAttributes(attrs);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.checkParent();
    }

    private void checkParent() {
        this.post(new Runnable() {
            public void run() {
                if(TabItem.this.getParent() instanceof BottomNavigation) {
                    TabItem.this.bottomNavigation = (BottomNavigation)TabItem.this.getParent();
                    TabItem.this.type = TabItem.this.bottomNavigation.getType();
                    TabItem.this.setupView();
                } else {
                    throw new RuntimeException("TabItem parent must be BottomNavigation!");
                }
            }
        });
    }

    private void setupView() {
        this.setOnClickListener(this);
        if(this.bottomNavigation.getMode() == 0) {
            this.setLayoutParams(new LayoutParams(0, -1, (int) 1.0F));
        } else {
            this.setLayoutParams(new LayoutParams(-1, Util.dpToPx(56)));
        }

        if(VERSION.SDK_INT >= 21) {
            this.setForeground(this.getResources().getDrawable(drawable.tab_forground, (Theme)null));
        }

        this.animationHelper = new AnimationHelper(this.type);
        this.textView = new TextView(this.getContext());
        this.textView.setTextColor(this.selectedTabTextColor);
        this.textView.setText(this.text);
        this.textView.setGravity(17);
        this.textView.setLayoutParams(LayoutParamsHelper.getTabItemTextLayoutParams(this.type));
        this.textView.setTextSize(2, 12.0F);
        this.iconImageView = new ImageView(this.getContext());
        this.iconImageView.setScaleType(ScaleType.FIT_CENTER);
        this.iconImageView.setImageDrawable(this.selectedTabIcon);
        this.iconImageView.setLayoutParams(LayoutParamsHelper.getTabItemIconLayoutParams(this.type));
        if(this.position == this.bottomNavigation.getDefaultItem()) {
            this.isActive = true;
//            if(this.unselectedTabIcon != null && this.unselectedTabTextColor != 0) {
//                this.animationHelper.animateActivate(this.textView, this.iconImageView, this.selectedTabTextColor, this.selectedTabTextColor, this.selectedTabIcon, this.unselectedTabIcon);
//            } else {
//                this.animationHelper.animateActivate(this.textView, this.iconImageView);
//            }
        } else if(this.unselectedTabIcon != null && this.unselectedTabTextColor != 0) {
//            this.animationHelper.animateDeactivate(this.textView, this.iconImageView, this.unselectedTabTextColor, this.selectedTabTextColor, this.selectedTabIcon, this.unselectedTabIcon);
        } else {
//            this.animationHelper.animateDeactivate(this.textView, this.iconImageView);
        }

        switch(this.type) {
        case 0:
            if(this.isActive) {
                this.addView(this.iconImageView);
                this.addView(this.textView);
            } else {
                this.addView(this.iconImageView);
                this.addView(this.textView);
            }
            break;
        case 1:
            this.addView(this.iconImageView);
            this.addView(this.textView);
        }

    }

    private void parseCustomAttributes(AttributeSet attributeSet) {
        if(attributeSet != null) {
            TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, styleable.TabItem, 0, 0);

            try {
                this.text = typedArray.getString(styleable.TabItem_tab_text);
                if(VERSION.SDK_INT >= 23) {
                    this.selectedTabTextColor = typedArray.getColor(styleable.TabItem_tab_text_color, this.getResources().getColor(color.default_text_color, (Theme)null));
                    this.unselectedTabTextColor = typedArray.getColor(styleable.TabItem_unselected_tab_text_color, 0);
                } else {
                    this.selectedTabTextColor = typedArray.getColor(styleable.TabItem_tab_text_color, this.getResources().getColor(color.default_text_color));
                    this.unselectedTabTextColor = typedArray.getColor(styleable.TabItem_unselected_tab_text_color, 0);
                }

                this.selectedTabIcon = typedArray.getDrawable(styleable.TabItem_tab_icon);
                this.unselectedTabIcon = typedArray.getDrawable(styleable.TabItem_unselected_tab_icon);
            } finally {
                typedArray.recycle();
            }
        }

    }

    public void setSelected(boolean isActive) {
        if(this.isActive != isActive) {
            this.notifyChange();
            this.isActive = isActive;
        }

    }

    public void setOnTabItemClickListener(OnTabItemClickListener onTabItemClickListener) {
        this.onTabItemClickListener = onTabItemClickListener;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public void onClick(View view) {
        if(this.onTabItemClickListener != null) {
            this.onTabItemClickListener.onTabItemClick(this.position);
        }

    }

    private void notifyChange() {
        if(this.unselectedTabIcon != null && this.unselectedTabTextColor != 0) {
            if(this.isActive) {
                this.animationHelper.animateDeactivate(this.textView, this.iconImageView, this.unselectedTabTextColor, this.selectedTabTextColor, this.selectedTabIcon, this.unselectedTabIcon);
            } else {
                this.animationHelper.animateActivate(this.textView, this.iconImageView, this.unselectedTabTextColor, this.selectedTabTextColor, this.selectedTabIcon, this.unselectedTabIcon);
            }
        } else if(this.isActive) {
            this.animationHelper.animateDeactivate(this.textView, this.iconImageView);
        } else {
            this.animationHelper.animateActivate(this.textView, this.iconImageView);
        }

    }

    public void setTypeface(Typeface typeface) {
        if(this.textView != null) {
            this.textView.setTypeface(typeface);
        }

    }
}
