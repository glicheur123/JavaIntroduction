// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Base;

public class BaseCommand extends CommandBase {
  private DoubleSupplier ax, ay;
  public Base m_base;
  /** Creates a new BaseCommand. */
  public BaseCommand(DoubleSupplier x, DoubleSupplier y, Base base) {
    // Use addRequirements() here to declare subsystem dependencies.
    ax = x;
    ay =y;
    m_base = base;
    addRequirements(m_base);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_base.Drive(ax.getAsDouble(), ay.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_base.Stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
