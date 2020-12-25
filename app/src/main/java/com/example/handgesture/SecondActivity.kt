package com.example.handgesture

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    fun Whatsapp(view: View?) {
        val whatsapp = packageManager.getLaunchIntentForPackage("com.whatsapp") //Intent is created to launch the app
        if (whatsapp != null) {
            startActivity(whatsapp)
            overridePendingTransition(R.anim.slide_from_top, R.anim.slide_to_bottom) // If that app exist in device, then this will launch the app
        } else {
            Toast.makeText(this, "App not found", Toast.LENGTH_LONG).show() // If app does not exist in device, this will toast message "App not found"
        }

    }

    // Above three steps are followed for every application
    fun Fb(view: View?) {
        val facebook = packageManager.getLaunchIntentForPackage("com.facebook.lite")
        if (facebook != null) {
            startActivity(facebook)
            overridePendingTransition(R.anim.slide_from_bottom, R.anim.slide_to_top)
        } else {
            Toast.makeText(this, "App not found", Toast.LENGTH_LONG).show()
        }
    }

    fun discord(view: View?) {
        val discord = packageManager.getLaunchIntentForPackage("com.discord")
        if (discord != null) {
            startActivity(discord)
            overridePendingTransition(R.anim.slide_from_bottom, R.anim.slide_to_top)
        } else {
            Toast.makeText(this, "App not found", Toast.LENGTH_LONG).show()
        }
    }

    fun instagram(view: View?) {
        val instagram = packageManager.getLaunchIntentForPackage("com.instagram.android")
        if (instagram != null) {
            startActivity(instagram)
            overridePendingTransition(R.anim.slide_from_top, R.anim.slide_to_bottom)
        } else {
            Toast.makeText(this, "App not found", Toast.LENGTH_LONG).show()
        }
    }

    fun youtube(view: View?) {
        val youtube = packageManager.getLaunchIntentForPackage("com.google.android.youtube")
        if (youtube != null) {
            startActivity(youtube)
            overridePendingTransition(R.anim.slide_from_top, R.anim.slide_to_bottom)
        } else {
            Toast.makeText(this, "App not found", Toast.LENGTH_LONG).show()
        }
    }

    fun linkedin(view: View?) {
        val linkedin = packageManager.getLaunchIntentForPackage("com.linkedin.android")
        if (linkedin != null) {
            startActivity(linkedin)
            overridePendingTransition(R.anim.slide_from_bottom, R.anim.slide_to_top)
        } else {
            Toast.makeText(this, "App not found", Toast.LENGTH_LONG).show()
        }
    }

    fun message(view: View?) {
        val message = Intent(Intent.ACTION_MAIN)
        message.addCategory(Intent.CATEGORY_APP_MESSAGING)
        if (message != null) {
            startActivity(message)
            overridePendingTransition(R.anim.slide_from_bottom, R.anim.slide_to_top)
        } else {
            Toast.makeText(this, "App not found", Toast.LENGTH_LONG).show()
        }
    }

    fun contacts(view: View?) {
        val contacts = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
        if (contacts != null) {
            startActivityForResult(contacts, 1)
            overridePendingTransition(R.anim.slide_from_top, R.anim.slide_to_bottom)
        } else {
            Toast.makeText(this, "App not found", Toast.LENGTH_LONG).show()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_from_bottom, R.anim.slide_to_top)
    }
}