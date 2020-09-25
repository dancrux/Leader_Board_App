package com.cruxrepublic.leader.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.cruxrepublic.leader.R
import com.cruxrepublic.leader.api.RetrofitClient
import com.cruxrepublic.leader.api.model.TopLearnersResponse
import com.cruxrepublic.leader.ui.adapters.TopLearnersAdapter
import kotlinx.android.synthetic.main.top_learners_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
private const val TAG = "LearnersFragment"
class TopLearnersFragment : Fragment() {

    companion object {
        fun newInstance() = TopLearnersFragment()
    }

    private lateinit var viewModel: TopLearnersViewModel
    private val learnerAdapter = TopLearnersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.top_learners_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        learnersRecycler.adapter = learnerAdapter
        learnersRecycler.layoutManager = LinearLayoutManager(this.activity)

        fetchData()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(TopLearnersViewModel::class.java)
    }

    private fun fetchData() {
        val service = RetrofitClient.apiInstance
        val call = service.getTopLearners()
        learnerProgressBar.visibility = View.VISIBLE

        call.enqueue(object : Callback<List<TopLearnersResponse>> {
            override fun onResponse(
                call: Call<List<TopLearnersResponse>>,
                response: Response<List<TopLearnersResponse>>) {
                Toast.makeText(requireActivity(), "Error code is ${response.code()}", Toast.LENGTH_SHORT).show()
                if (response.code() == 501) {
                    val learners = response.body()!!
                  learnerProgressBar.visibility = View.GONE
                  learnerAdapter.addItems(learners)
                    Log.d(TAG, "${response.code()}")

                } else {
                    learnerProgressBar.visibility = View.GONE
                    learnersOfflineViews.visibility = View.VISIBLE
                }
            }

            override fun onFailure(call: Call<List<TopLearnersResponse>>, t: Throwable) {
                learnerProgressBar.visibility = View.GONE
                learnersOfflineViews.visibility = View.VISIBLE
            }

        })
    }


}