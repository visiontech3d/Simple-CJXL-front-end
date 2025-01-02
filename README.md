# Simple-CJXL-front-end
The simplest CJXL front end ever! 

I suppose it is meant for Windows machines, but since it is Java so it might work with other Operating Systems. However delete original file and restore dates function will not be working since they use windows commands. To make it work in linux you can rename your CJXL binary to cjxl.exe, it might work, let me know!

Having thousands of old images I want to convert to JXL using CJXL, I just wanted to use a front end to run the command CJXL.exe. Just a few clicks to convert without any arguments, but for some reason there were none. So here it is, a very simple front end using Java that uses CJXL.exe to convert your library of images into JXL. 

Steps to setup the first time: 
------------------------------
![image](https://github.com/user-attachments/assets/6a87fac0-6173-41b1-bcab-245db2a15ea7)

1. Select folder where CJXL.exe is located
2. Set command argument. These are arguments that will be passed onto the command

And you are done! Start using!

Steps to use:
-------------
3. Select source folder where images you want to convert are located
4. Select target folder where you want the converted JXL files to be stored. If same as source folder then leave empty
5. Select option to:
    - Delete original images after conversion (use with caution)
    - Restore Create and Modified date of source images to converted JXL files
6. Convert away!
