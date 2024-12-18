// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Drivetrain.side;

public class PistonPeriodic extends Command {
  /** Creates a new PistonPeriodic. */
  Drivetrain dt;
  int rate_per_minute_r;
  int rate_per_minute_l;

  public PistonPeriodic(Drivetrain dt, int rate_per_minute_r, int rate_per_minute_l) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.dt = dt;
    this.rate_per_minute_r = rate_per_minute_r;
    this.rate_per_minute_l = rate_per_minute_l;
    addRequirements(this.dt);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    dt.count_reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //dt.cycle_right(this.rate_per_minute_r);
    //dt.cycle_left(this.rate_per_minute_l);

    dt.cycle(this.rate_per_minute_l, side.LEFT);
    dt.cycle(this.rate_per_minute_r, side.RIGHT);

    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
