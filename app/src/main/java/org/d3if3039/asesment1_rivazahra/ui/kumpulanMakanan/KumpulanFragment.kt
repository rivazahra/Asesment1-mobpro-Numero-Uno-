package org.d3if3039.asesment1_rivazahra.ui.kumpulanMakanan

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if3039.asesment1_rivazahra.HomeActivity
import org.d3if3039.asesment1_rivazahra.Manifest
import org.d3if3039.asesment1_rivazahra.databinding.FragmentKumpulanfoodBinding
import org.d3if3039.asesment1_rivazahra.databinding.KumpulanListBinding
import org.d3if3039.asesment1_rivazahra.network.ApiStatus

class KumpulanFragment : Fragment() {

    private val viewModel: KumpulanViewModel by lazy {
        ViewModelProvider(this)[KumpulanViewModel::class.java]
    }

    private lateinit var binding: FragmentKumpulanfoodBinding
    private lateinit var myAdapter: KumpulanAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKumpulanfoodBinding.inflate(layoutInflater, container, false)
        myAdapter = KumpulanAdapter()
        with(binding.recyclerKumpulan) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = myAdapter
            setHasFixedSize(true)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getData().observe(viewLifecycleOwner) {


        }
    }

    private fun updateProgress(status: ApiStatus) {
        when (status) {
            ApiStatus.LOADING -> {
                binding.progressbar.visibility = View.VISIBLE
            }
            ApiStatus.SUCCESS -> {
                binding.progressbar.visibility = View.GONE

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    requestNotificationPermission()
                }
            }
            ApiStatus.FAILED -> {
                binding.progressbar.visibility = View.GONE
                binding.networkError.visibility = View.VISIBLE
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun requestNotificationPermission() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
                HomeActivity.PERMISSION_REQUEST_CODE
            )
        }
    }
}