package com.projectpertama.binarchallengethree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.projectpertama.binarchallengethree.fragment.FirstFragment

class CoverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cover)



        var handler = Handler()
        handler.postDelayed({
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, 3000)
    }


}