package com.example.midastreasures.ui

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.midastreasures.databinding.GameFragmentBinding
import com.example.midastreasures.utils.toast
import com.example.midastreasures.viewmodels.GameViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GameFragment : Fragment() {
    private val binding: GameFragmentBinding by lazy {
        GameFragmentBinding.inflate(layoutInflater)
    }
    private val viewModel: GameViewModel by viewModels()
    var appendToScore : Int = 0


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

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {
            txt00.setOnClickListener { viewModel.attempt("00") }

            txt01.setOnClickListener { viewModel.attempt("01") }

            txt02.setOnClickListener { viewModel.attempt("02") }

            txt03.setOnClickListener { viewModel.attempt("03") }

            txt10.setOnClickListener { viewModel.attempt("10") }

            txt11.setOnClickListener { viewModel.attempt("11") }

            txt12.setOnClickListener { viewModel.attempt("12") }

            txt13.setOnClickListener { viewModel.attempt("13") }

            txt20.setOnClickListener { viewModel.attempt("20") }

            txt21.setOnClickListener { viewModel.attempt("21") }

            txt22.setOnClickListener { viewModel.attempt("22") }

            txt23.setOnClickListener { viewModel.attempt("23") }

            txt30.setOnClickListener { viewModel.attempt("30") }

            txt31.setOnClickListener { viewModel.attempt("31") }

            txt32.setOnClickListener { viewModel.attempt("32") }

            txt33.setOnClickListener { viewModel.attempt("33") }

            txt40.setOnClickListener { viewModel.attempt("40") }

            txt41.setOnClickListener { viewModel.attempt("41") }

            txt42.setOnClickListener { viewModel.attempt("42") }

            txt43.setOnClickListener { viewModel.attempt("43") }

            txt50.setOnClickListener { viewModel.attempt("50") }

            txt51.setOnClickListener { viewModel.attempt("51") }

            txt52.setOnClickListener { viewModel.attempt("52") }

            txt53.setOnClickListener { viewModel.attempt("53") }

            startBtn.setOnClickListener {
             startBtn.setText("STOP")
                viewModel.startAgain()
            }

        }

        viewModel.observeLoseScore().observe(viewLifecycleOwner){
            binding.apply {
                editTextScore.text = "0"
                editTextTotalScore.text = "0"
                startBtn.setText("START")
            }
//            toast("    You lose\n start again")
        }


        viewModel.observeScore().observe(viewLifecycleOwner) { t ->

            appendToScore = appendToScore + t.toInt()
            binding.editTextScore.text =  appendToScore.toString()
        }

        viewModel.observeTotalScore().observe(viewLifecycleOwner){ it->
            binding.apply {
                editTextScore.text = "0"
                editTextTotalScore.text = (appendToScore + it.toInt()).toString()
            }
        }



    }


}