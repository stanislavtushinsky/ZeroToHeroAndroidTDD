package ru.easycode.zerotoheroandroidtdd

import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ElementListBinding

class RecyclerViewHolder(val binding: ElementListBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(value: String) {
        binding.elementTextView.text = value
    }
}