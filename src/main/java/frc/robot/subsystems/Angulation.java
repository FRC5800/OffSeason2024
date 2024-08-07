// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Angulation extends SubsystemBase {
  private WPI_VictorSPX LeftMotor = new WPI_VictorSPX(Constants.AngulationMotors.Left);
  private WPI_VictorSPX RightMotor = new WPI_VictorSPX(Constants.AngulationMotors.Right);

  
  public Angulation() {
    LeftMotor.setInverted(false);
    RightMotor.setInverted(true);
    
    LeftMotor.setNeutralMode(NeutralMode.Brake);
    RightMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void setLeftMotor(double speed){
    LeftMotor.set(speed);
  }
  public void setRightMotor(double speed){
    RightMotor.set(speed);
  }
  public void setMotors(double speed){
    setLeftMotor(speed);
    setRightMotor(speed);
  }

}
