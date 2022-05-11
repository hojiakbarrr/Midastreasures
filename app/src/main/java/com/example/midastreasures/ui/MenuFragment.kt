package com.example.midastreasures.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.midastreasures.R
import com.example.midastreasures.databinding.MenuFragmentBinding
import com.example.midastreasures.viewmodels.MenuViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MenuFragment : Fragment(){
    private val binding: MenuFragmentBinding by lazy {
        MenuFragmentBinding.inflate(layoutInflater)
    }
    private val viewModel : MenuViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.startGame.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.from_menuFragment_to_gameFragment)
        }
        binding.exitGame.setOnClickListener {
            activity?.finishAffinity()
        }


    }


}