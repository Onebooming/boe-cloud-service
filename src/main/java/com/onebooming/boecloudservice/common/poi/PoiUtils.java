package com.onebooming.boecloudservice.common.poi;

import com.onebooming.boecloudservice.bean.VMachine;
import com.onebooming.boecloudservice.common.DateConverter;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 * @author Onebooming
 */
public class PoiUtils {

    public static ResponseEntity<byte[]> exportEmp2Excel(List<VMachine> vMachines) {
        HttpHeaders headers = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建Excel文档
            HSSFWorkbook workbook = new HSSFWorkbook();
            //2.创建文档摘要
            workbook.createInformationProperties();
            //3.获取文档信息，并配置
            DocumentSummaryInformation dsi = workbook.getDocumentSummaryInformation();
            //3.1文档类别
            dsi.setCategory("虚拟机信息");
            //3.2设置文档管理员
            dsi.setManager("Onebooming");
            //3.3设置组织机构
            dsi.setCompany("京东方科技集团股份有限公司");
            //4.获取摘要信息并配置
            SummaryInformation si = workbook.getSummaryInformation();
            //4.1设置文档主题
            si.setSubject("虚拟机信息表");
            //4.2.设置文档标题
            si.setTitle("虚拟机信息总表");
            //4.3 设置文档作者
            si.setAuthor("XXX集团");
            //4.4设置文档备注
            si.setComments("备注信息暂无");
            //创建Excel表单
            HSSFSheet sheet = workbook.createSheet("云服务本部虚拟机信息信息表");
            //创建日期显示格式
            HSSFCellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
            //创建标题的显示样式
            HSSFCellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //定义列的宽度
            sheet.setColumnWidth(0, 5 * 256);
            sheet.setColumnWidth(1, 12 * 256);
            sheet.setColumnWidth(2, 10 * 256);
            sheet.setColumnWidth(3, 5 * 256);
            sheet.setColumnWidth(4, 12 * 256);
            sheet.setColumnWidth(5, 20 * 256);
            sheet.setColumnWidth(6, 10 * 256);
            sheet.setColumnWidth(7, 10 * 256);
            sheet.setColumnWidth(8, 16 * 256);
            sheet.setColumnWidth(9, 12 * 256);
            sheet.setColumnWidth(10, 15 * 256);
            sheet.setColumnWidth(11, 20 * 256);
            sheet.setColumnWidth(12, 16 * 256);
            sheet.setColumnWidth(13, 14 * 256);
            sheet.setColumnWidth(14, 14 * 256);
            sheet.setColumnWidth(15, 12 * 256);
            sheet.setColumnWidth(16, 8 * 256);
            sheet.setColumnWidth(17, 16 * 256);
            sheet.setColumnWidth(18, 20 * 256);
            sheet.setColumnWidth(19, 12 * 256);
            sheet.setColumnWidth(20, 8 * 256);
            sheet.setColumnWidth(21, 25 * 256);
            sheet.setColumnWidth(22, 14 * 256);
            sheet.setColumnWidth(23, 12 * 256);
            sheet.setColumnWidth(24, 12 * 256);
            //5.设置表头
            HSSFRow headerRow = sheet.createRow(0);
            HSSFCell cell0 = headerRow.createCell(0);
            cell0.setCellValue("编号");
            cell0.setCellStyle(headerStyle);
            HSSFCell cell1 = headerRow.createCell(1);
            cell1.setCellValue("虚拟机名");
            cell1.setCellStyle(headerStyle);
            HSSFCell cell2 = headerRow.createCell(2);
            cell2.setCellValue("业务IP");
            cell2.setCellStyle(headerStyle);
            HSSFCell cell3 = headerRow.createCell(3);
            cell3.setCellValue("创建时间");
            cell3.setCellStyle(headerStyle);
            HSSFCell cell4 = headerRow.createCell(4);
            cell4.setCellValue("UUID");
            cell4.setCellStyle(headerStyle);
            HSSFCell cell5 = headerRow.createCell(5);
            cell5.setCellValue("CPU核数");
            cell5.setCellStyle(headerStyle);
            HSSFCell cell6 = headerRow.createCell(6);
            cell6.setCellValue("内存");
            cell6.setCellStyle(headerStyle);
            HSSFCell cell7 = headerRow.createCell(7);
            cell7.setCellValue("存储容量");
            cell7.setCellStyle(headerStyle);
            HSSFCell cell8 = headerRow.createCell(8);
            cell8.setCellValue("网络适配器");
            cell8.setCellStyle(headerStyle);
            HSSFCell cell9 = headerRow.createCell(9);
            cell9.setCellValue("使用者");
            cell9.setCellStyle(headerStyle);
            HSSFCell cell10 = headerRow.createCell(10);
            cell10.setCellValue("用户邮箱");
            cell10.setCellStyle(headerStyle);
            HSSFCell cell11 = headerRow.createCell(11);
            cell11.setCellValue("电话");
            cell11.setCellStyle(headerStyle);
            HSSFCell cell12 = headerRow.createCell(12);
            cell12.setCellValue("所属部门");
            cell12.setCellStyle(headerStyle);
            HSSFCell cell13 = headerRow.createCell(13);
            cell13.setCellValue("职位");
            cell13.setCellStyle(headerStyle);
            HSSFCell cell14 = headerRow.createCell(14);
            cell14.setCellValue("主要业务");
            cell14.setCellStyle(headerStyle);
            HSSFCell cell15 = headerRow.createCell(15);
            cell15.setCellValue("费用");
            cell15.setCellStyle(headerStyle);
            HSSFCell cell16 = headerRow.createCell(16);
            cell16.setCellValue("租赁形式");
            cell16.setCellStyle(headerStyle);
            HSSFCell cell17 = headerRow.createCell(17);
            cell17.setCellValue("CPU用量");
            cell17.setCellStyle(headerStyle);
            HSSFCell cell18 = headerRow.createCell(18);
            cell18.setCellValue("内存用量");
            cell18.setCellStyle(headerStyle);
            HSSFCell cell19 = headerRow.createCell(19);
            cell19.setCellValue("存储用量");
            cell19.setCellStyle(headerStyle);
            HSSFCell cell20 = headerRow.createCell(20);
            cell20.setCellValue("开始工作时间");
            cell20.setCellStyle(headerStyle);
            HSSFCell cell21 = headerRow.createCell(21);
            cell21.setCellValue("工作状态");
            cell21.setCellStyle(headerStyle);
            HSSFCell cell22 = headerRow.createCell(22);
            cell22.setCellValue("管理员");
            cell22.setCellStyle(headerStyle);
            HSSFCell cell23 = headerRow.createCell(23);
            cell23.setCellValue("操作系统版本");
            cell23.setCellStyle(headerStyle);
            HSSFCell cell24 = headerRow.createCell(24);
            cell24.setCellValue("修改时间");
            cell24.setCellStyle(headerStyle);
            HSSFCell cell25 = headerRow.createCell(24);
            cell25.setCellValue("故障时间");
            cell25.setCellStyle(headerStyle);
            HSSFCell cell26 = headerRow.createCell(24);
            cell26.setCellValue("物理主机IP");
            cell26.setCellStyle(headerStyle);
            //6.装数据
            for (int i = 0; i < vMachines.size(); i++) {
                HSSFRow row = sheet.createRow(i + 1);
                VMachine vMachine = vMachines.get(i);
                row.createCell(0).setCellValue(vMachine.getId());
                row.createCell(1).setCellValue(vMachine.getName());
                row.createCell(2).setCellValue(vMachine.getIp());
                //时间单元格格式
                HSSFCell createDate = row.createCell(3);
                createDate.setCellValue(vMachine.getCreateDate());
                createDate.setCellStyle(dateCellStyle);

                row.createCell(4).setCellValue(vMachine.getUuid());
                row.createCell(5).setCellValue(vMachine.getCpu());
                row.createCell(6).setCellValue(vMachine.getMemory());
                row.createCell(7).setCellValue(vMachine.getStorage());
                row.createCell(8).setCellValue(vMachine.getNetworkAdapter());
                row.createCell(9).setCellValue(vMachine.getOwnner());
                row.createCell(10).setCellValue(vMachine.getEmail());
                row.createCell(11).setCellValue(vMachine.getPhoneNum());
                row.createCell(12).setCellValue(vMachine.getDepartment());
                row.createCell(13).setCellValue(vMachine.getJob());
                row.createCell(14).setCellValue(vMachine.getDuty());
                row.createCell(15).setCellValue(vMachine.getFee());
                row.createCell(16).setCellValue(vMachine.getUseForm());
                row.createCell(17).setCellValue(vMachine.getCpuDosage());
                row.createCell(18).setCellValue(vMachine.getMemoryDosage());
                row.createCell(19).setCellValue(vMachine.getStorage());
                HSSFCell beginDateCell = row.createCell(20);
                beginDateCell.setCellValue(vMachine.getBeginWorkDate());
                beginDateCell.setCellStyle(dateCellStyle);
                row.createCell(21).setCellValue(vMachine.getWorkState());
                row.createCell(22).setCellValue(vMachine.getSupervisor());
                row.createCell(23).setCellValue(vMachine.getOsVersion());

                HSSFCell beFormDate = row.createCell(24);
                beginDateCell.setCellValue(vMachine.getBeFormDate());
                beginDateCell.setCellStyle(dateCellStyle);

                HSSFCell notworkDate = row.createCell(25);
                beginDateCell.setCellValue(vMachine.getNotWorkDate());
                beginDateCell.setCellStyle(dateCellStyle);

                row.createCell(26).setCellValue(vMachine.getServerHostIp());
            }
            headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment",
                    new String("员工表.xls".getBytes("UTF-8"), "iso-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            baos = new ByteArrayOutputStream();
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }

    public static List<VMachine> importEmp2List(MultipartFile file) {
        DateConverter dateConverter = new DateConverter();
        List<VMachine> vMachines = new ArrayList<>();
        try {
            HSSFWorkbook workbook =
                    new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                HSSFSheet sheet = workbook.getSheetAt(i);
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                VMachine vMachine;
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    if (j == 0) {
                        continue;//标题行
                    }
                    HSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue;//没数据
                    }
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    vMachine = new VMachine();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        HSSFCell cell = row.getCell(k);
                        switch (cell.getCellTypeEnum()) {
                            case STRING: {
                                String cellValue = cell.getStringCellValue();
                                if (cellValue == null) {
                                    cellValue = "";
                                }
                                switch (k) {
                                    case 1:
                                        vMachine.setName(cellValue);
                                        break;
                                    case 2:
                                        vMachine.setIp(cellValue);
                                        break;

                                    case 4:
                                        vMachine.setUuid(cellValue);
                                        break;

                                    case 8:
                                        vMachine.setNetworkAdapter(cellValue);
                                        break;
                                    case 9:
                                        vMachine.setOwnner(cellValue);
                                        break;
                                    case 10:
                                        vMachine.setEmail(cellValue);
                                        break;
                                    case 11:
                                        vMachine.setPhoneNum(Long.valueOf(cellValue));
                                        break;
                                    case 12:
                                        vMachine.setDepartment(cellValue);
                                        break;
                                    case 13:
                                        vMachine.setJob(cellValue);
                                        break;
                                    case 14:
                                        vMachine.setDuty(cellValue);
                                        break;
                                    case 15:
                                        vMachine.setFee(Double.valueOf(cellValue));
                                        break;
                                    case 16:
                                        vMachine.setUseForm(cellValue);
                                        break;
                                    case 17:
                                        vMachine.setCpuDosage(Float.valueOf(cellValue));
                                        break;
                                    case 18:
                                        vMachine.setMemoryDosage(Float.valueOf(cellValue));
                                        break;
                                    case 19:
                                        vMachine.setStorageDosage(Float.valueOf(cellValue));
                                        break;

                                    case 21:
                                        vMachine.setWorkState(cellValue);
                                        break;
                                    case 22:
                                        vMachine.setSupervisor(cellValue);
                                        break;
                                    case 23:
                                        vMachine.setOsVersion(cellValue);
                                        break;

                                    case 26:
                                        vMachine.setServerHostIp(cellValue);
                                        break;
                                }
                            }
                            break;
                            default: {

                                switch (k) {
                                    case 3:
                                        vMachine.setCreateDate(cell.getDateCellValue());
                                        break;
                                    case 20:
                                        vMachine.setBeginWorkDate(cell.getDateCellValue());
                                        break;
                                    case 24:
                                        vMachine.setBeFormDate(cell.getDateCellValue());
                                        break;
                                    case 25:
                                        vMachine.setNotWorkDate(cell.getDateCellValue());
                                        break;
                                }
                            }
                            break;
                        }
                    }
                    vMachines.add(vMachine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vMachines;
    }

    public static List<VMachine> importVMachineList(File file) throws Exception {
        List<VMachine> vMachines = new ArrayList<>();
        DateConverter dateConverter = new DateConverter();
        // 创建输入流，读取Excel
        InputStream is = new FileInputStream(file.getAbsolutePath());
        // jxl提供的Workbook类
        Workbook wb = Workbook.getWorkbook(is);
        // 只有一个sheet,直接处理
        //创建一个Sheet对象
        Sheet sheet = wb.getSheet(0);
        // 得到所有的行数
        int rows = sheet.getRows();

        // 越过第一行 它是列名称 j = 1
        for (int j = 1; j < rows; j++) {

            VMachine vMachine = new VMachine();
            Cell[] cells = sheet.getRow(j);
            for (int k = 0; k < cells.length; k++) {
                Cell cell = cells[k];
                switch (k) {
                    case 1:
                        vMachine.setName(cells[k].getContents().trim());
                        break;
                    case 2:
                        vMachine.setIp(cells[k].getContents().trim());
                        break;
                    case 3:
                        vMachine.setCreateDate(dateConverter.convert(cells[k].getContents().trim()));
                        break;
                    case 4:
                        vMachine.setUuid(cells[k].getContents().trim());
                        break;
                    case 5:
                        vMachine.setCpu(Integer.valueOf(cells[k].getContents().trim()));
                        break;
                    case 6:
                        vMachine.setMemory(Integer.valueOf(cells[k].getContents().trim()));
                        break;
                    case 7:
                        vMachine.setStorage(Integer.valueOf(cells[k].getContents().trim()));
                        break;
                    case 8:
                        vMachine.setNetworkAdapter(cells[k].getContents().trim());
                        break;
                    case 9:
                        vMachine.setOwnner(cells[k].getContents().trim());
                        break;
                    case 10:
                        vMachine.setEmail(cells[k].getContents().trim());
                        break;
                    case 11:
                        vMachine.setPhoneNum(Long.valueOf(cells[k].getContents().trim()));
                        break;
                    case 12:
                        vMachine.setDepartment(cells[k].getContents().trim());
                        break;
                    case 13:
                        vMachine.setJob(cells[k].getContents().trim());
                        break;
                    case 14:
                        vMachine.setDuty(cells[k].getContents().trim());
                        break;
                    case 15:
                        vMachine.setFee(Double.valueOf(cells[k].getContents().trim()));
                        break;
                    case 16:
                        vMachine.setUseForm(cells[k].getContents().trim());
                        break;
                    case 17:
                        vMachine.setCpuDosage(Float.valueOf(cells[k].getContents().trim()));
                        break;
                    case 18:
                        vMachine.setMemoryDosage(Float.valueOf(cells[k].getContents().trim()));
                        break;
                    case 19:
                        vMachine.setStorageDosage(Float.valueOf(cells[k].getContents().trim()));
                        break;
                    case 20:
                        vMachine.setBeginWorkDate(dateConverter.convert(cells[k].getContents().trim()));
                        break;
                    case 21:
                        vMachine.setWorkState(cells[k].getContents().trim());
                        break;
                    case 22:
                        vMachine.setSupervisor(cells[k].getContents().trim());
                        break;
                    case 23:
                        vMachine.setOsVersion(cells[k].getContents().trim());
                        break;
                    case 24:
                        vMachine.setBeFormDate(dateConverter.convert(cells[k].getContents().trim()));
                        break;
                    case 25:
                        vMachine.setNotWorkDate(dateConverter.convert(cells[k].getContents().trim()));
                        break;
                    case 26:
                        vMachine.setServerHostIp(cells[k].getContents().trim());
                        break;
                    case 27:
                        vMachine.setNotice(cells[k].getContents().trim());
                        break;
                    case 28:
                        vMachine.setRunDuration(Double.valueOf(cells[k].getContents().trim()));
                        break;
                    default:
                        break;
                }
            }
            vMachines.add(vMachine);
        }
        return vMachines;
}
}
