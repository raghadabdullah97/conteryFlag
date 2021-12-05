package com.example.contreyandflag.binding.adapter



import android.widget.ImageView

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.contreyandflag.adapter.CuontryAdapter
import com.example.contreyandflag.network.FlagPhoto


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl.let {
        val imageLoader = ImageLoader.Builder(imgView.context)
            .componentRegistry { add(SvgDecoder(imgView.context)) }
            .build()

        val request = ImageRequest.Builder(imgView.context)
            .data(imgUrl)
            .target(imgView)
            .build()

        imageLoader.enqueue(request)
    }


}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<FlagPhoto>?){

    val adapter = recyclerView.adapter as CuontryAdapter
    adapter.submitList(data)
}