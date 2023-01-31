package com.study.englishit.ui.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.study.englishit.databinding.FragmentHomeBinding
import com.study.englishit.domain.model.CardItemModel
import com.study.englishit.ui.presentation.navigation_screens.adapters.ItemListAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding ? = null
    private val binding get() = _binding!!

    private val itemListAdapter = ItemListAdapter()

    @Inject
    lateinit var dataList : List<CardItemModel>

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
    }

    private fun initListeners() {
        itemListAdapter.setCardItemClickListener {
            //here's goes the put extra
            val intent = Intent(requireContext(),DetailsActivity::class.java)
            intent.putExtra("details",it.title)
            intent.putExtra("detailsInt",it.img)
            startActivity(intent)
        }
    }

    private fun initRecyclerView() {
        with(binding.rvItems){
            adapter = itemListAdapter
            layoutManager= GridLayoutManager(requireContext(),2)
            overScrollMode = View.OVER_SCROLL_NEVER
            setHasFixedSize(false)
        }


        itemListAdapter.submitList(dataList)

    }

}