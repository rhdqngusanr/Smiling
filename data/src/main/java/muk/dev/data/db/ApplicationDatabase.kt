package muk.dev.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import muk.dev.data.db.dao.BasketDao
import muk.dev.data.db.dao.LikeDao
import muk.dev.data.db.dao.PurchaseDao
import muk.dev.data.db.entity.BasketProductEntity
import muk.dev.data.db.entity.LikeProductEntity
import muk.dev.data.db.entity.PurchaseProductEntity

@Database(
    entities = [
        PurchaseProductEntity::class,
        LikeProductEntity::class,
        BasketProductEntity::class
    ],
    version = 1
)
abstract class ApplicationDatabase : RoomDatabase() {
    companion object{
        const val DB_NAME = "ApplicationDatabase.db"
    }
    abstract fun purchaseDao( ): PurchaseDao
    abstract fun likeDao( ): LikeDao
    abstract fun basketDao( ): BasketDao
}