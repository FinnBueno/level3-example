package com.peakfinn.example

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Finn Bon on 06/03/2020.
 */
@Parcelize data class Reminder(var reminderText: String) : Parcelable