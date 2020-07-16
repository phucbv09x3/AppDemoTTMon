package com.monstar_lab_lifetime.appdemott

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_message.*
import kotlinx.android.synthetic.main.item_feed.*
import kotlinx.android.synthetic.main.item_message.*


class MessageFragment : Fragment() {


    val feedFragment=FeedFragment()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_message, container, false)
        // Inflate the layout for this fragment
        return view
    }

    fun update(mName:String){
       //tv_nameMes.setText(mName).toString()
    }



}
