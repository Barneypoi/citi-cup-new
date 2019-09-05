package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


//个人信息界面
public class PersonalInfoFragment extends Fragment {

    private View view;
    private Button btn_order, btn_contact, btn_problem, btn_exit; //添加我的信息界面两按钮的回调事件


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.fragment_personalinfo ,container, false);
        btn_order = view.findViewById(R.id.btn_checkorder);
        btn_exit = view.findViewById(R.id.btn_personinfoexit);


        return view;
    }

    public void addClickListener(){
        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 跳转至查看订单界面

                /*Intent checkorder = new Intent(getActivity(),XXXXActivity.this);
                startActivity(checkorder);*/


            }
        });

        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 跳转至联系客服界面
                /*Intent intent = new Intent(getActivity(),XXXXActivity.this);
                startActivity(intent);*/

            }
        });

        btn_problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 跳转至常见问题界面
                /*Intent intent = new Intent(getActivity(),XXXXActivity.this);
                startActivity(intent);*/

            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 执行退出账号后的操作

            }
        });
    }
}
