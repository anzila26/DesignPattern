package anzila.binar.designpattern.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import anzila.binar.designpattern.adapter.UserAdapter
import anzila.binar.designpattern.databinding.ActivityMainBinding
import anzila.binar.designpattern.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDataUser()
    }

    fun showDataUser() {
        val viewModelUser = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModelUser.callApiUser()
        viewModelUser.getliveDataUser().observe(this, Observer {
            if (it != null) {
                binding.rvUser.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvUser.adapter = UserAdapter(it)
            }
        })
    }
}
