/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.code_check

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import jp.co.yumemi.android.code_check.TopActivity.Companion.lastSearchDate
import jp.co.yumemi.android.code_check.databinding.FragmentTwoBinding

class TwoFragment : Fragment(R.layout.fragment_two) {

    private val args: TwoFragmentArgs by navArgs()

    private var binding: FragmentTwoBinding? = null
    private val _binding get() = binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("検索した日時", lastSearchDate.toString())

        binding = FragmentTwoBinding.bind(view)

        val item = args.item

        _binding.ownerIconView.load(item.ownerIconUrl)
        _binding.nameView.text = item.name
        _binding.languageView.text =
            context?.getString(R.string.written_language, item.language) ?: context?.getString(R.string.written_in_kotlin)
        _binding.starsView.text = context?.getString(R.string._stars_count, item.stargazersCount)
        _binding.watchersView.text = context?.getString(R.string._watchers_count, item.watchersCount)
        _binding.forksView.text = context?.getString(R.string._forks_count, item.forksCount)
        _binding.openIssuesView.text = context?.getString(R.string._open_issues_count, item.openIssuesCount)
    }
}
