package com.diva.pimpaddokter.adapter

import android.app.Activity
import android.content.Intent
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView
import com.diva.pimpaddokter.R
import com.diva.pimpaddokter.databinding.ItemResultDetectUserBinding
import com.diva.pimpaddokter.model.ResultDetectUser
import com.diva.pimpaddokter.ui.resultdetectuser.DetailResultDetectUserActivity
import com.squareup.picasso.Picasso

class ResultDetectUserAdapter(private val listResultDetectUser: ArrayList<ResultDetectUser>) : RecyclerView.Adapter<
        ResultDetectUserAdapter.ViewHolder>() {

    class ViewHolder(var binding: ItemResultDetectUserBinding) : RecyclerView.ViewHolder(binding.root) {
        val resultDetectImage: ImageView = itemView.findViewById(R.id.result_detect_iv)
        val username: TextView = itemView.findViewById(R.id.username_tv)
        val timeStamp: TextView = itemView.findViewById(R.id.timeStampResult)
        val resultAcne: TextView = itemView.findViewById(R.id.result_acne_tv)

        fun bind(item: ResultDetectUser) {
            Picasso.get()
                .load(item.resultImage)
                .into(resultDetectImage)
            username.text = item.username
            timeStamp.text = DateUtils.getRelativeTimeSpanString(item.timeStamp!!).toString()
            resultAcne.text = item.resultAcne
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailResultDetectUserActivity::class.java)
                intent.putExtra("ResultDetectUser", item)
                val optionsCompat: ActivityOptionsCompat =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        itemView.context as Activity,
                        Pair(resultDetectImage, "resultImage"),
                        Pair(username, "username"),
                        Pair(timeStamp, "timeStamp"),
                        Pair(resultAcne, "resultAcne")
                    )
                itemView.context.startActivity(intent, optionsCompat.toBundle())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemResultDetectUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listResultDetectUser[position])
    }

    override fun getItemCount(): Int = listResultDetectUser.size

}