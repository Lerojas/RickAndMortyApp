package com.androidavanzado.rickandmortyapp.presentation.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.*
import com.androidavanzado.rickandmortyapp.R
import com.androidavanzado.rickandmortyapp.di.Injection
import com.androidavanzado.rickandmortyapp.domain.model.Character
import com.androidavanzado.rickandmortyapp.domain.model.Result
import com.androidavanzado.rickandmortyapp.presentation.adapter.CharacterAdapter
import com.androidavanzado.rickandmortyapp.presentation.viewmodel.CharacterViewModel
import com.androidavanzado.rickandmortyapp.presentation.viewmodel.CharacterViewModelFactory
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.tasks.OnCompleteListener

class CharacterListActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var characterAdapter : CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_list)

        initRecyclerView()
        setupViewModel()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_character_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.syncDown) {
            logOut()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initRecyclerView(){

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@CharacterListActivity)
            characterAdapter = CharacterAdapter()
            adapter = characterAdapter

            val decoration = DividerItemDecoration(applicationContext, StaggeredGridLayoutManager.VERTICAL)
            addItemDecoration(decoration)
        }
    }

    private fun setupViewModel(){
        val viewModel = ViewModelProviders.of(this, CharacterViewModelFactory(Injection.providerCharacterRepository()))
            .get(CharacterViewModel::class.java)

        viewModel.characterData.observe(this,{
            if(it != null){
                val character = Character(it.info, it.results)
                characterAdapter.setListData(character.results, this@CharacterListActivity)
                characterAdapter.notifyDataSetChanged()
            }
            else{
                Toast.makeText(this@CharacterListActivity,"Error in getting dara from Api.", Toast.LENGTH_LONG).show()
            }
        })

        viewModel.getData()
    }

    override fun onItemClickListener(result: Result) {
        val intent = Intent(this, CharacterDetailActivity::class.java).apply {
            putExtra("result", result)
        }
        startActivity(intent)
    }

    fun logOut(){
        AuthUI.getInstance()
            .signOut(this)
            .addOnCompleteListener(OnCompleteListener {
                val intent = Intent(this, AuthenticationActivity::class.java)
                startActivity(intent)
                finish()
            })
    }
}