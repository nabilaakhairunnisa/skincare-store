package com.nabila.skincarestore.model

import com.nabila.skincarestore.R
import com.nabila.skincarestore.MainActivity.Companion.context

object DataSource {
    val dummySkincare = listOf(
        Skincare(1, R.drawable.pict1, context.getString(R.string.tittle1), 47000, context.getString(R.string.description1)),
        Skincare(2, R.drawable.pict2, context.getString(R.string.tittle2), 47000, context.getString(R.string.description2)),
        Skincare(3, R.drawable.pict3, context.getString(R.string.tittle3), 36000, context.getString(R.string.description3)),
        Skincare(4, R.drawable.pict4, context.getString(R.string.tittle4), 29000, context.getString(R.string.description4)),
        Skincare(5, R.drawable.pict5, context.getString(R.string.tittle5), 37000, context.getString(R.string.description5)),
        Skincare(6, R.drawable.pict6, context.getString(R.string.tittle6), 37000, context.getString(R.string.description6)),
        Skincare(7, R.drawable.pict7, context.getString(R.string.tittle7), 77000, context.getString(R.string.description7)),
        Skincare(8, R.drawable.pict8, context.getString(R.string.tittle8), 37000, context.getString(R.string.description8)),
        Skincare(9, R.drawable.pict9, context.getString(R.string.tittle9), 47000, context.getString(R.string.description9)),
        Skincare(10, R.drawable.pict10, context.getString(R.string.tittle10), 37000, context.getString(R.string.description10)),
    )
}