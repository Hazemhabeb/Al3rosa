//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hazem.al3rosa.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.ss.bottomnavigation.R.dimen;
import com.ss.bottomnavigation.R.styleable;
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;
import com.ss.bottomnavigation.events.OnTabItemClickListener;
import com.ss.bottomnavigation.utils.AnimationHelper;
import java.util.ArrayList;
import java.util.List;

public class BottomNavigation extends LinearLayout implements OnTabItemClickListener {
    private int type;
    public static final int TYPE_FIXED = 1;
    public static final int TYPE_DYNAMIC = 0;
    public static final int MODE_PHONE = 0;
    public static final int MODE_TABLET = 1;
    private int defaultItem = 0;
    private int selectedItemPosition;
    List<TabItem> tabItems;
    private Typeface typeface;
    private int mode;
    private OnSelectedItemChangeListener onSelectedItemChangeListener;

    public BottomNavigation(Context context) {
        super(context);
        this.selectedItemPosition = this.defaultItem;
        this.tabItems = new ArrayList();
        this.mode = 0;
        if(!this.isInEditMode()) {
            this.setup((AttributeSet)null);
        }

    }

    public BottomNavigation(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.selectedItemPosition = this.defaultItem;
        this.tabItems = new ArrayList();
        this.mode = 0;
        if(!this.isInEditMode()) {
            this.setup(attrs);
        }

    }

    public BottomNavigation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.selectedItemPosition = this.defaultItem;
        this.tabItems = new ArrayList();
        this.mode = 0;
        if(!this.isInEditMode()) {
            this.setup(attrs);
        }

    }

    @TargetApi(21)
    public BottomNavigation(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.selectedItemPosition = this.defaultItem;
        this.tabItems = new ArrayList();
        this.mode = 0;
        if(!this.isInEditMode()) {
            this.setup(attrs);
        }

    }

    private void setup(AttributeSet attributeSet) {
        this.parseAttributes(attributeSet);
        switch(this.mode) {
        case 0:
        default:
            this.setOrientation(0);
            this.setGravity(3);
            break;
        case 1:
            this.setOrientation(1);
            this.setGravity(1);
        }

        this.setMinimumHeight(this.getContext().getResources().getDimensionPixelSize(dimen.bottom_navigation_min_width));
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.setupChildren();
    }

    private void setupChildren() {
        if(this.getChildCount() > 0) {
            if(this.getChildCount() >= 3 && this.getChildCount() <= 5) {
                if(this.getChildCount() > 3) {
                    this.type = 0;
                } else {
                    this.type = 1;
                }

                for(int i = 0; i < this.getChildCount(); ++i) {
                    if(!(this.getChildAt(i) instanceof TabItem)) {
                        throw new RuntimeException("Bottom navigation only accept tab item as child.");
                    }

                    TabItem tabItem = (TabItem)this.getChildAt(i);
                    tabItem.setPosition(i);
                    this.tabItems.add(tabItem);
                    tabItem.setOnTabItemClickListener(this);
                }

            } else {
                throw new RuntimeException("Bottom navigation child count must between 3 to 5 only.");
            }
        } else {
            throw new RuntimeException("Bottom navigation can\'t be empty!");
        }
    }

    private void onSelectedItemChanged() {
        for(int i = 0; i < this.tabItems.size(); ++i) {
            if(((TabItem)this.tabItems.get(i)).getPosition() == this.selectedItemPosition) {
                ((TabItem)this.tabItems.get(i)).setSelected(true);
            } else {
                ((TabItem)this.tabItems.get(i)).setSelected(false);
            }
        }

    }

    public void onTabItemClick(final int position) {
        if(position != this.selectedItemPosition) {
            this.selectedItemPosition = position;
            this.onSelectedItemChanged();
            if(this.onSelectedItemChangeListener != null) {
                this.postDelayed(new Runnable() {
                    public void run() {
                        BottomNavigation.this.onSelectedItemChangeListener.onSelectedItemChanged(((TabItem)BottomNavigation.this.tabItems.get(position)).getId());
                    }
                }, (long)AnimationHelper.ANIMATION_DURATION);
            }
        }

    }

    private void parseAttributes(AttributeSet attributeSet) {
        if(attributeSet != null) {
            TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, styleable.BottomNavigation);

            try {
                this.mode = typedArray.getInteger(styleable.BottomNavigation_mode, 0);
            } finally {
                typedArray.recycle();
            }
        }

    }

    public int getType() {
        return this.type;
    }

    public void setDefaultItem(int position) {
        this.defaultItem = position;
    }

    public int getDefaultItem() {
        return this.defaultItem;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public void setTypeface(final Typeface typeface) {
        this.typeface = typeface;

        for(int i = 0; i < this.tabItems.size(); ++i) {
            final TabItem tabItem = (TabItem)this.tabItems.get(i);
            tabItem.post(new Runnable() {
                public void run() {
                    tabItem.setTypeface(typeface);
                }
            });
        }

    }

    public void setOnSelectedItemChangeListener(OnSelectedItemChangeListener onSelectedItemChangeListener) {
        this.onSelectedItemChangeListener = onSelectedItemChangeListener;
        onSelectedItemChangeListener.onSelectedItemChanged(((TabItem)this.tabItems.get(this.defaultItem)).getId());
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getSelectedItem() {
        return this.selectedItemPosition;
    }

    public void setSelectedItem(int position) {
        this.onTabItemClick(position);
    }
}
