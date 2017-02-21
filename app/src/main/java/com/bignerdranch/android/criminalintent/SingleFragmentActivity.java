package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by lfs-ios on 2017/2/14.
 */

public abstract class SingleFragmentActivity extends FragmentActivity {


    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            //调用createFragment()
            fragment = createFragment();
            /**创建并提交了一个　fragment事务，加入一个添加操作，然后提交该事务
             * fragment事务被用来添加，移除，附加，分离获替换fragment队列中的fragment
             * 这是fragment运行时组装和重新组装用户界面的关键
             * add(...) 两个参数：容器视图资源id和新创建的CrimeFragment
             * 容器视图资源id的作用，1。告诉FragmentManager，fragment视图应该出现在activity
             * 视图的位置，2。唯一表示
             */
            fm.beginTransaction().add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
