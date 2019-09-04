package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
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

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ZXFragment extends Fragment{

    //JSON数据对象
    public JSONObject object;
    //接受基金信息的TextView tv1为基金名称 tv2为七日年化收益率 tv3，tv4为其他可选添加信息
    private TextView tv1, tv2, tv3, tv4;

    private ListView lv;


    //推荐基金名称接口，用于储存推荐基金的名称
    private ArrayList<String> fundNameList = new ArrayList<>();


    private View view;

    //用于储存该用户自选基金Id的数组
    private ArrayList<String> favoriteFundIds = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2, container, false);
        lv = (ListView) view.findViewById(R.id.lv_favourite);
        //此用于连接数据库 得到该用户的自选信息
        //initFavConnection();
        TextView title = view.findViewById(R.id.title_tv);
        title.setText("自选基金");

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }



//    private void jsonJXFav(String data){
//        //判断数据是空
//        if(data!=null){
//            try {
//
//                JSONArray resultJsonArray = new JSONArray(removeBOM(data));
//                //遍历
//                for(int i=0;i<resultJsonArray.length();i++){
//                    //JSON数据对象
//                    object=resultJsonArray.getJSONObject(i);
//                    //此处将自选的基金放入数组中
//                    String favFundId = object.optString("fundId");
//                    favoriteFundIds.add(favFundId);
//                }
//                initConnection();
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
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
