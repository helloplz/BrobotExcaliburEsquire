package team238;

import battlecode.common.RobotController;

//Charlie likes penis a lot 
import behavior.RobotBehavior;

public class RobotPlayer {
  public static void run (RobotController rc) {
    RobotBehavior rb;
    switch (rc.getType()) {
      case HQ:
        rb = new HQBehavior();
        break;
      case ARTILLERY:
        break;
      case GENERATOR:
        break;
      case MEDBAY:
        break;
      case SHIELDS:
        break;
      case SOLDIER:
        break;
      case SUPPLIER:
        break;
      default:
        throw new RuntimeException("Unrecognized robot type.");
    }
    while (true) {
      rb.run(rc);
      rc.yield();
    }
  }
}
