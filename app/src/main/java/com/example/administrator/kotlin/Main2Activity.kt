package com.example.administrator.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.administrator.kotlin.fmkotlin.MeFragment
import com.example.administrator.kotlin.fmkotlin.MeFragment1
import com.example.administrator.kotlin.fmkotlin.MeFragment2
import com.example.administrator.kotlin.fmkotlin.MeFragment3
import com.example.administrator.kotlin.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
//        initView();s
        var meFragment = MeFragment()
        var meFragment1 = MeFragment1()
        var meFragment2 = MeFragment2()
        var meFragment3 = MeFragment3()
        radio_group.check(R.id.rb_home);
        rb_home.setOnClickListener {
            addFragment(meFragment)
        }
        rb_like.setOnClickListener {
            addFragment(meFragment1)
        }
        rb_location.setOnClickListener {
            addFragment(meFragment2)
        }
        rb_me.setOnClickListener {
            addFragment(meFragment3)
        }
    }

    fun addFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.sub_content, fragment)
        fragmentTransaction.commit()
    }
}
