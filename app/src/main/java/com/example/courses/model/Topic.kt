package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val topicName: Int,
    val topicDescription: Int,
    @DrawableRes val topicImage: Int
)
