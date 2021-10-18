package com.example.fragmentdataext

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.fragmentdataext.databinding.ActivityMainBinding
import com.example.fragmentdataext.fragments.Communicator
import com.example.fragmentdataext.fragments.FirstFragment
import com.example.fragmentdataext.fragments.SecondFragment


class MainActivity : AppCompatActivity(), Communicator {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FirstFragment()

        loadFragment(firstFragment)

    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment, fragment)
            addToBackStack(null)
            commit()
        }
    }

    override fun passData(name: String, stack: String, goals: String) {
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("stack", stack)
        bundle.putString("goals", goals )
        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle

        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, secondFragment)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }
}