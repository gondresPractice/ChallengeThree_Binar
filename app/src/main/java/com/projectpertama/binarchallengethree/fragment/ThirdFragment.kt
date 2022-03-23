package com.projectpertama.binarchallengethree.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.projectpertama.binarchallengethree.R

class ThirdFragment : Fragment() {

    private lateinit var btnNext : Button
    private lateinit var tvNama : TextView
    private lateinit var tvUmur : TextView
    private lateinit var tvAlamat : TextView
    private lateinit var tvStatus : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_third,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnNext = view.findViewById(R.id.btnNext)
        tvNama = view.findViewById(R.id.tvNama)
        tvUmur = view.findViewById(R.id.tvUsia)
        tvAlamat = view.findViewById(R.id.tvAlamat)
        tvStatus = view.findViewById(R.id.tvPekerjaan)


        val nama = arguments?.getString("nama")
        val umur = arguments?.getString("umur")
        val alamat = arguments?.getString("alamat")
        val status = arguments?.getString("status")

        val age = umur?.toInt()


        if (umur == null && alamat == null && status == null){
            tvUmur.setText("Umur belum di input")
            tvAlamat.setText("Alamat belum di input")
            tvStatus.setText("Status belum di input")
            btnNext.setText("Input Data")
        }else if (age != null) {
            if (age %2 == 0){
                tvNama.setText(nama)
                tvUmur.setText("Umur anda $umur yang berarti genap")
                tvAlamat.setText(alamat)
                tvStatus.setText(status)
                btnNext.setText("Ubah Data")
            }else{
                tvNama.setText(nama)
                tvUmur.setText("Umur anda $umur yang berarti ganjil")
                tvAlamat.setText(alamat)
                tvStatus.setText(status)
                btnNext.setText("Ubah Data")
            }
        }
        tvNama.setText(nama)

        btnNext.setOnClickListener {
            val fragmentManager: FragmentManager = parentFragmentManager

            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

            val fouthFragment = FouthFragment()

            val bundle = Bundle()

            bundle.putString("nama",nama)
            bundle.putString("umur",umur)
            bundle.putString("alamat",alamat)
            bundle.putString("status",status)
            fouthFragment.arguments = bundle

            fragmentTransaction.replace(R.id.container,fouthFragment,FouthFragment::class.java.simpleName)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        }
    }
}