package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ElementListBinding

class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewHolder>() {

    private val data = ArrayList<String>()

    fun addElem(value: String) {
        data.add(value)
        notifyItemInserted(data.size - 1)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerViewHolder {
        val view = ElementListBinding.inflate(LayoutInflater.from(parent.context))
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: RecyclerViewHolder,
        position: Int,
    ) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    fun save(bundle: Bundle) {
        bundle.putStringArrayList("list", data)
    }

    fun restore(bundle: Bundle) {
        data.addAll(bundle.getStringArrayList("list")!!)
        notifyItemRangeInserted(0, data.size)
    }
}