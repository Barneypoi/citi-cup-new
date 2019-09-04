package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SYFragment extends Fragment {

    //JSON数据对象
    public JSONObject object;
    //接受基金信息的TextView tv1为基金名称 tv2为七日年化收益率 tv3，tv4为其他可选添加信息
    private TextView tv1, tv2, tv3, tv4;

    private ListView lv;

    //从服务器获取的信息
    private String fundName, fundId, fundType, fundRisk, fundIncre;

    //推荐基金名称接口，用于储存推荐基金的名称
    private ArrayList<String> fundIdList = new ArrayList<>();


    private View view;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab1, container, false);

        return view;
    }

//    private void jsonJX(String data) {
//        //判断数据是空
//        if (data != null) {
//            try {
//                JSONArray resultJsonArray = new JSONArray(removeBOM(data));
//                //遍历
//                for (int i = 0; i < resultJsonArray.length(); i++) {
//                    //JSON数据对象
//                    object = resultJsonArray.getJSONObject(i);
//                    try {
//                        FundInfoObject temp_fund;
//
//                        //获取到json数据中的activity数组里的内容fundId
//                        String temp_name = object.getString("fundName");
//                        fundName = temp_name;
//                        Log.v(getActivity().toString(), fundName);
//
//                        //获取到json数据中的activity数组里的内容fundId
//                        String temp_id = object.getString("fundId");
//                        fundId = temp_id;
//                        Log.v(getActivity().toString(), fundId);
//
//                        //获取到json数据中的activity数组里的内容fundType
//                        String temp_type = object.optString("fundType");
//                        fundType = temp_type;
//                        Log.v(getActivity().toString(), fundType);
//
//                        //获取到json数据中的activity数组里的内容fundIncre
//                        String temp_incre = object.getString("fundIncre");
//                        fundIncre = temp_incre;
//                        Log.v(getActivity().toString(), fundIncre);
//
//                        //获取到json数据中的activity数组里的内容fundRisk
//                        String temp_risk = object.getString("fundRisk");
//                        fundRisk = temp_risk;
//                        Log.v(getActivity().toString(), fundRisk);
//
//                        //创建基金信息对象
//                        temp_fund = new FundInfoObject(fundName, fundIncre, fundId, fundType, fundRisk);
//                        fundInfoList.add(temp_fund);
//
//                    } catch (JSONException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//                //执行完数据线程再执行UI线程防止引用空对象
//                getActivity().runOnUiThread(
//                        new Runnable() {
//                            @Override
//                            public void run() {
//                                createList();
//                            }
//                        }
//                );
//                //通过handler可以通过子线程与UI线程进行信息传递
//                Message message = new Message();
//                //传递的信息
//                message.what = 1;
//                handler.sendMessage(message);
//                // }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }


    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    public static final String removeBOM(String data) {
        if (TextUtils.isEmpty(data)) {
            return data;
        }
        if (data.startsWith("\ufeff")) {
            return data.substring(1);
        } else {
            return data;
        }
    }

}