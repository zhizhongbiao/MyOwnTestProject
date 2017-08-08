package com.example.yang.myapplication.base.ui;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yang.myapplication.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {


    private static final int DEFAULT_TOOLBAR = 1;
    private static final int NO_TOOLBAR = 0;

    private static final String LAYOUT_LINEARLAYOUT = "LinearLayout";
    private static final String LAYOUT_FRAMELAYOUT = "FrameLayout";
    private static final String LAYOUT_RELATIVELAYOUT = "RelativeLayout";
    private static final String LAYOUT_RADIOGROUP = "RadioGroup";

    private Unbinder mUnbinder;
    private View contentView;
    private LinearLayout containerView;
    private ToolbarHolder toolbarHolder;


    /**
     * @return 布局resourceId
     */
    public abstract int getViewLayout();


    /**
     * 子类Toolbar需要复写该方法
     *
     * @return
     */
    protected int getTitleViewLayout() {
        return NO_TOOLBAR;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//             透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        getWindow().setBackgroundDrawable(null);
        containerView = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.activity_base, null, false);
        AutoRelativeLayout toolBar = (AutoRelativeLayout) containerView.findViewById(R.id.rlToobar);
        if (getTitleViewLayout() == NO_TOOLBAR) {
            toolBar.setVisibility(View.GONE);
        } else {
            toolBar.setVisibility(View.VISIBLE);
            toolbarHolder = new ToolbarHolder(toolBar);
        }

        contentView = LayoutInflater.from(this).inflate(getViewLayout(), null, false);
        mUnbinder = ButterKnife.bind(this, contentView);
        addContentView(contentView);
        setContentView(containerView);
        initView(savedInstanceState,toolbarHolder, getIntent());
    }


    /**
     * 从intent获取数据，初始化View。或者其他view级第三方控件的初始化,及相关点击事件的绑定
     *
     * @param savedInstanceState
     * @param intent
     */
    protected abstract void initView(Bundle savedInstanceState,ToolbarHolder toolbarHolder, Intent intent);

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = null;
        if (name.equals(LAYOUT_FRAMELAYOUT)) {
            view = new AutoFrameLayout(context, attrs);
        } else if (name.equals(LAYOUT_LINEARLAYOUT)) {
            view = new AutoLinearLayout(context, attrs);
        } else if (name.equals(LAYOUT_RELATIVELAYOUT)) {
            view = new AutoRelativeLayout(context, attrs);
        } else if (name.equals(LAYOUT_RADIOGROUP)) {
//            view = new AutoRadioGroup(context, attrs);
        }

        if (view != null) {
            return view;
        }
        return super.onCreateView(name, context, attrs);
    }

    protected void addContentView(View view) {
        containerView.addView(view);
    }

    @Override
    protected void onDestroy() {
        mUnbinder.unbind();
        super.onDestroy();
    }


   public class ToolbarHolder implements View.OnClickListener {
        @BindView(R.id.ivBack)
        public ImageView ivBack;
        @BindView(R.id.tvCenterTitle)
        public TextView tvCenterTitle;
        @BindView(R.id.tvRightTitle)
        public TextView tvRightTitle;
        @BindView(R.id.ivRight)
        public ImageView ivRight;
        @BindView(R.id.rlToobar)
        public AutoRelativeLayout rlToobar;

        public ToolbarHolder(AutoRelativeLayout toolbar) {
            ButterKnife.bind(this, toolbar);
            ivBack.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            BaseActivity.this.finish();
        }
    }

}
