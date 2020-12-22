package com.M_mehdi;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {
    private int counter = 0;
    Admin admin = new Admin("","");
    JFrame frame = new JFrame();
    JPanel panel = new JPanel(new BorderLayout(5,5));
    JRadioButton Admin = new JRadioButton("Admin");
    JRadioButton Teacher = new JRadioButton("Teacher");
    JRadioButton Student = new JRadioButton("Student");
    JLabel Username = new JLabel(" User name :");
    JLabel Password = new JLabel(" Password :");
    JTextField aUserName = new JTextField();
    JPasswordField aPassword = new JPasswordField();
    JButton SignUp = new JButton("Sign Up");
    JButton SignIn = new JButton("Sign In");

    public Gui() {
        frame.setSize(400,200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPanels();
        setRadioButton();
        setButtons();
        frame.setVisible(true);

    }
    public void setPanels(){
        panel.setBorder(new EmptyBorder(5,5,5,5));
        JPanel radiusPanel = new JPanel(new GridLayout(1,3,5,5));
        radiusPanel.add(Admin);
        radiusPanel.add(Teacher);
        radiusPanel.add(Student);
        JPanel fieldPanel = new JPanel(new GridLayout(2,2,5,5));
        fieldPanel.add(Username);
        fieldPanel.add(aUserName);
        fieldPanel.add(Password);
        fieldPanel.add(aPassword);
        JPanel buttons = new JPanel(new GridLayout(2,1,5,5));
        buttons.add(SignIn);
        buttons.add(SignUp);
        panel.add(radiusPanel,BorderLayout.NORTH);
        panel.add(fieldPanel,BorderLayout.CENTER);
        panel.add(buttons,BorderLayout.SOUTH);
        frame.add(panel);
        frame.setContentPane(panel);
    }
    public void setRadioButton() {
        ButtonGroup group = new ButtonGroup();
        Admin.addActionListener(this);
        Teacher.addActionListener(this);
        Student.addActionListener(this);
        group.add(Admin);
        group.add(Teacher);
        group.add(Student);

    }

    public void setButtons() {
        SignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter == 1) {
                    Admin example = new Admin(aUserName.getText(),aPassword.getText());


                }
                if (counter == 2) {
                    Teacher example = new Teacher(aUserName.getText(),aPassword.getText());
                    for (int i = 0; i < admin.getTeachersSize();i++) {
                        if (example.hashCode()==(admin.getTeachers(i).hashCode())) {
                            System.out.println(admin.getTeachers(i).toString());
                            JOptionPane.showMessageDialog(frame, "Your Sign In was successful", "Sign In", JOptionPane.PLAIN_MESSAGE);
                            break;
                        }
                    }
                    counter = 0;
                } else if (counter == 3 ) {
                    Student example = new Student(aUserName.getText(),aPassword.getText());
                    for (int i = 0; i < admin.getStudentsSize();i++) {
                        if (example.hashCode() == (admin.getStudents(i).hashCode())) {
                            System.out.println(admin.getStudents(i).getUsername());
                            sJframe secondFrame = new sJframe(admin.getStudents(i));
                            frame.setVisible(false);
                            break;
                        }
                    }
                    counter = 0;
                }

            }
        });
        SignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (counter == 1) {
                    admin.setUsername(aUserName.getText());
                    admin.setPassword(aPassword.getText());
                    JOptionPane.showMessageDialog(frame, "Your sign up was successful", "Sign Up", JOptionPane.PLAIN_MESSAGE);
                    aUserName.setText("");
                    aPassword.setText("");
                    counter = 0;
                } else if (counter == 2) {
                    admin.addTeachers(new Teacher(aUserName.getText(), aPassword.getText()));
                    JOptionPane.showMessageDialog(frame, "Your sign up was successful", "Sign Up", JOptionPane.PLAIN_MESSAGE);
                    aUserName.setText("");
                    aPassword.setText("");
                    counter = 0;
                } else if (counter == 3) {
                    admin.addStudents(new Student(aUserName.getText(), aPassword.getText()));
                    JOptionPane.showMessageDialog(frame, "Your sign up was successful", "Sign Up", JOptionPane.PLAIN_MESSAGE);
                    aUserName.setText("");
                    aPassword.setText("");
                    counter = 0;
                }

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(Admin)) {
            counter = 1;
        } else if (e.getSource().equals(Teacher)) {
            counter = 2;
        } else if (e.getSource().equals(Student)) {
            counter = 3;
        }
    }
    public class sJframe {
        JFrame std = new JFrame() ;
        JPanel stdp = new JPanel(new BorderLayout(5,5));
        JLabel changeUSer;
        JLabel changePass;
        JLabel cardNumber;
        JLabel cardPassword;
        JTextField newUser;
        JTextField newCardNumber;
        JPasswordField newPass;
        JPasswordField newCardPassword;
        JButton exit;
        JButton userNew;
        JButton passNew;
        JButton assignCardInfo;
        JButton food;
        JButton credit;
       sJframe(Student student) {
           std.setTitle(student.getUsername());
           std.setSize(300,300);
           exit = new JButton("EXIT");
           exit.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   std.dispose();
                   frame.setVisible(true);
               }
           });
           changeUSer = new JLabel("New username :");
           changePass = new JLabel("New password :");
           cardNumber = new JLabel("Card Number :");
           cardPassword = new JLabel("Card Password :");
           newUser = new JTextField();
           newCardNumber = new JTextField();
           newPass = new JPasswordField();
           newCardPassword = new JPasswordField();
           userNew = new JButton("Set new Username");
           userNew.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   student.setUsername(newUser.getText());
               }
           });
           passNew = new JButton("Set new password");
           passNew.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   student.setPassword(newPass.getText());
               }
           });
           assignCardInfo = new JButton("Set Card info");
           assignCardInfo.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   if (newCardNumber.getText().length() == 0 || newCardPassword.getText().length()== 0) {
                       JOptionPane.showMessageDialog(frame, "Please fill the fields", "Card Info", JOptionPane.ERROR_MESSAGE);
                   } else{
                       student.setCardInfoNum(newCardNumber.getText());
                       student.setCardInfoPAss(newCardPassword.getText());
                       System.out.println(student.getCardInfoNum() + student.getCardInfoPAss());
                   }
               }
           });
           food = new JButton("Food Selection");
           food.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {

               }
           });
           credit = new JButton("Credit raise");
           credit.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   JFrame creditFrame = new JFrame();
                   creditFrame.setSize(300,200);
                   JPanel creditPanel = new JPanel(new GridLayout(3,2,5,5));
                   JLabel enterCardNum = new JLabel("Enter your card Number :");
                   JLabel enterCardPass = new JLabel("Enter your card password :");
                   JLabel enterAmount = new JLabel("Enter amount :");
                   JTextField amount = new JTextField();
                   JTextField cardNum = new JTextField();
                   JPasswordField cardPass = new JPasswordField();
                   creditFrame.add(creditPanel);
                   JButton submit = new JButton("Submit");
                   submit.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                           if (cardNum.getText().equals(student.getCardInfoNum()) && cardPass.getText().equals(student.getCardInfoPAss())){
                               double money = student.getCash();
                               money += Double.parseDouble(amount.getText());
                               student.setCash(money);
                           } else  JOptionPane.showMessageDialog(frame, "Please try again", "Card Info", JOptionPane.ERROR_MESSAGE);
                       }
                   });
                   creditPanel.add(enterCardNum);
                   creditPanel.add(cardNum);
                   creditPanel.add(enterCardPass);
                   creditPanel.add(cardPass);
                   creditPanel.add(enterAmount);
                   creditPanel.add(amount);
                   creditPanel.add(submit);
                   creditFrame.add(creditPanel);
                   creditFrame.setVisible(true);
               }
           });
           std.add(stdp);
           panels();
           std.setVisible(true);
       }
       public void panels() {
         stdp.setBorder(new EmptyBorder(5,5,5,5));
         JPanel newInfo = new JPanel(new GridLayout(3,2,5,5));
         newInfo.add(changeUSer);
         newInfo.add(newUser);
         newInfo.add(changePass);
         newInfo.add(newPass);
         newInfo.add(userNew);
         newInfo.add(passNew);
         stdp.add(newInfo,BorderLayout.NORTH);
         JPanel newCard = new JPanel(new GridLayout(2,2,5,5));
         newCard.add(cardNumber);
         newCard.add(newCardNumber);
         newCard.add(cardPassword);
         newCard.add(newCardPassword);
         stdp.add(newCard,BorderLayout.CENTER);
         JPanel buttons = new JPanel(new GridLayout(2,2,5,5));
         buttons.add(assignCardInfo);
         buttons.add(credit);
         buttons.add(food);
         buttons.add(exit);
         stdp.add(buttons,BorderLayout.SOUTH);
       }
       public void setCredit() {

       }
    }

}
