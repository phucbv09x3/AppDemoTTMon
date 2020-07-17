package com.monstar_lab_lifetime.appdemott

import android.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import android.os.Build.VERSION_CODES.P
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import androidx.fragment.app.FragmentTransaction
import com.monstar_lab_lifetime.appdemott.FeedFragment
import com.monstar_lab_lifetime.appdemott.MessageFragment
import com.monstar_lab_lifetime.appdemott.R
import kotlinx.android.synthetic.main.activity_content.*
import kotlinx.android.synthetic.main.item_feed.*
import kotlinx.android.synthetic.main.item_message.*

class ContentActivity : AppCompatActivity(), View.OnClickListener, OnItemClick {
    val feedFragment = FeedFragment()
    val feedList = arrayListOf<String>()
    val messageFragment = MessageFragment()


    var fragmentManager = supportFragmentManager.beginTransaction()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        viewHome()
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
        if (feedFragment.isAdded) {
            fragmentManager.show(feedFragment)

        } else {
            fragmentManager.add(
                R.id.fr_content,
                feedFragment,
                "frgHome"
            )
        }
        fragmentManager.hide(messageFragment)
        fragmentManager.commit()
    }

    fun viewMes() {

        var fragmentManager = supportFragmentManager.beginTransaction()
        imgbtn_home.setImageResource(R.drawable.ic_group_7)
        imgbtn_mes.setImageResource(R.drawable.mes_black)
        if (messageFragment.isAdded) {
            fragmentManager.show(messageFragment)

        } else {
            fragmentManager.add(
                R.id.fr_content,
                messageFragment,
                "ok"
            )
        }
        fragmentManager.hide(feedFragment)
        fragmentManager.commit()


    }

    //        fun nextMess(name:String){
//        imgbtn_home.setImageResource(R.drawable.ic_group_7)
//        imgbtn_mes.setImageResource(R.drawable.mes_black)
//        fragmentManager.replace(
//            R.id.fr_content,
//            MessageFragment(),
//            MessageFragment::class.java.name
//        ).commit()
//    })
////    }
    override fun onClicks(feedData: FeedData, position: Int) {
        viewMes()
        //   messageFragment.update(feedData.mName.toString())
        //fragmentManagerr.show(messageFragment)
        messageFragment.list.add(0, MesData(feedData.mName, feedData.mImageProfile))
        messageFragment.adapter.setList(messageFragment.list)

        //feedData.mName.toString()

    }


}
