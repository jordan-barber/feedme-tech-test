package skybet.main.feed.me.message

open class Market(feedMeDataHeader: FeedMeDataHeader, eventId: String?, private val marketId: String, name: String, displayed: Boolean, suspended: Boolean) : Event(feedMeDataHeader, eventId, null, null, name, null, displayed, suspended)