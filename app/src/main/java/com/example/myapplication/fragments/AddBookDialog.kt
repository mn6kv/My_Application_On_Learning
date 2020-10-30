package com.example.myapplication.fragments

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.myapplication.R
import kotlinx.android.synthetic.main.dialogue_add_book.view.*

class AddBookDialog : DialogFragment() {

    private var positiveAction: (String, String, kotlin.Int) -> Unit = { _, _, _ -> }
    private var negativeAction: () -> Unit = {}

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = LayoutInflater.from(context).inflate(R.layout.dialogue_add_book, null, false)
        arguments?.getString(ARG_MESSAGE)?.takeIf { it.isNotEmpty() }?.let {
            view.tvAddBookTitle.text = it
            view.tvAddBookTitle.visibility = View.VISIBLE
        }
        view.etBookAuthor.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                onPositiveClick(view)
                dismiss()
                true
            } else false
        }
        return AlertDialog.Builder(requireContext())
            .setPositiveButton(R.string.confirm) { _, _ ->
                Log.e("POSITIVE BUTTON", " CLICKED")
                onPositiveClick(view)
            }
            .setNegativeButton(R.string.cancel) { _, _ ->
                onNegativeClick()
            }
            .setView(view)
            .create()
    }

    private fun onPositiveClick(view: View) {
        positiveAction(view.etBookName.text.toString(), view.etBookAuthor.text.toString(), view.etBookPosition.text.toString().toInt())

//        val bundle = Bundle()
//        val dialogList = ArrayList<String>()
//        dialogList.add(etBookPosition.text.toString())
//        dialogList.add(etBookName.text.toString())
//        dialogList.add(etBookAuthor.text.toString())
//        bundle.putStringArrayList("dialogList", dialogList)


    }

    private fun onNegativeClick() {
        negativeAction()
    }

    companion object {

        private const val ARG_MESSAGE = "arg_message"

        fun show(
            fragmentManager: FragmentManager,
            message: String? = "",
            negativeAction: () -> Unit,
            positiveAction: (String, String, kotlin.Int) -> Unit
        ) = AddBookDialog().apply {
            this.positiveAction = positiveAction
            this.negativeAction = negativeAction
            arguments = Bundle().apply {
                putString(ARG_MESSAGE, message)
            }
            show(fragmentManager, AddBookDialog::class.java.name)
        }
    }
}