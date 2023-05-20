package org.d3if3039.asesment1_rivazahra.ui.histori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if3039.asesment1_rivazahra.databinding.ItemHistoriBinding


import org.d3if3039.asesment1_rivazahra.db.FoodEntity
import org.d3if3039.asesment1_rivazahra.model.saveData


class HistoriAdapter :
    ListAdapter<FoodEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<FoodEntity>() {
                override fun areItemsTheSame(
                    oldData: FoodEntity, newData: FoodEntity
                ): Boolean {
                    return oldData.id == newData.id
                }

                override fun areContentsTheSame(
                    oldData: FoodEntity, newData: FoodEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FoodEntity) = with(binding) {
            val hasilMakanan = item.saveData()
           jdlMakanan.text= hasilMakanan.namaMakanan
            desJdl.text = hasilMakanan.deskripsiMakanan

        }
    }
}
