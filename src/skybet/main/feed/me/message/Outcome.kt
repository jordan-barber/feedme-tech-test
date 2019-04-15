package skybet.main.feed.me.message

class Outcome(feedMeDataHeader: FeedMeDataHeader, marketId: String, var outcomeId: String?, name: String, var price: String?, displayed: Boolean, suspended: Boolean) : Market(feedMeDataHeader, null, marketId, name, displayed, suspended)