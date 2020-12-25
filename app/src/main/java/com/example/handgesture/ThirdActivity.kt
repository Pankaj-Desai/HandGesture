package com.example.handgesture

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View

class ThirdActivity : AppCompatActivity() {
    var btmap: Bitmap? = null
    val REQUEST = 8293

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
    }
    fun capturePic(view:View) {
        startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE), REQUEST)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==8293) {
            val bitmap1 = data?.extras?.get("data")
            btmap= bitmap1 as Bitmap?
            val intent1 = Intent(this, BitmapProcessActivity::class.java)
            intent1.putExtra("bitmap", btmap)
            startActivity(intent1)
        }

    }
}