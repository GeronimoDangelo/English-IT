package com.study.englishit.ui.presentation.home

import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.alpha
import androidx.core.view.children
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.study.englishit.R
import com.study.englishit.databinding.CardItemBinding
import com.study.englishit.databinding.FragmentHomeBinding
import com.study.englishit.domain.model.CardItemModel
import com.study.englishit.ui.presentation.navigation_screens.adapters.ItemListAdapter
import com.study.englishit.util.Constants.DATA_POINTS_KEY
import com.study.englishit.util.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.NonDisposableHandle.parent
import java.lang.Float
import javax.inject.Inject
import kotlin.math.sign


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private val itemListAdapter = ItemListAdapter()


    @Inject
    lateinit var dataList: List<CardItemModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initListeners()
        initObserver()
    }

    private fun initObserver() {
        itemListAdapter
    }


    private fun initListeners() {


        itemListAdapter.setCardItemClickListener { cardItem ->
            //here's goes the put extra
            val intent = Intent(requireContext(), DetailsActivity::class.java)
            intent.putExtra("title", cardItem.title)
            intent.putExtra("img", cardItem.img)
            intent.putExtra("id", cardItem.id)
            val totalPoints = sharedPreferences.getInt(DATA_POINTS_KEY, 0)


            //

            when (cardItem.id) {
                0 -> startActivity(intent)

                1 -> startActivity(intent)

                2 -> {
                    if (totalPoints >= 20) {
                        startActivity(intent)
                    } else {
                        dialog(20)
                    }

                }
                3 -> {
                    if (totalPoints >= 30) {
                        startActivity(intent)
                    } else {
                        dialog(30)
                    }
                }
                4 -> {
                    if (totalPoints >= 40) {
                        startActivity(intent)
                    } else {
                        dialog(40)
                    }
                }
                5 -> {
                    if (totalPoints >= 60) {
                        startActivity(intent)
                    } else {
                        dialog(60)
                    }
                }
                6 -> {
                    if (totalPoints >= 70) {
                        startActivity(intent)
                    } else {
                        dialog(70)
                    }
                }
                7 -> {
                    if (totalPoints >= 80) {
                        startActivity(intent)
                    } else {
                        dialog(80)
                    }
                }
                8 -> {
                    if (totalPoints >= 90) {
                        startActivity(intent)
                    } else {
                        dialog(90)
                    }
                }
                9 -> {
                    if (totalPoints >= 100) {
                        startActivity(intent)
                    } else {
                        dialog(100)
                    }
                }
                10 -> {
                    if (totalPoints >= 110) {
                        startActivity(intent)
                    } else {
                        dialog(110)
                    }
                }
                11 -> {
                    if (totalPoints >= 120) {
                        startActivity(intent)
                    } else {
                        dialog(120)
                    }
                }
                12 -> {
                    if (totalPoints >= 130) {
                        startActivity(intent)
                    } else {
                        dialog(130)
                    }
                }
                13 -> {
                    if (totalPoints >= 140) {
                        startActivity(intent)
                    } else {
                        dialog(140)
                    }
                }
                14 -> {
                    if (totalPoints >= 150) {
                        startActivity(intent)
                    } else {
                        dialog(150)
                    }
                }
                15 -> {
                    if (totalPoints >= 160) {
                        startActivity(intent)
                    } else {
                        dialog(160)
                    }
                }
                16 -> {
                    if (totalPoints >= 170) {
                        startActivity(intent)
                    } else {
                        dialog(170)
                    }
                }
                17 -> {
                    if (totalPoints >= 180) {
                        startActivity(intent)
                    } else {
                        dialog(180)
                    }
                }


            }
        }
    }

    private fun initRecyclerView() {
        with(binding.rvItems) {
            adapter = itemListAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
            overScrollMode = View.OVER_SCROLL_NEVER
            setHasFixedSize(false)
        }


        itemListAdapter.submitList(dataList)

    }

    private fun dialog(points: Int) {
        AlertDialog.Builder(requireContext())
            .setTitle("Lesson Locked \uD83E\uDD8A")
            .setMessage("You need $points points to unlock this lesson. \n\nYou can earn more points completing lessons and pressing the button at the final of each list  \uD83E\uDD73 ")
            .setPositiveButton("Ok") { _, _ ->

            }.create()
            .show()
    }


}