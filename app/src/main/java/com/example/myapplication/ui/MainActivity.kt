package com.example.myapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.network.ApiClient
import com.example.myapplication.repo.UserRepository
import com.example.myapplication.ui.model.DashBoardViewModel
import com.example.myapplication.utils.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var dashBoardViewModel: DashBoardViewModel
    lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dashBoardViewModel = ViewModelProviders.of(
            this,
            BaseViewModelFactory(DashBoardViewModel(UserRepository(ApiClient().getApiInstance())))
        )[DashBoardViewModel::class.java]
        setObserver()
        if (::dashBoardViewModel.isInitialized) {
            if (UtilsData.isInternetAvailable()) {
                makeApiCall()
            } else {
                showDataFromDB()
            }
        }
    }

    override fun onResume() {
        super.onResume()


    }

    private fun setObserver() {
        dashBoardViewModel.UserResponseLiveData.observe(this) {
            when (it.status) {
                Status.LOADING -> {
                    ProgressDialogUtil.showProgressDialog(this)
                }
                Status.SUCCESS -> {
                    ProgressDialogUtil.hideProgressDialog()
                    if (!it?.item?.articles!!.isNullOrEmpty()) {
                        binding.rvNews.show()
                        newsAdapter = NewsAdapter(this, { data, position ->

                        })
                        newsAdapter.addAll(it?.item?.articles!!)
                        binding.rvNews.adapter = newsAdapter
                    } else {
                        binding.root.showSnackBar("No data to show")
                        binding.rvNews.hide()
                    }

                }
                Status.ERROR -> {
                    ProgressDialogUtil.hideProgressDialog()
                    binding.rvNews.hide()
                    binding.root.showSnackBar(it.message)
                }
            }
        }
    }

    private fun showDataFromDB() {

    }

    private fun makeApiCall() {
        dashBoardViewModel.callNewsListApi(1)
    }
}