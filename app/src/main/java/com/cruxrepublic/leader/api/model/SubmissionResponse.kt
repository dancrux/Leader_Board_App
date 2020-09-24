package com.cruxrepublic.leader.api.model

import com.google.gson.annotations.SerializedName

data class SubmissionResponse(
    @SerializedName("firstName") var firstName: String,
    @SerializedName("lastName") var lastName: String,
    @SerializedName("email") var email: String,
    @SerializedName("linkToProject") var linkToProject: String
)