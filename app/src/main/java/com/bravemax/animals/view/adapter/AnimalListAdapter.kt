package com.bravemax.animals.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bravemax.animals.R
import com.bravemax.animals.model.Animal
import com.bravemax.animals.view.AnimalClickListener
import com.bravemax.animals.view.fragments.ListFragmentDirections

class AnimalListAdapter(private val animalList: ArrayList<Animal>) : RecyclerView.Adapter<AnimalListAdapter.AnimalViewHolder>(), AnimalClickListener {


    class AnimalViewHolder(var view: ItemAnimalBinding) : RecyclerView.ViewHolder(view.root)

    fun updateAnimalList(newAnimalList: List<Animal>) {
        animalList.clear()
        animalList.addAll(newAnimalList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemAnimalBinding>(
            inflater,
            R.layout.item_ainmal,
            parent
        )
        return AnimalViewHolder(view)
    }

    override fun getItemCount(): Int = animalList.count()

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.view.listAnimal = animalList(position)
        holder.view.listener = this
    }

    override fun onClick(v: View) {
        for (animal in animalList) {
            if (v.tag == animal.name) {
                val action = ListFragmentDirections.actionDetail(animal)
                Navigation.findNavController(v).navigate(action)
            }
        }
    }

}