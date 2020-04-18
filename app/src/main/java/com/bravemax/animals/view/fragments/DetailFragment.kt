package com.bravemax.animals.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bravemax.animals.R
import com.bravemax.animals.databinding.FragmentDetailBinding
import com.bravemax.animals.model.Animal

class DetailFragment : Fragment() {

    private var animalArg: Animal? = null
    private lateinit var dataBinding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            animalArg = DetailFragmentArgs.fromBundle(it).animalArg
        }
        dataBinding.animal = animalArg
    }
}