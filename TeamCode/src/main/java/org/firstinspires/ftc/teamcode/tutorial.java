package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "mussatele_testing")
public class tutorial extends OpMode {

    DcMotor arm_motor;
    DcMotor right_motor;
    DcMotor left_motor;

    @Override
    public void init() {
        arm_motor = (DcMotor) hardwareMap.get("arm_motor");
        right_motor = (DcMotor) hardwareMap.get("right_motor");
        left_motor = (DcMotor) hardwareMap.get("left_motor");
        left_motor.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    @Override
    public void loop() {
        arm_motor.setPower(gamepad1.left_trigger);
        arm_motor.setPower(gamepad1.right_trigger * -1);
        left_motor.setPower(gamepad1.left_stick_y);
        right_motor.setPower(gamepad1.right_stick_y);
    }

}
