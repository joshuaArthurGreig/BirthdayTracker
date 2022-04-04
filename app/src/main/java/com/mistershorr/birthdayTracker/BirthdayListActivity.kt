package com.mistershorr.birthdayTracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.backendless.Backendless
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import com.backendless.persistence.DataQueryBuilder
import com.mistershorr.birthdayTracker.databinding.ActivityBirthdayListBinding

class BirthdayListActivity : AppCompatActivity() {

    lateinit var binding : ActivityBirthdayListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBirthdayListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadDataFromBackendless()
    }

    private fun loadDataFromBackendless() {

        Backendless.UserService.CurrentUser()
        val whereClause = "ownerId = '"
        val queryBuilder = DataQueryBuilder.create()
        queryBuilder.whereClause = whereClause
        Backendless.Data.of(Person::class.java).find(object : AsyncCallback<List<Person?>?> {
            override fun handleResponse(foundPeople: List<Person?>?) {
                Log.d("BirthdayList", "handleResponse : ${foundPeople}")
                val adapter = BirthdayAdapter((foundPeople ?: listOf<Person>()) as List<Person>)
                binding.recyclerViewBirthdayList.adapter = adapter
                binding.recyclerViewBirthdayList.layoutManager = LinearLayoutManager(this@BirthdayListActivity)
            }

            override fun handleFault(fault: BackendlessFault?) {
                Log.d("BirthdayList", "handleFault : ${fault?.message}")
            }
        })
    }
}