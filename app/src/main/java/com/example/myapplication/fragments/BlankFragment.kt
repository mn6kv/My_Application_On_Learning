package com.example.myapplication.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.forRecycler.MusicAdapter
import com.example.myapplication.forRecycler.OnFragmentListener
import com.example.myapplication.models.Music
import com.example.myapplication.repository.MusicRepository
import kotlinx.android.synthetic.main.fragment_blank.*

class BlankFragment : Fragment(), OnFragmentListener {

    private lateinit var mListener: OnFragmentListener
    private var mAdapter: MusicAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter = MusicAdapter(MusicRepository.getMusicList(), ::onItemClicked)
        rv_music_list.adapter = mAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        mAdapter = MusicAdapter(MusicRepository.getMusicList(), ::onItemClicked)
//        rv_music_list.adapter = mAdapter
    }

    private fun onItemClicked(id: Int) {
        mListener.onFragmentListener(id)
    }

    private fun getMusicList(): ArrayList<Music> {
        val list = MusicRepository.getMusicList()
        val author = arguments?.getString("author") ?: "NULL"
        var newList: ArrayList<Music> = ArrayList()
        if (author != "all") {
            list.forEach {
                if (it.author == author)
                    newList.add(it)
            }
        } else newList = list
        return newList
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentListener) {
            mListener = context
        } else {
            throw RuntimeException(context.toString() + "must implement interface")
        }
    }

    companion object {

        private const val ARG_AUTHOR_NAME = "author"

        fun newInstance(
            author: String = "NULL"
        ): BlankFragment = BlankFragment()
    }

    override fun onFragmentListener(music: Int) {
        TODO("Not yet implemented")
    }
}