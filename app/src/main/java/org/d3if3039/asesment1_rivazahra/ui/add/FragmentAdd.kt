package org.d3if3039.asesment1_rivazahra.ui.add

import android.content.Intent
import android.os.Bundle
import android.provider.LiveFolders.INTENT
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import org.d3if3039.asesment1_rivazahra.R
import org.d3if3039.asesment1_rivazahra.databinding.FragmentAddBinding
import org.d3if3039.asesment1_rivazahra.db.MakananDb

class FragmentAdd : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private val viewModel: MakananViewModel by lazy {
        val db = MakananDb.getInstance(requireContext())
        val factory = AddViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[MakananViewModel::class.java]
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater, container,false)
    setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.fragmentSearch -> {
                findNavController().navigate(
                    R.id.action_fragmentAdd_to_fragmentSearch
                )
                return true
            }
            R.id.historyFragment ->{
                findNavController().navigate(
                    R.id.action_fragmentAdd_to_historyFragment
                )
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonTambah.setOnClickListener { saveData() }

        binding.tentangBtn.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragmentAdd_to_aboutFragment
            )
        }
    }
    fun saveData(){
        val namaMakanan = binding.namaMakananInp.text.toString()
        if (TextUtils.isEmpty(namaMakanan)){
            showError(binding.layoutNamaMakanan, "Nama Makanan tidak boleh kosong")
            return
        }else{
            showError(binding.layoutNamaMakanan,"")
        }
        val deskripsi = binding.deksripsiText.text.toString()
        if (TextUtils.isEmpty(deskripsi)){
            showError(binding.layoutDeskripsi, "Deksripsi Makanan tidak boleh kosong")
            return
        }else if (deskripsi.length < 5) {
            showError(binding.layoutDeskripsi, "Deskripsi minimal 20 karakter")
            return
        }else{
            showError(binding.layoutDeskripsi,"")
        }
        viewModel.saveData(
            namaMakanan,deskripsi
        )
        viewModel.data.observe(viewLifecycleOwner){
            if(it !=null){
                Toast.makeText(context, "Data berhasil ditambahkan", Toast.LENGTH_LONG).show()
                clearData()
            }else{
                Toast.makeText(context,"Data gagal disimpan", Toast.LENGTH_LONG).show()
                clearData()
            }
        }
    }
    fun clearData(){
        binding.namaMakananInp.text?.clear()
        binding.deksripsiText.text?.clear()
    }

    fun showError(layout: TextInputLayout, error: String) {
        layout.error = error
        layout.requestFocus()
    }
}