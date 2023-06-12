package org.d3if3039.asesment1_rivazahra.ui.kumpulanMakanan

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.d3if3039.asesment1_rivazahra.databinding.KumpulanListBinding
import org.d3if3039.asesment1_rivazahra.model.KumpulanMakanan
import com.bumptech.glide.Glide
import org.d3if3039.asesment1_rivazahra.R
import org.d3if3039.asesment1_rivazahra.network.MakananApi

class KumpulanAdapter : RecyclerView.Adapter<KumpulanAdapter.ViewHolder>(){

    private  val data = mutableListOf<KumpulanMakanan>()

    fun updateData(newData: List<KumpulanMakanan>){
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
}

class ViewHolder(
    private val binding: KumpulanListBinding
): RecyclerView.ViewHolder(binding.root){
    fun bind(kumpulanMakanan: KumpulanMakanan) = with(binding){
        namaTextView.text = kumpulanMakanan.nama
        deskripsiTextView.text = kumpulanMakanan.deskripsi
        Glide.with(gambarFood.context)
            .load(MakananApi.getMakananUrl(kumpulanMakanan.imageUrl))
            .error(R.drawable.baseline_broken_image_24)
            .into(gambarFood)


        root.setOnClickListener{
            val message = root.context.getString(R.string.message, kumpulanMakanan.nama)
            Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
        }
    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = KumpulanListBinding.inflate(inflater, parent, false)
        return  ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}
