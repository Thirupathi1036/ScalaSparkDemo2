/*
package com.org.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


public class ExtractPDf {
    public static void main(String[] a) {
        String path = "/Users/thirupathi.c/Downloads/Thiru/pdf/ukpga_20160019_en.pdf";
        try {
            File f=new File(path);
            FileInputStream fs = new FileInputStream(f);
            String text = "";
            PDFParser parser = new PDFParser((RandomAccessRead) fs);
            parser.parse();
            COSDocument cosDoc = parser.getDocument();
            PDFTextStripper pdfStripper = new PDFTextStripper(){
                String prevBaseFont = "";

                protected void writeString(String text, List<TextPosition> textPositions) throws IOException
                {
                    StringBuilder builder = new StringBuilder();

                    for (TextPosition position : textPositions)
                    {
                        String baseFont = position.getFont().getBaseFont();
                        if (baseFont != null && !baseFont.equals(prevBaseFont))
                        {
                            builder.append('[').append(baseFont).append(']');
                            prevBaseFont = baseFont;
                        }
                        builder.append(position.getCharacter());
                    }

                    writeString(builder.toString());
                }
            };
            fs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fehler in readPDFDocument",
                    "Fehler", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
*/
