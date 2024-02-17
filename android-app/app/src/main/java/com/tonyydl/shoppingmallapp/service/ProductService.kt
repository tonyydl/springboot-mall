package com.tonyydl.shoppingmallapp.service

import com.tonyydl.shoppingmallapp.data.Page
import com.tonyydl.shoppingmallapp.data.ProductCategory
import com.tonyydl.shoppingmallapp.data.dto.ProductDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductService {

    @GET("/products")
    suspend fun getProducts(
        @Query("category") category: ProductCategory?,
        @Query("search") search: String?,
        @Query("page") page: Int?,
        @Query("size") size: Int?,
        @Query("sort") sort: String?
    ): Page<ProductDTO>

    @GET("/products/{id}")
    suspend fun getProductById(
        @Path("id") productId: Int?
    ): ProductDTO

    companion object {

    }
}