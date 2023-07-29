import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import com.itextpdf.layout.property.UnitValue;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.element.Image;



public class CVGeneratorApp extends JFrame {

    JTextField imagePathField;
    // Personal Details
    private JTextField nameField;
    private JTextField emailField;
    private JTextField dobField;
    private JTextArea addressArea;
    private JTextField contact_field;

    // Skills
    private JTextField skillField1;
    private JTextField skillField2;
    private JTextField skillField3;
    private JTextField skillField4;

    // Qualifications
    private JTextField tenthField;
    private JTextField twelfthField;
    private JTextField graduationField;

    // Work Experience
    private JTextField company1Field;
    private JTextField workDate1Field;
    private JTextField jobRole1Field;

    private JTextField company2Field;
    private JTextField workDate2Field;
    private JTextField jobRole2Field;

    //Achievements
    private JTextField Achievement1;
    private JTextField Achievement2;
    private JTextField Achievement3;

    public CVGeneratorApp() {
        // Frame setup
        setTitle("Resume Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);



        // Image Path field



        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;

        add(new JLabel("Photo:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
         imagePathField = new JTextField(20);
        add(imagePathField, gbc);



        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        JButton browseImageButton = new JButton("Browse");
        browseImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    // Get the selected image file path
                    File selectedFile = fileChooser.getSelectedFile();
                    imagePathField.setText(selectedFile.getAbsolutePath());
                }
            }
        });
        add(browseImageButton, gbc);


        // Personal Details section
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(new JLabel("Personal Details"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        nameField = new JTextField(20);
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        emailField = new JTextField(20);
        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("Date of Birth:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        dobField = new JTextField(20);
        add(dobField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(new JLabel("Address:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        addressArea = new JTextArea(2, 20);
        add(new JScrollPane(addressArea), gbc);


        // Skills section
        gbc.gridx = 2;
        gbc.gridy = 3;
        add(new JLabel("Skills"), gbc);



        gbc.gridx = 2;
        gbc.gridy = 4;
        add(new JLabel("Skill 1"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 4;
        skillField1 = new JTextField(20);
        add(skillField1, gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        add(new JLabel("Skill 2"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 5;
        skillField2 = new JTextField(20);
        add(skillField2, gbc);

        gbc.gridx = 2;
        gbc.gridy = 6;
        add(new JLabel("Skill 3"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 6;
        skillField3 = new JTextField(20);
        add(skillField3, gbc);

        gbc.gridx = 2;
        gbc.gridy = 7;
        add(new JLabel("Skill 4"), gbc);
        gbc.gridx = 3;
        gbc.gridy = 7;
        skillField4 = new JTextField(20);
        add(skillField4, gbc);


        //Achievements

        gbc.gridx = 2;
        gbc.gridy = 8;
        add(new JLabel("Achievements/Certificate"), gbc);



        gbc.gridx = 2;
        gbc.gridy = 9;
        add(new JLabel("Achievement 1"), gbc);


        gbc.gridx = 3;
        gbc.gridy = 9;
        Achievement1 = new JTextField(20);
        add(Achievement1, gbc);



        gbc.gridx = 2;
        gbc.gridy = 10;
        add(new JLabel("Achievement 2"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 10;
        Achievement2 = new JTextField(20);
        add(Achievement2, gbc);


        gbc.gridx = 2;
        gbc.gridy = 11;
        add(new JLabel("Achievement 3"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 11;
        Achievement3 = new JTextField(20);
        add(Achievement3, gbc);





        // Qualifications section
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        add(new JLabel("Qualifications"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        add(new JLabel("10th:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        tenthField = new JTextField(20);
        add(tenthField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        add(new JLabel("12th/Diploma:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        twelfthField = new JTextField(20);
        add(twelfthField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        add(new JLabel("Graduation:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        graduationField = new JTextField(20);
        add(graduationField, gbc);

        // Work Experience section
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        add(new JLabel("Work Experience"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.gridwidth = 1;
        add(new JLabel("Company Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 13;
        company1Field = new JTextField(20);
        add(company1Field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 14;
        add(new JLabel("Work Date:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 14;
        workDate1Field = new JTextField(20);
        add(workDate1Field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 15;
        add(new JLabel("Job Role:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 15;
        jobRole1Field = new JTextField(20);
        add(jobRole1Field, gbc);

        gbc.gridx = 2;
        gbc.gridy = 13;
        add(new JLabel("Company Name:"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 13;
        company2Field = new JTextField(20);
        add(company2Field, gbc);

        gbc.gridx = 2;
        gbc.gridy = 14;
        add(new JLabel("Work Date:"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 14;
        workDate2Field = new JTextField(20);
        add(workDate2Field, gbc);

        gbc.gridx = 2;
        gbc.gridy = 15;
        add(new JLabel("Job Role:"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 15;
        jobRole2Field = new JTextField(20);
        add(jobRole2Field, gbc);


        //Contact

        gbc.gridx = 1;
        gbc.gridy = 17;
        add(new JLabel("Contact \uD83D\uDCDE:"), gbc);


        gbc.gridx = 2;
        gbc.gridy = 17;
        gbc.gridwidth = 1;
        contact_field=new JTextField(20);
        add(contact_field,gbc);



        // Generate CV button
        gbc.gridx = 0;
        gbc.gridy = 20;
        gbc.gridwidth = 4;
        JButton generateButton = new JButton("Generate CV");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    generateCV();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (MalformedURLException malformedURLException) {
                    malformedURLException.printStackTrace();
                }
            }
        });
        add(generateButton, gbc);

        // Display the GUI
        pack(); // Adjust the frame size to fit the components
        setVisible(true);
    }





    private void generateCV() throws FileNotFoundException, MalformedURLException {




        String fileName = "Resume_" +  nameField.getText() + ".pdf"; // File name for the PDF

        // Create a new PDF document
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(fileName));
        Document doc = new Document(pdfDoc);






        Image image = new Image(ImageDataFactory.create(imagePathField.getText()));


        Paragraph s1 = new Paragraph("");
        float pageWidth = pdfDoc.getDefaultPageSize().getWidth();
        float pageHeight = pdfDoc.getDefaultPageSize().getHeight();

        // Calculate the position and size of the image at the top of the page
        float imageWidth = 150; // Adjust the image width as needed
        float imageHeight = 120; // Adjust the image height as needed
        float imageX = (pageWidth - imageWidth) -30; // Center the image horizontally at right
        float imageY = pageHeight - imageHeight-15; // Position the image at the top

        // Set the position and size of the image on the page
        image.setFixedPosition(imageX, imageY);
        image.scaleAbsolute(imageWidth, imageHeight);


        doc.add(s1);
        doc.add(image);


// Set padding around the image




        Paragraph centeredText = new Paragraph(nameField.getText());

        centeredText.setBold();
        centeredText.setFontSize(25);
        doc.add(centeredText);




        // Add the image to the document














        // Create a table with 2 columns
        Table table1 = new Table(2);



        doc.add(s1);

        doc.add(s1);
        doc.add(s1);

        doc.add(s1);


        


        Paragraph t1 = new Paragraph("Personal Details");

        t1.setBold();
        t1.setFontSize(15);

        doc.add(t1);



        doc.add(s1);





        // Add rows to the table Personal Details
        table1.addCell(new Cell().add(" Name:"));

        table1.addCell(new Cell().add(nameField.getText()));
        table1.addCell(new Cell().add("Email:"));
        table1.addCell(new Cell().add(emailField.getText()));

        table1.addCell(new Cell().add("Contact:"));
        table1.addCell(new Cell().add(contact_field.getText()));
        table1.addCell(new Cell().add("Date of Birth:"));
        table1.addCell(new Cell().add(dobField.getText()));
        table1.addCell(new Cell().add("Address"));
        table1.addCell(new Cell().add(addressArea.getText()));

        // Add the table to the document
        doc.add(table1);


        doc.add(s1);

        doc.add(s1);




        Table table2 = new Table(2);

        // Add rows to the table Qualifications
        table2.addCell(new Cell().add(" 10th %:"));

        table2.addCell(new Cell().add(tenthField.getText()));
        table2.addCell(new Cell().add("12th/Diploma %"));
        table2.addCell(new Cell().add(twelfthField.getText()));

        table2.addCell(new Cell().add("Degree:"));
        table2.addCell(new Cell().add(graduationField.getText()));


        Paragraph t2 = new Paragraph("Qualifications");

        t2.setBold();
        t2.setFontSize(15);
        doc.add(t2);




        doc.add(s1);


        // Add the table to the document
        doc.add(table2);



        doc.add(s1);

        doc.add(s1);




        Table table3 = new Table(2);

        //Skills


        table3.addCell(new Cell().add(" Skill 1:"));

        table3.addCell(new Cell().add(skillField1.getText()));
        table3.addCell(new Cell().add("Skill 2:"));
        table3.addCell(new Cell().add(skillField2.getText()));

        table3.addCell(new Cell().add("Skill 3:"));
        table3.addCell(new Cell().add(skillField3.getText()));

        table3.addCell(new Cell().add("Skill 4:"));
        table3.addCell(new Cell().add(skillField4.getText()));


        Paragraph t3 = new Paragraph("Skills");
        t3.setFontSize(15);

        t3.setBold();

        doc.add(t3);


        doc.add(s1);

        doc.add(table3);

        doc.add(s1);

        doc.add(s1);


        Table table4 = new Table(2);

        //Work Experience 1

        Paragraph t4 = new Paragraph("Work Experience 1");
        t4.setBold();

        t4.setFontSize(15);

        doc.add(t4);

        table4.addCell(new Cell().add("Company Name"));

        table4.addCell(new Cell().add(company1Field.getText()));
        table4.addCell(new Cell().add("Work Date"));
        table4.addCell(new Cell().add(workDate1Field.getText()));

        table4.addCell(new Cell().add("Job Role"));
        table4.addCell(new Cell().add(jobRole1Field.getText()));

        doc.add(s1);



        doc.add(table4);



        Table table5 = new Table(2);


        Paragraph t5 = new Paragraph("Work Experience 2");
        t5.setBold();

        t5.setFontSize(15);




        doc.add(s1);


        doc.add(t5);

        doc.add(s1);

        doc.add(s1);

        table5.addCell(new Cell().add("Company Name"));

        table5.addCell(new Cell().add(company2Field.getText()));
        table5.addCell(new Cell().add("Work Date"));
        table5.addCell(new Cell().add(workDate2Field.getText()));

        table5.addCell(new Cell().add("Job Role"));
        table5.addCell(new Cell().add(jobRole2Field.getText()));


        doc.add(table5);






        // Close the PDF document

        doc.close();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CVGeneratorApp();
            }
        });
    }
}
