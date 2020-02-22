package com.pms.drugx.repository

import androidx.lifecycle.LiveData
import com.pms.drugx.api.MyRetrofitBuilder
import com.pms.mpharm.models.Product
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object Repository {

    var job: CompletableJob? = null

    fun getUser(userId: String): LiveData<List<Product>>{
        job = Job()
        return object: LiveData<List<Product>>(){
            override fun onActive() {
                super.onActive()
                job?.let{ theJob ->
                    CoroutineScope(IO + theJob).launch {
                        val products = MyRetrofitBuilder.apiService.getProducts(userId)
                        withContext(Main){
                            value = products
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
















