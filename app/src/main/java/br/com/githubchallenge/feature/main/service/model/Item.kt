package br.com.githubchallenge.feature.main.service.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "repositories")
data class Item(

    @SerializedName("id")
    @PrimaryKey
    val id: Int?,

    @SerializedName("forks_count")
    @ColumnInfo(name = "forks_count")
    val forksCount: Int?,

    @SerializedName("full_name")
    @ColumnInfo(name = "full_name")
    val fullName: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("owner")
    @Embedded
    val owner: Owner?,

    @SerializedName("stargazers_count")
    @ColumnInfo(name = "stargazers_count")
    val stargazersCount: Int?,

    @SerializedName("description")
    val description: String?


) : Parcelable