package com.example.b5scb

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class LanguagesAdapter(var languages: Array<String>) :RecyclerView.Adapter<LangViewHolder>() {

    var TAG = LanguagesAdapter::class.java.simpleName


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LangViewHolder {
        Log.i(TAG,"ganesan bought a row plank from the market  and gave it to aravind")
        var row_plank:View = LayoutInflater.from(parent.context).inflate(R.layout.row_layout_plank,parent,false)
        return LangViewHolder(row_plank)
    }

    override fun onBindViewHolder(holder: LangViewHolder, position: Int) {
        Log.i(TAG,"avishi is writing")
        holder.tvRowItem.text = languages[position]
    }

    override fun getItemCount(): Int {
        Log.i(TAG,"arul counted items in dataset")
        return  languages.size
    }
}

class LangViewHolder(row_layout_plank : View): ViewHolder(row_layout_plank) {
    var tvRowItem = row_layout_plank.findViewById<TextView>(R.id.tvHeading)


}
