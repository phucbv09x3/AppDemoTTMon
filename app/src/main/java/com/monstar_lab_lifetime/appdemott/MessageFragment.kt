package com.monstar_lab_lifetime.appdemott

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_message.*
import kotlinx.android.synthetic.main.item_feed.*
import kotlinx.android.synthetic.main.item_message.*
import kotlinx.android.synthetic.main.item_message.view.*
import java.text.FieldPosition


class MessageFragment : Fragment() {

      lateinit var mNames : String


    private var list = mutableListOf<MesData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_message, container, false)
//        val rc=view.findViewById(R.id.rcy_mes) as? RecyclerView
//        rc?.setHasFixedSize(true)
//        rc?.layoutManager = LinearLayoutManager(view.context)
        val rc = view.findViewById(R.id.rcy_mes) as? RecyclerView
        rc?.layoutManager = LinearLayoutManager(view.context)
        rc?.setHasFixedSize(true)
        list.add(MesData(mNames.toString()))
        val adapter=MesAdapter(list)
        rc?.adapter=adapter
        return view
    }
    fun update(mName: String) {
        this.mNames = mName
    }


}
