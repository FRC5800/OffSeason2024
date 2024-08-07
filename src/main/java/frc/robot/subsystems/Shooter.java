// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private CANSparkMax LeftMotor = new CANSparkMax(Constants.ShooterMotors.Left , MotorType.kBrushed);
  private CANSparkMax RightMotor = new CANSparkMax(Constants.ShooterMotors.Left , MotorType.kBrushed);

  private Servo servo = new Servo(8);

  public Shooter() {
    LeftMotor.setInverted(false);
    RightMotor.setInverted(true);
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
  public void setServo(double angle){
    servo.setAngle(angle);
  }
  public double getServo(){
    return servo.getAngle();
  }

}
