package devandroid.vinicanallesdev.fastcalculation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import devandroid.vinicanallesdev.fastcalculation.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var fragmentResultBinding: FragmentResultBinding
    private lateinit var result: Result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            result = it.getParcelable(Extras.EXTRA_RESULTS) ?: Result()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentResultBinding = FragmentResultBinding.inflate(inflater, container, false)

        fragmentResultBinding.restartBt.setOnClickListener {
            (context as OnPlayGame).onPlayGame()
        }

        "${result.points} ${getString(R.string.pontos)}".also {
            fragmentResultBinding.pointsTv.text = it
        }

        return fragmentResultBinding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(result: Result) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(Extras.EXTRA_RESULTS, result)
                }
            }
    }
}