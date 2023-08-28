package com.diva.pimpaddokter.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.diva.pimpaddokter.R
import com.diva.pimpaddokter.databinding.ActivityDetailHomeBinding
import com.diva.pimpaddokter.model.Acne
import com.squareup.picasso.Picasso

class DetailHomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupData()
    }

    private fun setupData() {

        val item = intent.getParcelableExtra<Acne>("Acne") as Acne
        val actionBar = supportActionBar

        Picasso.get()
            .load(item.image)
            .into(findViewById<ImageView>(R.id.imageView_detail))
        binding.nameTvDetail.text = item.name
        binding.descriptionTvDetail.text = item.description
        binding.causeTvDetail.text = item.cause
        binding.solutionTvDetail.text = item.solution
        binding.referenceTvDetail.text = item.reference


        actionBar?.title = item.name
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}