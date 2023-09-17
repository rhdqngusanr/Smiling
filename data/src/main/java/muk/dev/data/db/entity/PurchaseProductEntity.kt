package muk.dev.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

import muk.dev.data.db.converter.PurchaseConverter
import muk.dev.domain.model.Category
import muk.dev.domain.model.Price
import muk.dev.domain.model.Product
import muk.dev.domain.model.SalesStatus
import muk.dev.domain.model.Shop

@Entity(tableName = "purchase")
@TypeConverters(PurchaseConverter::class)
data class PurchaseProductEntity(
    @PrimaryKey
    val productId : String,
    val productName : String,
    val imageUrl : String,
    val price : Price,
    val category: Category,
    val salesStatus: SalesStatus,
    val shop: Shop,
    val isNew : Boolean,
    val isFreeShipping:Boolean,
)

fun PurchaseProductEntity.toDomainModel( ) : Product {
    return Product(
        productId = productId,
        productName = productName,
        imageUrl = imageUrl,
        price = price,
        category = category,
        salesStatus = salesStatus,
        shop = shop,
        isNew = isNew,
        isFreeShipping = isFreeShipping
    )
}