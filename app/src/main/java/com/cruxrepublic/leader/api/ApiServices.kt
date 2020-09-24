package com.cruxrepublic.leader.api

import com.cruxrepublic.leader.api.model.TopLearnersResponse
import com.cruxrepublic.leader.api.model.TopSkillIQResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {
    @GET("api/hours")
    fun getTopLearners(): Call<List<TopLearnersResponse>>

    @GET("api/skilliq")
    fun getTopSkillIq(): Call<List<TopSkillIQResponse>>

    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    fun submission(
        @Field("entry.1824927963") email: String,
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.284483984") linkToProject: String
    ): Call<Void>
}