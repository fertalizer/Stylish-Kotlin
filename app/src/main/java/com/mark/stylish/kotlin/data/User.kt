package com.mark.stylish.kotlin.data

data class User(val id: Int,
                val provider: String,
                val name: String,
                val email: String,
                val picture: String) {
}