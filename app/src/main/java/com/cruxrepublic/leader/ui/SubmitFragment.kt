package com.cruxrepublic.leader.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.cruxrepublic.leader.MainActivity
import com.cruxrepublic.leader.R
import kotlinx.android.synthetic.main.submit_fragment.*

class SubmitFragment : Fragment() {

    companion object {
        fun newInstance() = SubmitFragment()
    }

    private lateinit var viewModel: SubmitViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.submit_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submitButton.setOnClickListener {
            findNavController().navigate(R.id.action_submitFragment_to_youSureDialog)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SubmitViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()
        MainActivity.hideToolBarTitle(requireActivity())
    }
}