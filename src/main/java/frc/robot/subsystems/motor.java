// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class motor extends SubsystemBase {
  /** Creates a new motor. */
  TalonFX motor = new TalonFX(0);
  final static MotionMagicVoltage m_position = new MotionMagicVoltage(0);
  public motor() {
    TalonFXConfiguration configs = new TalonFXConfiguration();
    var motionMagicConfigs = configs.MotionMagic;
    var slot0Configs = configs.Slot0;

    slot0Configs.kP = 6;
    slot0Configs.kI = 0;
    slot0Configs.kD = 0;
    slot0Configs.kV = 0;
    
    motionMagicConfigs.MotionMagicAcceleration = 100;
    motionMagicConfigs.MotionMagicCruiseVelocity = 70;

    motor.getConfigurator().apply(configs);

    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
