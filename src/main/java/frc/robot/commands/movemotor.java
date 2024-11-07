// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix6.signals.RobotEnableValue;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class movemotor extends Command {
  /** Creates a new movemotor. */
  public movemotor() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_motor);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

boolean finish = false;

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_motor.movePos(RobotContainer.m_motor.returnTargetPos()+0.5);
    finish = true;

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finish;
  }
}
