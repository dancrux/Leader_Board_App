package com.cruxrepublic.leader

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class YouSureDialog : Fragment() {

    companion object {
        fun newInstance() = YouSureDialog()
    }

    private lateinit var viewModel: YouSureDialogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.you_sure_dialog_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(YouSureDialogViewModel::class.java)
        // TODO: Use the ViewModel
    }

}