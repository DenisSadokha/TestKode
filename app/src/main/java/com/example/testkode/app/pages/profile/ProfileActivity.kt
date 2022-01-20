package com.example.testkode.app.pages.profile

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.testkode.R


class ProfileActivity : AppCompatActivity() {

    lateinit var tvName: TextView
    lateinit var tvDepartment: TextView
    lateinit var tvDate: TextView
    lateinit var tvNumber: TextView
    lateinit var tvOld: TextView
    lateinit var ibBack: ImageButton
    lateinit var vgCall: ViewGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_activity)
        tvName = findViewById(R.id.tv_name)
        tvDepartment = findViewById(R.id.tv_department)
        tvDate = findViewById(R.id.tv_date)
        tvOld = findViewById(R.id.tv_old)
        tvNumber = findViewById(R.id.tv_number)
        ibBack = findViewById(R.id.iv_back)
        vgCall = findViewById(R.id.vg_call)

        vgCall.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                phoneCall(1)
            } else {
                val per = arrayOf<String>(Manifest.permission.CALL_PHONE)
                ActivityCompat.requestPermissions(this, per, 9)
            }

        }

        ibBack.setOnClickListener {
            onBackPressed()
        }

    }


    private fun phoneCall(number: Int) {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:$number")
        startActivity(callIntent)
    }
}