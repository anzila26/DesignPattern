package anzila.binar.designpattern.network

import anzila.binar.designpattern.model.getAllUserItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {
    @GET("user")
    fun getAllUser(): Call<List<getAllUserItem>>
}