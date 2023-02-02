package com.study.englishit.ui.presentation.home

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.study.englishit.data.local.LocalSource.providesPhrases0
import com.study.englishit.data.local.LocalSource.providesPhrases1
import com.study.englishit.data.local.LocalSource.providesPhrases2
import com.study.englishit.data.local.LocalSource.providesPhrases3
import com.study.englishit.data.local.LocalSource.providesPhrases4
import com.study.englishit.data.local.LocalSource.providesPhrases5
import com.study.englishit.data.local.LocalSource.providesPhrases6
import com.study.englishit.databinding.ActivityDetailsBinding
import com.study.englishit.ui.presentation.navigation_screens.adapters.DetailsListAdapter
import dagger.hilt.android.AndroidEntryPoint

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = getIntent().getIntExtra("title", 0)
        val img = getIntent().getIntExtra("img", 0)
        val id = getIntent().getIntExtra("id", 0)

        binding.ivHeadImg.setImageResource(img)
        binding.tvFirstTitle.setText(title)
        binding.backArrow.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }



        when (id) {
            0 -> {
                detailsListAdapter.submitList(list0)
            }
            1 -> detailsListAdapter.submitList(list1)
            2 -> detailsListAdapter.submitList(list2)
            3 -> detailsListAdapter.submitList(list3)
            4 -> detailsListAdapter.submitList(list4)
            5 -> detailsListAdapter.submitList(list5)
            6 -> detailsListAdapter.submitList(list6)
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