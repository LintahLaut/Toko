package com.example.toko

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toko.entity.Pegawai

class FragmentHome : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Proses menghubungkan layout fragment_pegawai.xml dengan fragment ini
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        val adapter : RVHomeAdapter = RVHomeAdapter()

        // Menghubungkan rvPegawai dengan recycler view yang ada pada layout
        val rvHome : RecyclerView = view.findViewById(R.id.rv_home)

        // Set layout Manager dari recycler view
        rvHome.layoutManager = layoutManager

        // tidak mengubah size recycler view jika terdapat item ditambahkan atau dikurangkan
        rvHome.setHasFixedSize(true)

    }
}