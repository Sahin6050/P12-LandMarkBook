package com.sahin.landmarkbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sahin.landmarkbook.databinding.ActivityDetailsBinding
import com.sahin.landmarkbook.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        // Casting işlemi ben sana landmark objesi gönderdiğime eminim sen bunu landmark olarak kaydet demektir.
        //val selectedLandmark = intent.getSerializableExtra("landmark") as Landmark

        //val selectedLandmark = chosenLandmark
        val selectedLandmark = mySinleton.chosenLandmark

        selectedLandmark.let {
            binding.nameText.setText(selectedLandmark!!.landmarkName)
            binding.countryText.setText(selectedLandmark!!.countryName)
            binding.imageView.setImageResource(selectedLandmark!!.image)
        }



    }
}