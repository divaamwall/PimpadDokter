package com.diva.pimpaddokter.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultDetectUser(
    val userId: String? = null,
    val username: String? = null,
    val resultId: String? = null,
    val resultImage: String? = null,
    val resultAcne: String? = null,
    val timeStamp: Long? = null
) : Parcelable
