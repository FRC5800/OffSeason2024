// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class BasicShoot extends Command {
  private final Shooter shooter;
  private final Timer timer;

  public BasicShoot(Shooter Shooter) {
    this.shooter = Shooter;
    this.timer = new Timer();
    addRequirements(Shooter);
  }

  @Override
  public void initialize() {
    timer.restart();
  }

  @Override
  public void execute() {
    shooter.setMotors(0.8);
  }

  @Override
  public void end(boolean interrupted) {
    shooter.setMotors(0);
  }

  @Override
  public boolean isFinished() {
    return timer.get() >= 2.0;
  }
}
