package com.mark.stylish.kotlin.data

data class Product(val id: Long,
                   val title: String,
                   val description: String,
                   val price: Int,
                   val texture: String,
                   val wash: String,
                   val place: String,
                   val note: String,
                   val story: String,
                   val colors: List<Color>,
                   val sizes: List<String>,
                   val variants: List<Variant>,
                   val mainImage: String,
                   val images: List<String>) {
}