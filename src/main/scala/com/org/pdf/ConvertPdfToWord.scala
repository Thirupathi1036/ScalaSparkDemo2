package com.org.pdf

import java.io.FileOutputStream

import com.itextpdf.text.pdf.PdfReader
import com.itextpdf.text.pdf.parser.{PdfReaderContentParser, SimpleTextExtractionStrategy}
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.{PDFTextStripper, TextPosition}
import org.apache.poi.xwpf.usermodel.{BreakType, XWPFDocument}

object ConvertPdfToWord extends App {

  val pdfPath = "/Users/thirupathi.c/Downloads/Thiru/pdf/ukpga_20160019_en.pdf"
  val wordFilePath = "/Users/thirupathi.c/Downloads/Thiru/pdf/pdfword2.docx"
  /*  println("..... starting conversion ............")

    println("..... completed conversion ............")*/
  convertWord(pdfPath)
  //convertPdfToWord(pdfPath, wordFilePath)


  def convertWord(pdfPath: String) = {
    val doc = new XWPFDocument()
    val pdfReader = new PdfReader(pdfPath)
    val pdfParser = new PdfReaderContentParser(pdfReader)

    for (i <- 1 to pdfReader.getNumberOfPages()-230) {
      val strategy = pdfParser.processContent(i, new SimpleTextExtractionStrategy())

      val text = strategy.getResultantText()
      println(text)
      val p = doc.createParagraph()

      val run = p.createRun()
      run.setText(text)
      run.addBreak(BreakType.PAGE)
    }
  /*  val wordFile = "/Users/thirupathi.c/Downloads/Thiru/pdf/pdfword.docx"
    val out = new FileOutputStream(wordFile)
    doc.write(out)*/

  }

  def convertPdfToWord(pdfFilePath: String, wordFilePath: String) = {
    val command = "/Users/thirupathi.c/Downloads/Thiru/ScalaSparkDemo/src/main/resources/pdfconverter/pdfconvert.exe " +
      "/cs 10000 /i " + pdfFilePath + " /o " + wordFilePath + " /pwo 2"

    val permissionCmd = "chmod u+x /Users/thirupathi.c/Downloads/Thiru/ScalaSparkDemo/src/main/resources/pdfconverter/pdfconvert.exe"
    println("..... starting conversion ............")
    val process: Runtime = Runtime.getRuntime()
    //val exePermission = process.exec(permissionCmd)
    val pdfToWord = process.exec(command)
    println("..... completed conversion ............")
  }


}
