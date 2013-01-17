package messaging;

import static org.junit.Assert.*;

import org.junit.Test;

public class MessageTestCase {

  @Test
  public void test() {
    MessageType[] types = MessageType.values();
    for (MessageType type : types) {
      int data = (int) Math.floor(Math.random() * 65536);
      Message m = new Message(type, data);
      int rawMessage = m.getMessage();
      Message m2 = new Message(rawMessage);
      assertEquals(type, m2.getMessageType());
      assertEquals(data, m2.getMessageValue());
    }
  }
}