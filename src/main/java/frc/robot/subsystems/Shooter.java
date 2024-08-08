// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private WPI_TalonSRX LeftMotor = new WPI_TalonSRX(Constants.ShooterMotors.Left);
  
  private WPI_VictorSPX RightMotor = new WPI_VictorSPX(Constants.ShooterMotors.Right);

  private Servo servo = new Servo(8);

  public Shooter() {
    RightMotor.follow(LeftMotor);

    LeftMotor.setInverted(false);
    RightMotor.setInverted(true);
  }

  public void setLeftMotor(double speed){
    LeftMotor.set(ControlMode.PercentOutput, speed); }
  
  public void setMotors(double speed){
    setLeftMotor(speed);
  }
  public void setServo(double angle){
    servo.setAngle(angle);
  }
  public double getServo(){
    return servo.getAngle();
  }

}
