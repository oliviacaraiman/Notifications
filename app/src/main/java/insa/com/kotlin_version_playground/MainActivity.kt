package insa.com.kotlin_version_playground
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.system.Os.bind
import android.view.MenuItem
import android.widget.FrameLayout

import fragment.FragmentHome
import fragment.FragmentDiscover
import fragment.FragmentPost
import fragment.FragmentNotification
import fragment.FragmentProfile

class MainActivity : AppCompatActivity() {

 private var content: FrameLayout? = null

    private val mOnNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener {

        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.navigation_home -> {

                    val fragment = FragmentHome.Companion.newInstance()
                    addFragment(fragment)

                    return true
                }
                R.id.navigation_discover -> {
                    val fragment = FragmentDiscover()
                    addFragment(fragment)
                    return true
                }
                R.id.navigation_post -> {
                    val fragment = FragmentPost()
                    addFragment(fragment)
                    return true
                }
                R.id.navigation_notification -> {
                    var fragment = FragmentNotification()
                    addFragment(fragment)
                    return true
                }
                R.id.navigation_profile -> {
                    val fragment = FragmentPost()
                    addFragment(fragment)
                    return true
                }
            }
            return false
        }

    }



     /*
      add/replace fragment in container [framelayout]
       */

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
                .addToBackStack(fragment.javaClass.getSimpleName())
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        content = findViewById<FrameLayout>(R.id.content)
        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val fragment = FragmentHome.Companion.newInstance()
        addFragment(fragment)
        // Example of a call to a native method
        //sample_text.text = stringFromJNI()
    }


/*
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }

}
