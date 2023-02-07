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
import com.study.englishit.databinding.ActivityDetailsBinding
import com.study.englishit.databinding.ActivityHomeBinding
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

    private fun dialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("¡Felicidades! \uD83E\uDD8A")
            .setMessage("Has desbloqueado un nuevo logro! Ve a logros y descubre tu recompensa!")
            .setPositiveButton("Ok") { _, _ ->
            }.create()
            .show()
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
                //BASIC PHRASES
                0 -> {
                    startActivity(intent)            // GIVE 15 POINTS = 0 + 15 = 15
                }
                //CASUAL
                1 -> {
                    if (totalPoints >= 15) {
                        startActivity(intent)       // GIVE 30 POINTS = 15 + 30 = 45
                    } else {
                        dialog(15)
                    }
                }
                // CONNECTORS

                2 -> {
                    if (totalPoints >= 45) {
                        startActivity(intent)           // GIVE 20 POINTS = 45 + 20 = 65
                    } else {
                        dialog(45)
                    }

                }
                // ENDING A CONVERSATION

                3 -> {
                    if (totalPoints >= 65) {
                        startActivity(intent)
                    } else {
                        dialog(65)              // GIVE 15 POINTS = 80

                    }
                }

                // JOB CHATTING

                4 -> {
                    if (totalPoints >= 80) {
                        startActivity(intent)
                    } else {                         // GIVE 10 POINTS = 90

                        dialog(80)
                    }
                }
                // SOCIAL TECH

                5 -> {
                    if (totalPoints >= 90) {
                        startActivity(intent)                 // GIVE 15 POINTS = 90 +15 = 105

                    } else {
                        dialog(90)
                    }
                }
                // CASUAL 2

                6 -> {
                    if (totalPoints >= 105) {                   // GIVE 15 POINTS = 105 + 15 = 120

                        startActivity(intent)
                    } else {
                        dialog(105)
                    }
                }
                // AFTER WORK

                7 -> {
                    if (totalPoints >= 120) {
                        startActivity(intent)
                    } else {                        // GIVE 15 POINTS = 120 + 15 = 135
                        dialog(120)
                    }
                }
                //SHORT OF TIME

                8 -> {
                    if (totalPoints >= 135) {
                        startActivity(intent)
                    } else {                            // GIVE 15 POINTS = 135 + 15 = 150
                        dialog(135)
                    }
                }
                //JOB INTERVIEW

                9 -> {
                    if (totalPoints >= 150) {
                        startActivity(intent)
                    } else {                            // GIVE 15 POINTS = 150 + 15 = 165
                        dialog(150)
                    }
                }
                // CAREER CHANGE

                10 -> {
                    if (totalPoints >= 165) {
                        startActivity(intent)
                    } else {                         // GIVE 140 POINTS = 165 + 140 = 305
                        dialog(165)
                    }
                }
                // YOURSELF

                11 -> {
                    if (totalPoints >= 305) {
                        startActivity(intent)        // GIVE 20 POINTS = 305 + 20 = 325
                    } else {
                        dialog(305)
                    }
                }
                // OPINION

                12 -> {
                    if (totalPoints >= 325) {
                        startActivity(intent)        // GIVE 15 POINTS = 325 + 15 = 340
                    } else {
                        dialog(325)
                    }
                }
                // PROBABILITY

                13 -> {
                    if (totalPoints >= 340) {
                        startActivity(intent)
                    } else {                         // GIVE 15 POINTS = 340 + 15 = 355
                        dialog(340)
                    }
                }
                // SHORT ANSWERS

                14 -> {
                    if (totalPoints >= 355) {
                        startActivity(intent)
                    } else {                         // GIVE 130 POINTS = 355 + 130 = 485
                        dialog(355)
                    }
                }
                // HOMETOWN

                15 -> {
                    if (totalPoints >= 485) {
                        startActivity(intent)
                    } else {                     // GIVE 1533 POINTS = 489 + 1533 = 2022
                        dialog(485)
                    }
                }
                //
                //
                //
                //
                //
                //
                //
                //
                //
                //
                //
                //
                //
                //
                //THESE ARE CLOSED
                16 -> if (totalPoints >= 2023) {
                    dialogNoAvailable()
                } else {
                    dialog(2024)
                }

                17 -> if (totalPoints >= 2023) {
                    dialogNoAvailable()
                } else {
                    dialog(2025)
                }
                18 -> if (totalPoints >= 2023) {
                    dialogNoAvailable()
                } else {
                    dialog(2026)
                }
                19 -> if (totalPoints >= 2023) {
                    dialogNoAvailable()
                } else {
                    dialog(2027)
                }
                20 -> if (totalPoints >= 2023) {
                    dialogNoAvailable()
                } else {
                    dialog(2028)
                }
                21 -> if (totalPoints >= 2023) {
                    dialogNoAvailable()
                } else {
                    dialog(2029)
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
            .setTitle("Leccion Bloqueada \uD83E\uDD8A")
            .setMessage("Necesitas $points puntos para desbloquear esta leccion. Puedes ganar mas puntos completando previas lecciones!  \uD83E\uDD73 ")
            .setPositiveButton("Ok") { _, _ ->
            }.create()
            .show()
    }


    private fun dialogNoAvailable() {
        AlertDialog.Builder(requireContext())
            .setTitle("Leccion Bloqueada \uD83E\uDD8A")
            .setMessage("Lamento que las lecciones sean solo eso. Soy un solo programador. Pero si esta aplicación obtiene más descargas/estudiantes.. ¡Lanzaré muchas más! ¡Así que mantente alerta!")
            .setPositiveButton("Ok") { _, _ ->
            }.create()
            .show()
    }

}