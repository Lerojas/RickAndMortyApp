package com.androidavanzado.rickandmortyapp.presentation.views

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.androidavanzado.rickandmortyapp.R
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import java.util.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class AuthenticationActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val RC_SIGN_IN = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        auth = FirebaseAuth.getInstance()
    }

    override fun onResume() {
        super.onResume()
        validateLogin()
    }

    fun validateLogin(){
        if(auth.currentUser != null){
            logged()
        } else{
            singIn()
        }
    }

    fun singIn(){
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(
                    Arrays.asList(
                        AuthUI.IdpConfig.GoogleBuilder().build(),
                        AuthUI.IdpConfig.EmailBuilder().build(),
                    )
                )
                .setIsSmartLockEnabled(false)
                .setTheme(R.style.LoginTheme)
                .build(),
            RC_SIGN_IN
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(RC_SIGN_IN == requestCode){
            if(RESULT_OK == resultCode){
                logged()
            }
        }
    }

    fun logged() {
        val intent = Intent(this, CharacterListActivity::class.java)
        startActivity(intent)
        finish()
    }
}