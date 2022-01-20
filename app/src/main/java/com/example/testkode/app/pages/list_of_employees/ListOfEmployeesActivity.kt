package com.example.testkode.app.pages.list_of_employees

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testkode.R
import com.example.testkode.app.pages.profile.ProfileActivity
import com.example.testkode.base.presentation.viewModelFactory
import com.example.testkode.domain.entities.Employee
import com.example.testkode.domain.use_cases.GetEmployeeUseCase
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy


class ListOfEmployeesActivity : AppCompatActivity() {
//    @Inject
   // lateinit var getEmployeeUseCase: GetEmployeeUseCase

    private val viewModel: ListOfEmployeesViewModel by lazy {
        ViewModelProvider(
            this,
            viewModelFactory { ListOfEmployeesViewModel() }
        )[ListOfEmployeesViewModel::class.java]
    }

    lateinit var list: RecyclerView

    lateinit var progress: ProgressBar
    lateinit var vgMain: ViewGroup
    lateinit var vgError: ViewGroup

    private lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_employees_activity)
        val policy = ThreadPolicy.Builder()
            .permitAll().build()
        StrictMode.setThreadPolicy(policy)

        initView()
        initRecycler()
        viewModel.getEmployees()

        viewModel.viewState.observe(this, {
            handleState(it)

        })
    }

    private fun initView() {
        progress = findViewById(R.id.progress)
        vgMain = findViewById(R.id.vg_main)
        vgError = findViewById(R.id.vg_error)
    }

    private fun initRecycler() {
        listAdapter = ListAdapter()
        listAdapter.setOnItemClickListener { item, pos ->
            openEmployeeProfile(item)
        }
        list = findViewById(R.id.rv_list_of_employees)
        list.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(this@ListOfEmployeesActivity)
            setItemViewCacheSize(20)
            setHasFixedSize(true)
        }

    }

    private fun openEmployeeProfile(item: Employee) {
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("firstName", item.firstName)
        intent.putExtra("phone", item.phone)
        intent.putExtra("birthday", item.birthday)
        intent.putExtra("department", item.department)
        startActivity(intent)
    }

    private fun handleState(state: ListOfEmployeeViewState) {
        when {
            state.loading -> {
                vgMain.visibility = View.GONE
                vgError.visibility = View.GONE
                progress.visibility = View.VISIBLE

            }
            state.isSuccess -> {
                listAdapter.setNewData(state.entity!!.data)
                vgMain.visibility = View.VISIBLE
                vgError.visibility = View.GONE
                progress.visibility = View.GONE
            }
            state.errorMessage != null -> {
                vgMain.visibility = View.GONE
                vgError.visibility = View.VISIBLE
                progress.visibility = View.GONE
            }
        }

    }


}