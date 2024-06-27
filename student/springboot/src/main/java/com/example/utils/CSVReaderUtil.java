package com.example.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVReaderUtil {
    public static String readCsvAsString(String csvFilePath) throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            CSVParser parser = CSVFormat.DEFAULT.parse(reader);
            StringBuilder stringBuilder = new StringBuilder();

            for (CSVRecord record : parser) {
                // 遍历 CSV 记录中的每个字段
                for (int i = 0; i < record.size(); i++) {
                    // 将字段添加到字符串构建器中
                    stringBuilder.append(record.get(i));
                    // 如果不是最后一个字段，添加分隔符逗号
                    if (i < record.size() - 1) {
                        stringBuilder.append(",");
                    }
                }
                // 在每条记录后添加换行符，除了最后一行
                stringBuilder.append("\n");
            }

            // 返回构建的字符串
            return stringBuilder.toString();
        }
    }
}
