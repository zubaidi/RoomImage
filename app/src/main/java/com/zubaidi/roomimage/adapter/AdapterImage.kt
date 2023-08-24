package com.zubaidi.roomimage.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zubaidi.roomimage.databinding.ImageAdapterBinding
import com.zubaidi.roomimage.db.ImageModel

class AdapterImage : RecyclerView.Adapter<AdapterImage.ImageHolder>() {

    private val imageList = arrayListOf<ImageModel>()
    private lateinit var mContext: Context

    class ImageHolder(private val binding: ImageAdapterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imageModel: ImageModel) {
            binding.apply {
                imageModel.also {
                    txtNomor.text = it.id.toString()
                    val bitmap = BitmapConverter.convertStringToBitmap(it.imageString)
                    imageView.setImageBitmap(bitmap)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        mContext = parent.context
        val inflate = LayoutInflater.from(mContext)
        val binding = ImageAdapterBinding.inflate(inflate, parent, false)
        return ImageHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<ImageModel>) {
        imageList.clear()
        imageList.addAll(list)
        notifyDataSetChanged()
    }
}