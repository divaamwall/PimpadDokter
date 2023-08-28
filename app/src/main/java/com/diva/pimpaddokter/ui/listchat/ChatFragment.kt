package com.diva.pimpaddokter.ui.listchat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.diva.pimpaddokter.adapter.UserAdapter
import com.diva.pimpaddokter.databinding.FragmentChatBinding
import com.diva.pimpaddokter.model.Users

class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val chatViewModel =
            ViewModelProvider(this).get(ChatViewModel::class.java)

        chatViewModel.allUsers.observe(viewLifecycleOwner, Observer {
            setupAction(it)
        })
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    private fun setupAction(listUser: ArrayList<Users>) {
        val adapter = UserAdapter(requireContext(),listUser, true)
        binding.apply {
            usersRv.layoutManager = LinearLayoutManager(activity)
            usersRv.setHasFixedSize(true)
            usersRv.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}