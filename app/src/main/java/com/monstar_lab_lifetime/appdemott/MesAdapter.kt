package com.monstar_lab_lifetime.appdemott

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.monstar_lab_lifetime.appdemott.MesAdapter.MesViewHolder

class MesAdapter(val list: MutableList<MesData>) : Adapter<MesViewHolder>() {
    class MesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val mNameMess=itemView.findViewById(R.id.tv_nameMes) as TextView
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MesViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        return MesViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MesViewHolder, position: Int) {
        val list:MesData=list[position]
        holder.mNameMess.text= list.name
    }
}