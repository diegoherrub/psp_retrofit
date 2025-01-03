package com.psp.retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.psp.retrofit.data.StudentDataRepository
import com.psp.retrofit.data.remote.ApiClient
import com.psp.retrofit.data.remote.ApiService
import com.psp.retrofit.ui.theme.RetrofitTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val repository: StudentDataRepository by lazy {
        val apiService = ApiClient.provideRetrofit().create(ApiService::class.java)
        StudentDataRepository(apiService)
    }
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetrofitTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                        onFetchStudents = {
                            coroutineScope.launch(Dispatchers.IO) {
                                val response = repository.getStudents()
                                if (response.isSuccessful) {
                                    println("Students: ${response.body()}")
                                } else {
                                    println("Error: ${response.errorBody()}")
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, onFetchStudents: () -> Unit) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )

    onFetchStudents()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RetrofitTheme {
        Greeting("Android", onFetchStudents = {})
    }
}