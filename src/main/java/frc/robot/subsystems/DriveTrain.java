// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private WPI_TalonSRX LeftMaster = new WPI_TalonSRX(1);
  private WPI_TalonSRX RightMaster = new WPI_TalonSRX(2);
  private WPI_VictorSPX LeftSlave = new WPI_VictorSPX(3);
  private WPI_VictorSPX RightSlave = new WPI_VictorSPX(4);

  public DifferentialDrive diffDrive = new DifferentialDrive(LeftMaster, RightMaster); 
  
  public DriveTrain() {
    LeftSlave.follow(LeftMaster);
    RightSlave.follow(RightMaster);

    RightMaster.setInverted(false);
    LeftMaster.setInverted(false);

    RightSlave.setInverted(false);
    LeftSlave.setInverted(false);

    LeftMaster.setNeutralMode(NeutralMode.Brake);
    RightMaster.setNeutralMode(NeutralMode.Brake);
    LeftSlave.setNeutralMode(NeutralMode.Brake);
    RightSlave.setNeutralMode(NeutralMode.Brake);

    
  }

  public void drive(XboxController mainController){
    double Xspeed = 0;
    double Yspeed = 0;

    if (Math.abs(mainController.getRightX()) > 0.2){
      Xspeed = mainController.getRightX()*0.8;
    }
    if (Math.abs(mainController.getLeftY()) > 0.2){
      Yspeed = mainController.getLeftY()*0.8;
    }

    diffDrive.arcadeDrive(Xspeed, Yspeed);    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
