package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.myapplication.BookAdapter
import com.example.myapplication.BookList
import com.example.myapplication.BookVisibilityAdapter
import com.example.myapplication.R
import com.example.myapplication.bookViewPager.VPBookAdapter
import com.example.myapplication.util.ImageList
import kotlinx.android.synthetic.main.book_cardview_visibility.*
import kotlinx.android.synthetic.main.fragment_btm_storage.*
import kotlinx.android.synthetic.main.fragment_btm_visibiliti.*

class BtmFragmentVisibiliti : Fragment() {

    val bookList = BookList.getBooks()
    val imgList = ImageList.getImgs()
    private var adapter: BookVisibilityAdapter? = null
    private var vpAdapter: VPBookAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_btm_visibiliti, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        vpAdapter = VPBookAdapter(imgList)
//        vp_book_cv.adapter = vpAdapter
        adapter = this.context?.let { BookVisibilityAdapter(it, BookList.getBooks(), vpAdapter!!) }
        rv_visibility_book.adapter = adapter
        rv_visibility_book.addItemDecoration(
            DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
        )

//        swipe_storage.setOnRefreshListener {
//            adapter?.updateDataDiffUtils(BookList.getBooks())
//            swipe_storage.isRefreshing = false
//        }
    }
}