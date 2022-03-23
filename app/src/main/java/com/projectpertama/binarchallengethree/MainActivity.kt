package com.projectpertama.binarchallengethree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.projectpertama.binarchallengethree.fragment.FirstFragment
import com.projectpertama.binarchallengethree.fragment.SecondFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openFirstFragment()
    }

    private fun openFirstFragment(){
        val fragmentManager : FragmentManager = supportFragmentManager

        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        val secondFragment = SecondFragment()

        fragmentTransaction.replace(R.id.container,secondFragment,SecondFragment::class.java.simpleName)
        fragmentTransaction.commit()
    }
}