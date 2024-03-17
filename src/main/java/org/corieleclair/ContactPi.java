package org.corieleclair;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ContactPi {
    public static void UpdateSpeed(String leftSpeed, String rightSpeed) throws IOException {
        Socket socket = new Socket("10.0.0.65", 5001);
        DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
        dOut.writeByte(1);

        // left motor = 0
        // right motor = 1

        // commas to remote coding, i just didnt feel like filtering it on the python side
        dOut.writeUTF(",UD," + leftSpeed + "," + rightSpeed);
        dOut.flush();


        dOut.close();
    }
    public static void DriveForward() throws IOException {
        Socket socket = new Socket("10.0.0.65", 5001);
        DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
        dOut.writeByte(1);

        // commas to remote coding, i just didnt feel like filtering it on the python sid
        dOut.writeUTF(",W");
        dOut.flush(); // Send off the data


        dOut.close();
    }

    public static void DriveReverse() throws IOException {
        Socket socket = new Socket("10.0.0.65", 5001);
        DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
        dOut.writeByte(1);

        // left motor = 0
        // right motor = 1
        // commas to remote coding, i just didnt feel like filtering it on the python side

        dOut.writeUTF(",B");

        dOut.flush(); // Send off the data


        dOut.close();
    }
    public static void DriveLeft() throws IOException {
        Socket socket = new Socket("10.0.0.65", 5001);
        DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
        dOut.writeByte(1);

        // left motor = 0
        // right motor = 1
        // commas to remote coding, i just didnt feel like filtering it on the python side

        dOut.writeUTF(",L");
        dOut.flush(); // Send off the data


        dOut.close();
    }

    public static void DriveRight() throws IOException {
        Socket socket = new Socket("10.0.0.65", 5001);
        DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
        dOut.writeByte(1);

        // left motor = 0
        // right motor = 1
        // commas to remote coding, i just didnt feel like filtering it on the python side

        dOut.writeUTF(",R");
        dOut.flush(); // Send off the data


        dOut.close();
    }

    public static void Stop() throws IOException {
        Socket socket = new Socket("10.0.0.65", 5001);
        DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
        dOut.writeByte(1);

        // left motor = 0
        // right motor = 1
        // commas to remote coding, i just didnt feel like filtering it on the python side

        dOut.writeUTF(",CONTROL");
        dOut.flush(); // Send off the data


        dOut.close();
    }


}
