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

class SecondFragment : Fragment() {

    private lateinit var etName : EditText
    private lateinit var btnNext : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_second,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etName = view.findViewById(R.id.etNama)
        btnNext = view.findViewById(R.id.btnNext)


        btnNext.setOnClickListener {

            val fragmentManager: FragmentManager = parentFragmentManager

            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

            val thirdFragment = ThirdFragment()

            if (etName.text.isEmpty()){
                Toast.makeText(requireActivity(),"Silahkan isi dahulu nama anda",Toast.LENGTH_SHORT).show()
            }else{

                val nama = etName.text.toString()
                val bundle = Bundle()

                bundle.putString("nama",nama)
                thirdFragment.arguments = bundle

                fragmentTransaction.replace(R.id.container,thirdFragment,ThirdFragment::class.java.simpleName)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }



        }
    }
}