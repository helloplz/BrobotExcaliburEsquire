package messaging;

public class Message {
  private final int message;
  private final MessageType messageType;
  private final int messageValue;

  private final int MESSAGE_TYPE_BITMASK = 0xF8000000;
  private final int MESSAGE_VALUE_BITMASK = 0x07FFFFFF;

  /**
   * Create a message to be sent.
   * @param messageType
   *   The "type" of message being sent.
   * @param messageValue
   *   The value being posted in the message.
   */
  public Message(MessageType messageType, int messageValue) {
    this.messageType = messageType;
    this.messageValue = messageValue;
    this.message = formulateMessage(messageType, messageValue);
  }

  /**
   * Create a message that was received.
   */
  public Message(int channel, MessageType mt) {
    
  }

  /**
   * The first 5 bits of the integer determine message type, the other 27 bits
   * are for the message.
   * @param mt
   * @param mv
   * @return
   *   Integer representing message type and message value.
   */
  private int formulateMessage(MessageType mt, int mv) {
    int mt_int = mt.ordinal() & (MESSAGE_TYPE_BITMASK >>> 27);
    int mv_int = mv & MESSAGE_VALUE_BITMASK;
    int mt_shift = mt_int << 27;
    return mt_shift + mv_int;
  }

  /**
   * Reads the message type from the first 5 bits of the message.
   * @param m
   * @return
   */
  private MessageType readMessageType(int m) {
    int mt_int = m & MESSAGE_TYPE_BITMASK;
    int mt_shift = mt_int >>> 27;
    return MessageType.values()[mt_shift];
  }

  /**
   * Reads the message value from the last 27 bits of the message.
   * @param m
   * @return
   */
  private int readMessageValue(int m) {
    return m & MESSAGE_VALUE_BITMASK;
  }
}
