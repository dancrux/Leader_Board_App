package com.cruxrepublic.leader.api.model

import com.google.gson.annotations.SerializedName

data class TopLearnersResponse(
    @SerializedName("name") var name: String,
    @SerializedName("hours") var hours: Int,
    @SerializedName("country") var country: String,
    @SerializedName("badgeUrl") var badgeUrl: String
)