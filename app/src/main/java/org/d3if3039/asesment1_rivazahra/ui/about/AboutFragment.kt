package org.d3if3039.asesment1_rivazahra.ui.about

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if3039.asesment1_rivazahra.R
import org.d3if3039.asesment1_rivazahra.databinding.FragmentAboutBinding


class AboutFragment : Fragment() {
    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnBagikan.setOnClickListener { shareApp() }
    }
    fun shareApp(){

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, requireActivity().getString(R.string.app_name))
        intent.putExtra(
            Intent.EXTRA_TEXT,
            "Eksplor makanan italian mu di aplikasi kami "
        )
        requireActivity().startActivity(Intent.createChooser(intent, "Bagikan" ))
    }

}