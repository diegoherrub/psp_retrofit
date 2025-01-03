package com.psp.retrofit.data

import com.psp.retrofit.data.remote.ApiService
import com.psp.retrofit.model.Course
import com.psp.retrofit.model.Student
import com.psp.retrofit.model.StudentRepository
import com.psp.retrofit.model.Subject
import retrofit2.Response

class StudentDataRepository(
    private val apiService: ApiService
) : StudentRepository {

    override suspend fun getStudents(): Response<List<Student>> {
        val response = apiService.requestStudents()
        return Response.success(response.body())
    }

    override suspend fun getStudentById(id: Int): Response<Student> {
        val response = apiService.requestStudentById(id)
        return Response.success(response.body())
    }

    override suspend fun getStudentByName(name: String): Response<List<Student>> {
        val response = apiService.requestStudentByName(name)
        return Response.success(response.body())
    }

    override suspend fun getStudentByEmail(email: String): Response<Student> {
        val response = apiService.requestStudentByEmail(email)
        return Response.success(response.body())
    }

    override suspend fun getStudentsByCourse(course: Course): Response<List<Student>> {
        val response = apiService.requestStudentsByCourse(course)
        return Response.success(response.body())
    }

    override suspend fun getStudentsBySubject(subject: Subject): Response<List<Student>> {
        val response = apiService.requestStudentsBySubject(subject)
        return Response.success(response.body())
    }

    override suspend fun addStudent(student: Student): Response<Student> {
        val response = apiService.addStudent(student)
        return Response.success(response.body())
    }

    override suspend fun deleteStudent(id: Int): Response<Boolean> {
        val response = apiService.deleteStudent(id)
        return Response.success(response.body())
    }
}