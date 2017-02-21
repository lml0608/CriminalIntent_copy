package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by lfs-ios on 2017/2/14.
 */

public class CrimeFragment extends Fragment {


    private Crime mCrime;//Crime实例
    private EditText mTitleField;//显示标题
    private Button mDateButton;//显示时间
    private CheckBox mSolvedCheckBox;//显示是否已处理


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCrime = new Crime();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        //获取fragment布局上的控件
        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        //给EditText控件增加监听
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                //CharSequence代表用户输入的内容，调用setTitle()设置Crime的标题
                mCrime.setTitle(charSequence.toString());

                //打印出title
                Log.v("CrimeFragment",mCrime.getTitle());// 打出EditText控件的输入
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        //获取button控件
        mDateButton = (Button) v.findViewById(R.id.crime_date);
        //设置时间到button上显示
        mDateButton.setText(mCrime.getDate().toString());
        //把button控件禁用
        mDateButton.setEnabled(false);

        //获取CheckBox控件
        mSolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
        //设置监听器用于更新Crime的mSolved 变量值
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                mCrime.setSolved(b);

                //输出选择的结果
                Log.v("CrimeFragment", String.valueOf(mCrime.isSolved()));
            }
        });

        return v;
    }
}
