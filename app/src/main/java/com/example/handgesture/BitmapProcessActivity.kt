package com.example.handgesture

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast

class BitmapProcessActivity : AppCompatActivity() {

    private val mInputSize = 200
    private val mModelPath = "Gesture_recogniser_quantised_1.tflite"
    private val mLabelPath = "labels.txt"
    private lateinit var classifier: Classifier


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initClassifier()
        val bitmap1 = intent.extras?.get("bitmap") as Bitmap
        val results1 = getResults(bitmap1)
        var value = results1[16].toString()

        if (value == "4"){
            val whatsapp = packageManager.getLaunchIntentForPackage("com.whatsapp") //Intent is created to launch the app
            if (whatsapp != null) {
                startActivity(whatsapp)
                overridePendingTransition(R.anim.slide_from_top, R.anim.slide_to_bottom) // If that app exist in device, then this will launch the app
            } else {
                Toast.makeText(this, "App not found", Toast.LENGTH_LONG).show() // If app does not exist in device, this will toast message "App not found"
            }
        }
        else if (value == "1"){
            val youtube = packageManager.getLaunchIntentForPackage("com.google.android.youtube")
            if (youtube != null) {
                startActivity(youtube)
                overridePendingTransition(R.anim.slide_from_top, R.anim.slide_to_bottom)
            } else {
                Toast.makeText(this, "App not found", Toast.LENGTH_LONG).show()
            }
        }
        else if (value == "2"){
            val message = Intent(Intent.ACTION_MAIN)
            message.addCategory(Intent.CATEGORY_APP_MESSAGING)
            if (message != null) {
                startActivity(message)
                overridePendingTransition(R.anim.slide_from_bottom, R.anim.slide_to_top)
            } else {
                Toast.makeText(this, "App not found", Toast.LENGTH_LONG).show()
            }
        }
        else {
            val contacts = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            if (contacts != null) {
                startActivityForResult(contacts, 1)
                overridePendingTransition(R.anim.slide_from_top, R.anim.slide_to_bottom)
            } else {
                Toast.makeText(this, "App not found", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getResults(bitmap: Bitmap): String {
        val results = classifier.recognizeImage(bitmap)
        return results.toString()
    }

    private fun initClassifier() {
        classifier = Classifier(assets, mModelPath, mLabelPath, mInputSize)
    }


}