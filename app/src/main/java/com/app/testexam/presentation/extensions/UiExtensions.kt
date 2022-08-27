package com.app.testexam.presentation.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun Fragment.hideActionBar() = (requireActivity() as AppCompatActivity).supportActionBar?.hide()
fun Fragment.showActionBar() = (requireActivity() as AppCompatActivity).supportActionBar?.show()