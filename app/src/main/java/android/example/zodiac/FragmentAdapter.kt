package android.example.zodiac

import android.example.zodiac.fragments.LogInFragment
import android.example.zodiac.fragments.SignUpFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(FragActivity: FragmentActivity): FragmentStateAdapter(FragActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        if(position==0){
            return LogInFragment()
        }
        else{
            return SignUpFragment()
        }
    }
}