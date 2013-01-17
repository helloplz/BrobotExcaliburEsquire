package team238;

import team238.exceptions.UnrecognizedRobotTypeException;
import battlecode.common.RobotController;

import team238.behavior.*;

public class RobotPlayer {
  public static void run (RobotController rc) {
    RobotBehavior rb;
    try {
      switch (rc.getType()) {
        case HQ:
          rb = new HQBehavior();
          break;
        case ARTILLERY:
          rb = new ArtilleryBehavior();
          break;
        case GENERATOR:
          rb = new GeneratorBehavior();
          break;
        case MEDBAY:
          rb = new MedbayBehavior();
          break;
        case SHIELDS:
          rb = new ShieldsBehavior();
          break;
        case SOLDIER:
          rb = new SoldierBehavior();
          break;
        case SUPPLIER:
          rb = new SupplierBehavior();
          break;
        default:
          throw new UnrecognizedRobotTypeException();
      }
      while (true) {
        rb.run(rc);
        rc.yield();
      }
    }
    catch (UnrecognizedRobotTypeException e) {
      
    }
  }
}
