package com.konasl.yan.exercise.pdfbox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.*;
import java.io.IOException;

/**
 * Created by Mohammad Nur on 10/19/2017.
 */
public class PDFCreator {

    public static void main(String[] args) throws IOException {

        PDDocument document = new PDDocument();
        PDPage my_page = new PDPage();
        document.addPage(my_page);
        PDPageContentStream contents = new PDPageContentStream(document, my_page);

        //Begin the Content stream
        contents.beginText();
        //Setting the font to the Content stream
        contents.setFont(PDType1Font.TIMES_ROMAN, 12);
        //Setting the position for the line
        contents.newLineAtOffset(100, 700);
        String text = "This is the sample document and we are adding content to it.";
        //Adding text in the form of string
        contents.showText(text);
        //Ending the content stream
        contents.endText();
        System.out.println("Text added");

        //Creating a background PDF image
        PDImageXObject background = PDImageXObject.createFromFile("F:\\Excersize-Projects\\exercise-pdfbox\\resources\\image2.jpg", document);
        //Drawing the image in the PDF document with specific width and height
        contents.drawImage(background, 95, 295, 210, 210);
        System.out.println("background Image inserted");

        //Creating the foreground image that should be the QR Code object
        PDImageXObject qrCode = PDImageXObject.createFromFile("F:\\Excersize-Projects\\exercise-pdfbox\\resources\\image1.jpg", document);
        //Drawing the image in the PDF document
        contents.drawImage(qrCode, 100, 300, 200, 200);
        System.out.println("Foreground Image inserted");

        // Creating a line as a collapsed rectangle
        contents.setNonStrokingColor(Color.DARK_GRAY);
        contents.addRect(50, 200, 200, 1);
        contents.fill();

        //Closing the PDPageContentStream object
        contents.close();

        document.save("F:\\Excersize-Projects\\hello.pdf");
        System.out.println("A PDF has been created");
        document.close();
    }
}
