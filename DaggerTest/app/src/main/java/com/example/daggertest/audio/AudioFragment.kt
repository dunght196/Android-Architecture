package com.example.daggertest.audio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daggertest.R
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import timber.log.Timber

class AudioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_audio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFirebase()
    }

    fun initFirebase() {
        val storage = Firebase.storage
        val storageRef = storage.reference
        val gsReference = storage.getReferenceFromUrl("gs://demoaudio-2c5f4.appspot.com/audio1/They-Said-Touliver-Binz.mp3")

        storageRef.child("audio1/They-Said-Touliver-Binz.mp3").downloadUrl.addOnSuccessListener {
            Timber.i("Uri: $it")
        }
    }
}