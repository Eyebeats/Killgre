package com.company;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.NetworkChannel;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class CommandManager {



    public String settings = "0";

    public int tyme = 0;

    public String resp = null;

    public boolean isCommand(String cmd, String[] args){

        if (cmd.equalsIgnoreCase("help")){
            exeCMD("Commands available to you:\n\n" +
                    "help\n\n" +
                    "roll\n\n" +
                    "open internet\n\n" +
                    "open text\n\n" +
                    "open zoom\n\n" +
                    "coinflip\n\n" +
                    "settings list\n\n" +

                    "Note: More commands will be available in the future.",null);
            return true;
        }
        else if (cmd.equalsIgnoreCase("roll")){
            SecureRandom rnd = new SecureRandom();
            Integer rand = rnd.nextInt(1000);

            exeCMD("A random number I have chosen from 0-1000 is " + String.valueOf(rand), null);

            return true;
        }
        else if (cmd.equalsIgnoreCase("open internet")){



            File file = new File("C:\\Program Files\\Opera\\launcher.exe");
            File file2 = new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
            File file3 = new File("C:\\Program Files\\internet explorer\\iexplore.exe");


            if (!file.exists() || file2.exists() || file3.exists()){
                // IE sucks so if they both exist open chrome
                try {
                    exeCMD("Opened: chrome", null);
                    Desktop.getDesktop().open(file2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (file.exists() || !file2.exists() || !file3.exists()){
                //open opera
                try {
                    exeCMD("Opened: opera", null);
                    Desktop.getDesktop().open(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (!file.exists() || !file2.exists() || file3.exists()){
                // open IE
                try {
                    exeCMD("Opened: IE", null);
                    Desktop.getDesktop().open(file3);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else if (!file.exists() || !file3.exists() || file2.exists()){
                //open chrome

                try {
                    exeCMD("Opened: chrome", null);
                    Desktop.getDesktop().open(file2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }





            return true;
        }
        else if (cmd.equalsIgnoreCase("open text")){

            File file = new File("C:\\WINDOWS\\system32\\notepad.exe");
            File file2 = new File("C:\\Program Files (x86)\\Notepad++\\notepad++.exe");
            File file3 = new File("C:\\Program Files\\Sublime Text 3\\sublime_text.exe");

            if (file.exists() || !file2.exists() || !file3.exists()){
                // open notepad
                try {
                    exeCMD("Opened: notepad", null);
                    Desktop.getDesktop().open(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (!file.exists() || file2.exists() || !file3.exists()){
                //open opera
                try {
                    exeCMD("Opened: notepad++", null);
                    Desktop.getDesktop().open(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (!file.exists() || !file2.exists() || file3.exists()){
                // open IE
                try {
                    exeCMD("Opened: Sublime text", null);
                    Desktop.getDesktop().open(file3);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }



            return true;
        }
        else if (cmd.equalsIgnoreCase("coinflip")){


            SecureRandom rnd = new SecureRandom();
            Integer rand = rnd.nextInt(101);

            if (rand <= 50){
                exeCMD("Heads", null);
            }
            else if (rand >= 51){
                exeCMD("Tails", null);
            }





            return true;
        }
        else if (cmd.equalsIgnoreCase("rocky")){


            try {
                File file = new File("C:\\Users\\Jarrod\\Desktop\\ez\\Screenshot_1.png");
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }


            exeCMD("Rocky doggy <3", null);



            return true;
        }
        else if (cmd.equalsIgnoreCase("awesome")){



            try {
                File file = new File("C:\\Users\\Jarrod\\Documents\\Curse\\Minecraft\\Instances\\SevTech Ages\\screenshots\\2019-02-24_16.07.40.png");
               if (!file.exists()){
                   exeCMD("Error: file not found", null);
               }
               else {
                   exeCMD("Look at that view!", null);
               }
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }






            return true;
        }
        else if (cmd.equalsIgnoreCase("no")){



            try {
                File file = new File("C:\\Users\\Jarrod\\Desktop\\i9Joaqo.png");
                if (!file.exists()){
                    exeCMD("Error: File not found", null);
                }
                else {
                    exeCMD("NO", null);
                }
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }







            return true;
        }
        else if (cmd.equalsIgnoreCase("open zoom")){



            try {
                File file = new File("C:\\WINDOWS\\system32\\Magnify.exe");
                if (!file.exists()){
                    exeCMD("Error: File not found", null);
                }
                else {
                    exeCMD("Opened: Magnify", null);
                }
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }





            return true;
        }
        else if (cmd.startsWith("settings")){

            if (args[1].equalsIgnoreCase("1")){


                exeCMD("one",null);
            }
            else if (args[1].equalsIgnoreCase("default")){


                exeCMD("zero",null);
            }
            else if (args[1].equalsIgnoreCase("0")){


                exeCMD("zero",null);
            }
            else if (args[1].equalsIgnoreCase("reset")){


                exeCMD("zero",null);
            }
            else if (args[1].equalsIgnoreCase("2")){


                exeCMD("two",null);
            }
            else if (args[1].equalsIgnoreCase("3")){


                exeCMD("three",null);
            }
            else if (args[1].equalsIgnoreCase("random")){


                exeCMD("random",null);
            }
            else if (args[1].equalsIgnoreCase("blue")){


                exeCMD("bluetheme",null);
            }
            else if (args[1].equalsIgnoreCase("green")){


                exeCMD("greentheme",null);
            }
            else if (args[1].equalsIgnoreCase("red")){


                exeCMD("redtheme",null);
            }
            else if (args[1].equalsIgnoreCase("list")){


                exeCMD("listcolors",null);
            }





            return true;
        }
        else if (cmd.startsWith("size")){

            String size = args[1];
            if (size.equalsIgnoreCase("reset")){
                exeCMD("reset-0024",null);
            }
            else {
                exeCMD(size,null);
            }




            return true;
        }
        else {
            return false;
        }

    }

    public void exeCMD(String response, String stuff){


        if (response == null){
            settings = stuff;
        }
        else if (stuff == null){
            resp = response;
        }
        else {
            resp = response;
            settings = stuff;
        }


    }
}
