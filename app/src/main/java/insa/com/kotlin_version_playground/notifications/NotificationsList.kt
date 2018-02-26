package insa.com.kotlin_version_playground.notifications

/**
 * Created by olivi on 2/23/2018.
 */
class NotificationsList {
    var id: Int? = null
    var content: String? = null

    constructor(id: Int, title: String, content: String) {
        this.id = id
        this.content = content
    }
}