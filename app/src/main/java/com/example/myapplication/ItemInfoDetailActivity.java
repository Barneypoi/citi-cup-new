package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ItemInfoDetailActivity extends FragmentActivity implements View.OnClickListener{

    //声明Tab的布局文件
    private LinearLayout mTabSell; //出售
    private LinearLayout mTabBuy; //求购
    private LinearLayout mTabPrice; //价格趋势


    //声明Tab分别对应的Fragment
    private Fragment mFragSell;
    private Fragment mFragBuy;
    private Fragment mFragPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews();//初始化控件
        initEvents();//初始化事件

        selectTab(0);//默认选中第一个Tab
        TextView tv_title = findViewById(R.id.title_tv);
        tv_title.setText("商品详情界面");
        TextView textView1 = findViewById(R.id.id_tab_Sell_text);
        textView1.setTextColor(getResources().getColor(R.color.black));

    }

    private void initEvents() {
        //初始化Tab的点击事件
        mTabSell.setOnClickListener(this);
        mTabBuy.setOnClickListener(this);
        mTabPrice.setOnClickListener(this);
    }

    private void initViews() {
        //初始化Tab的布局文件
        mTabSell =  findViewById(R.id.id_tab_Sell);
        mTabBuy =  findViewById(R.id.id_tab_Buy);
        mTabPrice = findViewById(R.id.id_tab_Price);

    }

    //处理Tab的点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_tab_Sell:
                selectTab(0);//当点击的是首页的Tab就选中微信的Tab
                resetBottomText();
                TextView textView1 = findViewById(R.id.id_tab_Sell_text);
                textView1.setTextColor(getResources().getColor(R.color.black));
                break;
            case R.id.id_tab_Buy:
                selectTab(1);
                resetBottomText();
                TextView textView2 = findViewById(R.id.id_tab_Buy_text);
                textView2.setTextColor(getResources().getColor(R.color.black));
                break;
            case R.id.id_tab_Price:
                selectTab(2);
                resetBottomText();
                TextView textView3 = (TextView)findViewById(R.id.id_tab_Price_text);
                textView3.setTextColor(getResources().getColor(R.color.black));
                break;
        }

    }

    private void resetBottomText()
    {
        TextView textView1 = (TextView)findViewById(R.id.id_tab_Sell_text);
        textView1.setTextColor(getResources().getColor(R.color.grey));
        TextView textView2 = (TextView)findViewById(R.id.id_tab_Buy_text);
        textView2.setTextColor(getResources().getColor(R.color.grey));
        TextView textView3 = (TextView)findViewById(R.id.id_tab_Price_text);
        textView3.setTextColor(getResources().getColor(R.color.grey));
    }
    //进行选中Tab的处理
    private void selectTab(int i) {
        //获取FragmentManager对象
        FragmentManager manager = getSupportFragmentManager();
        //获取FragmentTransaction对象
        FragmentTransaction transaction = manager.beginTransaction();
        //先隐藏所有的Fragment
        hideFragments(transaction);
        switch (i) {
            //当选中点击的是首页的Tab时
            case 0:
                //如果对应的Fragment没有实例化，则进行实例化，并显示出来
                if (mFragSell == null) {
                    mFragSell = new SellFragment();
                    transaction.add(R.id.id_content, mFragSell);
                } else {
                    //如果对应的Fragment已经实例化，则直接显示出来
                    transaction.show(mFragSell);
                }
                break;
            case 1:
                if (mFragBuy == null) {
                    mFragBuy = new BuyFragment();
                    transaction.add(R.id.id_content, mFragBuy);
                } else {
                    transaction.show(mFragBuy);
                }
                break;
            case 2:
                if (mFragPrice == null) {
                    mFragPrice = new PriceFragment();
                    transaction.add(R.id.id_content, mFragPrice);
                } else {
                    transaction.show(mFragPrice);
                }
                break;
        }
        //不要忘记提交事务
        transaction.commit();
    }


    //将Fragment隐藏
    private void hideFragments(FragmentTransaction transaction) {
        if (mFragSell != null) {
            transaction.hide(mFragSell);
        }
        if (mFragBuy != null) {
            transaction.hide(mFragBuy);
        }
        if (mFragPrice != null) {
            transaction.hide(mFragPrice);
        }
    }




    //统一定义单击返回按键执行操作
    public void backToMain(View view){
        onBackPressed();
    }
}
