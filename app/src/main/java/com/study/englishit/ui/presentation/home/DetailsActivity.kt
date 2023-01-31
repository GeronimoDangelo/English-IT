package com.study.englishit.ui.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.study.englishit.databinding.ActivityDetailsBinding
import com.study.englishit.domain.model.CardItemModel
import com.study.englishit.domain.model.PhrasesModel
import com.study.englishit.ui.presentation.navigation_screens.adapters.DetailsListAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private val detailsListAdapter = DetailsListAdapter()


    @Inject
    lateinit var dataList : List<PhrasesModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent.getStringExtra("details")
        val intentInt = getIntent().getIntExtra("detailsInt",0)


        binding.ivHeadImg.setImageResource(intentInt)
        binding.tvFirstTitle.text = intent

        initRecyclerView()
        detailsListAdapter.submitList(dataList)

    }

    private fun initRecyclerView() {
        with(binding.rvDetails) {
            adapter = detailsListAdapter
            layoutManager= LinearLayoutManager(this@DetailsActivity,LinearLayoutManager.VERTICAL, false)
            overScrollMode= View.OVER_SCROLL_NEVER
            setHasFixedSize(false)
        }
    }
}