package com.example.myfirstkotlinapplication.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myfirstkotlinapplication.models.Hobby
import com.example.myfirstkotlinapplication.R
import com.example.myfirstkotlinapplication.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.myViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): myViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, p0, false)
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(p0: myViewHolder, p1: Int) {
        val hobby = hobbies[p1]
        p0.setData(hobby, p1)
    }

    inner class  myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                currentHobby?.let {
                    context.showToast(currentHobby!!.title + " Clicked!")
                }
            }

            itemView.imgShare.setOnClickListener {

                currentHobby?.let {

                    val messageString: String = "My hobby is " + currentHobby!!.title

                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, messageString)
                    intent.type = "text/plain"

                    context.startActivity(Intent.createChooser(intent, "Share to :"))
                }
            }
        }

        fun setData(hobby: Hobby?, pos: Int) {

            hobby?.let {
                itemView.txvTitle.text = hobby.title
            }

            this.currentHobby = hobby
            this.currentPosition = pos
        }
    }
}
