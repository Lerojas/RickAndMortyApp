package com.androidavanzado.rickandmortyapp.presentation.views

import com.androidavanzado.rickandmortyapp.domain.model.Result

interface OnItemClickListener {
    fun onItemClickListener(result : Result)
}