package com.study.englishit.ui.presentation.home

import android.content.SharedPreferences
import android.graphics.BlendMode
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.compose.ui.res.colorResource
import androidx.recyclerview.widget.LinearLayoutManager
import com.study.englishit.R
import com.study.englishit.data.local.LocalSource.providesPhrases0
import com.study.englishit.data.local.LocalSource.providesPhrases1
import com.study.englishit.data.local.LocalSource.providesPhrases10
import com.study.englishit.data.local.LocalSource.providesPhrases11
import com.study.englishit.data.local.LocalSource.providesPhrases12
import com.study.englishit.data.local.LocalSource.providesPhrases13
import com.study.englishit.data.local.LocalSource.providesPhrases14
import com.study.englishit.data.local.LocalSource.providesPhrases15
import com.study.englishit.data.local.LocalSource.providesPhrases2
import com.study.englishit.data.local.LocalSource.providesPhrases3
import com.study.englishit.data.local.LocalSource.providesPhrases4
import com.study.englishit.data.local.LocalSource.providesPhrases5
import com.study.englishit.data.local.LocalSource.providesPhrases6
import com.study.englishit.data.local.LocalSource.providesPhrases7
import com.study.englishit.data.local.LocalSource.providesPhrases8
import com.study.englishit.data.local.LocalSource.providesPhrases9
import com.study.englishit.databinding.ActivityDetailsBinding
import com.study.englishit.ui.presentation.navigation_screens.adapters.DetailsListAdapter
import com.study.englishit.util.Constants.DATA_POINTS_KEY
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private val detailsListAdapter = DetailsListAdapter()


    private val list0 = providesPhrases0()
    private val list1 = providesPhrases1()
    private val list2 = providesPhrases2()
    private val list3 = providesPhrases3()
    private val list4 = providesPhrases4()
    private val list5 = providesPhrases5()
    private val list6 = providesPhrases6()
    private val list7 = providesPhrases7()
    private val list8 = providesPhrases8()
    private val list9 = providesPhrases9()
    private val list10 = providesPhrases10()
    private val list11 = providesPhrases11()
    private val list12 = providesPhrases12()
    private val list13 = providesPhrases13()
    private val list14 = providesPhrases14()
    private val list15 = providesPhrases15()


    private val homeViewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getIntExtra("title", 0)
        val img = intent.getIntExtra("img", 0)
        val id = intent.getIntExtra("id", 0)

        binding.ivHeadImg.setImageResource(img)
        binding.tvFirstTitle.setText(title)
        binding.backArrow.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        fun provideViewmodel(points: Int = 15) {
            homeViewModel.lessonCompleted(points)
            homeViewModel.saveData()
        }

        fun getPoints() {
            homeViewModel.getPoints()
        }

        fun lessonCompletedAndRecovered() {
            binding.btnFinish.text = "Lesson Completed"
            binding.btnFinish.isEnabled = false
            binding.btnFinish.background.setTint(R.color.pointsEarned)
            binding.btnFinish.setBackgroundColor(getColor(R.color.pointsEarned))
            binding.btnFinish.setTextColor(getColor(R.color.white))


        }

        fun lessonNotCompleted(points: Int = 15, msg: Int = 15) {
            binding.btnFinish.setOnClickListener {
                provideViewmodel(points = points)
                binding.btnFinish.text = "$msg Points Earned"
                binding.btnFinish.isEnabled = false
                binding.btnFinish.setBackgroundColor(getColor(R.color.pointsEarned))
                binding.btnFinish.setTextColor(getColor(R.color.white))
            }
        }


        when (id) {
            0 -> {
                getPoints()
                detailsListAdapter.submitList(list0)
                val total = sharedPreferences.getInt(DATA_POINTS_KEY, 0)
                if (total >= 15) {
                    lessonCompletedAndRecovered()
                } else {
                    lessonNotCompleted()
                }


            }
            1 -> {
                getPoints()
                detailsListAdapter.submitList(list1)
                val total = sharedPreferences.getInt(DATA_POINTS_KEY, 0)
                if (total >= 30) {
                    lessonCompletedAndRecovered()
                } else {
                    lessonNotCompleted(points = 30, msg = 30)
                }

            }
            2 -> detailsListAdapter.submitList(list2) {
                getPoints()
                detailsListAdapter.submitList(list1)
                val total = sharedPreferences.getInt(DATA_POINTS_KEY, 0)
                if (total >= 60) {
                    lessonCompletedAndRecovered()
                } else {
                    lessonNotCompleted(points = 20, msg = 20)
                }
            }
            3 -> detailsListAdapter.submitList(list3)
            4 -> detailsListAdapter.submitList(list4)
            5 -> detailsListAdapter.submitList(list5)
            6 -> detailsListAdapter.submitList(list6)
            7 -> detailsListAdapter.submitList(list7)
            8 -> detailsListAdapter.submitList(list8)
            9 -> detailsListAdapter.submitList(list9)
            10 -> detailsListAdapter.submitList(list10)
            11 -> detailsListAdapter.submitList(list11)
            12 -> detailsListAdapter.submitList(list12)
            13 -> detailsListAdapter.submitList(list13)
            14 -> detailsListAdapter.submitList(list14)
            15 -> detailsListAdapter.submitList(list15)
        }


        detailsListAdapter.setDetailsItemClickListener {
            playSound(it.audio)
        }

        initRecyclerView()
    }


    private fun playSound(audio: Int) {
        var mediaPlayer: MediaPlayer? = null
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, audio)
            mediaPlayer!!.isLooping = false
            mediaPlayer.start()
        } else mediaPlayer.start()
    }


    private fun initRecyclerView() {
        with(binding.rvDetails) {
            adapter = detailsListAdapter
            layoutManager =
                LinearLayoutManager(this@DetailsActivity, LinearLayoutManager.VERTICAL, false)
            overScrollMode = View.OVER_SCROLL_NEVER
            setHasFixedSize(false)
        }
    }


}