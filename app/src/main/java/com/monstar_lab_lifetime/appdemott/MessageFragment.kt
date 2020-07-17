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
import kotlin.String


class MessageFragment : Fragment() {

    var adapter = MesAdapter()
    var list = mutableListOf<MesData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_message, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rcy_mes.layoutManager = LinearLayoutManager(view.context)
        rcy_mes.setHasFixedSize(true)
        rcy_mes.adapter = adapter
        adapter.setList(list)

    }




}
