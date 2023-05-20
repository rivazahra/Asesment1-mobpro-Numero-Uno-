package org.d3if3039.asesment1_rivazahra.ui.search

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout
import org.d3if3039.asesment1_rivazahra.databinding.FragmentSearchBinding
import org.d3if3039.asesment1_rivazahra.model.Food

class FragmentSearch : Fragment() {
    private lateinit var binding: FragmentSearchBinding

    private val viewModel: SearchViewModel by lazy { ViewModelProvider(requireActivity())[SearchViewModel::class.java] }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.buttonCari.setOnClickListener {
            cariMakan(binding.textPencarian.text.toString())
        }
        viewModel.listData().observe(requireActivity(), { filtered -> tampilkanMakanan(filtered) })

    }

    fun cariMakan(namaMakanan: String) {
        if (TextUtils.isEmpty(namaMakanan)) {
            showError(binding.pencarianInput, "Masukkan nama makanan terlebih dahulu")
            return
        }
        showError(binding.pencarianInput, "")
        val filtered = viewModel.fulllistMakanan().filter {
            namaMakanan.equals(it.namaMakanan, ignoreCase = true)
        }

        viewModel._listData.value = filtered
    }

    fun showError(layout: TextInputLayout, error: String) {
        layout.error = error
        layout.requestFocus()
    }

    private fun tampilkanMakanan(filtered: List<Food>) {
        if (filtered.isNotEmpty()) {
            filtered.forEach { makanan ->
                binding.nama.text = makanan.namaMakanan
                binding.nama.visibility = View.VISIBLE
                binding.deskripsiResep.text = makanan.deskripsiMakanan
                binding.deskripsiResep.visibility = View.VISIBLE
            }
        }
    }
}







