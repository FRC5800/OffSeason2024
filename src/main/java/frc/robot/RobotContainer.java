// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Drive;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;


public class RobotContainer {
  private final DriveTrain driveTrain = new DriveTrain();

  private final XboxController driverController = new XboxController(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {

    driveTrain.setDefaultCommand(new Drive(driveTrain, driverController));

  }

  public Command getAutonomousCommand() {
    return null;
  }
}
