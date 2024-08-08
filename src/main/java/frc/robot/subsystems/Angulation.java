// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Angulation extends SubsystemBase {
  private WPI_TalonSRX AngMotor = new WPI_TalonSRX(Constants.AngulationMotors.Right);

  
  public Angulation() {
    AngMotor.setInverted(true);
  }

  public void setMotor(double speed){
    AngMotor.set(speed);
  }

}
