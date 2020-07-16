package com.monstar_lab_lifetime.appdemott

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.view.menu.SubMenuBuilder
import androidx.fragment.app.Fragment
import com.monstar_lab_lifetime.appdemott.FeedFragment
import com.monstar_lab_lifetime.appdemott.MessageFragment
import com.monstar_lab_lifetime.appdemott.R
import kotlinx.android.synthetic.main.activity_content.*
import kotlinx.android.synthetic.main.item_feed.*

class ContentActivity : AppCompatActivity(), View.OnClickListener, OnItemClick {
    val feedFragment = FeedFragment()
    val feedList = mutableListOf<FeedData>()
    var fragmentManager = supportFragmentManager.beginTransaction()

    val messageFragment = MessageFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        val fragmentManagerr = supportFragmentManager.beginTransaction()
        fragmentManager.replace(
            R.id.fr_content,
            feedFragment,
            FeedFragment::class.java.name
        )
            .commit()
        imgbtn_home.setImageResource(R.drawable.home_black)
        imgbtn_home.setOnClickListener(this)
        imgbtn_mes.setOnClickListener(this)


    }


    override fun onClick(v: View?) {
        val fragmentManager = supportFragmentManager.beginTransaction()
        when (v?.id) {
            R.id.imgbtn_home -> {
                imgbtn_home.setImageResource(R.drawable.home_black)
                imgbtn_mes.setImageResource(R.drawable.ic_group_mes)
                fragmentManager.replace(
                    R.id.fr_content,
                    feedFragment,
                    FeedFragment::class.java.name
                )
                    .commit()
            }
            R.id.imgbtn_mes -> {
                imgbtn_home.setImageResource(R.drawable.ic_group_7)
                imgbtn_mes.setImageResource(R.drawable.mes_black)
                fragmentManager.replace(
                    R.id.fr_content,
                    messageFragment,
                    MessageFragment::class.java.name
                )

                    .commit()
            }
        }

    }


    //    fun nextMess(name:String){
//        imgbtn_home.setImageResource(R.drawable.ic_group_7)
//        imgbtn_mes.setImageResource(R.drawable.mes_black)
//        fragmentManager.replace(
//            R.id.fr_content,
//            MessageFragment(),
//            MessageFragment::class.java.name
//        ).commit()
//    }
    override fun onClicks(feedData: FeedData, position: Int) {
        fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(
            R.id.fr_content,
            messageFragment,
            MessageFragment::class.java.name
        )
        messageFragment?.update(feedData.mName.toString())
    }


}
