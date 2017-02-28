package shindo.Java.jxl;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class StudentTest {
    public static void main(String[] args) throws IOException, RowsExceededException, WriteException, BiffException {

        // 1、创建WritableWorkbook对象
        File file = new File("E:/studentTest.xls");
        WritableWorkbook oWritableBK = Workbook.createWorkbook(file);

        // 2、创建WritableSheet对象
        WritableSheet oWritableSheet = oWritableBK.createSheet("sheet1", 0);

        // 3、添加单元格
//        WritableFont fmtx2TotalCaption = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD,
//                false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK);
//        WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        WritableFont wf_t = new WritableFont(WritableFont.ARIAL, 16, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
//        WritableCellFormat wcfF = new WritableCellFormat(wf);
        WritableCellFormat wcfF_t = new WritableCellFormat(wf_t);

        oWritableSheet.setRowView(0, 525);// 第 0行的高度
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        Label label00 = new Label(0, 0, "学生成绩单", wcfF_t);// 列，行
        oWritableSheet.addCell(label00);// 4、 合并单元格
        oWritableSheet.mergeCells(0, 0, 8, 0);// 参数说明，前两个参数为待合并的起始单元格位置，后两个参数用来指定结束单元格位置（列和行）

        oWritableSheet.setRowView(1, 360);// 第 1行的高度
        oWritableSheet.setColumnView(0, 10);// 第 0列的宽度
        oWritableSheet.setColumnView(3, 10);// 第 3列的宽度
        oWritableSheet.setColumnView(6, 10);// 第 6列的宽度
        oWritableSheet.setColumnView(8, 16);// 第 6列的宽度

        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        Label label = new Label(0, 1, "学       院", wcfF_t);
        oWritableSheet.addCell(label);

        oWritableSheet.mergeCells(1, 1, 2, 1);
        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(1, 1, "信息学院", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(3, 1, "专        业", wcfF_t);
        oWritableSheet.addCell(label);

        oWritableSheet.mergeCells(4, 1, 5, 1);
        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(4, 1, "计算机科学与技术", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(6, 1, "性        别", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(7, 1, "男", wcfF_t);
        oWritableSheet.addCell(label);

        // --------------第二行--------------

        oWritableSheet.setRowView(2, 360);// 第2行的高度
        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(0, 2, "姓       名", wcfF_t);
        oWritableSheet.addCell(label);

        oWritableSheet.mergeCells(1, 2, 2, 2);
        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(1, 2, "", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(3, 2, "学        号", wcfF_t);
        oWritableSheet.addCell(label);

        oWritableSheet.mergeCells(4, 2, 5, 2);
        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(4, 2, "", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(6, 2, "民        族", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(7, 2, "", wcfF_t);
        oWritableSheet.addCell(label);

        // --------------第三行--------------

        oWritableSheet.setRowView(3, 360);// 第4行的高度
        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(0, 3, "入学时间", wcfF_t);
        oWritableSheet.addCell(label);

        oWritableSheet.mergeCells(1, 3, 2, 3);
        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(1, 3, "", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(3, 3, "毕业时间", wcfF_t);
        oWritableSheet.addCell(label);

        oWritableSheet.mergeCells(4, 3, 5, 3);
        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(4, 3, "", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(6, 3, "学        制", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(7, 3, "", wcfF_t);
        oWritableSheet.addCell(label);

        // --------------第四行--------------
        oWritableSheet.setRowView(4, 360);// 第4行的高度
        wf_t = new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(0, 4, "函授站全称", wcfF_t);
        oWritableSheet.addCell(label);

        oWritableSheet.mergeCells(1, 4, 2, 4);
        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(1, 4, "", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(3, 4, "身份证号", wcfF_t);
        oWritableSheet.addCell(label);

        oWritableSheet.mergeCells(4, 4, 5, 4);
        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(4, 4, "", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(6, 4, "政治面貌", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(7, 4, "", wcfF_t);
        oWritableSheet.addCell(label);

        // --------------第五行--------------

        oWritableSheet.setRowView(5, 360);// 第4行的高度
        wf_t = new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(0, 5, "总  学  分", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(1, 5, "", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(2, 5, "必修学分", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(3, 5, "", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(4, 5, "专    选", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(5, 5, "", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(6, 5, "毕业设计", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(7, 5, "", wcfF_t);
        oWritableSheet.addCell(label);

        oWritableSheet.mergeCells(8, 1, 8, 5);
        wf_t = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(8, 1, "照片", wcfF_t);
        oWritableSheet.addCell(label);

        // --------------第六行--------------

        Label label68 = new Label(8, 6, "成绩");
        oWritableSheet.addCell(label68);

        oWritableSheet.setRowView(6, 360);// 第4行的高度
        wf_t = new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(0, 6, "学年学期", wcfF_t);
        oWritableSheet.addCell(label);

        oWritableSheet.mergeCells(1, 6, 2, 6);
        wf_t = new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(1, 6, "课程名称", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(3, 6, "性质", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(4, 6, "计划课时", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(5, 6, "讲授学时", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(6, 6, "自学学时", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(7, 6, "学分", wcfF_t);
        oWritableSheet.addCell(label);

        wf_t = new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        wcfF_t = new WritableCellFormat(wf_t);
        wcfF_t.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
        wcfF_t.setAlignment(Alignment.CENTRE);
        wcfF_t.setVerticalAlignment(VerticalAlignment.CENTRE);
        label = new Label(8, 6, "成绩", wcfF_t);
        oWritableSheet.addCell(label);

        // 4、 合并单元格
//        Label label30 = new Label(3, 1, "我是合并后的单元格！");
//        oWritableSheet.addCell(label30);

        oWritableBK.write();
        oWritableBK.close();
    }
}
