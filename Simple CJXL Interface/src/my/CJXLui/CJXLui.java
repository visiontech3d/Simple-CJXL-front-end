/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package my.CJXLui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;


/**
 *
 * @author me
 */
public class CJXLui extends javax.swing.JFrame {

    /* CJXL location */
    public static String CJXL_loc = " ";
    /* CJXL command pre arguments */
    //public static String CJXL_pre = "";
    /* CJXL command post arguments */
    public static String CJXL_post = "";
    /* How many times  button pressed*/
    public int PreButtonPressed = 0;
    public int PostButtonPressed = 0;
    public int TargetButtonPressed = 0;
    
    /* CJXL target folder */
    public static String CJXL_target = "";
    /* CJXL source folder */
    public static String CJXL_source = "";
    
    /**
     * Creates new form CJXLui
     */
    public CJXLui() {
        initComponents();
        
        // Scan INI file for setup information
        try {
            Scanner infile = new Scanner(new File("SimpleCJXLConvert.ini"));
            infile.useDelimiter("\\|\\||\n");   /* This means || or new line as delimeter. Geniuses at Java couldn't even create easy parsing expressions */
            
            /* Read saved CJXL binary location */
            if (infile.next().equals("CJXL_loc")){
                CJXL_loc = infile.next().replace("\n", "").replace("\r", "");   /* Remove carriage returns from scan */
                System.out.println("CJXL_loc is " + CJXL_loc );
            }
            /* Read saved CJXL command pre run argument */
            //if (infile.next().equals("CJXL_pre")){
            //    CJXL_pre = infile.next().replace("\n", "").replace("\r", "");   /* Remove carriage returns from scan */
            //    System.out.println("CJXL_pre is " + CJXL_pre );
            //}
            /* Read saved CJXL command post run argument */
            if (infile.next().equals("CJXL_post")){
                CJXL_post = infile.next().replace("\n", "").replace("\r", "");  /* Remove carriage returns from scan */
                System.out.println("CJXL_post is " + CJXL_post );
            }
            infile.close();
        } catch (IOException e) {
            System.out.println("An error occurred or SimpleCJXLConvert.ini does not exist");
            e.printStackTrace();
        }
        
        //Switch off panel until called on by button press
        jPanel1.setVisible(false);
        
        //Set table column width
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(500);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileChooser_CJXL = new javax.swing.JFileChooser();
        jDialog1 = new javax.swing.JDialog();
        button_cjxlloc = new javax.swing.JButton();
        button_selectFiles = new javax.swing.JButton();
        button_convert = new javax.swing.JButton();
        button_cjxlpost = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        button_selectTarget = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        button_selectall = new javax.swing.JButton();
        button_unselect = new javax.swing.JButton();
        check_delete = new javax.swing.JCheckBox();
        check_restoredates = new javax.swing.JCheckBox();

        jDialog1.setTitle("Alert");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simple CJXL Converter");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        button_cjxlloc.setText("Set CJXL location");
        button_cjxlloc.setToolTipText("Point to where CJXL.exe is located");
        button_cjxlloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cjxllocActionPerformed(evt);
            }
        });

        button_selectFiles.setText("Select Source Folder");
        button_selectFiles.setToolTipText("Select source folder where input images are located.\n\nNote: At the time of this release, files in subfolders are not processed. You will need manually select each subfolders at a time. Maybe a future release would do a recursive subfolder processing.");
        button_selectFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_selectFilesActionPerformed(evt);
            }
        });

        button_convert.setText("Convert!");
        button_convert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_convertActionPerformed(evt);
            }
        });

        button_cjxlpost.setText("Set CJXL arguments");
        button_cjxlpost.setToolTipText("Insert arguments to CJXL.exe here. \n\nAll arguments will be post CJXL command generated by this tool : <cjxl.exe input.jpg output.jxl> <argument>.\n\nExample: argument -q 100\nWill be run as: <cjxl.exe input.jpg output.jxl> -q 100");
        button_cjxlpost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cjxlpostActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setName(""); // NOI18N

        jTextField1.setText("jTextField1");

        jLabel1.setText("Label");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        button_selectTarget.setText("Select Target Folder");
        button_selectTarget.setToolTipText("Select the folder where you want the target JXL to be stored. If same as source folder then leave empty.");
        button_selectTarget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_selectTargetActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Steps 1 - 2 only for one time setup", "", ""},
                {"1. Press Set CJXL Location and locate CJXL.exe", "", ""},
                {"2. Press Set Command Prefix/Postfix if any", "", ""},
                {"Regular Use", "", ""},
                {"1. Press Select Target Folder to place new files", "", ""},
                {"2. Press Select Source Folder to locate images to convert", "", ""},
                {"3. Select images from table", "", ""},
                {"4. Press Convert to convert selected images", "", ""}
            },
            new String [] {
                "File", "Ext", "OK?"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        button_selectall.setText("Select All");
        button_selectall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_selectallActionPerformed(evt);
            }
        });

        button_unselect.setText("DeSelect All");
        button_unselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_unselectActionPerformed(evt);
            }
        });

        check_delete.setText("Delete original files");
        check_delete.setToolTipText("Delete orginal images after conversion to JXL. \n\nWarning: It is a permanent delete, so use with caution!");
        check_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_deleteActionPerformed(evt);
            }
        });

        check_restoredates.setText("Restore file dates");
        check_restoredates.setToolTipText("## Note: Really Slow, disable if you need quick operation ##\nCopy Create and Modified dates from original source images to new JXL files.\n\nNote: It does not copy JPEG, PNG or any metadata dates from images, only Operating System dates ");
        check_restoredates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_restoredatesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_selectall)
                            .addComponent(button_unselect)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_cjxlloc)
                            .addComponent(button_cjxlpost))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(button_selectFiles)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button_selectTarget)
                                .addGap(55, 55, 55)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_convert)
                            .addComponent(check_delete)
                            .addComponent(check_restoredates))))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_cjxlloc)
                    .addComponent(button_convert)
                    .addComponent(button_selectTarget)
                    .addComponent(button_selectFiles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(check_delete)
                        .addGap(5, 5, 5)
                        .addComponent(check_restoredates))
                    .addComponent(button_cjxlpost))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button_selectall)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_unselect)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_cjxllocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cjxllocActionPerformed
        FileChooser_CJXL.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);   // Set to select folder only
        int returnVal = FileChooser_CJXL.showOpenDialog(this); 
        if (returnVal == FileChooser_CJXL.APPROVE_OPTION) {
            File file = FileChooser_CJXL.getSelectedFile();
            // Assign CJXL executable location
            CJXL_loc = file.getAbsolutePath();
            System.out.println("It is: " + CJXL_loc);
            } else {
              System.out.println("File access cancelled by user.");
            }
    }//GEN-LAST:event_button_cjxllocActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        File DelFile = new File("SimpleCJXLConvert.ini");
        DelFile.delete();
        
        try {
            FileWriter myWriter = new FileWriter("SimpleCJXLConvert.ini");
            myWriter.write("CJXL_loc||" + CJXL_loc);
            //myWriter.write(System.getProperty( "line.separator" ) + "CJXL_pre||" + CJXL_pre);
            myWriter.write(System.getProperty( "line.separator" ) + "CJXL_post||" + CJXL_post);
            myWriter.write(System.getProperty( "line.separator" ));
            myWriter.close();
            System.out.println("Successfully wrote to INI file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
       
    }//GEN-LAST:event_formWindowClosing

    private void button_cjxlpostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cjxlpostActionPerformed
        // TODO add your handling code here:
        PreButtonPressed = 0;
        if (PostButtonPressed == 0){
            button_cjxlpost.setText("Save CJXL arguments");
            jLabel1.setText("Post argument");
            jTextField1.setText(CJXL_post);
            jPanel1.setVisible(true);
            PostButtonPressed = PostButtonPressed + 1;
        } else {
            button_cjxlpost.setText("Set CJXL arguments");
            CJXL_post = jTextField1.getText();
            jPanel1.setVisible(false);
            PostButtonPressed = 0;
        }
    }//GEN-LAST:event_button_cjxlpostActionPerformed

    private void button_selectTargetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_selectTargetActionPerformed
        // TODO add your handling code here:
        TargetButtonPressed = TargetButtonPressed + 1;
        FileChooser_CJXL.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);   // Set to select folder only
        int returnVal = FileChooser_CJXL.showOpenDialog(this); 
        if (returnVal == FileChooser_CJXL.APPROVE_OPTION) {
            File file = FileChooser_CJXL.getSelectedFile();
            // Assign CJXL executable location
            CJXL_target = file.getAbsolutePath() + "\\";
            System.out.println("Target is: " + CJXL_target);
            } else {
              System.out.println("File access cancelled by user.");
            }                  
    }//GEN-LAST:event_button_selectTargetActionPerformed

    private void button_selectFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_selectFilesActionPerformed
        // TODO add your handling code here:
        // Get model from jTable1
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        //Reset Table
        model.setRowCount(0); 
        
        FileChooser_CJXL.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);   // Set to select folder only
        int returnVal = FileChooser_CJXL.showOpenDialog(this); 
        if (returnVal == FileChooser_CJXL.APPROVE_OPTION) {
            File file = FileChooser_CJXL.getSelectedFile();
            CJXL_source = file.getAbsolutePath() + "\\";
            //jTable1.add(JCheckbox);
            System.out.println("Target is: " + CJXL_source);
        
            File folder = new File(CJXL_source);
            File[] listOfFiles = folder.listFiles();
            for (File file2 : listOfFiles) {
                if (file2.isFile()) {
                    //Get extension if any
                    int ext_index = file2.getName().lastIndexOf(".");
                    String ext = "";
                    if (ext_index > 0 && file2.getName().substring(ext_index, file2.getName().length()).length() < 6){
                        ext = file2.getName().substring(ext_index, file2.getName().length());
                    }
                    model.addRow(new Object[]{file2.getName(), ext, "", false});
                }
            }
            //Enable table sort 
            jTable1.setAutoCreateRowSorter(true);
        } else {
              System.out.println("File access cancelled by user.");
        }         
        
        //File folder = new File("/Users/you/folder/");
        //File[] listOfFiles = folder.listFiles();

    }//GEN-LAST:event_button_selectFilesActionPerformed

    private void button_convertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_convertActionPerformed
        // Get table model from jTable1
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        //Initialize command
        String command = "\"" + CJXL_loc + "\\cjxl.exe\" " ;
        
        //If no target folder specified use source folder as target folder
        if (TargetButtonPressed == 0) { CJXL_target = CJXL_source ; }   
        
        //Start processing selected items
        //Process only if there is select items
        if (jTable1.getSelectedRowCount() > 0){
            //Loop all selected files in table
            process: for (int x : jTable1.getSelectedRows()){
                //String infile = "" + model.getValueAt(x, NORMAL);    //Input file
                String infile = "" + model.getValueAt(jTable1.convertRowIndexToModel(x), NORMAL); 
                
                //Initialize non standard latin unicode flag
                int is_nonlatin_unicode = 0;
                
                /* Get outfile name */
                //Get location of file extension 
                int extension = infile.lastIndexOf(".");
                System.out.println("Extension :" + extension);
                
                //Replace output file name with *.jxl
                String outfile ;
                if (extension > 0 && infile.substring(extension, infile.length()).length() < 5){       //In case source file has no extension, try to encompass cases like .jpeg , .jpg. Assume is not extension if length after final '.' is more than 5
                    outfile = infile.substring(0, extension) + ".jxl";
                    System.out.println("Outfile is :" + outfile);
                }    
                else {outfile = infile + ".jxl";}
                
                //Return codes for temporary rename target operation 
                int mv_target_return = 1;
                //Return code for delete operation
                int del_target_return = 1;
                //Return code for Convert command 
                int cmd_return = 1;
                
                //Check if target jxl file already exist
                if (!(CJXL_target.equals(CJXL_source) && extension > 0
                        && infile.substring(extension, infile.length()).equals(".jxl"))){
                    //Get full path and file name
                    String full_path = CJXL_target + outfile ;
                    System.out.println("Full path: " + full_path);
                    
                    //Skip file if output already exists
                    Path temp_path = Paths.get(full_path);
                    if (Files.exists(temp_path)) {
                        System.out.println("JXL file exists, skipping : " + full_path);
                        model.setValueAt("Skip", jTable1.convertRowIndexToModel(x), 2);
                        continue ;
                    }
                }
                
                //Temporarily copy input file if name has non standard latin unicode like chinese arabic etc.
                for (int y = 0; y < infile.length(); y++ ){
                    if (!Character.UnicodeBlock.of(infile.charAt(y)).equals(Character.UnicodeBlock.BASIC_LATIN)){
                        System.out.println("Non standard unicode found, copying...");
                        //Rename file and set flag for use when renaming back    
                        is_nonlatin_unicode = 1;
                        
                        //Copy source file
                        Path source = Paths.get(CJXL_source + infile);
                        Path target = Paths.get(CJXL_target + outfile);
                        try {
                            //Delete previous temporary files first stopped because of errors
                            if (Files.exists(source.resolveSibling("nobodywouldnametheirfilethis000555"))) {
                                Files.delete(source.resolveSibling("nobodywouldnametheirfilethis000555"));
                            }
                            if (Files.exists(target.resolveSibling("nobodywouldnametheirfilethis000555.jxl"))) {
                                Files.delete(target.resolveSibling("nobodywouldnametheirfilethis000555.jxl"));
                            }
                            
                            //Copy 
                            Files.copy(source, source.resolveSibling("nobodywouldnametheirfilethis000555"));
                            
                            //Copy source file attributes as well in case need to copy later
                            BasicFileAttributes src_attr = Files.readAttributes(source, BasicFileAttributes.class);
                            Files.setAttribute(source.resolveSibling("nobodywouldnametheirfilethis000555"), "creationTime", src_attr.creationTime());
                            Files.setAttribute(source.resolveSibling("nobodywouldnametheirfilethis000555"), "lastModifiedTime", src_attr.lastModifiedTime());
                            
                            //Temporarily reassign infile and outfile for CJXL and restore dates steps
                            infile = "nobodywouldnametheirfilethis000555";
                            outfile = infile + ".jxl";
                            
                            break ;
                        } catch (IOException ex) {
                            System.out.println("Special unicode file could not be duplicated : " + CJXL_source + infile);
                            model.setValueAt("Fail", jTable1.convertRowIndexToModel(x), 2);
                            continue process;       //Skip to next file in table
                        }
                    } 
                }
                                
                /* Parse final command */
                /* Final command looks like "<CJXL Path>\cjxl.exe <Source path>\Source file.jpg <Target path>\Target file.jxl" */
                String final_command = command + "\"" + CJXL_source + infile 
                        + "\" \"" + CJXL_target + outfile + "\""; 
                if (!CJXL_post.equals("")){ final_command = final_command  + " \"\"" + CJXL_post + "\"\"";} //Add argument at the end 
                System.out.println("Command :" + final_command);
            
                /* Run command */
                //Shamelessly copied from StackOverflow stackoverflow.com/users/48503/luke-woodward
                ProcessBuilder build = new ProcessBuilder(final_command);
                build.redirectErrorStream(true);
                try {
                    Process cmd = build.start();
                    BufferedReader r = new BufferedReader(new InputStreamReader(cmd.getInputStream()));
                
                    //Get command output
                    String line;
                    while (true) {
                        line = r.readLine();
                        if (line == null) { break; }
                        System.out.println(line);
                    }
                
                    try {
                        cmd_return = cmd.waitFor();
                        System.out.println("Cmd return: " + cmd_return);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CJXLui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                                        
                    //Restore create and modified date to new JXL file
                    int attr_exit = 1;  //Get powershell exit value
                    
                    if (check_restoredates.isSelected() == true){   //Run only if restoredate checkbox selected
                        Path source = Paths.get(CJXL_source + infile);
                        Path target = Paths.get(CJXL_target + outfile);
                        
                        BasicFileAttributes src_attr = Files.readAttributes(source, BasicFileAttributes.class);
                        try {
                            
                            Files.setAttribute(target, "creationTime", src_attr.creationTime());
                            Files.setAttribute(target, "lastModifiedTime", src_attr.lastModifiedTime());
                            attr_exit = 0;
                        } catch (IOException ex) {
                            attr_exit = 1;                          //Set flag to fail
                            System.out.println("Cannot restore dates : ");
                            ex.printStackTrace();
                        }
                    } else {
                        attr_exit = 0;
                    }
                    
                    //Rename the file back to their non standard latin unicode
                    if (is_nonlatin_unicode == 1){
                        //Rename back to original file name 
                        infile = "" + model.getValueAt(jTable1.convertRowIndexToModel(x), NORMAL);              //Restore original infile
                        
                        //Rename original outfile same as defined in beginning of function
                        if (extension > 0 && infile.substring(extension, infile.length()).length() < 5){       
                            outfile = infile.substring(0, extension) + ".jxl";
                            System.out.println("Outfile is :" + outfile);
                        }    
                        else {outfile = infile + ".jxl";}
                        
                        System.out.println("Renaming files back: " + infile + " " + outfile);
                        
                        //Rename target file, delete temporary file
                        Path source = Paths.get(CJXL_source + infile);
                        Path target = Paths.get(CJXL_target + outfile);
                        
                        try {
                            //Delete source file if JXL. Otherwise renaming temporary target to itself will fail
                            if (extension > 0 && infile.substring(extension, infile.length()).equals(".jxl")){Files.delete(source);}  
                            
                            Files.move(target.resolveSibling("nobodywouldnametheirfilethis000555.jxl"), target);
                            Files.delete(source.resolveSibling("nobodywouldnametheirfilethis000555"));
                            //Temporarily reassign infile and outfile for CJXL and restore dates steps
                            mv_target_return = 0;
                            
                        } catch (IOException ex) {
                            System.out.println("Special unicode file could not be moved : " + CJXL_target + outfile);
                            mv_target_return = 1;
                            
                        }
                    } else {
                        mv_target_return = 0;
                    }
                                        
                    //Delete original files
                    //Only if CJXL.exe, date attribute set was successful and delete checkbox selected
                    //Added check for JXL file input because otherwise will delete original JXL file
                    if(cmd_return == 0 && attr_exit == 0 && check_delete.isSelected() && mv_target_return == 0
                            && ((extension < 0 || !infile.substring(extension, infile.length()).equals(".jxl")) || (infile.substring(extension, infile.length()).equals(".jxl") && !CJXL_source.equals(CJXL_target)))){     //if file is JXL and target and source not the same folder
                        
                        Path source = Paths.get(CJXL_source + model.getValueAt(jTable1.convertRowIndexToModel(x), NORMAL));
                        try {
                            
                            System.out.println("Deleting original file");
                            Files.delete(source);
                            del_target_return = 0;
                            
                        }catch (IOException e){
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                                del_target_return = 1;
                            }
                        
                    } else {
                        del_target_return = 0;
                    }
                    
                    //Get return value and update table of success
                    if (cmd_return == 0 && attr_exit == 0 && del_target_return == 0
                            && (is_nonlatin_unicode == 0 || (is_nonlatin_unicode == 1 && mv_target_return == 0))){
                        model.setValueAt("OK", jTable1.convertRowIndexToModel(x), 2);
                    }else {
                        model.setValueAt("Fail", jTable1.convertRowIndexToModel(x), 2);
                    }
                } catch (IOException e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        }else {     //If no selected items stop and show dialog
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "No files selected from box", "Alert", JOptionPane.WARNING_MESSAGE);  
        }
    }//GEN-LAST:event_button_convertActionPerformed

    private void button_selectallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_selectallActionPerformed
        // TODO add your handling code here:
        jTable1.selectAll();
    }//GEN-LAST:event_button_selectallActionPerformed

    private void button_unselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_unselectActionPerformed
        // TODO add your handling code here:
        jTable1.clearSelection();
    }//GEN-LAST:event_button_unselectActionPerformed

    private void check_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_deleteActionPerformed
        // TODO add your handling code here:
        if(check_delete.isSelected()){
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Original files will be deleted! No further warnings will be issued!", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_check_deleteActionPerformed

    private void check_restoredatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_restoredatesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check_restoredatesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CJXLui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CJXLui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CJXLui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CJXLui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CJXLui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser FileChooser_CJXL;
    private javax.swing.JButton button_cjxlloc;
    private javax.swing.JButton button_cjxlpost;
    private javax.swing.JButton button_convert;
    private javax.swing.JButton button_selectFiles;
    private javax.swing.JButton button_selectTarget;
    private javax.swing.JButton button_selectall;
    private javax.swing.JButton button_unselect;
    private javax.swing.JCheckBox check_delete;
    private javax.swing.JCheckBox check_restoredates;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
