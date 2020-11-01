package com.example.fetchgithubtokotlinretrofit

import android.content.Context
import android.util.MutableDouble
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fetchgithubtokotlinretrofit.model.Users
import kotlinx.android.synthetic.main.user_item_row.view.*

class UserAdapter(private val context: Context):RecyclerView.Adapter<UserAdapter.MyViewHolder>(){

    var items = ArrayList<Users>()

    fun setListData(data:ArrayList<Users>){
        this.items = data
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item_row,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: UserAdapter.MyViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            Toast.makeText(context," " + items[position].id,Toast.LENGTH_LONG).show()
        }
    }

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        val tvID = itemView.tvID
        val imageURL = itemView.imageThumb
        val followersURL = itemView.followers_url
        val tv_url = itemView.tvURL

        fun bind(data: Users){
            val url = data.avatar_url
            Glide.with(imageURL)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .fallback(R.drawable.ic_launcher_background)
                .into(imageURL)

            val followers = data.followers_url
            followersURL.text = data.followers_url

            val tvurl = data.url
            tv_url.text = tvurl

            val _ID = data.id
            tvID.text = _ID.toString()



        }





    }

}
