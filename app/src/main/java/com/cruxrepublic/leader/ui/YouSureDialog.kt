package com.cruxrepublic.leader.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.cruxrepublic.leader.R
import kotlinx.android.synthetic.main.you_sure_dialog_fragment.*

class YouSureDialog : DialogFragment() {

    companion object {
        var yesDialogClick: YesDialogClick? = null
        fun setYesButtonClick(contract: YesDialogClick){
            yesDialogClick = contract
        }
        fun newInstance() = YouSureDialog()
    }

    interface YesDialogClick{
        fun gotSelected()
    }

    private lateinit var viewModel: YouSureDialogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Window.FEATURE_NO_TITLE
        requireDialog().window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setStyle(STYLE_NO_FRAME, android.R.style.Theme)
        return inflater.inflate(R.layout.you_sure_dialog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        yesButton.setOnClickListener {
            yesDialogClick?.gotSelected()
        }
        closeImage.setOnClickListener {
            findNavController().popBackStack()
            SubmitFragment.showSubmitView(requireActivity())
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(YouSureDialogViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onStart() {
        super.onStart()
        SubmitFragment.hideSubmitView(requireActivity())
    }

    override fun onDestroy() {
        super.onDestroy()
          SubmitFragment.showSubmitView(requireActivity())
    }
}