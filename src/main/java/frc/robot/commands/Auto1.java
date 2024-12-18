// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Auto1 extends SequentialCommandGroup {
  /** Creates a new Auto1. */
  public Auto1(Drivetrain dt) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new PistonPeriodic(dt, 5, 5).raceWith(new WaitCommand(30)), 
    new PistonPeriodic(dt, 0, 5).raceWith(new WaitCommand(40)), 
    new PistonPeriodic(dt, 5, 5).raceWith(new WaitCommand(30))
    );
  }
}
