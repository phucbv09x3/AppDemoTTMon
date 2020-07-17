package com.monstar_lab_lifetime.appdemott

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.monstar_lab_lifetime.appdemott.FeedAdapter
import com.monstar_lab_lifetime.appdemott.FeedData
import kotlinx.android.synthetic.main.fragment_feed.*
import kotlinx.android.synthetic.main.item_feed.*
import kotlinx.android.synthetic.main.item_feed.view.*
import java.text.SimpleDateFormat
import java.util.*


class FeedFragment : Fragment(){
    val feedList = mutableListOf<FeedData>()
    var onItemClick: OnItemClick? = null
    private var type = arrayOf("Hello", "Goodbye", "Xin Chao")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        Log.d("m","okoko")
        //onItemClick=activity as OnItemClick
        var view = inflater.inflate(R.layout.fragment_feed, container, false)

        val rc = view.findViewById(R.id.rcy_feed) as RecyclerView
        rc.layoutManager = LinearLayoutManager(view.context)
        rc.setHasFixedSize(true)
        var lang = resources.getStringArray(R.array.lang)

        val spinner = view.findViewById<Spinner>(R.id.spinner)
        var adapter = ArrayAdapter(
            view.context, android.R.layout.simple_spinner_dropdown_item, lang
        )
        spinner.adapter = adapter
        Log.d("o", "ok")


        feedList.add(
            FeedData(
                R.drawable.ngoc,
                "Martin Palmer",
                getCurrentDate(),
                "What is the loop of Creation? How is there phuc bui something from nothing? In spite of the fact that it is impossible to prove that anythin…."
                ,
                0

            )
        )
        feedList.add(
            FeedData(
                R.drawable.mytam,
                "Daniel Leonarda",
                "Today, 08:24 PM",
                "What is the loop of Creation? How is there something from nothing? In spite of the fact that it is impossible to prove that anythin…."
                ,
                R.drawable.real
            )
        )
        feedList.add(
            FeedData(
                R.drawable.billgate,
                "Raphel Nadal",
                getCurrentDate(),
                "What is the loop of Creation? How is there something from nothing? In spite of the fact that it is impossible to prove that anythin…."
                ,
                R.drawable.vn
            )
        )
        feedList.add(
            FeedData(
                R.drawable.fesuson,
                "Martil Phekol",
                "Today, 02:24 PM",
                "What is the loop of Creation? How is there something from nothing? In spite of the fact that it is impossible to prove that anythin…."
                ,
                R.drawable.rectangle_copy
            )
        )
        feedList.add(
            FeedData(
                R.drawable.kaka,
                "Horoku Pental",
                getCurrentDate(),
                "What is the loop of Creation? How is there something from nothing? In spite of the fact that it is impossible to prove that anythin…."
                ,
                R.drawable.vn
            )
        )

        val adapte: FeedAdapter = FeedAdapter(feedList,activity as ContentActivity )//activity as ContentActivity
        rc.adapter = adapte
        return view
    }


    fun getCurrentDate(): String {
        val date = Date()
        val dateFormat = "dd/MM/yyyy hh:mm"
        val sdf = SimpleDateFormat(dateFormat)
        return sdf.format(date)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }



}
