package muk.dev.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import muk.dev.data.db.entity.BasketProductEntity


@Dao
interface BasketDao {

    @Query("SELECT * FROM basket")
    suspend fun getAll() : List<BasketProductEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item : BasketProductEntity)

    @Query("DELETE FROM basket WHERE productId =:id")
    suspend fun delete(id:String)
}