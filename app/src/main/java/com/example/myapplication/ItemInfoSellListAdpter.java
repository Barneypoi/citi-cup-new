package com.example.myapplication;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.ItemObject;
import com.example.myapplication.R;

import java.util.List;


public class ItemInfoSellListAdpter extends ArrayAdapter<ItemObject> {
    private int resourceId;
    PopupWindow popupWindow;
    View view;

    public ItemInfoSellListAdpter(@NonNull Context context, int resource, @NonNull List<ItemObject> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

        ItemObject temp_item = getItem(position);

        //设置列表项文本
        TextView tv_user = view.findViewById(R.id.tv_setbuyerorseller);
        Button btn_sell = view.findViewById(R.id.btn_setbuyorsell);
        tv_user.setText("卖家： ");
        btn_sell.setText("购买");

        final TextView temp_price = view.findViewById(R.id.tv_itemprice);
        TextView temp_seller = view.findViewById(R.id.tv_itemuser);

        temp_price.setText(String.valueOf(temp_item.getPrice()));
        temp_seller.setText(temp_item.getUserName());

        //设置商品列表项购买按钮回调事件
        Button btn = view.findViewById(R.id.btn_setbuyorsell);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getContext(), temp_price.getText(),Toast.LENGTH_LONG).show();
                bottomWindow(view);

            }
        });



        return view;
    }

    public void bottomWindow(View view){
        LinearLayout layout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.activity_bottompopup, null);
        popupWindow = new PopupWindow(layout, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        //点击空白处，隐藏pop窗口
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
//添加弹出、弹入的动画
        popupWindow.setAnimationStyle(R.style.Popupwindow);
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        popupWindow.showAtLocation(view, Gravity.LEFT | Gravity.BOTTOM, 0, -location[1]);
        //添加按键事件监听
        setButtonListeners(layout);
        //添加pop窗口关闭事件，主要是实现关闭时改变背景的透明度
        backgroundAlpha(1f);

    }

    private void setButtonListeners(LinearLayout layout){
        Button submit = layout.findViewById(R.id.btn_submitOrder);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow != null && popupWindow.isShowing()) {
                    //TODO 在此处添加点击提交订单按钮的后台操作



                    Toast.makeText(getContext(),"Order Submit!",Toast.LENGTH_SHORT).show();
                    popupWindow.dismiss();
                }
            }
        });

    }

    public void backgroundAlpha(float bgAlpha)
    {
        WindowManager.LayoutParams lp = ((Activity) getContext()).getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        ((Activity) getContext()).getWindow().setAttributes(lp);
        ((Activity) getContext()).getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

}
