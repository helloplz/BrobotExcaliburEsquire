package messaging;

public enum MessageType {
  // Requests from HQ to soldiers:
  // Mines
  DEFUSE_MINE,
  LAY_MINE,
  // Encampments
  BUILD_MEDBAY,
  BUILD_SHIELDS,
  BUILD_ARTILLERY,
  BUILD_GENERATOR,
  BUILD_SUPPLIER,
  // Movement/attacking
  MOVE_TO
}
