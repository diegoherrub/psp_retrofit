package com.psp.retrofit.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.psp.retrofit.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class StudentFragment : Fragment() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_students)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





    }
}