package com.zubaidi.roomimage

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.zubaidi.roomimage.adapter.AdapterImage
import com.zubaidi.roomimage.adapter.BitmapConverter
import com.zubaidi.roomimage.databinding.ActivityMainBinding
import com.zubaidi.roomimage.db.ImageDB
import com.zubaidi.roomimage.db.ImageModel
import com.zubaidi.roomimage.db.ImageRepository

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val repository: ImageRepository by lazy {
        ImageRepository(ImageDB(this).imageDAO)
    }

    private val imageAdapterImage: AdapterImage by lazy {
        AdapterImage()
    }

    private val image = listOf(
        R.drawable.sample_boat_400x300,
        R.drawable.sample_bumblebee_400x300,
        R.drawable.sample_clouds2_400x300,
        R.drawable.sample_hut_400x300
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        makeListOfImage()
        binding.listImage.adapter = imageAdapterImage
        binding.listImage.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        binding.button.setOnClickListener {
            imageAdapterImage.setData(repository.getAllImage())
        }
    }

    private fun makeListOfImage() {
        for (i in 0..1) {
            image.forEach {
                val bitmap = BitmapFactory.decodeResource(resources, it)
                val bitmapToString = BitmapConverter.convertBitmapToString(bitmap)
                val item = ImageModel(null, bitmapToString)
                repository.insertImage(item)
            }
        }
    }
}