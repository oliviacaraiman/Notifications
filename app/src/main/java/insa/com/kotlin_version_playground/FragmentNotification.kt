package fragment

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import insa.com.kotlin_version_playground.notifications.FragmentNotificationsFollowing
import insa.com.kotlin_version_playground.notifications.FragmentNotificationsPersonal
import insa.com.kotlin_version_playground.R
import kotlinx.android.synthetic.main.fragment_notification.*

/**
 * Created by chirag on 31/7/17.
 */
class FragmentNotification : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater!!.inflate(R.layout.fragment_notification, container, false)
        Log.d("Notif", "OK!!!!!!!!!!")
        return rootView
    }

    private val mOnNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener {

        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            Log.d("Nav Selected", "OK!!!!!!!!!!")
            when (item.itemId) {
                R.id.navigation_notifications_personal -> {
                    val fragment = FragmentNotificationsPersonal()
                    insertNestedFragment(fragment)
                    return true
                }
                R.id.navigation_notifications_following -> {
                    Log.d("Notif_follow", "OK!!!!!!!!!!")
                    val fragment = FragmentNotificationsFollowing()
                    insertNestedFragment(fragment)
                    return true
                }
            }
            return false
        }


        // Embeds the child fragment dynamically
        private fun insertNestedFragment(fragment: Fragment) {
            val childFragment = fragment
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.content_notifications_personal, childFragment).commit()
        }
    }


    private fun insertNestedFragment() {
        val childFragment = FragmentNotificationsPersonal()
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.content_notifications_personal, childFragment).commit()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        insertNestedFragment()
        val navigation = navigation_notifications
        navigation?.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
