package com.example.midastreasures.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.midastreasures.R
import com.example.midastreasures.databinding.GameFragmentBinding
import com.example.midastreasures.viewmodels.GameViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class GameFragment : Fragment() {
    private val binding: GameFragmentBinding by lazy {
        GameFragmentBinding.inflate(layoutInflater)
    }
    private val viewModel: GameViewModel by viewModels()
    var appendToScore: Int = 0
    var isClick: String? = null


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
            img00.setOnClickListener {

                viewModel.attempt("00")
            }

            img01.setOnClickListener {

                viewModel.attempt("00")


            }

            img02.setOnClickListener { viewModel.attempt("00") }

            img03.setOnClickListener { viewModel.attempt("00") }

            img10.setOnClickListener {

                viewModel.attempt("10")
            }

            img11.setOnClickListener {

                viewModel.attempt("10")
            }

            img12.setOnClickListener {

                viewModel.attempt("10")
            }

            img13.setOnClickListener {
                viewModel.attempt("10")
            }

            img20.setOnClickListener {

                viewModel.attempt("20")
            }

            img21.setOnClickListener {

                viewModel.attempt("20")
            }

            img22.setOnClickListener {

                viewModel.attempt("20")
            }

            img23.setOnClickListener {

                viewModel.attempt("20")
            }

            img30.setOnClickListener {

                viewModel.attempt("31")
            }

            img31.setOnClickListener {

                viewModel.attempt("31")
            }

            img32.setOnClickListener {

                viewModel.attempt("31")
            }

            img33.setOnClickListener {

                viewModel.attempt("31")
            }

            img40.setOnClickListener {
                    viewModel.attempt("40")
            }

            img41.setOnClickListener {
                    viewModel.attempt("40")
            }

            img42.setOnClickListener {
                    viewModel.attempt("40")
            }

            img43.setOnClickListener {
                    viewModel.attempt("40")
            }

            img50.setOnClickListener {
                    viewModel.attempt("50")
            }

            img51.setOnClickListener {
                    viewModel.attempt("50")
            }

            img52.setOnClickListener {
                    viewModel.attempt("50")
            }

            img53.setOnClickListener {
                    viewModel.attempt("50")
            }

            startBtn.setOnClickListener {
                restart()
                viewModel.startAgain()

                editTextScore.text = "0"
                editTextTotalScore.text = "0"
                appendToScore = 0

            }

            isClickable("")
        }

        viewModel.observeLoseScore().observe(viewLifecycleOwner) {
            binding.apply {
                Log.d("Test", it)
                editTextScore.text = "0"
                editTextTotalScore.text = "0"
                startBtn.setText("START")
                appendToScore = 0
                restart()
            }
//            toast("    You lose\n start again")
        }

        viewModel.observeScore().observe(viewLifecycleOwner) { t ->
            isClick = t
            isClickable(t)
            appendToScore = appendToScore + t.toInt()
            binding.editTextScore.text = appendToScore.toString()
        }

        viewModel.observeTotalScore().observe(viewLifecycleOwner) { it ->
            binding.apply {
                editTextScore.text = "0"
                editTextTotalScore.text = (appendToScore + it.toInt()).toString()
            }
        }
    }


    private fun restart() {
        binding.apply {
            img00.setImageResource(R.drawable.treasure)
            img01.setImageResource(R.drawable.treasure)
            img02.setImageResource(R.drawable.treasure)
            img03.setImageResource(R.drawable.treasure)

            img20.setImageResource(R.drawable.treasurenoselected)
            img21.setImageResource(R.drawable.treasurenoselected)
            img22.setImageResource(R.drawable.treasurenoselected)
            img23.setImageResource(R.drawable.treasurenoselected)

            img30.setImageResource(R.drawable.treasurenoselected)
            img31.setImageResource(R.drawable.treasurenoselected)
            img32.setImageResource(R.drawable.treasurenoselected)
            img33.setImageResource(R.drawable.treasurenoselected)

            img40.setImageResource(R.drawable.treasurenoselected)
            img41.setImageResource(R.drawable.treasurenoselected)
            img42.setImageResource(R.drawable.treasurenoselected)
            img43.setImageResource(R.drawable.treasurenoselected)

            img50.setImageResource(R.drawable.treasurenoselected)
            img51.setImageResource(R.drawable.treasurenoselected)
            img52.setImageResource(R.drawable.treasurenoselected)
            img53.setImageResource(R.drawable.treasurenoselected)
        }


    }

    private fun isClickable(t: String) {
        binding.apply {

            if (t.equals("100")) {

                img10.setImageResource(R.drawable.treasure)

                img11.setImageResource(R.drawable.treasure)

                img12.setImageResource(R.drawable.treasure)

                img13.setImageResource(R.drawable.treasure)

                img00.setImageResource(R.drawable.treasurenoselected)
                img01.setImageResource(R.drawable.treasurenoselected)
                img02.setImageResource(R.drawable.treasurenoselected)
                img03.setImageResource(R.drawable.treasurenoselected)


            } else if (t == "500") {

                img20.setImageResource(R.drawable.treasure)

                img21.setImageResource(R.drawable.treasure)

                img22.setImageResource(R.drawable.treasure)

                img23.setImageResource(R.drawable.treasure)

                img10.setImageResource(R.drawable.treasurenoselected)
                img11.setImageResource(R.drawable.treasurenoselected)
                img12.setImageResource(R.drawable.treasurenoselected)
                img13.setImageResource(R.drawable.treasurenoselected)

            } else if (t == "2000") {

                img30.isClickable = false
                img30.setImageResource(R.drawable.treasure)

                img31.isClickable = false
                img31.setImageResource(R.drawable.treasure)

                img32.isClickable = false
                img32.setImageResource(R.drawable.treasure)

                img33.isClickable = false
                img33.setImageResource(R.drawable.treasure)

                img20.setImageResource(R.drawable.treasurenoselected)
                img21.setImageResource(R.drawable.treasurenoselected)
                img22.setImageResource(R.drawable.treasurenoselected)
                img23.setImageResource(R.drawable.treasurenoselected)

            } else if (t == "10000") {

                img40.isClickable = false
                img40.setImageResource(R.drawable.treasure)

                img41.isClickable = false
                img41.setImageResource(R.drawable.treasure)

                img42.isClickable = false
                img42.setImageResource(R.drawable.treasure)

                img43.isClickable = false
                img43.setImageResource(R.drawable.treasure)

                img30.setImageResource(R.drawable.treasurenoselected)
                img31.setImageResource(R.drawable.treasurenoselected)
                img32.setImageResource(R.drawable.treasurenoselected)
                img33.setImageResource(R.drawable.treasurenoselected)

            } else if (t == "50000") {

                img50.isClickable = false
                img50.setImageResource(R.drawable.treasure)

                img51.isClickable = false
                img51.setImageResource(R.drawable.treasure)

                img52.isClickable = false
                img52.setImageResource(R.drawable.treasure)

                img53.isClickable = false
                img53.setImageResource(R.drawable.treasure)

                img40.setImageResource(R.drawable.treasurenoselected)
                img41.setImageResource(R.drawable.treasurenoselected)
                img42.setImageResource(R.drawable.treasurenoselected)
                img43.setImageResource(R.drawable.treasurenoselected)

            } else if (t == "200000") {
                img00.setImageResource(R.drawable.treasure)
                img01.setImageResource(R.drawable.treasure)
                img02.setImageResource(R.drawable.treasure)
                img03.setImageResource(R.drawable.treasure)

                img20.setImageResource(R.drawable.treasure)
                img21.setImageResource(R.drawable.treasure)
                img22.setImageResource(R.drawable.treasure)
                img23.setImageResource(R.drawable.treasure)

                img30.setImageResource(R.drawable.treasure)
                img31.setImageResource(R.drawable.treasure)
                img32.setImageResource(R.drawable.treasure)
                img33.setImageResource(R.drawable.treasure)

                img40.setImageResource(R.drawable.treasure)
                img41.setImageResource(R.drawable.treasure)
                img42.setImageResource(R.drawable.treasure)
                img43.setImageResource(R.drawable.treasure)

                img50.setImageResource(R.drawable.treasure)
                img51.setImageResource(R.drawable.treasure)
                img52.setImageResource(R.drawable.treasure)
                img53.setImageResource(R.drawable.treasure)

            }
        }

    }


}