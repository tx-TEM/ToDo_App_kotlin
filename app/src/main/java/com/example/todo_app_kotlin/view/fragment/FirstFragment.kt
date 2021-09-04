package com.example.todo_app_kotlin.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_app_kotlin.ListRecyclerViewAdapter
import com.example.todo_app_kotlin.R
import com.example.todo_app_kotlin.Task
import com.example.todo_app_kotlin.databinding.FragmentFirstBinding
import com.example.todo_app_kotlin.viewModel.FirstViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val viewModel: FirstViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        val view = inflater.inflate(R.layout.fragment_first, container, false)

        // タイトルをセット
        activity?.title = "書籍情報一覧"

        // レイアウト要素RecyclerViewを取得
        val bookListRecyclerView = binding.recyclerView
        // LayoutManagerを取得
        val linearLayoutManager = LinearLayoutManager(view.context)
        // ダミーデータをセットしたアダプターを作成
        val adapter = ListRecyclerViewAdapter(createDummyBookList())

        // linearLayoutManager と adapter をRecyclerViewにセット
        bookListRecyclerView.layoutManager = linearLayoutManager
        bookListRecyclerView.adapter = adapter

        // 一覧画面の各セルの区切り線を作成
        bookListRecyclerView.addItemDecoration(DividerItemDecoration(view.context, linearLayoutManager.orientation))

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // アダプターにセットするためのサンプルデータを作成するメソッド
    private fun createDummyBookList(): MutableList<Task> {
        var bookList: MutableList<Task> = ArrayList()
        var book = Task("Kotlinスタートブック", 2800, "2020/11/24")

        // 20件のサンプルーデータを登録
        var i = 0
        while (i < 20) {
            i++
            bookList.add(book)
        }
        return bookList
    }
}