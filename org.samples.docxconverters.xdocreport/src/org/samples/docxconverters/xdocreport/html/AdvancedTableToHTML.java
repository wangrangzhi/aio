package org.samples.docxconverters.xdocreport.html;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class AdvancedTableToHTML {

	public static void main(String[] args) {
		createHTML();
		createHTML();
	}

	private static void createHTML() {
		try {
			long start = System.currentTimeMillis();

			// 1) Load DOCX into XWPFDocument
			InputStream is = new FileInputStream(new File(
					"docx/AdvancedTable.docx"));
			XWPFDocument document = new XWPFDocument(is);

			// 2) Prepare Html options
			XHTMLOptions options = XHTMLOptions.create();

			// 3) Convert XWPFDocument to HTML
			OutputStream out = new FileOutputStream(new File(
					"html/AdvancedTable.html"));
			XHTMLConverter.getInstance().convert(document, out, options);

			System.err.println("Generate html/AdvancedTable.html with "
					+ (System.currentTimeMillis() - start) + "ms");

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
