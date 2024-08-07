// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Angulation;

public class AutoSlopeTime extends Command {
  private final Angulation angulation;
  private final Timer timer;
  private final double power;
  private final double time;

  public AutoSlopeTime(Angulation Angulation, double power, double time) {
    this.angulation = Angulation;
    this.timer = new Timer();
    this.power = power;
    this.time = time;
    addRequirements(Angulation);
  }

  @Override
  public void initialize() {
    timer.restart();
  }

  @Override
  public void execute() {
    angulation.setMotors(power);
  }

  @Override
  public void end(boolean interrupted) {
    angulation.setMotors(0);
  }

  @Override
  public boolean isFinished() {
    return timer.get() >= time;
  }
}
