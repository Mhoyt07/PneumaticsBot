// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  DoubleSolenoid right_piston;
  DoubleSolenoid left_piston;
  DoubleSolenoid.Value value;
  double count;
  boolean run;
  public Drivetrain() {
    right_piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.dt.right_for, Constants.dt.right_rev);
    left_piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.dt.left_for, Constants.dt.left_rev);
    count_reset();
  }

  public void right(double pos) {
    if (pos == 0) {
      value = DoubleSolenoid.Value.kForward;
    } else if (pos == 1) {
      value = DoubleSolenoid.Value.kReverse;
    } else {
      value = DoubleSolenoid.Value.kOff;
    }
    right_piston.set(value);
  }

  public void left(double pos) {
    if (pos == 0) {
      value = DoubleSolenoid.Value.kForward;
    } else if (pos == 1) {
      value = DoubleSolenoid.Value.kReverse;
    } else {
      value = DoubleSolenoid.Value.kOff;
    }
    left_piston.set(value);
  }

  public void cycle_right() {
    if (count % 50 == 0 && run == true) {
      right(0);
      run = false;
    } else if (count % 50 == 0 && run == false) {
      right(1);
      run = true;
    }
    count += 1;
  }

  public void cycle_left() {
    if (count % 50 == 0 && run == true) {
      left(0);
      run = false;
    } else if (count % 50 == 0 && run == false) {
      left(1);
      run = true;
    }
    count += 1;
  }

  public void count_reset() {
    count = 0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
