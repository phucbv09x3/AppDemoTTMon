package com.monstar_lab_lifetime.appdemott

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.view.menu.SubMenuBuilder
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.monstar_lab_lifetime.appdemott.FeedFragment
import com.monstar_lab_lifetime.appdemott.MessageFragment
import com.monstar_lab_lifetime.appdemott.R
import kotlinx.android.synthetic.main.activity_content.*
import kotlinx.android.synthetic.main.item_feed.*

class ContentActivity : AppCompatActivity(), View.OnClickListener, OnItemClick {
    val feedFragment = FeedFragment()
    val feedList = mutableListOf<FeedData>()
    val messageFragment = MessageFragment()


    var fragmentManager = supportFragmentManager.beginTransaction()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
//        var fragmentManager = supportFragmentManager.beginTransaction()
//        imgbtn_home.setImageResource(R.drawable.home_black)
//        imgbtn_mes.setImageResource(R.drawable.ic_group_mes)
//        fragmentManager.replace(
//            R.id.fr_content,
//            feedFragment,
//            "frgMan"
//        )
//            .commit()
        fragmentManager.show(feedFragment)
        //viewHome()
        imgbtn_home.setImageResource(R.drawable.home_black)
        imgbtn_home.setOnClickListener(this)
        imgbtn_mes.setOnClickListener(this)


    }
    
    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.imgbtn_home -> {

                viewHome()


            }
            R.id.imgbtn_mes -> {
                viewMes()
            }
        }
    }



    fun viewHome() {
        var fragmentManager = supportFragmentManager.beginTransaction()
        imgbtn_home.setImageResource(R.drawable.home_black)
        imgbtn_mes.setImageResource(R.drawable.ic_group_mes)
        fragmentManager.replace(
            R.id.fr_content,
            feedFragment,
            "frgMan"
        )
            .commit()
    }

    fun viewMes() {
        var fragmentManager = supportFragmentManager.beginTransaction()
        imgbtn_home.setImageResource(R.drawable.ic_group_7)
        imgbtn_mes.setImageResource(R.drawable.mes_black)
        fragmentManager.replace(
            R.id.fr_content,
            messageFragment,
            "fragMes"
        )
            .commit()
    }

    //        fun nextMess(name:String){
//        imgbtn_home.setImageResource(R.drawable.ic_group_7)
//        imgbtn_mes.setImageResource(R.drawable.mes_black)
//        fragmentManager.replace(
//            R.id.fr_content,
//            MessageFragment(),
//            MessageFragment::class.java.name
//        ).commit()
//    }
    override fun onClicks(feedData: FeedData, position: Int) {
        val fragmentManagerN = supportFragmentManager.beginTransaction()
        fragmentManagerN.replace(
            R.id.fr_content,
            messageFragment,
            "fragMes"
        ).hide(feedFragment)
            .commit()
      //   messageFragment.update(feedData.mName.toString())
        //fragmentManagerr.show(messageFragment)
        messageFragment.update(feedData.mName)
        //feedData.mName.toString()

    }


}
