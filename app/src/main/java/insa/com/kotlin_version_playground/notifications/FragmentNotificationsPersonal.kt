package insa.com.kotlin_version_playground.notifications

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import insa.com.kotlin_version_playground.R
import kotlinx.android.synthetic.main.fragment_notifications_personal.*

/**
 * Created by olivi on 2/22/2018.
 */
class FragmentNotificationsPersonal: Fragment() {

    private var listNotifications = ArrayList<NotificationsList>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater!!.inflate(R.layout.fragment_notifications_personal, container, false)
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listNotifications.add(NotificationsList(1, "1", "@fasfas liked your post"))
        listNotifications.add(NotificationsList(2, "2", "@dodo commented your post"))
        listNotifications.add(NotificationsList(3, "3", "@lulu liked your post"))
        listNotifications.add(NotificationsList(4, "4", "@lilu started following you"))
        listNotifications.add(NotificationsList(5, "8", "@bibi started following you"))

        var listAdapter = ListAdapter(this, listNotifications)
        lvNotes.adapter = listAdapter
        /*lvNotes.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            Toast.makeText(this.activity, "Click on " + listNotifications[position].title, Toast.LENGTH_SHORT).show()
        }*/

    }

    inner class ListAdapter : BaseAdapter {

        private var notificationsList = ArrayList<NotificationsList>()
        private var context: Context? = null

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

            val view: View?
            val vh: ViewHolder

            if (convertView == null) {
                view = layoutInflater.inflate(R.layout.notifications_personal_list, parent, false)
                vh = ViewHolder(view)
                view?.tag = vh
                Log.i("JSA", "set Tag for ViewHolder, position: " + position)
            } else {
                view = convertView
                vh = view.tag as ViewHolder
            }

           // vh.tvTitle.text = notesList[position].title
            vh.tvContent.text = notificationsList[position].content

            return view
        }

        constructor(context: FragmentNotificationsPersonal, notesList: ArrayList<NotificationsList>) : super() {
            this.notificationsList = notesList
            this.context = context.activity
        }

        override fun getItem(position: Int): Any {
            return notificationsList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return notificationsList.size
        }
    }

    private class ViewHolder(view: View?) {
      //  val tvTitle: TextView
        val tvContent: TextView

        init {

            //this.tvTitle = view?.findViewById<TextView>(R.id.tvTitle) as TextView
            this.tvContent = view?.findViewById<TextView>(R.id.tvContent) as TextView
        }
    }

}