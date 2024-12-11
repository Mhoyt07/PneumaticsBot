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
  boolean run_r;
  boolean run_l;
  double scheduler_count;
  public Drivetrain() {
    right_piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.dt.right_for, Constants.dt.right_rev);
    left_piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.dt.left_for, Constants.dt.left_rev);
    count_reset();
    run_r = true;
    run_l = true;
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

  public void cycle_right(int rate) {
    //rate is how many times per minute the piston will make an action
    scheduler_count = 50 / rate;
    if (count % scheduler_count == 0 && run_r == true) {
      right(0);
      run_r = false;
    } else if (count % scheduler_count == 0 && run_r == false) {
      right(1);
      run_r = true;
    }
    count += 1;
  }

  public void cycle_left(int rate) {
    //rate is how many times per minute the piston will make an action
    scheduler_count = 50 / rate;
    if (count % scheduler_count == 0 && run_l == true) {
      right(0);
      run_l = false;
    } else if (count % scheduler_count == 0 && run_l == false) {
      right(1);
      run_l = true;
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
