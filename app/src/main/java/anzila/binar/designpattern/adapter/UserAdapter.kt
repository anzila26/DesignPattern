package anzila.binar.designpattern.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import anzila.binar.designpattern.databinding.ItemUserBinding
import anzila.binar.designpattern.model.getAllUserItem
import com.bumptech.glide.Glide

class UserAdapter (var listUser : List<getAllUserItem>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(var binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        var view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.binding.nameUser.text = listUser[position].name
        holder.binding.ageUser.text = listUser[position].age.toString()
        holder.binding.adressUser.text = listUser[position].address
    }

    override fun getItemCount(): Int {
        return listUser.size
    }
}