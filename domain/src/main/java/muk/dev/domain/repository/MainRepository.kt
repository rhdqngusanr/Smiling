package muk.dev.domain.repository

import muk.dev.domain.model.Product

interface MainRepository {
    fun getProductList() : List<Product>
}