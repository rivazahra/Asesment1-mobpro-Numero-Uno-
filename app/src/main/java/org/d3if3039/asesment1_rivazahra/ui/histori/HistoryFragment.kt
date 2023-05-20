package org.d3if3039.asesment1_rivazahra.ui.histori

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch
import org.d3if3039.asesment1_rivazahra.R
import org.d3if3039.asesment1_rivazahra.data.SettingsDataStore
import org.d3if3039.asesment1_rivazahra.data.dataStore
import org.d3if3039.asesment1_rivazahra.databinding.FragmentAddBinding
import org.d3if3039.asesment1_rivazahra.databinding.FragmentHistoryBinding
import org.d3if3039.asesment1_rivazahra.db.MakananDb

class HistoryFragment : Fragment() {

    private val layoutDataStore: SettingsDataStore by lazy{
        SettingsDataStore(requireContext().dataStore)
    }


    private val viewModel: HistoriViewModel by lazy {
        val db = MakananDb.getInstance(requireContext())
        val factory = HistoriViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[HistoriViewModel::class.java]
    }

    private var isLinearLayout = true
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var myAdapter: HistoriAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(
            layoutInflater, container, false
        )
        setHasOptionsMenu(true)
        return binding.root
    }

    // agar recyleview tampil di fragment histori
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        myAdapter = HistoriAdapter()
        with(binding.recyclerView) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = myAdapter
            setHasFixedSize(true)
        }

        layoutDataStore.preferenceFlow.asLiveData().observe(viewLifecycleOwner){
            isLinearLayout = it
            setLayout()
            activity?.invalidateOptionsMenu()
        }

        viewModel.data.observe(viewLifecycleOwner) {
            binding.emptyView.visibility = if (it.isEmpty())
                View.VISIBLE else View.GONE
            myAdapter.submitList(it)

        }
    }


    private fun setLayout(){
        binding.recyclerView.layoutManager= if (isLinearLayout)
            LinearLayoutManager(context)
        else
            GridLayoutManager(context,2)
    }

    private fun setIcon(menuItem: MenuItem){
        val iconId = if(isLinearLayout)
            R.drawable.ic_grid_view
        else
            R.drawable.ic_view_list
        menuItem.icon = ContextCompat.getDrawable(requireContext(),iconId)
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.histori_menu, menu)

        val menuItem = menu.findItem(R.id.action_switch_layout)
        setIcon(menuItem)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_hapus) {
            hapusData()
            return true
        }
        else if(item.itemId == R.id.action_switch_layout){
           lifecycleScope.launch {
               layoutDataStore.saveLayout(!isLinearLayout, requireContext())
           }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun hapusData() {
        MaterialAlertDialogBuilder(requireContext())
            .setMessage(R.string.konfirmasi_hapus)
            .setPositiveButton(getString(R.string.hapus)) { _, _ ->
                viewModel.hapusData()
            }
            .setNegativeButton(getString(R.string.batal)) { dialog, _ ->
                dialog.cancel()
            }
            .show()
    }
}