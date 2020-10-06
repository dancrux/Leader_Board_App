package com.cruxrepublic.leader

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment

class YouSureDialog : DialogFragment() {

    companion object {
        fun newInstance() = YouSureDialog()
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(YouSureDialogViewModel::class.java)
        // TODO: Use the ViewModel
    }

}