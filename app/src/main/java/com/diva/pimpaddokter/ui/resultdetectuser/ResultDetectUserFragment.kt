package com.diva.pimpaddokter.ui.resultdetectuser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.diva.pimpaddokter.adapter.ResultDetectUserAdapter
import com.diva.pimpaddokter.databinding.FragmentResultDetectUserBinding
import com.diva.pimpaddokter.model.ResultDetectUser

class ResultDetectUserFragment : Fragment() {
    private var _binding: FragmentResultDetectUserBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val resultDetectUserViewModel =
            ViewModelProvider(this).get(ResultDetectUserViewModel::class.java)
        resultDetectUserViewModel.allResultDetectUser.observe(viewLifecycleOwner, Observer{
            setupAction(it)
        })

        _binding = FragmentResultDetectUserBinding.inflate(inflater, container, false)
        val root: View = binding.root


        // Inflate the layout for this fragment
        return root
    }

    private fun setupAction(listResultDetectUser: ArrayList<ResultDetectUser>) {
        val adapter = ResultDetectUserAdapter(listResultDetectUser)
        binding.apply {
            resultDetectUserRv.layoutManager = LinearLayoutManager(activity)
            resultDetectUserRv.setHasFixedSize(true)
            resultDetectUserRv.adapter = adapter
        }
    }

}