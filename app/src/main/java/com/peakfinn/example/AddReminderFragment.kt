package com.peakfinn.example

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_add_reminder.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AddReminderFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_reminder, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddReminder.setOnClickListener { onSaveClick() }
    }

    private fun onSaveClick() {
        val reminderText = etAddReminder.text.toString()
        if (reminderText.isNotBlank()) {
            setFragmentResult(
                ADD_REMINDER,
                bundleOf(
                    Pair(
                        REMINDER_CONTENT,
                        reminderText
                    )
                )
            )
            findNavController().popBackStack()
        } else {
            Toast.makeText(context, "The reminder cannot be empty", Toast.LENGTH_SHORT).show()
        }
    }
}