package com.diva.pimpaddokter.ui.resultdetectuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.diva.pimpaddokter.R
import com.diva.pimpaddokter.databinding.ActivityDetailResultDetectUserBinding
import com.diva.pimpaddokter.model.ResultDetectUser
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

class DetailResultDetectUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailResultDetectUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailResultDetectUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupData()
    }

    private fun setupData() {
        val item = intent.getParcelableExtra<ResultDetectUser>("ResultDetectUser") as ResultDetectUser
        val actionBar = supportActionBar

        Picasso.get()
            .load(item.resultImage)
            .into(findViewById<ImageView>(R.id.image_result_detail_iv))
        binding.usernameDetailTv.text = item.username
        binding.timestampDetailTv.text = getDateTime(item.timeStamp!!)
        binding.resultDetectDetailTv.text = item.resultAcne
        actionBar?.title = "Hasil Deteksi " + item.username
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun getDateTime(timeStamp: Long) : String{
        val format = "HH:mm dd MMMM yyyy"
        val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
        return simpleDateFormat.format(Date(timeStamp))
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}