package com.example.lintstagram

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.lintstagram.fragments.ComposeFragment
import com.example.lintstagram.fragments.FeedFragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.parse.*
import java.io.File

/**
 * Let user create a post by taking a photo with their camera
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener {
            item -> // Creates a variable called 'item'

            var fragmentToShow: Fragment? = null
            when (item.itemId) {
                R.id.action_home -> {
                    // Navigate to the home screen
                    fragmentToShow = FeedFragment()
                    Toast.makeText(this, "Home!", Toast.LENGTH_LONG).show()
                }
                R.id.action_compose -> {
                    // Show compose
                    fragmentToShow = ComposeFragment()
//                    Toast.makeText(this, "Compose!", Toast.LENGTH_LONG).show()
                }
                R.id.action_profile -> {
                    Toast.makeText(this, "Profile!", Toast.LENGTH_LONG).show()
                }
            }

            if (fragmentToShow != null) {
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow).commit()
            }
            // Return true to signal that we've handled the user interaction on the item
            true

        }
        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.action_home

//        queryPosts()
    }



    companion object {
        const val TAG = "MainActivity"
    }
}