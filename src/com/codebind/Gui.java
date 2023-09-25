package com.codebind;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

class Person implements Serializable {
    protected String name;
    protected int id;
    protected String password;

    Person(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public Person(int id , String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return name + " " + id + " " + password;
    }

}
class Admin extends Person implements Serializable {
    private boolean found = false;

    public Admin(String adminusername, int adminID, String adminpass) {
        super(adminusername, adminID, adminpass);
    }

}
class new_doctors extends Person implements Serializable {
    private String specilist, appoint, doc_qual;
    private int droom;
    private boolean occ;

    public new_doctors(String dname, int did, String docPass, String specilist, String appoint, String doc_qual, int droom, boolean occ) {
        super(dname, did, docPass);
        this.specilist = specilist;
        this.appoint = appoint;
        this.doc_qual = doc_qual;
        this.droom = droom;
        this.occ = occ;
    }

    public String getSpecilist() {
        return specilist;
    }

    public void setSpecilist(String specilist) {
        this.specilist = specilist;
    }

    public String getAppoint() {
        return appoint;
    }

    public void setAppoint(String appoint) {
        this.appoint = appoint;
    }

    public String getDoc_qual() {
        return doc_qual;
    }

    public void setDoc_qual(String doc_qual) {
        this.doc_qual = doc_qual;
    }

    public int getDroom() {
        return droom;
    }

    public void setDroom(int droom) {
        this.droom = droom;
    }

    public boolean isOcc() {
        return occ;
    }

    public void setOcc(boolean occ) {
        this.occ = occ;
    }


    public String toString() {
        return (super.toString() + specilist + "\t" + appoint + "\t" + doc_qual + "\t" + droom);
    }

}
class new_patients extends Person implements Serializable  {
    private String bg, patpass;
    private int phone, pp;
    private boolean app;
    //private ArrayList<new_appointments> appointments;

    public new_patients(String pname, int pid, String patpass, String bg, int phone, boolean app, int pp) {
        super(pname, pid, patpass);
        this.bg = bg;
        this.phone = phone;
        this.app = app;
        this.pp = pp;
    }

    public new_patients(int patientId, String patientName) {
        super(patientId , patientName);
    }

    public void setPatPass(String patpass) {
        this.patpass = patpass;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public boolean isApp() {
        return app;
    }

    public void setApp(boolean app) {
        this.app = app;
    }
    /* public void addAppointment(File appointmentFile, File doctorFile, ArrayList<new_doctors> dal, Scanner input) throws IOException ,ClassNotFoundException {
             // Get appointment details
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(doctorFile));
             dal = (ArrayList<new_doctors>) ois.readObject();
             ois.close();
             ArrayList<String> availableDoctorNames = new ArrayList<>();
             for (new_doctors doctor : dal) {
                 if (!doctor.isOcc()) {
                     System.out.println(doctor);
                     availableDoctorNames.add(doctor.getName());
                 }
             }
             System.out.println("\n--------------------------------------------------");
             int patientID = getId();
             int appointNo = appointments.size() + 1;
             String patientName = getName();
             System.out.println("Select a doctor (by name):");
             String doctorName = input.next();
             while (!availableDoctorNames.contains(doctorName)) {
                 System.out.println("Invalid doctor name. Please try again:");
                 doctorName = input.next();
             }
             System.out.println("Enter the time:");
             int time = input.nextInt();
             System.out.println("Enter the date:");
             String date = input.next();
             boolean confirm = false;
             String appStatus = "Awaiting";

             // Create new appointment and add it to the list
             new_doctors selectedDoctor = null;
             for (new_doctors doctor : dal) {
                 if (doctor.getName().equals(doctorName)) {
                     selectedDoctor = doctor;
                     break;
                 }
             }
             if (selectedDoctor != null) {
                 new_appointments appointment = new new_appointments(appointNo, this, selectedDoctor, time, date, confirm, appStatus);
                 appointments.add(appointment);

                 // Save the updated appointment list
                 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(appointmentFile));
                 oos.writeObject(appointments);
                 oos.close();

                 System.out.println("Appointment added successfully.");
                 System.out.println("Wait for admin to confirm the appointment.");
                 System.out.println("Appointment No: " + appointNo);
             } else {
                 System.out.println("Error: Selected doctor not found.");
             }
     }*/
    public String toString() {
        return (super.toString() + "\t" + "\t" + bg + "\t" + "\t" + phone);
    }
}
class new_appointments implements Serializable {
    private int appointNo;
    private int patientId;
    private String patientName;
    private new_doctors Doctor;
    private String doctorName;
    private new_patients Patient;

    private String Time;
    private String Date;
    private boolean confirm;
    private String appStatus;

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public int getAppointNo() {
        return appointNo;
    }

    public void setAppointNo(int appointNo) {
        this.appointNo = appointNo;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public new_patients getPatient() {
        return Patient;
    }

    public void setPatient(new_patients patient) {
        Patient = patient;
    }

    public new_doctors getDoctor() {
        return Doctor;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setDoctor(new_doctors doctor) {
        Doctor = doctor;
    }

    public new_appointments(int appointNo, int patientId, String patientName, String Doctor, String Time, String Date, boolean confirm, String appStatus) {
        this.appointNo = appointNo;
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorName = Doctor;
        this.Patient = new new_patients(patientId, patientName);
        this.Time = Time;
        this.Date = Date;
        this.confirm = confirm;
        this.appStatus = appStatus;
    }

    public String toString() {
        return appointNo + "\t" + patientId + "\t" + patientName + "\t" + Doctor.getName() + "\t" + Time + "\t" + Date + "\t" + appStatus;
    }
}
class new_prescription implements Serializable {
    int preNo, condition, appointNo;
    String Patientname, Doctorname, medicine, ward, roomno, preStatus;

    public int getPreNo() {
        return preNo;
    }

    public void setPreNo(int preNo) {
        this.preNo = preNo;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getAppointNo() {
        return appointNo;
    }

    public void setAppointNo(int appointNo) {
        this.appointNo = appointNo;
    }

    public String getPatientname() {
        return Patientname;
    }

    public void setPatientname(String patientname) {
        Patientname = patientname;
    }

    public String getDoctorname() {
        return Doctorname;
    }

    public void setDoctorname(String doctorname) {
        Doctorname = doctorname;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(String preStatus) {
        this.preStatus = preStatus;
    }

    public new_prescription(int preNo, int appointNo, String Patientname, String Doctorname, String medicine, int condition, String ward, String roomno, String preStatus) {
        this.preNo = preNo;
        this.appointNo = appointNo;
        this.Patientname = Patientname;
        this.Doctorname = Doctorname;
        this.medicine = medicine;
        this.condition = condition;
        this.ward = ward;
        this.roomno = roomno;
        this.preStatus = preStatus;
    }

    public String toString() {
        return preNo + "\t\t" + appointNo + "\t\t" + Patientname + "\t\t" + Doctorname + "\t" + medicine + "\t\t" + condition + "\t" + ward + "\t" + roomno + "\t" + preStatus;
    }
}
class Ward implements Serializable {
    private new_prescription prescription;
    private String wardType;

    public Ward(new_prescription prescription, String wardType) {
        this.prescription = prescription;
        this.wardType = wardType;
    }

    public new_prescription getPrescription() {
        return prescription;
    }

    public String getWardType() {
        return wardType;
    }
    public String toString() {
        return getPrescription().getPatientname();
    }
}




public class Gui extends JFrame {
    private JPanel welcomePanel;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private JButton adminPanelButton;
    private JButton doctorPanelButton;
    private JButton patientPanelButton;
    private JPanel adminMainMenuPanel;
    private JPanel patientPanel;

    private final String adminUsername = "admin";
    private String adminPass;
    int loggedInPatientId = -1;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    Admin admin = new Admin(adminUsername , 1 , "admin");
    File doctorFile = new File("doctorsFile.txt");
    File adminFile = new File("adminFile.txt");
    File patientFile = new File("patientsFile.txt");
    File appointmentFile = new File("appointments.txt");
    File prescriptionFile = new File("prescriptionFile.txt");
    ArrayList<new_doctors> doctorsArrayList = new ArrayList<>();
    ArrayList<new_patients> patientsArrayList = new ArrayList<>();
    ArrayList<new_appointments> appointmentArrayList = new ArrayList<>();
    ArrayList<new_prescription> prescriptionsArrayList = new ArrayList<>();
    ArrayList<Ward> wards = new ArrayList<>();



    public Gui() {

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        welcomePanel = new JPanel();
        welcomePanel.setLayout(new GridBagLayout());


        // Create a title label and set its properties
        JLabel titleLabel = new JLabel("Welcome to the HMS");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Create a panel for the buttons and center-align it
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        adminPanelButton = new JButton("Admin Panel");
        doctorPanelButton = new JButton("Doctor Panel");
        patientPanelButton = new JButton("Patient Panel");
        buttonPanel.add(adminPanelButton);
        buttonPanel.add(doctorPanelButton);
        buttonPanel.add(patientPanelButton);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;
        welcomePanel.add(titleLabel, constraints);

        constraints.gridy = 1;
        constraints.insets = new Insets(10, 0, 0, 0);
        welcomePanel.add(buttonPanel, constraints);

        cardPanel.add(welcomePanel, "welcome");

        setContentPane(cardPanel);
        setTitle("Hospital Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        doctorsArrayList = (ArrayList<new_doctors>) loadFromFile("doctorFile");
        patientsArrayList = (ArrayList<new_patients>) loadFromFile("patientFile");
        appointmentArrayList = (ArrayList<new_appointments>) loadFromFile("appointmentFile");
        prescriptionsArrayList = (ArrayList<new_prescription>) loadFromFile("prescriptionFile");
        wards = populateWardsList(prescriptionsArrayList);
        for (Ward ward: wards) {
            System.out.println(ward);
        }


        adminPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdminPanel();
            }
        });
        doctorPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDoctorPanel();
            }
        });

        patientPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPatientPanel();
            }
        });
    }

    private void showAdminPanel() {
        JPanel adminPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton loginButton = new JButton("Login");
        JButton updatePasswordButton = new JButton("Update Password");
        JButton backButton = new JButton("Back");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredId = JOptionPane.showInputDialog("Enter Admin ID:");
                String enteredPassword = JOptionPane.showInputDialog("Enter Admin Password:");

                if (enteredId.equals(admin.name) && enteredPassword.equals(admin.password)) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    // Perform additional logic for successful login here
                    showAdminMainMenu();

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid ID or Password");
                    // Perform logic for invalid login here, such as displaying an error message
                }

                // Perform login logic here
            }
        });

        updatePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = JOptionPane.showInputDialog("Enter username:");
                String newPassword = JOptionPane.showInputDialog("Enter new password:");

                // Perform password update logic here
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminPanel.setVisible(false);
                getContentPane().removeAll();
                getContentPane().add(welcomePanel);
                revalidate();
                repaint();
            }
        });

        adminPanel.add(loginButton);
        adminPanel.add(updatePasswordButton);
        adminPanel.add(backButton);

        cardPanel.add(adminPanel, "admin");
        cardLayout.show(cardPanel, "admin");
    }
    private void showDoctorPanel() {
        JPanel doctorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton loginButton = new JButton("Login");
        JButton updatePasswordButton = new JButton("Update Password");
        JButton backButton = new JButton("Back");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int username = Integer.parseInt(JOptionPane.showInputDialog("Enter doctor username:"));
                String password = JOptionPane.showInputDialog("Enter doctor password:");

                // Perform doctor login logic here
                new_doctors loggedInDoctor = null; // Placeholder variable for the logged-in doctor

                // Iterate through the doctorsArrayList to find the matching doctor based on username and password
                for (new_doctors doctor : doctorsArrayList) {
                    if (doctor.getId() == (username) && doctor.getPassword().equals(password)) {
                        loggedInDoctor = doctor;
                        break;
                    }
                }

                if (loggedInDoctor != null) {
                    doctorPanel.setVisible(false);
                    showDoctorMainMenu(loggedInDoctor);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
                }
            }
        });

        updatePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = JOptionPane.showInputDialog("Enter username:");
                String newPassword = JOptionPane.showInputDialog("Enter new password:");

                // Perform password update logic for doctor panel here
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "welcome");
            }
        });

        doctorPanel.add(loginButton);
        doctorPanel.add(updatePasswordButton);
        doctorPanel.add(backButton);

        cardPanel.add(doctorPanel, "doctor");
        cardLayout.show(cardPanel, "doctor");
    }
    private void showPatientPanel() {
        patientPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        patientPanel.setVisible(true);
        patientsArrayList = (ArrayList<new_patients>) loadFromFile("patientFile");
        JButton loginButton = new JButton("Login");
        JButton updatePasswordButton = new JButton("Update Password");
        JButton backButton = new JButton("Back");

        /*loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int username = Integer.parseInt(JOptionPane.showInputDialog("Enter username:"));
                String password = JOptionPane.showInputDialog("Enter password:");

                boolean loggedIn = false;
                for (new_patients patient : patientsArrayList) {
                    if (patient.getId() == username && patient.getPassword().equals(password)) {
                        loggedIn = true;
                        // Perform logic for logged in patient here
                        break;
                    }
                }

                if (loggedIn) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    // Perform actions for logged in patient


                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });*/
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int username = Integer.parseInt(JOptionPane.showInputDialog("Enter username:"));
                String password = JOptionPane.showInputDialog("Enter password:");


                boolean loggedIn = false;
                for (new_patients patient : patientsArrayList) {
                    if (patient.getId() == (username) && patient.getPassword().equals(password)) {
                        loggedIn = true;
                        loggedInPatientId = patient.getId();

                        // Perform logic for logged in patient here
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        showPatientMainMenu(patient);
                    }
                }
                /*for (new_patients patient : patientsArrayList) {
                    if (patient.getId() == (username) && patient.getPassword().equals(password)) {
                        loggedIn = true;
                        loggedInPatientId = patient.getId();

                        // Perform logic for logged in patient here
                        JOptionPane.showMessageDialog(null, "Login Successful");

                        // Create buttons for the logged-in patient
                        JButton viewProfileButton = new JButton("View Profile");
                        JButton updateProfileButton = new JButton("Update Profile");
                        JButton createAppointmentsButton = new JButton("Create Appointments");
                        JButton viewAppointmentsButton = new JButton("View Appointments");
                        JButton viewPrescriptionButton = new JButton("View Prescription");

                        // Add action listeners to the buttons (implement desired logic)
                        viewProfileButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Logic for viewing profile
                            }
                        });

                        updateProfileButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Logic for updating profile
                            }
                        });

                        createAppointmentsButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Logic for creating appointments
                            }
                        });

                        viewAppointmentsButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Logic for viewing appointments
                            }
                        });

                        viewPrescriptionButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Logic for viewing prescription
                            }
                        });

                        // Add the buttons to the patientPanel
                        patientPanel.add(viewProfileButton);
                        patientPanel.add(updateProfileButton);
                        patientPanel.add(createAppointmentsButton);
                        patientPanel.add(viewAppointmentsButton);
                        patientPanel.add(viewPrescriptionButton);

                        // Repaint the patientPanel to update the UI
                        patientPanel.revalidate();
                        patientPanel.repaint();

                        break;
                    }
                }*/

                if (!loggedIn) {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        updatePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = JOptionPane.showInputDialog("Enter username:");
                String newPassword = JOptionPane.showInputDialog("Enter new password:");

                // Perform password update logic for patient panel here
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                patientPanel.setVisible(false);
                cardLayout.show(cardPanel, "welcome");

            }
        });

        patientPanel.add(loginButton);
        patientPanel.add(updatePasswordButton);
        patientPanel.add(backButton);

        // Add the patient panel to the parent panel
        cardPanel.add(patientPanel, "patient");

        // Show the patient panel
        cardLayout.show(cardPanel, "patient");


    }
    private void showAdminMainMenu() {
        adminMainMenuPanel = new JPanel(new GridLayout(5, 1, 10, 10));


        JLabel titleLabel = new JLabel("Welcome to the Admin Panel", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        adminMainMenuPanel.add(titleLabel);

        JButton doctorsButton = new JButton("Doctors");
        JButton patientsButton = new JButton("Patients");
        JButton wardsButton = new JButton("Wards");
        JButton backButton = new JButton("Back");

        doctorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logic for doctors option here
                showDoctorSection();
            }
        });

        patientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logic for patients option here
                showPatientSection();
            }
        });

        wardsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logic for wards option here
                showWardsSection();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminMainMenuPanel.setVisible(false);
                showAdminPanel(); // Show the admin panel again
            }
        });

        adminMainMenuPanel.add(doctorsButton);
        adminMainMenuPanel.add(patientsButton);
        adminMainMenuPanel.add(wardsButton);
        adminMainMenuPanel.add(backButton);

        getContentPane().removeAll();
        getContentPane().add(adminMainMenuPanel);
        revalidate();
        repaint();
    }
    private void showPatientMainMenu(new_patients loggedInPatient) {
        JPanel patientMainMenuPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        JLabel titleLabel = new JLabel("Patient Main Menu", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        patientMainMenuPanel.add(titleLabel);

        JButton viewProfileButton = new JButton("View Profile");
        JButton updateProfileButton = new JButton("Update Profile");
        JButton createAppointmentsButton = new JButton("Create Appointments");
        JButton viewAppointmentsButton = new JButton("View Appointments");
        JButton viewPrescriptionButton = new JButton("View Prescription");
        JButton backButton = new JButton("Back to Patient Panel");

        // Add action listeners to the buttons (implement desired logic)
        /*viewProfileButton.addActionListener(e -> viewProfile());
        updateProfileButton.addActionListener(e -> updateProfile());
        createAppointmentsButton.addActionListener(e -> createAppointments());
        viewAppointmentsButton.addActionListener(e -> viewAppointments());
        viewPrescriptionButton.addActionListener(e -> viewPrescription());*/
        viewProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPatientProfile(patientsArrayList , loggedInPatientId);
            }
        });
        updateProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProfile(patientsArrayList , loggedInPatientId);
            }
        });

        createAppointmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAppointment(appointmentArrayList , doctorsArrayList , loggedInPatient);
            }
        });
        viewAppointmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAppointments(loggedInPatient , appointmentArrayList);
            }
        });
        viewPrescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPatientPrescriptions(loggedInPatient);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "patient");
                patientMainMenuPanel.setVisible(false);
                showPatientPanel();
            }
        }); // Navigate back to the patient panel


        // Add components to the panel
        patientMainMenuPanel.add(viewProfileButton);
        patientMainMenuPanel.add(updateProfileButton);
        patientMainMenuPanel.add(createAppointmentsButton);
        patientMainMenuPanel.add(viewAppointmentsButton);
        patientMainMenuPanel.add(viewPrescriptionButton);
        patientMainMenuPanel.add(backButton);

        // Hide the patientPanel and show the patientMainMenuPanel
        patientPanel.setVisible(false);
        patientMainMenuPanel.setVisible(true);

        // Add the patientMainMenuPanel to the cardPanel and switch to it
        cardPanel.add(patientMainMenuPanel, "patientMainMenu");
        cardLayout.show(cardPanel, "patientMainMenu");
    }
    private void showDoctorMainMenu(new_doctors loggedInDoctor) {
        JPanel doctorMainMenuPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        JLabel titleLabel = new JLabel("Doctor Main Menu", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton viewProfileButton = new JButton("View Profile");
        JButton updateProfileButton = new JButton("Update Profile");
        JButton viewAppointmentsButton = new JButton("View Appointments");
        JButton viewPrescriptionsButton = new JButton("View Prescriptions");
        JButton backButton = new JButton("Back");

        viewProfileButton.addActionListener(e -> viewDoctorProfile(loggedInDoctor));
        updateProfileButton.addActionListener(e -> updateDoctorProfile(loggedInDoctor));
        viewAppointmentsButton.addActionListener(e -> viewDoctorAppointments(loggedInDoctor));
        viewPrescriptionsButton.addActionListener(e -> viewDoctorPrescriptions(loggedInDoctor , prescriptionsArrayList));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "welcome");
            }
        });

        doctorMainMenuPanel.add(titleLabel);
        doctorMainMenuPanel.add(viewProfileButton);
        doctorMainMenuPanel.add(updateProfileButton);
        doctorMainMenuPanel.add(viewAppointmentsButton);
        doctorMainMenuPanel.add(viewPrescriptionsButton);
        doctorMainMenuPanel.add(backButton);

        cardPanel.add(doctorMainMenuPanel, "doctorMainMenu");
        cardLayout.show(cardPanel, "doctorMainMenu");
    }
    private void showDoctorSection() {
        JPanel doctorSectionPanel = new JPanel(new GridLayout(9, 1, 10, 10));

        JLabel titleLabel = new JLabel("DOCTOR SECTION", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        doctorSectionPanel.add(titleLabel);

        JButton newDoctorButton = new JButton("Enter New Doctor");
        JButton displayDoctorsButton = new JButton("Display Doctors");
        JButton searchDoctorButton = new JButton("Search");
        JButton deleteDoctorButton = new JButton("Delete");
        JButton editDoctorButton = new JButton("Edit");
        JButton viewAvailableDoctorsButton = new JButton("View Available Doctors");
        JButton viewPrescriptionsButton = new JButton("View Prescriptions");
        JButton backButton = new JButton("Back");

        newDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logic for entering a new doctor here
                addDoctor(doctorsArrayList);
            }
        });

        displayDoctorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logic for displaying doctors here
                displayDoctors();
            }
        });

        searchDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Prompt the user to enter the name of the doctor to search
                String name = JOptionPane.showInputDialog(null, "Enter the name of the doctor to search:", "Search Doctor", JOptionPane.PLAIN_MESSAGE);

                // Call the searchDoctor method
                searchDoctor(doctorsArrayList, name);
            }
        });

        deleteDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logic for deleting a doctor here
                deleteDoctor(doctorsArrayList);
            }
        });

        editDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logic for editing a doctor here
                editDoctor(doctorsArrayList);
            }
        });

        viewAvailableDoctorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logic for viewing available doctors here
                displayAvailableDoctors(doctorsArrayList);
            }
        });

        viewPrescriptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logic for viewing prescriptions here
                viewPrescriptions();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doctorSectionPanel.setVisible(false);
                showAdminMainMenu();
            }
        });

        doctorSectionPanel.add(newDoctorButton);
        doctorSectionPanel.add(displayDoctorsButton);
        doctorSectionPanel.add(searchDoctorButton);
        doctorSectionPanel.add(deleteDoctorButton);
        doctorSectionPanel.add(editDoctorButton);
        doctorSectionPanel.add(viewAvailableDoctorsButton);
        doctorSectionPanel.add(viewPrescriptionsButton);
        doctorSectionPanel.add(backButton);
        getContentPane().removeAll();
        getContentPane().add(doctorSectionPanel);
        revalidate();
        repaint();
    }
    private void showPatientSection() {
        JFrame frame = new JFrame("Patient Section");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        JPanel patientSectionPanel = new JPanel(new GridLayout(9, 1, 10, 10));
        JLabel titleLabel = new JLabel("Patient SECTION", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        patientSectionPanel.add(titleLabel);

        JButton newPatientButton = new JButton("Enter New Patient");
        JButton displayPatientsButton = new JButton("Display Patients");
        JButton searchPatientButton = new JButton("Search Patient");
        JButton deletePatientButton = new JButton("Delete Patient");
        JButton editPatientButton = new JButton("Edit Patient");
        JButton viewAwaitingAppointmentsButton = new JButton("View Awaiting Appointments");
        JButton viewAllAppointmentsButton = new JButton("View All Appointments");
        JButton backButton = new JButton("Back to Menu");

        // Add components to the panel
        patientSectionPanel.add(newPatientButton);
        patientSectionPanel.add(displayPatientsButton);
        patientSectionPanel.add(searchPatientButton);
        patientSectionPanel.add(deletePatientButton);
        patientSectionPanel.add(editPatientButton);
        patientSectionPanel.add(viewAwaitingAppointmentsButton);
        patientSectionPanel.add(viewAllAppointmentsButton);
        patientSectionPanel.add(backButton);

        // Add action listeners to the buttons
        newPatientButton.addActionListener(e -> addPatient(patientsArrayList));
        displayPatientsButton.addActionListener(e -> displayPatients());
        searchPatientButton.addActionListener(e -> searchPatient(patientsArrayList));
        deletePatientButton.addActionListener(e -> deletePatient(patientsArrayList));
        editPatientButton.addActionListener(e -> editPatient(patientsArrayList));
        viewAwaitingAppointmentsButton.addActionListener(e -> viewAwaitingAppointments(appointmentArrayList));
        viewAllAppointmentsButton.addActionListener(e -> viewAllAppointments(appointmentArrayList));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdminMainMenu();
                patientSectionPanel.setVisible(false);
                Window dialog = SwingUtilities.windowForComponent(patientSectionPanel);
                if (dialog != null) {
                    dialog.dispose();
                }
            }
        });

        // Add the panel to the frame
        frame.getContentPane().add(patientSectionPanel);

        // Set the frame visible
        frame.setVisible(true);
    }
    /*private void showWardsSection() {
        // Create the ward section panel
        JPanel wardSectionPanel = new JPanel();
        wardSectionPanel.setLayout(new BorderLayout());

        // Create the buttons for Surgical Ward and General Ward
        JButton surgicalWardButton = new JButton("Surgical Ward");
        JButton generalWardButton = new JButton("General Ward");

        // Create the table model for the ward tables
        DefaultTableModel wardTableModel = new DefaultTableModel();
        wardTableModel.addColumn("Prescription No");
        wardTableModel.addColumn("Patient Name");
        wardTableModel.addColumn("Doctor Name");
        wardTableModel.addColumn("Condition");

        // Create the tables for Surgical Ward and General Ward
        JTable surgicalWardTable = new JTable(wardTableModel);
        JTable generalWardTable = new JTable(wardTableModel);

        // Create the scroll panes for the tables
        JScrollPane surgicalWardScrollPane = new JScrollPane(surgicalWardTable);
        JScrollPane generalWardScrollPane = new JScrollPane(generalWardTable);

        // Add the scroll panes to the ward section panel
        wardSectionPanel.add(surgicalWardScrollPane, BorderLayout.CENTER);

        // ActionListener for Surgical Ward button
        surgicalWardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the table model
                wardTableModel.setRowCount(0);

                // Populate the table with patients in Surgical Ward
                for (Ward ward : wards) {
                    if (ward.getWardType().equals("Surgical Ward")) {
                        Object[] rowData = {
                                ward.getPrescription().getPreNo(),
                                ward.getPrescription().getPatientname(),
                                ward.getPrescription().getDoctorname(),
                                ward.getPrescription().getCondition()
                        };
                        wardTableModel.addRow(rowData);
                    }
                }
            }
        });

        // ActionListener for General Ward button (similar logic as Surgical Ward button)
        generalWardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wardTableModel.setRowCount(0);
                for (Ward ward : wards) {
                    if (ward.getWardType().equals("General Ward")) {
                        Object[] rowData = {
                                ward.getPrescription().getPreNo(),
                                ward.getPrescription().getPatientname(),
                                ward.getPrescription().getDoctorname(),
                                ward.getPrescription().getCondition()
                        };
                        wardTableModel.addRow(rowData);
                    }
                }
            }
        });

        // Add the buttons to the ward section panel
        wardSectionPanel.add(surgicalWardButton, BorderLayout.NORTH);
        wardSectionPanel.add(generalWardButton, BorderLayout.SOUTH);

        // Add the ward section panel to the main admin menu panel
        adminMainMenuPanel.add(wardSectionPanel, "ward");
    }*/
    /*private void showWardsSection() {
        // Create the ward section panel
        JPanel wardSectionPanel = new JPanel();
        wardSectionPanel.setLayout(new BorderLayout());

        // Create the buttons for Surgical Ward and General Ward
        JButton surgicalWardButton = new JButton("Surgical Ward");
        JButton generalWardButton = new JButton("General Ward");

        // Create the table model for the ward tables
        DefaultTableModel wardTableModel = new DefaultTableModel();
        wardTableModel.addColumn("Prescription No");
        wardTableModel.addColumn("Patient Name");
        wardTableModel.addColumn("Doctor Name");
        wardTableModel.addColumn("Condition");

        // Create the tables for Surgical Ward and General Ward
        JTable surgicalWardTable = new JTable(wardTableModel);
        JTable generalWardTable = new JTable(wardTableModel);

        // Create the scroll panes for the tables
        JScrollPane surgicalWardScrollPane = new JScrollPane(surgicalWardTable);
        JScrollPane generalWardScrollPane = new JScrollPane(generalWardTable);

        // Add the scroll panes to the ward section panel
        wardSectionPanel.add(surgicalWardScrollPane, BorderLayout.CENTER);

        // ActionListener for Surgical Ward button
        surgicalWardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the table model
                wardTableModel.setRowCount(0);

                // Populate the table with patients in Surgical Ward
                for (Ward ward : wards) {
                    if (ward.getWardType().equals("Surgical Ward")) {
                        Object[] rowData = {
                                ward.getPrescription().getPreNo(),
                                ward.getPrescription().getPatientname(),
                                ward.getPrescription().getDoctorname(),
                                ward.getPrescription().getCondition()
                        };
                        wardTableModel.addRow(rowData);
                    }
                }
            }
        });

        // ActionListener for General Ward button (similar logic as Surgical Ward button)
        generalWardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wardTableModel.setRowCount(0);
                for (Ward ward : wards) {
                    if (ward.getWardType().equals("General Ward")) {
                        Object[] rowData = {
                                ward.getPrescription().getPreNo(),
                                ward.getPrescription().getPatientname(),
                                ward.getPrescription().getDoctorname(),
                                ward.getPrescription().getCondition()
                        };
                        wardTableModel.addRow(rowData);
                    }
                }
            }
        });

        // Add the buttons to the ward section panel
        wardSectionPanel.add(surgicalWardButton, BorderLayout.NORTH);
        wardSectionPanel.add(generalWardButton, BorderLayout.SOUTH);

        // Remove existing components from the adminMainMenuPanel
        adminMainMenuPanel.removeAll();

        // Add the ward section panel to the main admin menu panel
        adminMainMenuPanel.add(wardSectionPanel);

        // Revalidate and repaint the adminMainMenuPanel to update the UI
        adminMainMenuPanel.revalidate();
        adminMainMenuPanel.repaint();
    }*/
    private void showWardsSection() {
        // Create the ward dialog
        JDialog wardDialog = new JDialog();
        wardDialog.setTitle("Ward Section");
        wardDialog.setSize(400, 300);
        wardDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Create the buttons for Surgical Ward and General Ward
        JButton surgicalWardButton = new JButton("Surgical Ward");
        JButton generalWardButton = new JButton("General Ward");
        JButton backButton = new JButton("Back");

        // Add action listener to the surgicalWardButton
        surgicalWardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showWardTable("Surgical");
            }
        });

        // Add action listener to the generalWardButton
        generalWardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showWardTable("General");
            }
        });

        // Add action listener to the backButton
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wardDialog.dispose();
            }
        });

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(surgicalWardButton);
        buttonPanel.add(generalWardButton);
        buttonPanel.add(backButton);

        // Set the layout for the ward dialog
        wardDialog.setLayout(new BorderLayout());

        // Add the button panel to the ward dialog
        wardDialog.add(buttonPanel, BorderLayout.CENTER);

        // Make the ward dialog visible
        wardDialog.setVisible(true);
    }

    private void showWardTable(String wardType) {
        // Create the ward table dialog

        JDialog wardTableDialog = new JDialog();
        wardTableDialog.setTitle(wardType + " Ward Patients");
        wardTableDialog.setSize(500, 400);
        wardTableDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Create the table model for the ward table
        DefaultTableModel wardTableModel = new DefaultTableModel();
        wardTableModel.addColumn("Prescription No");
        wardTableModel.addColumn("Patient Name");
        wardTableModel.addColumn("Doctor Name");
        wardTableModel.addColumn("Condition");

        // Create the table for the ward patients
        JTable wardTable = new JTable(wardTableModel);

        // Populate the table with patients in the specified ward
        for (Ward ward : wards) {
            if (ward.getWardType().equalsIgnoreCase(wardType)) {
                Object[] rowData = {
                        ward.getPrescription().getPreNo(),
                        ward.getPrescription().getPatientname(),
                        ward.getPrescription().getDoctorname(),
                        ward.getPrescription().getCondition()
                };
                wardTableModel.addRow(rowData);
            }
        }

        // Create a scroll pane for the ward table
        JScrollPane wardScrollPane = new JScrollPane(wardTable);

        // Set the layout for the ward table dialog
        wardTableDialog.setLayout(new BorderLayout());

        // Add the ward table to the ward table dialog
        wardTableDialog.add(wardScrollPane, BorderLayout.CENTER);

        // Make the ward table dialog visible
        wardTableDialog.setVisible(true);
    }


    private void addDoctor(ArrayList<new_doctors> doctorsArrayList) {
        String dname = JOptionPane.showInputDialog(null, "Enter Doctor's Name:");
        String specilist = JOptionPane.showInputDialog(null, "Enter Doctor's Specialization:");
        String appoint = JOptionPane.showInputDialog(null, "Enter Doctor's Work Time:");
        String doc_qual = JOptionPane.showInputDialog(null, "Enter Doctor's Qualification:");
        int droom = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Doctor's Room Number:"));
        String docPass = JOptionPane.showInputDialog(null, "Enter Doctor's Password:");

        // Generate a unique ID for the doctor
        int doctorID = generateUniqueDoctorID(doctorsArrayList);

        new_doctors doctor = new new_doctors(dname, doctorID, docPass, specilist, appoint, doc_qual, droom, false);
        // Add the doctor to the appropriate data structure or perform desired operations
        doctorsArrayList.add(doctor);
        // (e.g., add to an ArrayList or store in a database)
        saveToFile("doctorFile", doctorsArrayList);

        //JOptionPane.showMessageDialog(null, "Doctor added successfully.");
    }
    private int generateUniqueDoctorID(ArrayList<new_doctors> doctorsArrayList) {
        int maxID = 0;
        for (new_doctors doctor : doctorsArrayList) {
            if (doctor.getId() > maxID) {
                maxID = doctor.getId();
            }
        }
        return maxID + 1;
    }
    // Method to search for doctors by name and display the results in a JTable
    public void searchDoctor(ArrayList<new_doctors> doctorList, String name) {
        //doctorsArrayList = (ArrayList<new_doctors>) loadFromFile("doctorFile");
        // Create a new ArrayList to store the search results
        ArrayList<new_doctors> searchResults = new ArrayList<>();

        // Search for doctors with matching name
        for (new_doctors doctor : doctorList) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                searchResults.add(doctor);
            }
        }

        // Check if any search results were found
        if (searchResults.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No doctors found with the name: " + name, "Search Results", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Create a two-dimensional array to hold the data for the table
            Object[][] tableData = new Object[searchResults.size()][6]; // Assuming 6 fields in new_doctors class

            // Fill the table data from the search results
            for (int i = 0; i < searchResults.size(); i++) {
                new_doctors doctor = searchResults.get(i);
                tableData[i][0] = doctor.getName();
                tableData[i][1] = doctor.getId();
                tableData[i][2] = doctor.getSpecilist();
                tableData[i][3] = doctor.getAppoint();
                tableData[i][4] = doctor.getDoc_qual();
                tableData[i][5] = doctor.getDroom();
            }

            // Create an array of column names for the table
            String[] columnNames = {"Name", "ID", "Specialization", "Work Time", "Qualification", "Room No."};

            // Create a new JTable with the table data and column names
            JTable table = new JTable(tableData, columnNames);

            // Create a scroll pane to hold the table
            JScrollPane scrollPane = new JScrollPane(table);

            // Create a new JFrame to display the table
            JFrame frame = new JFrame("Search Results - Doctors");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(scrollPane);
            frame.pack();
            frame.setVisible(true);
        }
    }
    private void editDoctor(ArrayList<new_doctors> doctorsArrayList) {
        int doctorID = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the ID of the doctor to edit:"));

        // Find the doctor with the specified ID
        new_doctors doctorToEdit = null;
        for (new_doctors doctor : doctorsArrayList) {
            if (doctor.getId() == doctorID) {
                doctorToEdit = doctor;
                break;
            }
        }

        if (doctorToEdit == null) {
            JOptionPane.showMessageDialog(null, "No doctor found with the specified ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Ask for the new values of the doctor's fields
        String dname = JOptionPane.showInputDialog(null, "Enter Doctor's Name:", doctorToEdit.getName());
        String specilist = JOptionPane.showInputDialog(null, "Enter Doctor's Specialization:", doctorToEdit.getSpecilist());
        String appoint = JOptionPane.showInputDialog(null, "Enter Doctor's Work Time:", doctorToEdit.getAppoint());
        String doc_qual = JOptionPane.showInputDialog(null, "Enter Doctor's Qualification:", doctorToEdit.getDoc_qual());
        int droom = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Doctor's Room Number:", doctorToEdit.getDroom()));
        String docPass = JOptionPane.showInputDialog(null, "Enter Doctor's Password:", doctorToEdit.getPassword());

        // Update the doctor's fields
        doctorToEdit.setName(dname);
        doctorToEdit.setSpecilist(specilist);
        doctorToEdit.setAppoint(appoint);
        doctorToEdit.setDoc_qual(doc_qual);
        doctorToEdit.setDroom(droom);
        doctorToEdit.setPassword(docPass);

        // Save the updated ArrayList to the file
        saveToFile("doctorFile", doctorsArrayList);

        JOptionPane.showMessageDialog(null, "Doctor details updated successfully.");
    }
    private void deleteDoctor(ArrayList<new_doctors> doctorsArrayList) {
        int doctorID = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the ID of the doctor to delete:"));

        // Find the index of the doctor with the specified ID
        int doctorIndex = -1;
        for (int i = 0; i < doctorsArrayList.size(); i++) {
            if (doctorsArrayList.get(i).getId() == doctorID) {
                doctorIndex = i;
                break;
            }
        }

        if (doctorIndex == -1) {
            JOptionPane.showMessageDialog(null, "No doctor found with the specified ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Remove the doctor from the ArrayList
        doctorsArrayList.remove(doctorIndex);

        // Save the updated ArrayList to the file
        saveToFile("doctorFile", doctorsArrayList);

        JOptionPane.showMessageDialog(null, "Doctor deleted successfully.");
    }
    private void displayDoctors() {
        doctorsArrayList = (ArrayList<new_doctors>) loadFromFile("doctorFile");
        String[] columnNames = {"Name", "ID", "Password", "Specialization", "Work Time", "Qualification", "Room No."};
        Object[][] rowData = new Object[doctorsArrayList.size()][columnNames.length];

        for (int i = 0; i < doctorsArrayList.size(); i++) {
            new_doctors doctor = doctorsArrayList.get(i);
            rowData[i][0] = doctor.getName();
            rowData[i][1] = doctor.getId();
            rowData[i][2] = doctor.getPassword();
            rowData[i][3] = doctor.getSpecilist();
            rowData[i][4] = doctor.getAppoint();
            rowData[i][5] = doctor.getDoc_qual();
            rowData[i][6] = doctor.getDroom();
        }

        JTable doctorsTable = new JTable(rowData, columnNames);
        doctorsTable.setEnabled(false); // Make the table read-only

        JScrollPane scrollPane = new JScrollPane(doctorsTable);
        scrollPane.setPreferredSize(new Dimension(500, 300));

        JOptionPane.showMessageDialog(null, scrollPane, "Doctors", JOptionPane.PLAIN_MESSAGE);
    }
    private void displayAvailableDoctors(ArrayList<new_doctors> doctorsArrayList) {
        // Prepare the table data
        Object[][] tableData = new Object[doctorsArrayList.size()][6];
        String[] columnNames = {"ID", "Name", "Specialization", "Work Time", "Qualification", "Room No."};
        int rowIndex = 0;

        for (new_doctors doctor : doctorsArrayList) {
            if (!doctor.isOcc()) {
                tableData[rowIndex][0] = doctor.getId();
                tableData[rowIndex][1] = doctor.getName();
                tableData[rowIndex][2] = doctor.getSpecilist();
                tableData[rowIndex][3] = doctor.getAppoint();
                tableData[rowIndex][4] = doctor.getDoc_qual();
                tableData[rowIndex][5] = doctor.getDroom();
                rowIndex++;
            }
        }

        // Create the table model
        DefaultTableModel tableModel = new DefaultTableModel(tableData, columnNames);

        // Create the JTable with the table model
        JTable doctorTable = new JTable(tableModel);

        // Display the table in a scrollable pane
        JScrollPane scrollPane = new JScrollPane(doctorTable);
        JOptionPane.showMessageDialog(null, scrollPane, "Available Doctors", JOptionPane.INFORMATION_MESSAGE);
    }
    private void addPatient(ArrayList<new_patients> patientsArrayList) {
        String pname = JOptionPane.showInputDialog(null, "Enter Patient's Name:");
        int pid = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Patient's ID:"));
        String patpass = JOptionPane.showInputDialog(null, "Enter Patient's Password:");
        String bg = JOptionPane.showInputDialog(null, "Enter Patient's Blood Group:");
        int phone = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Patient's Phone Number:"));
        boolean app = Boolean.parseBoolean(JOptionPane.showInputDialog(null, "Enter Patient's Appointment Status (true/false):"));
        int pp = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Patient's Previous Prescription:"));

        new_patients patient = new new_patients(pname, pid, patpass, bg, phone, app, pp);
        patientsArrayList.add(patient);
        saveToFile("patientFile", patientsArrayList);

        JOptionPane.showMessageDialog(null, "Patient added successfully.");
    }
    private void editPatient(ArrayList<new_patients> patientsArrayList) {
        int pid = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Patient's ID to edit:"));

        for (new_patients patient : patientsArrayList) {
            if (patient.getId() == pid) {
                String pname = JOptionPane.showInputDialog(null, "Enter Patient's Name:");
                String patpass = JOptionPane.showInputDialog(null, "Enter Patient's Password:");
                String bg = JOptionPane.showInputDialog(null, "Enter Patient's Blood Group:");
                int phone = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Patient's Phone Number:"));
                boolean app = Boolean.parseBoolean(JOptionPane.showInputDialog(null, "Enter Patient's Appointment Status (true/false):"));
                int pp = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Patient's Previous Prescription:"));

                patient.setName(pname);
                patient.setPatPass(patpass);
                patient.setBg(bg);
                patient.setPhone(phone);
                patient.setApp(app);
                patient.setPp(pp);

                saveToFile("patientFile", patientsArrayList);
                JOptionPane.showMessageDialog(null, "Patient edited successfully.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No patient found with the specified ID.");
    }
    private void deletePatient(ArrayList<new_patients> patientsArrayList) {
        int pid = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Patient's ID to delete:"));

        for (new_patients patient : patientsArrayList) {
            if (patient.getId() == pid) {
                patientsArrayList.remove(patient);
                saveToFile("patientFile", patientsArrayList);
                JOptionPane.showMessageDialog(null, "Patient deleted successfully.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No patient found with the specified ID.");
    }
    private void searchPatient(ArrayList<new_patients> patientsArrayList) {
        int pid = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Patient's ID to search:"));
        boolean found = false;

        // Create table model and column names
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Blood Group");
        tableModel.addColumn("Phone");
        tableModel.addColumn("Appointment");
        tableModel.addColumn("Previous Prescription");

        // Populate table model with search results
        for (new_patients patient : patientsArrayList) {
            if (patient.getId() == pid) {
                Object[] rowData = {
                        patient.getId(),
                        patient.getName(),
                        patient.getBg(),
                        patient.getPhone(),
                        patient.isApp(),
                        patient.getPp()
                };
                tableModel.addRow(rowData);
                found = true;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "No patient found with the specified ID.");
            return;
        }

        // Create and display table
        JTable table = new JTable(tableModel);
        JOptionPane.showMessageDialog(null, table);
    }
    private void displayPatients() {
        patientsArrayList = (ArrayList<new_patients>) loadFromFile("patientFile");
        // Create a JFrame to display the table
        JFrame frame = new JFrame("Patient Records");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create the table model with column names and data
        String[] columnNames = {"ID", "Name", "Blood Group", "Phone", "Appointment", "PP"};
        Object[][] rowData = new Object[patientsArrayList.size()][columnNames.length];
        for (int i = 0; i < patientsArrayList.size(); i++) {
            new_patients patient = patientsArrayList.get(i);
            rowData[i][0] = patient.getId();
            rowData[i][1] = patient.getName();
            rowData[i][2] = patient.getBg();
            rowData[i][3] = patient.getPhone();
            rowData[i][4] = patient.isApp();
            rowData[i][5] = patient.getPp();
        }

        // Create the JTable and set the data
        JTable table = new JTable(rowData, columnNames);

        // Set table properties
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.getContentPane().add(scrollPane);

        // Set the frame size and make it visible
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private void viewAwaitingAppointments(ArrayList<new_appointments> appointmentsArrayList) {
        // Filter the appointmentsArrayList to get only the pending appointments
        ArrayList<new_appointments> pendingAppointments = new ArrayList<>();
        for (new_appointments appointment : appointmentsArrayList) {
            if (appointment.getAppStatus().equalsIgnoreCase("Pending")) {
                pendingAppointments.add(appointment);
            }
        }

        // Create a table model to hold the pending appointment data
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        // Add columns to the table
        model.addColumn("Appointment No");
        model.addColumn("Doctor Name");
        model.addColumn("Time");
        model.addColumn("Date");
        model.addColumn("Status");

        // Add the pending appointments to the table
        for (new_appointments appointment : pendingAppointments) {
            model.addRow(new Object[]{
                    appointment.getAppointNo(),
                    appointment.getDoctorName(),
                    appointment.getTime(),
                    appointment.getDate(),
                    appointment.getAppStatus()
            });
        }

        // Create a scroll pane to hold the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a dialog to display the table
        JDialog dialog = new JDialog();
        dialog.setTitle("Pending Appointments");
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.add(scrollPane);
        dialog.pack();
        dialog.setVisible(true);

        // Prompt the user to select an appointment to confirm
        String input = JOptionPane.showInputDialog("Enter the appointment number to confirm:");

        // Check if the user entered a valid appointment number
        if (input != null) {
            int appointmentNo = Integer.parseInt(input);

            // Find the appointment in the pendingAppointments list
            new_appointments selectedAppointment = null;
            for (new_appointments appointment : pendingAppointments) {
                if (appointment.getAppointNo() == appointmentNo) {
                    selectedAppointment = appointment;
                    break;
                }
            }

            // Check if a valid appointment was found
            if (selectedAppointment != null) {
                // Update the appointment status to confirmed
                selectedAppointment.setAppStatus("Confirmed");

                // Display a confirmation message
                JOptionPane.showMessageDialog(null, "Appointment confirmed!");

                // Save the updated appointment list to the file
                saveToFile("appointmentFile", appointmentsArrayList);
            } else {
                // Display an error message if the appointment number is invalid
                JOptionPane.showMessageDialog(null, "Invalid appointment number!");
            }
        }


    }
    private void viewAllAppointments(ArrayList<new_appointments> appointmentsArrayList) {
        // Create a table model to hold the appointment data
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        // Add columns to the table
        model.addColumn("Appointment No");
        model.addColumn("Doctor Name");
        model.addColumn("Time");
        model.addColumn("Date");
        model.addColumn("Status");

        // Add the appointments to the table
        for (new_appointments appointment : appointmentsArrayList) {
            model.addRow(new Object[]{
                    appointment.getAppointNo(),
                    appointment.getDoctorName(),
                    appointment.getTime(),
                    appointment.getDate(),
                    appointment.getAppStatus()
            });
        }

        // Create a scroll pane to hold the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a dialog to display the table
        JDialog dialog = new JDialog();
        dialog.setTitle("All Appointments");
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.add(scrollPane);
        dialog.pack();
        dialog.setVisible(true);
    }
    private void viewPatientProfile(ArrayList<new_patients> patientsArrayList, int loggedInPatientId) {
        // Find the logged-in patient in the ArrayList
        new_patients loggedInPatient = null;
        for (new_patients patient : patientsArrayList) {
            if (patient.getId() == loggedInPatientId) {
                loggedInPatient = patient;
                break;
            }
        }

        if (loggedInPatient != null) {
            // Create a table to display the patient data
            String[] columnNames = {"ID", "Name", "Blood Group", "Phone"};
            String[][] data = {
                    {String.valueOf(loggedInPatient.getId()), loggedInPatient.getName(), loggedInPatient.getBg(), String.valueOf(loggedInPatient.getPhone())}
            };
            JTable table = new JTable(data, columnNames);

            // Display the table in a dialog
            JOptionPane.showMessageDialog(null, new JScrollPane(table), "Profile", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Patient not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void updateProfile(ArrayList<new_patients> patientsArrayList, int loggedInPatientId) {
        // Find the patient in the arraylist based on the loggedInPatientId
        new_patients loggedInPatient = null;
        for (new_patients patient : patientsArrayList) {
            if (patient.getId() == loggedInPatientId) {
                loggedInPatient = patient;
                break;
            }
        }

        if (loggedInPatient == null) {
            JOptionPane.showMessageDialog(null, "Patient not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Prompt the user to enter new data
        String newName = JOptionPane.showInputDialog("Enter new name:", loggedInPatient.getName());
        int newPhone = Integer.parseInt(JOptionPane.showInputDialog("Enter new phone number:", loggedInPatient.getPhone()));
        String newBg = JOptionPane.showInputDialog("Enter new blood group:", loggedInPatient.getBg());
        String newPass = JOptionPane.showInputDialog("Enter new password:", loggedInPatient.getPassword());

        // Update the patient's data
        loggedInPatient.setName(newName);
        loggedInPatient.setPhone(newPhone);
        loggedInPatient.setBg(newBg);
        loggedInPatient.setPatPass(newPass);

        // Save the updated patient list to the file
        saveToFile("patientFile", patientsArrayList);

        JOptionPane.showMessageDialog(null, "Profile updated successfully.");
    }
    private void createAppointment(ArrayList<new_appointments> appointmentsArrayList, ArrayList<new_doctors> doctorsArrayList , new_patients loggedInPatient) {
        ArrayList<new_doctors> availableDoctors = new ArrayList<>();

        for (new_doctors doctor : doctorsArrayList) {
            if (!doctor.isOcc()) {
                availableDoctors.add(doctor);
            }
        }

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Specialization");

        for (new_doctors doctor : availableDoctors) {
            Object[] rowData = {doctor.getId(), doctor.getName(), doctor.getSpecilist()};
            tableModel.addRow(rowData);
        }

        JTable doctorsTable = new JTable(tableModel);
        doctorsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JDialog dialog = new JDialog();
        dialog.setTitle("Select Doctor");
        dialog.setModal(true);

        dialog.setLayout(new BorderLayout());

        dialog.add(new JScrollPane(doctorsTable), BorderLayout.CENTER);

        doctorsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = doctorsTable.getSelectedRow();
                    if (selectedRow != -1) {
                        int doctorId = (int) doctorsTable.getValueAt(selectedRow, 0);
                        String doctorName = (String) doctorsTable.getValueAt(selectedRow, 1);

                        int patientId = loggedInPatient.getId();
                        String patientName = loggedInPatient.getName();

                        String time = JOptionPane.showInputDialog("Enter appointment time:");
                        String date = JOptionPane.showInputDialog("Enter appointment date:");

                        boolean confirm = false;
                        String appStatus = "Pending";

                        new_appointments appointment = new new_appointments(doctorId, patientId, patientName, doctorName, time, date, confirm, appStatus);
                        appointmentsArrayList.add(appointment);

                        // Save the updated appointment list to the file
                        saveToFile("appointmentFile" , appointmentsArrayList);

                        dialog.dispose();
                    }
                }
            }
        });

        doctorsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable targetTable = (JTable) e.getSource();
                    int selectedRow = targetTable.getSelectedRow();

                    if (selectedRow != -1) {
                        int doctorId = (int) targetTable.getValueAt(selectedRow, 0);
                        String doctorName = (String) targetTable.getValueAt(selectedRow, 1);

                        int patientId = loggedInPatient.getId();
                        String patientName = loggedInPatient.getName();

                        String time = JOptionPane.showInputDialog("Enter appointment time:");
                        String date = JOptionPane.showInputDialog("Enter appointment date:");

                        boolean confirm = false;
                        String appStatus = "Pending";

                        new_appointments appointment = new new_appointments(doctorId, patientId, patientName, doctorName, time, date, confirm, appStatus);
                        appointmentsArrayList.add(appointment);

                        // Save the updated appointment list to the file
                        saveToFile("appointmentFile", appointmentArrayList);

                        dialog.dispose();
                    }
                }
            }
        });

        dialog.pack();
        dialog.setVisible(true);
    }
    private int generateNewAppointmentNumber(ArrayList<new_appointments> appointmentsArrayList) {
        int maxAppointmentNo = 0;

        for (new_appointments appointment : appointmentsArrayList) {
            if (appointment.getAppointNo() > maxAppointmentNo) {
                maxAppointmentNo = appointment.getAppointNo();
            }
        }

        return maxAppointmentNo + 1;
    }
    private void viewAppointments(new_patients loggedInPatient , ArrayList<new_appointments> appointmentsArrayList) {
        // Create a table model to hold the appointment data
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        // Add columns to the table
        model.addColumn("Appointment No");
        model.addColumn("Doctor Name");
        model.addColumn("Time");
        model.addColumn("Date");
        model.addColumn("Status");

        // Iterate through the appointmentsArrayList to find appointments for the logged-in patient
        for (new_appointments appointment : appointmentsArrayList) {
            if (appointment.getPatient().getId() == loggedInPatient.getId()) {
                // Add a row to the table with appointment data
                model.addRow(new Object[]{
                        appointment.getAppointNo(),
                        appointment.getDoctorName(),
                        appointment.getTime(),
                        appointment.getDate(),
                        appointment.getAppStatus()
                });
            }
        }

        // Create a scroll pane to hold the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a dialog to display the table
        JDialog dialog = new JDialog();
        dialog.setTitle("Appointments");
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.add(scrollPane);
        dialog.pack();
        dialog.setVisible(true);
    }
    private void viewDoctorProfile(new_doctors doctor) {
        String[] columnNames = {"ID", "Name", "Specialization"};
        Object[][] rowData = {{doctor.getId(), doctor.getName(), doctor.getSpecilist()}};

        JTable doctorProfileTable = new JTable(rowData, columnNames);
        doctorProfileTable.setEnabled(false);

        JOptionPane.showMessageDialog(null, new JScrollPane(doctorProfileTable),
                "Doctor Profile", JOptionPane.PLAIN_MESSAGE);
    }

    private void updateDoctorProfile(new_doctors doctor) {
        String newName = JOptionPane.showInputDialog("Enter new name:");
        String newSpecialization = JOptionPane.showInputDialog("Enter new specialization:");

        doctor.setName(newName);
        doctor.setSpecilist(newSpecialization);

        JOptionPane.showMessageDialog(null, "Profile updated successfully!");
    }
    /*private void viewDoctorAppointments(new_doctors loggedInDoctor) {
        // Filter the appointments to display only confirmed ones for the logged-in doctor
        ArrayList<new_appointments> confirmedAppointments = new ArrayList<>();
        for (new_appointments appointment : appointmentArrayList) {
            if (appointment.getDoctorName().equals(loggedInDoctor.getName())  && appointment.getAppStatus().equals("Confirmed")) {
                confirmedAppointments.add(appointment);
            }
        }

        // Display the appointments in a table
        String[] columnNames = {"Appointment No", "Patient ID", "Patient Name", "Time", "Date"};
        Object[][] data = new Object[confirmedAppointments.size()][5];
        for (int i = 0; i < confirmedAppointments.size(); i++) {
            new_appointments appointment = confirmedAppointments.get(i);
            data[i][0] = appointment.getAppointNo();
            data[i][1] = appointment.getPatientId();
            data[i][2] = appointment.getPatientName();
            data[i][3] = appointment.getTime();
            data[i][4] = appointment.getDate();
        }

        JTable appointmentsTable = new JTable(data, columnNames);
        appointmentsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add a double click listener to select appointment and trigger writePrescription method
        appointmentsTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = appointmentsTable.getSelectedRow();
                    if (selectedRow != -1) {
                        new_appointments selectedAppointment = confirmedAppointments.get(selectedRow);
                        writePrescription(selectedAppointment); // Trigger writePrescription method with selected appointment
                    }
                }
            }
        });

        // Display the table in a dialog
        JOptionPane.showMessageDialog(null, new JScrollPane(appointmentsTable));
    }*/
    private void viewDoctorAppointments(new_doctors loggedInDoctor) {
        // Filter the appointments to display only confirmed ones for the logged-in doctor
        ArrayList<new_appointments> confirmedAppointments = new ArrayList<>();
        for (new_appointments appointment : appointmentArrayList) {
            if (appointment.getDoctorName().equals(loggedInDoctor.getName())  && appointment.getAppStatus().equals("Confirmed")) {
                confirmedAppointments.add(appointment);
            }
        }
        // Display confirmed appointments in a table
        DefaultTableModel model = new DefaultTableModel();
        JTable appointmentsTable = new JTable(model);
        model.addColumn("Appointment No");
        model.addColumn("Patient ID");
        model.addColumn("Patient Name");
        model.addColumn("Doctor Name");
        model.addColumn("Time");
        model.addColumn("Date");

        // Populate the table with confirmed appointments
        for (new_appointments appointment : confirmedAppointments) {
            if (appointment.getDoctorName().equals(loggedInDoctor.getName())) {
                model.addRow(new Object[] {
                        appointment.getAppointNo(),
                        appointment.getPatientId(),
                        appointment.getPatientName(),
                        appointment.getDoctorName(),
                        appointment.getTime(),
                        appointment.getDate()
                });
            }
        }

        JScrollPane scrollPane = new JScrollPane(appointmentsTable);
        JPanel appointmentsPanel = new JPanel(new BorderLayout());
        appointmentsPanel.add(scrollPane, BorderLayout.CENTER);

        // Add double click listener to select appointment and trigger writePrescription method
       /* appointmentsTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = appointmentsTable.getSelectedRow();
                    if (selectedRow != -1) {
                        new_appointments selectedAppointment = confirmedAppointments.get(selectedRow);
                        writePrescription(selectedAppointment);
                        // Update appointment status to "Prescribed"
                        selectedAppointment.setAppStatus("Prescribed");
                        JOptionPane.showMessageDialog(null, "Prescription added successfully!");
                    }
                }
            }
        });*/
        appointmentsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = appointmentsTable.getSelectedRow();
                    if (selectedRow != -1) {
                        new_appointments selectedAppointment = confirmedAppointments.get(selectedRow);
                        writePrescription(selectedAppointment);
                        // Update appointment status to "Prescribed"
                        selectedAppointment.setAppStatus("Prescribed");
                        JOptionPane.showMessageDialog(null, "Prescription added successfully!");
                        showDoctorMainMenu(loggedInDoctor);
                    }
                }
            }
        });

        // Show the appointments panel
        cardLayout.show(cardPanel, "doctorAppointments");
        cardPanel.add(appointmentsPanel, "doctorAppointments");
    }

    private void writePrescription(new_appointments appointment) {
        String medicine = JOptionPane.showInputDialog("Enter prescribed medicine:");
        int condition = Integer.parseInt(JOptionPane.showInputDialog("Enter patient's condition (1-10):"));
        String ward = JOptionPane.showInputDialog("Enter ward:");
        String roomNo = JOptionPane.showInputDialog("Enter room number:");
        String prescriptionStatus = JOptionPane.showInputDialog("Enter prescription status:");

        new_prescription prescription = new new_prescription(
                generateNewPrescriptionNumber(prescriptionsArrayList), // You need to implement this method to generate a new unique prescription number
                appointment.getAppointNo(),
                appointment.getPatientName(),
                appointment.getDoctorName(),
                medicine,
                condition,
                ward,
                roomNo,
                prescriptionStatus
        );

        // Add the prescription to the prescriptionsArrayList
        prescriptionsArrayList.add(prescription);
        saveToFile("prescriptionFile", prescriptionsArrayList);

        //JOptionPane.showMessageDialog(null, "Prescription created successfully!");
    }
    private void viewPatientPrescriptions(new_patients loggedInPatient) {
        // Get the prescriptions for the logged-in patient
        ArrayList<new_prescription> patientPrescriptions = new ArrayList<>();
        for (new_prescription prescription : prescriptionsArrayList) {
            if (prescription.getPatientname().equals(loggedInPatient.getName())) {
                patientPrescriptions.add(prescription);
            }
        }

        // Create a table to display the prescriptions
        String[] columnNames = {"Prescription No.", "Appointment No.", "Doctor Name", "Medicine", "Condition", "Ward", "Room No.", "Status"};
        Object[][] data = new Object[patientPrescriptions.size()][columnNames.length];
        for (int i = 0; i < patientPrescriptions.size(); i++) {
            new_prescription prescription = patientPrescriptions.get(i);
            data[i][0] = prescription.getPreNo();
            data[i][1] = prescription.getAppointNo();
            data[i][2] = prescription.getDoctorname();
            data[i][3] = prescription.getMedicine();
            data[i][4] = prescription.getCondition();
            data[i][5] = prescription.getWard();
            data[i][6] = prescription.getRoomno();
            data[i][7] = prescription.getPreStatus();
        }

        JTable prescriptionsTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(prescriptionsTable);

        // Create a dialog to display the prescriptions table
        JDialog prescriptionsDialog = new JDialog();
        prescriptionsDialog.setTitle("Prescriptions");
        prescriptionsDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        prescriptionsDialog.add(scrollPane);
        prescriptionsDialog.pack();
        prescriptionsDialog.setVisible(true);
    }

    /*private void viewDoctorPrescriptions(new_doctors loggedInDoctor) {
        // Filter prescriptions by the logged-in doctor
        List<new_prescription> doctorPrescriptions = new ArrayList<>();
        for (new_prescription prescription : prescriptionsList) {
            if (prescription.getDoctorname().equals(loggedInDoctor.getName())) {
                doctorPrescriptions.add(prescription);
            }
        }

        // Create a table model for prescriptions
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Prescription No.", "Appointment No.", "Patient Name", "Doctor Name", "Medicine", "Condition", "Ward", "Room No.", "Prescription Status"});

        // Populate the table model with prescription data
        for (new_prescription prescription : doctorPrescriptions) {
            model.addRow(new Object[]{prescription.getPreNo(), prescription.getAppointNo(), prescription.getPatientname(),
                    prescription.getDoctorname(), prescription.getMedicine(), prescription.getCondition(),
                    prescription.getWard(), prescription.getRoomno(), prescription.getPreStatus()});
        }

        // Create the prescriptions table
        JTable prescriptionsTable = new JTable(model);

        // Add the prescriptions table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(prescriptionsTable);

        // Create a new frame to display the prescriptions
        JFrame frame = new JFrame("Doctor Prescriptions");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);

        // Add the scroll pane to the frame
        frame.add(scrollPane);

        // Set the frame visible
        frame.setVisible(true);
    }*/
    private void viewDoctorPrescriptions(new_doctors loggedInDoctor , ArrayList<new_prescription> prescriptionsArrayList ) {
        // Filter prescriptions by the logged-in doctor
        ArrayList<new_prescription> doctorPrescriptions = new ArrayList<>();
        for (new_prescription prescription : prescriptionsArrayList) {
            if (prescription.getDoctorname().equals(loggedInDoctor.getName())) {
                doctorPrescriptions.add(prescription);
            }
        }

        // Create a table model for prescriptions
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Prescription No.", "Appointment No.", "Patient Name", "Doctor Name", "Medicine", "Condition", "Ward", "Room No.", "Prescription Status"});

        // Populate the table model with prescription data
        for (new_prescription prescription : doctorPrescriptions) {
            model.addRow(new Object[]{prescription.getPreNo(), prescription.getAppointNo(), prescription.getPatientname(),
                    prescription.getDoctorname(), prescription.getMedicine(), prescription.getCondition(),
                    prescription.getWard(), prescription.getRoomno(), prescription.getPreStatus()});
        }

        // Create the prescriptions table
        JTable prescriptionsTable = new JTable(model);

        // Add the prescriptions table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(prescriptionsTable);

        // Create a new frame to display the prescriptions
        JFrame frame = new JFrame("Doctor Prescriptions");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);

        // Add the scroll pane to the frame
        frame.add(scrollPane);

        // Set the frame visible
        frame.setVisible(true);
    }
    private void viewPrescriptions() {
        // Get the prescriptions for all patients
        ArrayList<new_prescription> allPrescriptions = new ArrayList<>(prescriptionsArrayList);

        // Create a table to display the prescriptions
        String[] columnNames = {"Prescription No.", "Appointment No.", "Patient Name", "Doctor Name", "Medicine", "Condition", "Ward", "Room No.", "Status"};
        Object[][] data = new Object[allPrescriptions.size()][columnNames.length];
        for (int i = 0; i < allPrescriptions.size(); i++) {
            new_prescription prescription = allPrescriptions.get(i);
            data[i][0] = prescription.getPreNo();
            data[i][1] = prescription.getAppointNo();
            data[i][2] = prescription.getPatientname();
            data[i][3] = prescription.getDoctorname();
            data[i][4] = prescription.getMedicine();
            data[i][5] = prescription.getCondition();
            data[i][6] = prescription.getWard();
            data[i][7] = prescription.getRoomno();
            data[i][8] = prescription.getPreStatus();
        }

        JTable prescriptionsTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(prescriptionsTable);

        // Create a dialog to display the prescriptions table
        JDialog prescriptionsDialog = new JDialog();
        prescriptionsDialog.setTitle("Prescriptions");
        prescriptionsDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        prescriptionsDialog.add(scrollPane);
        prescriptionsDialog.pack();
        prescriptionsDialog.setVisible(true);
// Prompt the user to select an appointment to confirm
        String input = JOptionPane.showInputDialog("Enter the appointment number to confirm:");

        if (input != null) {
            int prescriptionNo = Integer.parseInt(input);

            // Find the prescription in the prescriptions list
            new_prescription selectedPrescription = null;
            for (new_prescription prescription : prescriptionsArrayList) {
                if (prescription.getPreNo() == prescriptionNo) {
                    selectedPrescription = prescription;
                    break;
                }
            }

            // Check if a valid prescription was found
            if (selectedPrescription != null) {
                // Update the prescription status to confirmed
                selectedPrescription.setPreStatus("Confirmed");

                // Display a confirmation message
                JOptionPane.showMessageDialog(null, "Prescription confirmed!");

                // Save the updated prescriptions list to the file
                saveToFile("prescriptionFile", prescriptionsArrayList);
            } else {
                // Display an error message if the prescription number is invalid
                JOptionPane.showMessageDialog(null, "Invalid prescription number!");
            }
        }
        // Add a double click listener to select prescription and trigger confirmation
        /*prescriptionsTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = prescriptionsTable.getSelectedRow();
                    if (selectedRow != -1) {
                        new_prescription selectedPrescription = allPrescriptions.get(selectedRow);
                        *//*selectedPrescription.setPreStatus("Confirmed");*//*
                        // Update prescription status to "Confirmed"
                        selectedPrescription.setPreStatus("Confirmed");
                        JOptionPane.showMessageDialog(null, "Prescription confirmed successfully!");
                    }
                }
            }
        });*/

    }



    private int generateNewPrescriptionNumber(ArrayList<new_prescription> prescriptionArrayList) {
        // Check the existing prescriptions and find the maximum prescription number
        int maxPrescriptionNumber = 0;
        for (new_prescription prescription : prescriptionArrayList) {
            if (prescription.getPreNo() > maxPrescriptionNumber) {
                maxPrescriptionNumber = prescription.getPreNo();
            }
        }

        // Increment the maximum prescription number by 1 to generate a new prescription number
        return maxPrescriptionNumber + 1;
    }
    private ArrayList<Ward> populateWardsList(ArrayList<new_prescription> prescriptionArrayList) {
        ArrayList<Ward> wards = new ArrayList<>();

        for (new_prescription prescription : prescriptionArrayList) {
            String wardType = prescription.getWard();
            if (wardType.startsWith("G") || wardType.startsWith("g") ){
                wardType = "General";
            } else if (wardType.startsWith("S") || wardType.startsWith("s")) {
                wardType = "Surgical";
            }
            else wardType = prescription.getWard();
            // Create a new Ward object and add it to the wards ArrayList
            Ward ward = new Ward(prescription, wardType);
            wards.add(ward);
        }

        return wards;
    }



    private void saveToFile(String fileName , ArrayList AL) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName + ".txt"));
            oos.writeObject(AL);
            oos.close();
            //JOptionPane.showMessageDialog(null, "Added to Successfully.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    private ArrayList<?> loadFromFile(String fileName) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName + ".txt"));
            ArrayList<?> loadedList = (ArrayList<?>) ois.readObject();
            ois.close();
            return loadedList;
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error loading doctors data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Gui();
            }
        });
        ArrayList<new_doctors> doctorsArrayList = new ArrayList<new_doctors>();
        /*ArrayList<new_patients> pal = new ArrayList<new_patients>();
        ArrayList<new_appointments> apal = new ArrayList<new_appointments>();*/
    }
}