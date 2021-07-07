package com.example.quizler.feature.main.admin_panel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.quizler.R

class AdminPanelFragment : Fragment() {

    companion object {
        fun newInstance() = AdminPanelFragment()
    }

    private lateinit var viewModel: AdminPanelViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_admin_panel, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AdminPanelViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
