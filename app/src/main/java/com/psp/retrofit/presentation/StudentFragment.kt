package com.psp.retrofit.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.psp.retrofit.R
import com.psp.retrofit.data.StudentDataRepository
import com.psp.retrofit.data.remote.ApiClient
import com.psp.retrofit.data.remote.ApiService
import com.psp.retrofit.model.StudentRepository
import kotlinx.coroutines.launch

class StudentFragment : Fragment() {

    private val repository: StudentRepository by lazy {
        val apiService = ApiClient.provideRetrofit().create(ApiService::class.java)
        StudentDataRepository(apiService)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_student, container, false) // Asegúrate de usar el ID correcto
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_students)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Asocia el adaptador incluso si los datos aún no están listos
        recyclerView.adapter = StudentAdapter(emptyList()) // Lista vacía temporal
        fetchStudents(recyclerView) // Llama a la función para obtener los datos
    }

    private fun fetchStudents(recyclerView: RecyclerView) {
        lifecycleScope.launch {
            val response = repository.getStudents()
            if (response.isSuccessful) {
                val students = response.body() ?: emptyList()
                recyclerView.adapter = StudentAdapter(students)
            } else {
                // Manejo de errores
            }
        }
    }
}
