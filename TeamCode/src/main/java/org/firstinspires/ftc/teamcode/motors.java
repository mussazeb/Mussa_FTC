package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name = "mussatele_testing")
public class motors extends OpMode {


    public Servo axel;
    public Servo axel2;

    public Servo mainaxel;
    DcMotor arm_motor;
    DcMotor right_motor;
    DcMotor left_motor;

    @Override
    public void init() {
        telemetry.addData(
                "Initialization:", "was a huge success"
        );


        arm_motor = (DcMotor) hardwareMap.get("arm_motor");

        right_motor = (DcMotor) hardwareMap.get("right_motor");

        left_motor = (DcMotor) hardwareMap.get("left_motor");
        left_motor.setDirection(DcMotorSimple.Direction.REVERSE);

        axel = (Servo) hardwareMap.get("axel");
        axel2 = (Servo) hardwareMap.get("axel2");
        mainaxel = (Servo) hardwareMap.get("mainaxel");

        telemetry.addData(
                "Hardware:", "successfully Initialized"
        );
    }

    @Override
    public void loop() {
        telemetry.addData(
                "Loop", "has been reached with success"
        );


        arm_motor.setPower(gamepad1.left_trigger);
        arm_motor.setPower(gamepad1.right_trigger * -1);

        if ((gamepad1.left_trigger > 0) ||  (gamepad1.left_trigger < 0)) {
            telemetry.addData(
                    "Arm Forward", "movement has been detected"
            );

        }

        if ((gamepad1.right_trigger > 0) ||  (gamepad1.right_trigger < 0)) {
            telemetry.addData(
                    "Arm Backwards", "movement has been detected"
            );

        }


        left_motor.setPower(gamepad1.left_stick_y);

        if (gamepad1.left_stick_y > 0) {
            telemetry.addData(
                    "Left Motor", "backwards movement has been detected"
            );
        }
        if (gamepad1.left_stick_y < 0) {
            telemetry.addData(
                    "Left Motor", "forward movement has been detected"
            );
        }

        right_motor.setPower(gamepad1.right_stick_y);

        if (gamepad1.right_stick_y > 0) {
            telemetry.addData(
                    "Right Motor", "backwards movement has been detected"
            );
        }
        if (gamepad1.right_stick_y < 0) {
            telemetry.addData(
                    "Right Motor", "forward movement has been detected"
            );
        }

        while (gamepad1.y || gamepad1.x) {
            if (gamepad1.y) {
                axel.setPosition(0.6);
                axel2.setPosition(0.6);
                break;
            }
            else if (gamepad1.x) {
                axel.setPosition(1);
                axel2.setPosition(0.2);
                break;
            }
        }

        while (gamepad1.a || gamepad1.b) {
            if (gamepad1.a) {
                mainaxel.setPosition(0);
                break;
            }
            else if (gamepad1.b) {
                mainaxel.setPosition(1);
                break;
            }
        }
    }

}
