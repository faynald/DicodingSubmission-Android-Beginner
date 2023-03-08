package com.farhanrv.randomyugiohcard.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.farhanrv.randomyugiohcard.data.Card
import com.farhanrv.randomyugiohcard.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val cardData = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_CARD, Card::class.java)
        } else {
            intent.getParcelableExtra(EXTRA_CARD)
        }

        if (cardData != null) {
            setupCard(cardData)
        }
    }

    private fun setupCard(data: Card) {
        with(binding) {
            supportActionBar?.title = data.name
            tvDesc.text = data.desc
            Glide.with(this@DetailActivity)
                .load(data.image_url_small)
                .into(imgCard)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_CARD = "EXTRA_CARD"
    }
}