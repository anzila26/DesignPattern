package anzila.binar.designpattern.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import anzila.binar.designpattern.model.getAllUserItem
import anzila.binar.designpattern.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel: ViewModel() {
    lateinit var liveDataUser : MutableLiveData<List<getAllUserItem>>

    init {
        liveDataUser = MutableLiveData()
    }

    fun getliveDataUser(): MutableLiveData<List<getAllUserItem>>{
        return liveDataUser
    }

    fun callApiUser(){
        RetrofitClient.instance.getAllUser()
            .enqueue(object : Callback<List<getAllUserItem>> {
                override fun onResponse(
                    call: Call<List<getAllUserItem>>,
                    response: Response<List<getAllUserItem>>
                ) {
                    if (response.isSuccessful) {
                        liveDataUser.postValue(response.body())
                    //show data
                    } else {
                        liveDataUser.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<getAllUserItem>>, t: Throwable) {
                    liveDataUser.postValue(null)
                }
            })
    }
}