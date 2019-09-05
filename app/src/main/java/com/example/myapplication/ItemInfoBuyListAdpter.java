package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ItemInfoBuyListAdpter extends ArrayAdapter<ItemObject> {
    private int resourceId;

    public ItemInfoBuyListAdpter(@NonNull Context context, int resource, @NonNull List<ItemObject> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

        ItemObject temp_item = getItem(position);

        //设置列表项文本
        TextView tv_user = view.findViewById(R.id.tv_setbuyerorseller);
        Button btn_sell = view.findViewById(R.id.btn_setbuyorsell);
        tv_user.setText("买家： ");
        btn_sell.setText("供应");

        TextView temp_price = view.findViewById(R.id.tv_itemprice);
        TextView temp_seller = view.findViewById(R.id.tv_itemuser);

        temp_price.setText(String.valueOf(temp_item.getPrice()));
        temp_seller.setText(temp_item.getUserName());

        return view;
    }
}
