// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class Wrist extends SubsystemBase {
  /** Creates a new Wrist. */
  TalonFX motor = new TalonFX(Constants.wristMotorPort);
  MotionMagicVoltage mmv = new MotionMagicVoltage(0);
  protected double targetPos = 0;
  public Wrist() {
    var tfx_config = new TalonFXConfiguration();
    var mm_configs = tfx_config.MotionMagic;
    var slot0configs = tfx_config.Slot0;

    slot0configs.kP = 0;
    slot0configs.kI = 0;
    slot0configs.kD = 0;

    mm_configs.MotionMagicAcceleration = 0;
    mm_configs.MotionMagicCruiseVelocity = 0;

    motor.getConfigurator().apply(tfx_config);
  }

  public void moveFeedForward(double pos){
    motor.setControl(mmv.withFeedForward(pos));
  }

  public void movePos(double pos){
    motor.setControl(mmv.withPosition(pos));
  }

  public double returnTargetPos(){
    return targetPos;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
