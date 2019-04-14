package skybet.main.feed.me.message

class FeedMeDataHeader(var msgId: Int, var operation: String?, var type: String?, var timestamp: Long) {
  fun getMessageId(): Int {
    return msgId;
  }

  fun getOp(): String? {
    return operation;
  }

  fun getTypes(): String? {
    return type;
  }

  fun getTime(): Long {
    return timestamp;
  }
}
