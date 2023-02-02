package com.study.englishit.ui.presentation.home

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.study.englishit.data.local.LocalSource.providesPhrases
import com.study.englishit.data.local.LocalSource.providesPhrases2
import com.study.englishit.data.local.LocalSource.providesPhrases3
import com.study.englishit.databinding.ActivityDetailsBinding
import com.study.englishit.di.DataModule
import com.study.englishit.domain.model.PhrasesModel
import com.study.englishit.domain.model.PhrasesModel2
import com.study.englishit.ui.presentation.navigation_screens.adapters.DetailsListAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private val detailsListAdapter = DetailsListAdapter()


    private val list1 = providesPhrases()
    private val list2 = providesPhrases2()
    private val list3 = providesPhrases3()


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
                detailsListAdapter.submitList(list1)
            }
            1 -> detailsListAdapter.submitList(list2)
            2 -> detailsListAdapter.submitList(list3)
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