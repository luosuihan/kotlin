package com.example.administrator.kotlin;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.kotlin.fragment.HomeFragment;
import com.example.administrator.kotlin.fragment.HomeFragment1;
import com.example.administrator.kotlin.fragment.HomeFragment2;
import com.example.administrator.kotlin.fragment.HomeFragment3;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton rb_home;
    private RadioButton rb_like;
    private RadioButton rb_location;
    private RadioButton rb_me;
    private RadioGroup radio_group;
    private FragmentManager mFragmentManager;
    private HomeFragment homeFragment;
    private HomeFragment1 homeFragment1;
    private HomeFragment2 homeFragment2;
    private HomeFragment3 homeFragment3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
//        getWindow().setSoftInputMode(
//                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        initView();
    }

    private void initView() {
        radio_group = (RadioGroup) findViewById(R.id.radio_group);
        rb_home = (RadioButton) findViewById(R.id.rb_home);
        rb_like = (RadioButton) findViewById(R.id.rb_like);
        rb_location = (RadioButton) findViewById(R.id.rb_location);
        rb_me = (RadioButton) findViewById(R.id.rb_me);
        homeFragment = new HomeFragment();
        homeFragment1 = new HomeFragment1();
        homeFragment2 = new HomeFragment2();
        homeFragment3 = new HomeFragment3();
        radio_group.check(R.id.rb_home);
        rb_home.setOnClickListener(this);
        rb_like.setOnClickListener(this);
        rb_location.setOnClickListener(this);
        rb_me.setOnClickListener(this);
        addFragment(homeFragment);
    }
    @Override
    public void finish() {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        viewGroup.removeAllViews();
        super.finish();
    }
    @Override
    public void onClick(View view) {
        //我们根据参数的id区别不同按钮
        //不同按钮对应着不同的Fragment对象页面
        switch (view.getId()) {
            case R.id.rb_home:
                addFragment(homeFragment);
                break;
            case R.id.rb_like:
                addFragment(homeFragment1);
                break;
            case R.id.rb_location:
                addFragment(homeFragment2);
                break;
            case R.id.rb_me:
                addFragment(homeFragment3);
                break;
            default:
                break;
        }
    }
    //向Activity中添加Fragment的方法
    public void addFragment(Fragment fragment) {

        //获得Fragment管理器
        FragmentManager fragmentManager = getSupportFragmentManager();
        //使用管理器开启事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //使用事务替换Fragment容器中Fragment对象
        fragmentTransaction.replace(R.id.sub_content,fragment);
        //提交事务，否则事务不生效
        fragmentTransaction.commit();
    }
    public static class FragmentFactory {
        public static Fragment getInstanceByIndex(int index) {
            Fragment fragment = null;
            switch (index) {
                case R.id.rb_home:
                    fragment = new HomeFragment();
                    break;
                case R.id.rb_like:
                    fragment = new HomeFragment1();
                    break;
                case R.id.rb_location:
                    fragment = new HomeFragment2();
                    break;
                case R.id.rb_me:
                    fragment = new HomeFragment3();
                    break;
            }
            return fragment;
        }
    }
}


