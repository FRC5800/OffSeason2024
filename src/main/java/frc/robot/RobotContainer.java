// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Auto1;
import frc.robot.commands.AutoSlopeTime;
import frc.robot.commands.BasicShoot;
import frc.robot.commands.Drive;
import frc.robot.commands.Take;
import frc.robot.subsystems.Angulation;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class RobotContainer {
  private final DriveTrain driveTrain = new DriveTrain();
  private final Intake intake = new Intake();
  private final Shooter shooter = new Shooter();
  private final Angulation angulation = new Angulation();

  private final XboxController driverController = new XboxController(OperatorConstants.kDriverControllerPort);
  private final PS4Controller subsystemController= new PS4Controller(OperatorConstants.kSubsystemControllerPort);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {

    driveTrain.setDefaultCommand(new Drive(driveTrain, driverController));

    new JoystickButton(subsystemController, PS4Controller.Button.kCross.value).whileTrue(new Take(intake, true));
    new JoystickButton(subsystemController, PS4Controller.Button.kCircle.value).whileTrue(new Take(intake, false));
    new JoystickButton(subsystemController, PS4Controller.Button.kSquare.value).whileTrue(new BasicShoot(shooter));
   new JoystickButton(subsystemController, PS4Controller.Button.kL1.value).onTrue(new AutoSlopeTime(angulation, 0.8, 1));
    new JoystickButton(subsystemController, PS4Controller.Button.kR1.value).onTrue(new AutoSlopeTime(angulation, -0.8, 1));
  }

  public Command getAutonomousCommand() {
    return null; //new Auto1(driveTrain, shooter);
  }
}
