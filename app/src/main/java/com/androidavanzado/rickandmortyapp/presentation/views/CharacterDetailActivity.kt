package com.androidavanzado.rickandmortyapp.presentation.views

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.androidavanzado.rickandmortyapp.R
import com.androidavanzado.rickandmortyapp.domain.model.Result
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class CharacterDetailActivity : AppCompatActivity() {

    private lateinit var result : Result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        result = intent.getSerializableExtra("result") as Result
        setupViews()
    }

    fun setupViews(){

        val characterImageIv = findViewById<ImageView>(R.id.characterImageIv)
        Glide.with(characterImageIv)
            .load(result.image)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .fallback(R.drawable.ic_launcher_background)
            .into(characterImageIv)

        val characterNameTv = findViewById<TextView>(R.id.characterNameTv)
        characterNameTv.text = result.name

        val characterStatusTv = findViewById<TextView>(R.id.characterStatusTv)
        characterStatusTv.text = result.status

        val characterSpeciesTv = findViewById<TextView>(R.id.characterSpeciesTv)
        characterSpeciesTv.text = result.species

        val characterGenderTv = findViewById<TextView>(R.id.characterGenderTv)
        characterGenderTv.text = result.gender

        val characterLocationTv = findViewById<TextView>(R.id.characterLocationTv)
        characterLocationTv.text = result.location.name

        val characterOriginTv = findViewById<TextView>(R.id.characterOriginTv)
        characterOriginTv.text = result.origin.name
    }
}