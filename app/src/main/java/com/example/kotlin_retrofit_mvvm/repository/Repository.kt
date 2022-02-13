package com.example.kotlin_retrofit_mvvm.repository

import androidx.lifecycle.LiveData
import com.example.kotlin_retrofit_mvvm.model.User
import com.example.kotlin_retrofit_mvvm.network.RetrofitBuilder
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object Repository {
    var job: CompletableJob? = null

    fun getUser(userId: String): LiveData<User>{
        job = Job()
        return object: LiveData<User>(){
            override fun onActive() {
                super.onActive()
                job?.let{ theJob ->
                    CoroutineScope(IO + theJob).launch {
                        val user = RetrofitBuilder.apiService.getUser(userId)
                        withContext(Main){
                            value = user
                            theJob.complete()
                        }
                    }

                }

            }
        }
    }

    fun cancelJobs(){
        job?.cancel()
    }

}