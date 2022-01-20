package com.example.testkode.app.pages.list_of_employees

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testkode.R
import com.example.testkode.domain.entities.Employee
import com.google.android.material.imageview.ShapeableImageView

class ListAdapter(
    private val data: MutableList<Employee> = mutableListOf()
) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.employee_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], position)
    }

    override fun getItemCount(): Int = data.size

    private var mClickListener: ((Employee, Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (Employee, Int) -> Unit) {
        mClickListener = listener
    }

    fun setNewData(newData: List<Employee>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            mClickListener?.let { listener ->
                itemView.setOnClickListener {
                    listener.invoke(data[adapterPosition], adapterPosition)
                }
            }
        }


        fun bind(item: Employee, position: Int) {
            val tvName = itemView.findViewById<TextView>(R.id.tv_name)
            val tvDepartment = itemView.findViewById<TextView>(R.id.tv_department)
            val avatar = itemView.findViewById<ShapeableImageView>(R.id.avatarUri)
            tvName.text = item.firstName
            tvDepartment.text = item.department
            Glide
                .with(itemView.context)
                .load(item.avatarUrl)
                .into(avatar)

        }
    }
}
