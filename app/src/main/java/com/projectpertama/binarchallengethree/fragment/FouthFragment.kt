package com.projectpertama.binarchallengethree.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.projectpertama.binarchallengethree.R

class FouthFragment : Fragment() {

    private lateinit var  etNama : EditText
    private lateinit var  etUmur : EditText
    private lateinit var  etAlamat : EditText
    private lateinit var  etStatus : EditText
    private lateinit var btnNext : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_fourth,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etNama = view.findViewById(R.id.etNama)
        etUmur = view.findViewById(R.id.etUmur)
        etAlamat = view.findViewById(R.id.etTempat)
        etStatus = view.findViewById(R.id.etStatus)
        btnNext = view.findViewById(R.id.btnNext)

        val nama = arguments?.getString("nama")
        val umur = arguments?.getString("umur")
        val alamat = arguments?.getString("alamat")
        val status = arguments?.getString("status")

        etNama.setText(nama)
        etUmur.setText(umur)
        etAlamat.setText(alamat)
        etStatus.setText(status)

        val fragmentManager: FragmentManager = parentFragmentManager

        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        val thirdFragment = ThirdFragment()

        btnNext.setOnClickListener {
            val nama = etNama.text.toString()
            val umur = etUmur.text.toString()
            val alamat = etAlamat.text.toString()
            val status = etStatus.text.toString()

            if(nama.isEmpty() || umur.isEmpty() || alamat.isEmpty() || status.isEmpty()){

                Toast.makeText(requireActivity(),"Isi kolom yang kosong terlebih dahulu",Toast.LENGTH_SHORT).show()

            }else{

                val bundle = Bundle()
                bundle.putString("nama",nama)
                bundle.putString("umur",umur)
                bundle.putString("alamat",alamat)
                bundle.putString("status",status)
                thirdFragment.arguments = bundle

                fragmentTransaction.replace(R.id.container,thirdFragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }




        }
    }
}