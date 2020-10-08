package com.cruxrepublic.leader.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.cruxrepublic.leader.MainActivity
import com.cruxrepublic.leader.R
import com.cruxrepublic.leader.api.RetrofitClient
import kotlinx.android.synthetic.main.submit_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SubmitFragment : Fragment(), YouSureDialog.YesDialogClick {



    private lateinit var viewModel: SubmitViewModel

    companion object {

        fun hideSubmitView(activity: FragmentActivity){
            activity.groupedViews.visibility = View.GONE
        }
        fun showSubmitView(activity: FragmentActivity){
            activity.groupedViews.visibility = View.VISIBLE
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.submit_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        YouSureDialog.setYesButtonClick(this)
        submitButton.setOnClickListener {
            val firstName = firstNameEdit.text!!.toString().trim()
            val lastName = lastNameEdit.text!!.toString().trim()
            val email = emailEdit.text!!.toString().trim()
            val projectLink = projectLinkEdit.text!!.toString().trim()
            when{
                firstName.isBlank() ->{
                    firstNameEdit.error = "Enter Your First Name"
                    firstNameEdit.requestFocus()
                    return@setOnClickListener
                }
                lastName.isBlank() ->{
                    lastNameEdit.error = "Enter Your Last Name"
                    lastNameEdit.requestFocus()
                    return@setOnClickListener
                }
                email.isBlank() ->{
                    emailEdit.error = "Enter Your Email"
                    emailEdit.requestFocus()
                    return@setOnClickListener
                }
                projectLink.isBlank() ->{
                    projectLinkEdit.error = "Enter Your Project Link"
                    projectLinkEdit.requestFocus()
                    return@setOnClickListener
                }
            }
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
        showSubmitView(requireActivity())
    }

    override fun gotSelected() {
        doSubmission()
        submitProgressBar.visibility = View.VISIBLE
    }

    private fun doSubmission() {
        submitProgressBar.visibility = View.VISIBLE
        val firstName = firstNameEdit.text!!.toString().trim()
        val lastName = lastNameEdit.text!!.toString().trim()
        val email = emailEdit.text!!.toString().trim()
        val projectLink = projectLinkEdit.text!!.toString().trim()
        RetrofitClient.submitInstance.submission(firstName,lastName,email,projectLink)
            .enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        submitProgressBar.visibility = View.GONE
                        findNavController().navigate(R.id.action_youSureDialog_to_submissionSuccessful)
                    } else {
                        submitProgressBar.visibility = View.GONE
                        findNavController().navigate(R.id.action_youSureDialog_to_submissionNotSuccessful)
                        Toast.makeText(
                            requireContext(),
                            "Submission Failed: ${response.errorBody()}",
                            Toast.LENGTH_SHORT
                        ).show()
                        print("Submission Failed: ${response.errorBody()}")
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    submitProgressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
                    showSubmitView(requireActivity())
                }

            })
    }

    override fun onResume() {
        super.onResume()
        showSubmitView(requireActivity())
    }
}