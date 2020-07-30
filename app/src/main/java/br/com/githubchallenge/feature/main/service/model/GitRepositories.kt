package br.com.githubchallenge.feature.main.service.model

import androidx.room.Embedded
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GitRepositories(

    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,

    @SerializedName("items")
    @Embedded
    val items: List<Item>,

    @SerializedName("total_count")
    val totalCount: Int

) : Parcelable