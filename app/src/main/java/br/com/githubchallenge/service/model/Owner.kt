package br.com.githubchallenge.service.model

import android.arch.persistence.room.ColumnInfo
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Owner(

    @SerializedName("avatar_url")
    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String?,

    @SerializedName("login")
    @ColumnInfo(name = "login")
    val login: String?

) : Parcelable