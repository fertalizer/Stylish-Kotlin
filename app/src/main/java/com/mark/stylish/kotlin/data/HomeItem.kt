package com.mark.stylish.kotlin.data

/**
 * For different view holder in home page.
 */
sealed class HomeItem {
    abstract val id: Long

    data class HomeTitle(val title: String): HomeItem() {
        override val id: Long
            get() = -1
    }

    data class HomeFull(val product: Product): HomeItem() {
        override val id: Long
            get() = product.id
    }

    data class HomeCollage(val product: Product): HomeItem() {
        override val id: Long
            get() = product.id
    }

}
