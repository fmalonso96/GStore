package com.example.gstore.ui.configuration.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.gstore.R
import com.example.gstore.databinding.FragmentConfigurationBinding

class ConfigurationFragment : Fragment() {

    private lateinit var binding: FragmentConfigurationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_configuration, container, false)

        return binding.root
    }

}