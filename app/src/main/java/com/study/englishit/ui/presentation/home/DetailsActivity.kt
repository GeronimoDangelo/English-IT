package com.study.englishit.ui.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.study.englishit.databinding.ActivityDetailsBinding
import com.study.englishit.di.DataModule
import com.study.englishit.domain.model.PhrasesModel
import com.study.englishit.ui.presentation.navigation_screens.adapters.DetailsListAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private val detailsListAdapter = DetailsListAdapter()


    @DataModule.List1
    @Inject
    lateinit var list1: List<PhrasesModel>

    @DataModule.List2
    @Inject
    lateinit var list2: List<PhrasesModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val img = getIntent().getIntExtra("img", 0)
        val id = getIntent().getIntExtra("id", 0)

        binding.ivHeadImg.setImageResource(img)
        binding.tvFirstTitle.text = title


        when (id) {
            0 -> detailsListAdapter.submitList(list1)
            1 -> detailsListAdapter.submitList(list2)

        }

        initRecyclerView()
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