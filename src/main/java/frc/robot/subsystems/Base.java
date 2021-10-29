// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Base extends SubsystemBase {
  private DifferentialDrive m_base;
  private Talon left1, right1, left2, right2;
  private SpeedControllerGroup left, right;
  /** Creates a new Base. */
  public Base() {

    left1 = new Talon(Constants.FrontLeftBaseMotor);
    left2 = new Talon(Constants.RearLeftBaseMotor);

    right1 = new Talon(Constants.FrontRightBaseMotor);
    right2 = new Talon(Constants.RearRightBaseMotor);

    left = new SpeedControllerGroup(left1, left2);
    right = new SpeedControllerGroup(right1, right2);

    m_base = new DifferentialDrive(left, right);
  }

  public void Drive(Double X, Double Y){
    m_base.arcadeDrive(X,Y);
  }

  public void Stop(){
    m_base.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
