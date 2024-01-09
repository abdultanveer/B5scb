package com.example.b5scb.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.b5scb.InventoryApplication
import com.example.b5scb.data.Item
import com.example.b5scb.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private val viewModel: HomeViewModel by activityViewModels {
        HomeViewModelFactory(
            (activity?.application as InventoryApplication).database
                .itemDao()
        )
    }
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.btnnAdd.setOnClickListener {
            addItemDb()
        }

        binding.btnGet.setOnClickListener {
            getItemDb()
        }
        return root
    }

    private fun getItemDb() {
        viewModel.retrieveItem(11).observe(this.viewLifecycleOwner) {
                foundItem -> binding.textDashboard.text = foundItem.toString()
        }
    }

    private fun addItemDb() {
        viewModel.insertItem(Item(11,"grocery",11.11,11))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}