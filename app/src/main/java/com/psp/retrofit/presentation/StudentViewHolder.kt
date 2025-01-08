package com.psp.retrofit.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.psp.retrofit.R
import com.psp.retrofit.model.Student

class StudentViewHolder(
    private val view: View
) : RecyclerView.ViewHolder(view) {

    fun bind(student: Student) {
        view.findViewById<TextView>(R.id.item_student_name).text = student.name
        view.findViewById<TextView>(R.id.item_student_email).text = student.email
        view.findViewById<TextView>(R.id.item_student_course).text = student.course.toString()
        view.findViewById<TextView>(R.id.item_student_subjects).text = student.subjects.joinToString(", ")
    }
}