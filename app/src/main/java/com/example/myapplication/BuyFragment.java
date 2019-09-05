package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BuyFragment extends Fragment {
    //测试数据
    private ArrayList<ItemObject> itemlist = new ArrayList<>();

    private ItemInfoBuyListAdpter baseAdapter ;
    private ListView lv;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_buy,container, false);

        //TODO add other manipulations here
        //测试数据
        ItemObject item1 = new ItemObject("1",213);
        ItemObject item2 = new ItemObject("2",23);
        ItemObject item3 = new ItemObject("3",654);
        ItemObject item4 = new ItemObject("4",43);
        ItemObject item5 = new ItemObject("5",435.88);
        ItemObject item6 = new ItemObject("6",666.66);
        ItemObject item7 = new ItemObject("7",3.6);
        ItemObject item8 = new ItemObject("8",12);

        itemlist.add(item1);itemlist.add(item2);itemlist.add(item3);itemlist.add(item4);itemlist.add(item5);itemlist.add(item6);itemlist.add(item7);itemlist.add(item8);
        lv = view.findViewById(R.id.buy_lv);
        createList();

        return view;
    }

    private void createList(){
        baseAdapter = new ItemInfoBuyListAdpter(getContext(), R.layout.listitem_iteminfo, itemlist);
        lv.setAdapter(baseAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                TextView tv1 = view.findViewById(R.id.tv_itemprice);
                Toast.makeText(getContext(),tv1.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
