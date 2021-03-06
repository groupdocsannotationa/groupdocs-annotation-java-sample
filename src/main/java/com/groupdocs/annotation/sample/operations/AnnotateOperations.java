package com.groupdocs.annotation.sample.operations;

import com.groupdocs.annotation.domain.*;
import com.groupdocs.annotation.domain.config.AnnotationConfig;
import com.groupdocs.annotation.handler.AnnotationImageHandler;
import com.groupdocs.annotation.sample.Utilities;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Aleksey Permyakov (16.09.2016)
 */
public class AnnotateOperations {

    public static void creatingTextAnnotation(AnnotationConfig cfg, String storagePath, String fileName) throws Exception {

        Utilities.cleanStorage();

        cfg.setStoragePath(storagePath);
        AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);

        annotator.getDocumentDataHandler();

        if(!new File(cfg.getStoragePath()).exists() && !new File(cfg.getStoragePath()).mkdirs())
        {
            System.out.println("Can't create directory!");
        }

        InputStream cleanPdf = new FileInputStream(storagePath + File.separator + fileName);
        List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();

        // Text annotation.
        AnnotationInfo textAnnotation = new AnnotationInfo();
        textAnnotation.setBox(new Rectangle(68, 154, 102, 9));
        textAnnotation.setPageNumber(0);
        textAnnotation.setSvgPath("[{\"x\":68.7886,\"y\":687.5769},{\"x\":170.8186,\"y\":687.5769},{\"x\":68.7886,\"y\":678.5769},{\"x\":170.8186,\"y\":678.5769}]");
        textAnnotation.setType(AnnotationType.Text);
        textAnnotation.setCreatorName("Anonym A.");

        annotations.add(textAnnotation);

        // add annotation to the document
        InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);

        // Save result stream to file.
        OutputStream fileStream = new FileOutputStream(Utilities.OUTPUT_PATH + File.separator + "annotated-text.pdf");
        IOUtils.copy(result, fileStream);
    }

    public static void creatingAreaAnnnotation(AnnotationConfig cfg, String storagePath, String fileName) throws Exception {
        Utilities.cleanStorage();

        cfg.setStoragePath(storagePath);
        AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);

        annotator.getDocumentDataHandler();

        if(!new File(cfg.getStoragePath()).exists() && !new File(cfg.getStoragePath()).mkdirs())
        {
            System.out.println("Can't create directory!");
        }

        InputStream cleanPdf = new FileInputStream(storagePath + File.separator + fileName);
        List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();

        // Area annotation with 2 replies
        AnnotationInfo areaAnnnotation = new AnnotationInfo();
        areaAnnnotation.setAnnotationPosition(new Point(852.0, 59.0));
        final AnnotationReplyInfo[] annotationReplyInfos = {
                new AnnotationReplyInfo() {
                    {
                        setMessage("Hello!");
                        setRepliedOn(Calendar.getInstance().getTime());
                        setUserName("John");
                    }
                },
                new AnnotationReplyInfo() {
                    {
                        setMessage("Hi!");
                        setRepliedOn(Calendar.getInstance().getTime());
                        setUserName("Judy");
                    }
                }};
        areaAnnnotation.setReplies(annotationReplyInfos);
        areaAnnnotation.setBackgroundColor(11111111);
        areaAnnnotation.setBox(new Rectangle(300f, 200f, 88f, 37f));
        areaAnnnotation.setPageNumber(0);
        areaAnnnotation.setPenColor(2222222);
        areaAnnnotation.setPenStyle((byte) 1);
        areaAnnnotation.setPenWidth((byte) 1);
        areaAnnnotation.setType(AnnotationType.Area);
        areaAnnnotation.setCreatorName("Anonym A.");

        annotations.add(areaAnnnotation);

        // add annotation to the document
        InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);

        // Save result stream to file.
        OutputStream fileStream = new FileOutputStream(Utilities.OUTPUT_PATH + File.separator + "annotated-area.pdf");
        IOUtils.copy(result, fileStream);
    }

    public static void creatingPointAnnotation(AnnotationConfig cfg, String storagePath, String fileName) throws Exception {
        Utilities.cleanStorage();

        cfg.setStoragePath(storagePath);
        AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);

        annotator.getDocumentDataHandler();

        if(!new File(cfg.getStoragePath()).exists() && !new File(cfg.getStoragePath()).mkdirs())
        {
            System.out.println("Can't create directory!");
        }

        InputStream cleanPdf = new FileInputStream(storagePath + File.separator + fileName);
        List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();

        // Point annotation
        AnnotationInfo pointAnnotation = new AnnotationInfo();
        pointAnnotation.setAnnotationPosition(new Point(852.0, 81.0));
        pointAnnotation.setBox(new Rectangle(212f, 81f, 35f, 0.0f));
        pointAnnotation.setPageNumber(0);
        pointAnnotation.setType(AnnotationType.Point);
        pointAnnotation.setCreatorName("Anonym A.");

        annotations.add(pointAnnotation);

        // add annotation to the document
        InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);

        // Save result stream to file.
        OutputStream fileStream = new FileOutputStream(Utilities.OUTPUT_PATH + File.separator + "annotated-point.pdf");
        IOUtils.copy(result, fileStream);
    }

    public static void creatingStrikeoutAnnotation(AnnotationConfig cfg, String storagePath, String fileName) throws Exception {
        Utilities.cleanStorage();

        cfg.setStoragePath(storagePath);
        AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);

        annotator.getDocumentDataHandler();

        if(!new File(cfg.getStoragePath()).exists() && !new File(cfg.getStoragePath()).mkdirs())
        {
            System.out.println("Can't create directory!");
        }

        InputStream cleanPdf = new FileInputStream(storagePath + File.separator + fileName);
        List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();

        // Text strikeout annotation
        AnnotationInfo strikeoutAnnotation = new AnnotationInfo();
        strikeoutAnnotation.setAnnotationPosition(new Point(852.0, 154.31));
        strikeoutAnnotation.setBox(new Rectangle(173f, 154f, 142f, 9f));
        strikeoutAnnotation.setPageNumber(0);
        strikeoutAnnotation.setPenColor(0);
        strikeoutAnnotation.setSvgPath("[{\"x\":173.2986,\"y\":687.5769},{\"x\":315.79859999999996,\"y\":687.5769},{\"x\":173.2986,\"y\":678.5769},{\"x\":315.79859999999996,\"y\":678.5769}]");
        strikeoutAnnotation.setType(AnnotationType.TextStrikeout);
        strikeoutAnnotation.setCreatorName("Anonym A.");

        annotations.add(strikeoutAnnotation);

        // add annotation to the document
        InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);

        // Save result stream to file.
        OutputStream fileStream = new FileOutputStream(Utilities.OUTPUT_PATH + File.separator + "annotated-strikeout.pdf");
        IOUtils.copy(result, fileStream);
    }

    public static void creatingPolylineAnnotation(AnnotationConfig cfg, String storagePath, String fileName) throws Exception {
        Utilities.cleanStorage();

        cfg.setStoragePath(storagePath);
        AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);

        annotator.getDocumentDataHandler();

        if(!new File(cfg.getStoragePath()).exists() && !new File(cfg.getStoragePath()).mkdirs())
        {
            System.out.println("Can't create directory!");
        }

        InputStream cleanPdf = new FileInputStream(storagePath + File.separator + fileName);
        List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();

        // Polyline annotation
        AnnotationInfo polylineAnnotation = new AnnotationInfo();
        polylineAnnotation.setAnnotationPosition(new Point(852.0, 35.0));
        polylineAnnotation.setBox(new Rectangle(250f, 35f, 102f, 12f));
        polylineAnnotation.setPageNumber(0);
        polylineAnnotation.setPenColor(1201033);
        polylineAnnotation.setPenWidth((byte) 2);
        polylineAnnotation.setSvgPath("M250.8280751173709,48.209295774647885l0.6986854460093896,0l0.6986854460093896,-1.3973708920187793l0.6986854460093896,0l0.6986854460093896,-1.3973708920187793l1.3973708920187793,-0.6986854460093896l0.6986854460093896,-0.6986854460093896l0.6986854460093896,0l2.096056338028169,-1.3973708920187793l3.493427230046948,-1.3973708920187793l0.6986854460093896,-0.6986854460093896l1.3973708920187793,-1.3973708920187793l0.6986854460093896,0l1.3973708920187793,-0.6986854460093896l0.6986854460093896,0l0.6986854460093896,-0.6986854460093896l0.6986854460093896,0l0.6986854460093896,0l0,-0.6986854460093896l0.6986854460093896,0l0.6986854460093896,0l1.3973708920187793,0l0,-0.6986854460093896l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l2.096056338028169,-0.6986854460093896l1.3973708920187793,0l0.6986854460093896,0l0.6986854460093896,0l1.3973708920187793,0l1.3973708920187793,0l1.3973708920187793,0l2.096056338028169,0l5.589483568075117,0l1.3973708920187793,0l2.096056338028169,0l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l1.3973708920187793,0l1.3973708920187793,0l0.6986854460093896,0.6986854460093896l1.3973708920187793,0l2.096056338028169,1.3973708920187793l0.6986854460093896,0l0.6986854460093896,0l0,0.6986854460093896l1.3973708920187793,0l0.6986854460093896,0.6986854460093896l1.3973708920187793,0.6986854460093896l0,0.6986854460093896l0.6986854460093896,0l1.3973708920187793,0.6986854460093896l1.3973708920187793,0.6986854460093896l3.493427230046948,0.6986854460093896l1.3973708920187793,0.6986854460093896l2.096056338028169,0.6986854460093896l1.3973708920187793,0.6986854460093896l1.3973708920187793,0l1.3973708920187793,0.6986854460093896l0.6986854460093896,0l0.6986854460093896,0.6986854460093896l1.3973708920187793,0l0.6986854460093896,0l0.6986854460093896,0l2.7947417840375586,0l1.3973708920187793,0l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l2.7947417840375586,0l0.6986854460093896,0l2.7947417840375586,0l1.3973708920187793,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,-0.6986854460093896l0.6986854460093896,0");
        polylineAnnotation.setType(AnnotationType.Polyline);
        polylineAnnotation.setCreatorName("Anonym A.");

        annotations.add(polylineAnnotation);

        // add annotation to the document
        InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);

        // Save result stream to file.
        OutputStream fileStream = new FileOutputStream(Utilities.OUTPUT_PATH + File.separator + "annotated-polyline.pdf");
        IOUtils.copy(result, fileStream);
    }

    public static void creatingTextFieldAnnotation(AnnotationConfig cfg, String storagePath, String fileName) throws Exception {
        Utilities.cleanStorage();

        cfg.setStoragePath(storagePath);
        AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);

        annotator.getDocumentDataHandler();

        if(!new File(cfg.getStoragePath()).exists() && !new File(cfg.getStoragePath()).mkdirs())
        {
            System.out.println("Can't create directory!");
        }

        InputStream cleanPdf = new FileInputStream(storagePath + File.separator + fileName);
        List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();

        // Text field annotation
        AnnotationInfo textFieldAnnotation = new AnnotationInfo();
        textFieldAnnotation.setAnnotationPosition(new Point(852.0, 201.0));
        textFieldAnnotation.setFieldText("text in the box");
        textFieldAnnotation.setFontFamily("Arial");
        textFieldAnnotation.setFontSize(10);
        textFieldAnnotation.setBox(new Rectangle(66f, 201f, 64f, 37f));
        textFieldAnnotation.setPageNumber(0);
        textFieldAnnotation.setType(AnnotationType.TextField);
        textFieldAnnotation.setCreatorName("Anonym A.");

        annotations.add(textFieldAnnotation);

        // add annotation to the document
        InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);

        // Save result stream to file.
        OutputStream fileStream = new FileOutputStream(Utilities.OUTPUT_PATH + File.separator + "annotated-textfield.pdf");
        IOUtils.copy(result, fileStream);
    }

    public static void creatingWatermarkAnnotation(AnnotationConfig cfg, String storagePath, String fileName) throws Exception {
        Utilities.cleanStorage();

        cfg.setStoragePath(storagePath);
        AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);

        annotator.getDocumentDataHandler();

        if(!new File(cfg.getStoragePath()).exists() && !new File(cfg.getStoragePath()).mkdirs())
        {
            System.out.println("Can't create directory!");
        }

        InputStream cleanPdf = new FileInputStream(storagePath + File.separator + fileName);
        List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();

        // Watermark annotation
        AnnotationInfo watermarkAnnotation = new AnnotationInfo();
        watermarkAnnotation.setAnnotationPosition(new Point(852.0, 300.0));
        watermarkAnnotation.setFieldText("TEXT STAMP");
        watermarkAnnotation.setFontFamily("Microsoft Sans Serif");
        watermarkAnnotation.setFontSize(10);
        watermarkAnnotation.setFontColor(2222222);
        watermarkAnnotation.setBox(new Rectangle(430f, 272f, 66f, 51f));
        watermarkAnnotation.setPageNumber(0);
        watermarkAnnotation.setType(AnnotationType.TextField);
        watermarkAnnotation.setCreatorName("Anonym A.");

        annotations.add(watermarkAnnotation);

        // add annotation to the document
        InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);

        // Save result stream to file.
        OutputStream fileStream = new FileOutputStream(Utilities.OUTPUT_PATH + File.separator + "annotated-watermark.pdf");
        IOUtils.copy(result, fileStream);
    }

    public static void creatingTextReplacementAnnotation(AnnotationConfig cfg, String storagePath, String fileName) throws Exception {
        Utilities.cleanStorage();

        cfg.setStoragePath(storagePath);
        AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);

        annotator.getDocumentDataHandler();

        if(!new File(cfg.getStoragePath()).exists() && !new File(cfg.getStoragePath()).mkdirs())
        {
            System.out.println("Can't create directory!");
        }

        InputStream cleanPdf = new FileInputStream(storagePath + File.separator + fileName);
        List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();

        // Text replacement annotation
        AnnotationInfo textReplacementAnnotation = new AnnotationInfo();
        textReplacementAnnotation.setAnnotationPosition(new Point(852.0, 172.0));
        textReplacementAnnotation.setFieldText("Replaced text");
        textReplacementAnnotation.setFontSize(10);
        textReplacementAnnotation.setBox(new Rectangle(324f, 172f, 127f, 9f));
        textReplacementAnnotation.setSvgPath("[{\"x\":324.0786,\"y\":669.1768999999999},{\"x\":451.8486,\"y\":669.1768999999999},{\"x\":324.0786,\"y\":660.1768999999999},{\"x\":451.8486,\"y\":660.1768999999999}]");
        textReplacementAnnotation.setPageNumber(0);
        textReplacementAnnotation.setType(AnnotationType.TextReplacement);
        textReplacementAnnotation.setCreatorName("Anonym A.");

        annotations.add(textReplacementAnnotation);

        // add annotation to the document
        InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);

        // Save result stream to file.
        OutputStream fileStream = new FileOutputStream(Utilities.OUTPUT_PATH + File.separator + "annotated-textreplacement.pdf");
        IOUtils.copy(result, fileStream);
    }

    public static void creatingArrowAnnotation(AnnotationConfig cfg, String storagePath, String fileName) throws Exception {
        Utilities.cleanStorage();

        cfg.setStoragePath(storagePath);
        AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);

        annotator.getDocumentDataHandler();

        if(!new File(cfg.getStoragePath()).exists() && !new File(cfg.getStoragePath()).mkdirs())
        {
            System.out.println("Can't create directory!");
        }

        InputStream cleanPdf = new FileInputStream(storagePath + File.separator + fileName);
        List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();

        // Arrow annotation
        AnnotationInfo arrowAnnotation = new AnnotationInfo();
        arrowAnnotation.setAnnotationPosition(new Point(852.0, 252.0));
        arrowAnnotation.setBox(new Rectangle(279.4742f, 252.9241f, 129.9555f, -9.781596f));
        arrowAnnotation.setPageNumber(0);
        arrowAnnotation.setPenColor(1201033);
        arrowAnnotation.setPenStyle((byte) 0);
        arrowAnnotation.setPenWidth((byte) 1);
        arrowAnnotation.setSvgPath("M279.47417840375584,252.92413145539905 L129.9554929577465,-9.781596244131455");
        arrowAnnotation.setType(AnnotationType.Arrow);
        arrowAnnotation.setCreatorName("Anonym A.");

        annotations.add(arrowAnnotation);

        // add annotation to the document
        InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);

        // Save result stream to file.
        OutputStream fileStream = new FileOutputStream(Utilities.OUTPUT_PATH + File.separator + "annotated-arrow.pdf");
        IOUtils.copy(result, fileStream);
    }

    public static void creatingTextRedactionAnnotation(AnnotationConfig cfg, String storagePath, String fileName) throws Exception {
        Utilities.cleanStorage();

        cfg.setStoragePath(storagePath);
        AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);

        annotator.getDocumentDataHandler();

        if(!new File(cfg.getStoragePath()).exists() && !new File(cfg.getStoragePath()).mkdirs())
        {
            System.out.println("Can't create directory!");
        }

        InputStream cleanPdf = new FileInputStream(storagePath + File.separator + fileName);
        List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();

        // Text redaction annotation
        AnnotationInfo textRedactionAnnotation = new AnnotationInfo();
        textRedactionAnnotation.setAnnotationPosition(new Point(852.0, 154.0));
        textRedactionAnnotation.setBox(new Rectangle(478f, 154f, 61f, 9f));
        textRedactionAnnotation.setPageNumber(0);
        textRedactionAnnotation.setSvgPath("[{\"x\":478.9186,\"y\":687.5769},{\"x\":540.5786,\"y\":687.5769},{\"x\":478.9186,\"y\":678.5769},{\"x\":540.5786,\"y\":678.5769}]");
        textRedactionAnnotation.setType(AnnotationType.TextRedaction);
        textRedactionAnnotation.setCreatorName("Anonym A.");

        annotations.add(textRedactionAnnotation);

        // add annotation to the document
        InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);

        // Save result stream to file.
        OutputStream fileStream = new FileOutputStream(Utilities.OUTPUT_PATH + File.separator + "annotated-textredaction.pdf");
        IOUtils.copy(result, fileStream);
    }

    public static void creatingResourceRedactionAnnotation(AnnotationConfig cfg, String storagePath, String fileName) throws Exception {
        Utilities.cleanStorage();

        cfg.setStoragePath(storagePath);
        AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);

        annotator.getDocumentDataHandler();

        if(!new File(cfg.getStoragePath()).exists() && !new File(cfg.getStoragePath()).mkdirs())
        {
            System.out.println("Can't create directory!");
        }

        InputStream cleanPdf = new FileInputStream(storagePath + File.separator + fileName);
        List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();

        // Resource redaction annotation
        AnnotationInfo resourceRedactionAnnotation = new AnnotationInfo();
        resourceRedactionAnnotation.setAnnotationPosition(new Point(852.0, 271.78));
        resourceRedactionAnnotation.setBackgroundColor(3355443);
        resourceRedactionAnnotation.setBox(new Rectangle(466f, 271f, 69f, 62f));
        resourceRedactionAnnotation.setPageNumber(0);
        resourceRedactionAnnotation.setPenColor(3355443);
        resourceRedactionAnnotation.setType(AnnotationType.ResourcesRedaction);
        resourceRedactionAnnotation.setCreatorName("Anonym A.");

        annotations.add(resourceRedactionAnnotation);

        // add annotation to the document
        InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);

        // Save result stream to file.
        OutputStream fileStream = new FileOutputStream(Utilities.OUTPUT_PATH + File.separator + "annotated-resourceredaction.pdf");
        IOUtils.copy(result, fileStream);
    }

    public static void creatingUnderlineAnnotation(AnnotationConfig cfg, String storagePath, String fileName) throws Exception {
        Utilities.cleanStorage();

        cfg.setStoragePath(storagePath);
        AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);

        annotator.getDocumentDataHandler();

        if(!new File(cfg.getStoragePath()).exists() && !new File(cfg.getStoragePath()).mkdirs())
        {
            System.out.println("Can't create directory!");
        }

        InputStream cleanPdf = new FileInputStream(storagePath + File.separator + fileName);
        List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();

        // Underline annotation
        AnnotationInfo underlineAnnotation = new AnnotationInfo();
        underlineAnnotation.setAnnotationPosition(new Point(852.0, 154.3131));
        underlineAnnotation.setBox(new Rectangle(90f, 172f, 189f, 9f));
        underlineAnnotation.setPageNumber(0);
        underlineAnnotation.setPenColor(1201033);
        underlineAnnotation.setSvgPath("[{\"x\":90.6586,\"y\":669.1768999999999},{\"x\":280.0886,\"y\":669.1768999999999},{\"x\":90.6586,\"y\":660.1768999999999},{\"x\":280.0886,\"y\":660.1768999999999}]");
        underlineAnnotation.setType(AnnotationType.TextUnderline);
        underlineAnnotation.setCreatorName("Anonym A.");

        annotations.add(underlineAnnotation);

        // add annotation to the document
        InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);

        // Save result stream to file.
        OutputStream fileStream = new FileOutputStream(Utilities.OUTPUT_PATH + File.separator + "annotated-underline.pdf");
        IOUtils.copy(result, fileStream);
    }

    public static void creatingDistanceAnnotation(AnnotationConfig cfg, String storagePath, String fileName) throws Exception {
        Utilities.cleanStorage();

        cfg.setStoragePath(storagePath);
        AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);

        annotator.getDocumentDataHandler();

        if(!new File(cfg.getStoragePath()).exists() && !new File(cfg.getStoragePath()).mkdirs())
        {
            System.out.println("Can't create directory!");
        }

        InputStream cleanPdf = new FileInputStream(storagePath + File.separator + fileName);
        List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();

        // Distance annotation
        AnnotationInfo distanceAnnotation = new AnnotationInfo();
        distanceAnnotation.setAnnotationPosition(new Point(852.0, 287.0));
        distanceAnnotation.setBox(new Rectangle(248f, 287f, 115f, 25f));
        distanceAnnotation.setPageNumber(0);
        distanceAnnotation.setPenColor(1201033);
        distanceAnnotation.setPenStyle((byte) 0);
        distanceAnnotation.setPenWidth((byte) 1);
        distanceAnnotation.setSvgPath("M248.73201877934272,295.5439436619718 l115.28309859154929,-4.192112676056338");
        distanceAnnotation.setFieldText("\r\nAnonym A.: 115px");
        distanceAnnotation.setType(AnnotationType.Distance);
        distanceAnnotation.setCreatorName("Anonym A.");

        annotations.add(distanceAnnotation);

        // add annotation to the document
        InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);

        // Save result stream to file.
        OutputStream fileStream = new FileOutputStream(Utilities.OUTPUT_PATH + File.separator + "annotated-distance.pdf");
        IOUtils.copy(result, fileStream);
    }

    public static void addingAnnotationsToSlidesDocument(AnnotationConfig cfg, String storagePath, String fileName) throws Exception {
        Utilities.cleanStorage();

        cfg.setStoragePath(storagePath);
        AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);

        InputStream inputStream = new FileInputStream(storagePath + File.separator + fileName);
        List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();

        //add annotation to 1st slide to point with coordinates with X=1 and Y=2
        final AnnotationInfo annotationInfo = new AnnotationInfo();
        annotationInfo.setPageNumber(0);
        annotationInfo.setAnnotationPosition(new Point(1, 2));
        annotationInfo.setFieldText("Hello!");
        annotationInfo.setCreatorName("John");
        annotations.add(annotationInfo);

        //Export annotations to Slides document
        InputStream resultStream = annotator.exportAnnotationsToDocument(inputStream, annotations);
        System.out.println(resultStream.available());
        IOUtils.copy(resultStream, new FileOutputStream(Utilities.OUTPUT_PATH + File.separator + "slides-annotated.pptx"));
    }

    public static void addingAnnotationsToCellsDocument(AnnotationConfig cfg, String storagePath, String fileName) throws Exception {
        Utilities.cleanStorage();

        cfg.setStoragePath(storagePath);
        AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);

        InputStream inputStream = new FileInputStream(storagePath + File.separator + fileName);
        List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();

        //add bookmark to 3rd cell in 3rd row on 1st page
        final AnnotationInfo annotationInfo = new AnnotationInfo();
        annotationInfo.setPageNumber(1);
        annotationInfo.setAnnotationPosition(new Point(3, 3));
        annotationInfo.setFieldText("Hello!");

        annotations.add(annotationInfo);

        //Export annotations to Cells document
        InputStream resultStream = annotator.exportAnnotationsToDocument(inputStream, annotations);
        System.out.println(resultStream.available());

        IOUtils.copy(resultStream, new FileOutputStream(Utilities.OUTPUT_PATH + File.separator + "cells-annotated.xlsx"));
    }

    public static void addingAnnotationsToWordDocument(AnnotationConfig cfg, String storagePath, String fileName) throws Exception {

        cfg.setStoragePath(storagePath);
        AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);

        InputStream cleanDoc = new FileInputStream(storagePath + File.separator + fileName);
        List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();

        // init possible types of annotations
        AnnotationInfo textAnnotation = new AnnotationInfo();
        textAnnotation.setPageNumber(1);
        textAnnotation.setSvgPath("[{\"x\":186.698,\"y\":706.196},{\"x\":318.41201,\"y\":706.196},{\"x\":186.698,\"y\":697.196},{\"x\":318.41201,\"y\":697.196}]");
        textAnnotation.setType(AnnotationType.Text);
        textAnnotation.setText("Comment");

        AnnotationInfo areaAnnnotation = new AnnotationInfo();
        areaAnnnotation.setBackgroundColor(11111111);
        areaAnnnotation.setBox(new Rectangle(87.9f, 276.5f, 435.7f, 87f));
        areaAnnnotation.setPageNumber(1);
        areaAnnnotation.setType(AnnotationType.Area);

        AnnotationInfo strikeoutAnnotation = new AnnotationInfo();
        strikeoutAnnotation.setBox(new Rectangle(87.9f, 276.5f, 435.7f, 87f));
        strikeoutAnnotation.setPageNumber(1);
        strikeoutAnnotation.setPenColor(1201033);
        strikeoutAnnotation.setSvgPath("[{\"x\":208.392,\"y\":313.088},{\"x\":519.659,\"y\":313.088},{\"x\":208.392,\"y\":304.088},{\"x\":519.659,\"y\":304.088}]");
        strikeoutAnnotation.setType(AnnotationType.TextStrikeout);

        AnnotationInfo textFieldAnnotation = new AnnotationInfo();
        textFieldAnnotation.setFieldText("text in the box");
        textFieldAnnotation.setFontFamily("Arial");
        textFieldAnnotation.setFontSize(10);
        textFieldAnnotation.setBox(new Rectangle(92f, 73f, 106f, 45f));
        textFieldAnnotation.setPageNumber(1);
        textFieldAnnotation.setType(AnnotationType.TextField);

        AnnotationInfo textReplacementAnnotation = new AnnotationInfo();
        textReplacementAnnotation.setFieldText(" \"REPLACED TEXT\" ");
        textReplacementAnnotation.setFontSize(10);
        textReplacementAnnotation.setSvgPath("[{\"x\":251.224,\"y\":637.20401},{\"x\":327.89,\"y\":637.20401},{\"x\":251.224,\"y\":628.20401},{\"x\":327.89,\"y\":628.20401}]");
        textReplacementAnnotation.setPageNumber(0);
        textReplacementAnnotation.setType(AnnotationType.TextReplacement);

        AnnotationInfo arrowAnnotation = new AnnotationInfo();
        arrowAnnotation.setBox(new Rectangle(479f, 218f, -261f, -89f));
        arrowAnnotation.setPageNumber(1);
        arrowAnnotation.setType(AnnotationType.Arrow);

        AnnotationInfo textRedactionAnnotation = new AnnotationInfo();
        textRedactionAnnotation.setPageNumber(2);
        textRedactionAnnotation.setSvgPath("[{\"x\":72,\"y\":676.07},{\"x\":196.427,\"y\":676.074},{\"x\":72,\"y\":662.674},{\"x\":196.427,\"y\":662.674}]");
        textRedactionAnnotation.setType(AnnotationType.TextRedaction);

        AnnotationInfo resourceRedactionAnnotation = new AnnotationInfo();
        resourceRedactionAnnotation.setBox(new Rectangle(69f, 337f, 449f, 118f));
        resourceRedactionAnnotation.setPageNumber(1);
        resourceRedactionAnnotation.setType(AnnotationType.ResourcesRedaction);

        AnnotationInfo underlineAnnotation = new AnnotationInfo();
        underlineAnnotation.setPageNumber(2);
        underlineAnnotation.setSvgPath("[{\"x\":415.17499,\"y\":628.874},{\"x\":511.85101,\"y\":628.874},{\"x\":415.17499,\"y\":619.874},{\"x\":511.85101,\"y\":619.874}]");
        underlineAnnotation.setType(AnnotationType.TextUnderline);

        annotations.add(textAnnotation);
        annotations.add(areaAnnnotation);
        annotations.add(strikeoutAnnotation);
        annotations.add(textFieldAnnotation);
        annotations.add(textReplacementAnnotation);
        annotations.add(arrowAnnotation);
        annotations.add(textRedactionAnnotation);
        annotations.add(resourceRedactionAnnotation);
        annotations.add(underlineAnnotation);

        // Add annotation to the document
        InputStream result = annotator.exportAnnotationsToDocument(cleanDoc, annotations, DocumentType.Words);

        // Save result stream to file.
        OutputStream fileStream = new FileOutputStream(Utilities.OUTPUT_PATH + File.separator + "words-annotated.docx");
        System.out.println(result.available());
        IOUtils.copy(result, fileStream);
    }
}
