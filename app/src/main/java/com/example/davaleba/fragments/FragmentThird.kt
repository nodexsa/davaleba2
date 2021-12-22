package com.example.davaleba.fragments

import android.app.Activity
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.davaleba.MainActivity
import com.example.davaleba.R
import com.google.android.material.tabs.TabLayout

class FragmentThird: Fragment(R.layout.fragment_third) {
    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var editText: EditText
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.textView)
        button = view.findViewById(R.id.button)
        editText = view.findViewById(R.id.editText)
        val sharedPreferences = this.getActivity()?.getSharedPreferences("pref", 0)
        val notes = sharedPreferences?.getString("NOTES", "")
        textView.text = notes
        button.setOnClickListener {
            val note = textView.text.toString()
            val nnote = editText.text.toString()
            val result = note + "\n" + nnote
            textView.text = result
            sharedPreferences?.edit()
                ?.putString("NOTES", result)
                ?.apply()
        }
    }

}
