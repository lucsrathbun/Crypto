package com.example.crypto

import android.net.wifi.rtt.CivicLocationKeys.STATE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crypto.databinding.ActivityCryptoListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CryptoListActivity : AppCompatActivity() {
    companion object{
        const val TAG = "CryptoListActivity"
        const val RATE = "USD"
    }
    private lateinit var binding: ActivityCryptoListBinding
    private lateinit var adapter: CryptoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptoListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getCryptoDataByRateApiCall(RATE)
    }

    private fun getCryptoDataByRateApiCall(rate: String) {
        val cryptoDataService = RetrofitHelper.getInstance().create(CryptoDataService::class.java)
        val countyDataCall = cryptoDataService.getCryptoData(rate,Constants.API_KEY)
        countyDataCall.enqueue(object: Callback<List<CryptoData>> {
            override fun onResponse(
                call: Call<List<CryptoData>>,
                response: Response<List<CryptoData>>
            ) {
                Log.d(TAG, "onResponse: ${response.body()}")
                if(response.body()!=null)
                    adapter = CryptoAdapter(response.body()!!)
                else{
                    Log.d(TAG, "response is null")
                }
                binding.recyclerViewCryptoList.adapter = adapter
                binding.recyclerViewCryptoList.layoutManager = LinearLayoutManager(this@CryptoListActivity)
            }

            override fun onFailure(call: Call<List<CryptoData>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })
    }

}