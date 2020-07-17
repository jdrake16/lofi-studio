package edu.cnm.deepdive.lofistudio.sequencer;

/**
 * @class Cell This class provides the functionality for delivering different
 *        sounds at different points in the time. This is done using a sequencer
 *        matrix like the one below:
 *
 *        <pre>
 *  -----------------------------------
 * |   |   |   |   |   |   |   |   |   |
 *  -----------------------------------
 * |   |   |   |   |   |   |   |   |   |
 *  -----------------------------------
 *   1   2   3   4   5   6   7   8   9
 * </pre>
 *
 *        Each row is a sample and each column is a beat within a time measure.
 * @author claudio
 */
public class Cell {
  private int value = 0;

  // default constructor
  public Cell() {
    value = 0;

  }

  /**
   * Check if a cell is enabled or disabled.
   *
   * @return true if the cell is enabled.
   */
  public boolean isEnabled() {
    if (value > 0)
      return true;

    return false;
  }

  /**
   * Enable a cell.
   */
  public void enable() {
    value = 1;
  }

  /**
   * Disable a cell.
   */
  public void disable() {
    value = 0;
  }

  /**
   * Set the value of a cell (0 = disable, >0 = enabled).
   *
   * @param v Value to set the cell.
   */
  public void setValue(int v) {
    value = v;
  }

  /**
   * Get the value of a cell (0 = disable, >0 = enabled).
   *
   * @return the value of the cell.
   */
  public int getValue() {
    return value;
  }
}
